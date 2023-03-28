package org.springframework.webflow.samples.booking;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelLazyDataModel extends LazyDataModel<Hotel> {

	private static final long serialVersionUID = -8832831134966938627L;

	private SearchCriteria searchCriteria;

	private BookingService bookingService;

	private List<Hotel> hotels;

	private Hotel selected;


	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public int count(Map<String, FilterMeta> filterBy) {
		return bookingService.getNumberOfHotels(this.searchCriteria);
	}

	@Override
	public List<Hotel> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		this.searchCriteria.setCurrentPage(first / pageSize + 1);
		String sortField = null;
		SortOrder sortOrder = SortOrder.ASCENDING;
		if (!sortBy.isEmpty()) {
			SortMeta sortMeta = sortBy.values().iterator().next();
			sortField = sortMeta.getField();
			sortOrder = sortMeta.getOrder();
		}
		this.hotels = bookingService.findHotels(searchCriteria, first, sortField, !sortOrder.equals(SortOrder.DESCENDING));
		return hotels;
	}

	@Override
	public Hotel getRowData(String rowKey) {
		for (Hotel hotel : this.hotels){
			if (hotel.getId().equals(Long.valueOf(rowKey))) {
				return hotel;
			}
 		}
		return null;
	}

	@Override
	public String getRowKey(Hotel hotel) {
		return String.valueOf(hotel.getId());
	}

	@Override
	public int getRowCount() {
		return bookingService.getNumberOfHotels(searchCriteria);
	}

	public Hotel getSelected() {
		return selected;
	}

	public void setSelected(Hotel selected) {
		this.selected = selected;
	}

	public int getCurrentPage() {
		return this.searchCriteria.getCurrentPage();
	}

	public int getPageSize() {
		return this.searchCriteria.getPageSize();
	}

}