package org.springframework.webflow.samples.booking;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;

import org.easymock.EasyMock;
import org.springframework.binding.mapping.Mapper;
import org.springframework.binding.mapping.MappingResults;
import org.springframework.faces.model.converter.FacesConversionService;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.engine.EndState;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

public class MainFlowExecutionTests extends AbstractXmlFlowExecutionTests {

    private BookingService bookingService;

    protected void setUp() {
	bookingService = EasyMock.createMock(BookingService.class);
    }

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
	return resourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/main/main-flow.xml");
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
	builderContext.registerBean("bookingService", bookingService);
	builderContext.getFlowBuilderServices().setConversionService(new FacesConversionService());
    }

    public void testStartMainFlow() {
	List<Booking> bookings = new ArrayList<Booking>();
	bookings.add(new Booking(new Hotel(), new User("keith", "password", "Keith Donald")));
	EasyMock.expect(bookingService.findBookings("keith")).andReturn(bookings);
	EasyMock.replay(bookingService);

	MockExternalContext context = new MockExternalContext();
	context.setCurrentUser("keith");
	startFlow(context);
	assertCurrentStateEquals("enterSearchCriteria");
	assertResponseWrittenEquals("enterSearchCriteria", context);
	assertTrue(getRequiredFlowAttribute("searchCriteria") instanceof SearchCriteria);
	assertTrue(getRequiredViewAttribute("bookings") instanceof DataModel);

	EasyMock.verify(bookingService);
    }

    public void testSearchHotels() {
	setCurrentState("enterSearchCriteria");

	SearchCriteria criteria = new SearchCriteria();
	criteria.setSearchString("Jameson");
	getFlowScope().put("searchCriteria", criteria);

	MockExternalContext context = new MockExternalContext();
	context.setEventId("search");
	resumeFlow(context);

	assertCurrentStateEquals("reviewHotels");
	assertResponseWrittenEquals("reviewHotels", context);
	assertTrue(getRequiredViewAttribute("hotels") instanceof HotelLazyDataModel);
    }

    public void testSelectHotel() {
	setCurrentState("reviewHotels");

	List<Hotel> hotels = new ArrayList<Hotel>();
	Hotel hotel = new Hotel();
	hotel.setId(1L);
	hotel.setName("Jameson Inn");
	hotels.add(hotel);
	HotelLazyDataModel dataModel = new HotelLazyDataModel(null, null);
	dataModel.setSelected(hotel);
	getViewScope().put("hotels", dataModel);

	MockExternalContext context = new MockExternalContext();
	context.setEventId("select");
	resumeFlow(context);

	assertCurrentStateEquals("reviewHotel");
	assertNull(getFlowAttribute("hotels"));
	assertSame(hotel, getFlowAttribute("hotel"));
    }

    public void testBookHotel() {
	setCurrentState("reviewHotel");

	Hotel hotel = new Hotel();
	hotel.setId(1L);
	hotel.setName("Jameson Inn");
	getFlowScope().put("hotel", hotel);

	Flow mockBookingFlow = new Flow("booking");
	mockBookingFlow.setInputMapper(new Mapper() {
	    public MappingResults map(Object source, Object target) {
		assertEquals(new Long(1), ((AttributeMap) source).get("hotelId"));
		return null;
	    }
	});
	new EndState(mockBookingFlow, "bookingConfirmed");
	getFlowDefinitionRegistry().registerFlowDefinition(mockBookingFlow);

	MockExternalContext context = new MockExternalContext();
	context.setEventId("book");
	resumeFlow(context);

	assertFlowExecutionEnded();
	assertFlowExecutionOutcomeEquals("finish");
    }
}
