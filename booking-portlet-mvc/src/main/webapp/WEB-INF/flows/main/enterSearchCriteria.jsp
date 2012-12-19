<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<portlet:actionURL var="actionUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<form:form modelAttribute="searchCriteria" action="${actionUrl}">
	<h2>Search Hotels</h2>
    <span class="errors">
    	<form:errors path="*"/>
    </span>
	<fieldset> 
		<label for="searchString">Search For:</label>
		<form:input path="searchString"/>
		<label for="pageSize">Maximum results:</label>
		<form:select path="pageSize">
			<form:option label="5" value="5"/>
			<form:option label="10" value="10"/>
			<form:option label="20" value="20"/>
		</form:select>
		<input type="submit" class="button" name="_eventId_search" value="Find Hotels" />
    </fieldset>
</form:form>

<h2>Current Hotel Bookings</h2>
<table class="summary">
	<thead>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>City, State</th>
			<th>Check in Date</th>
			<th>Check out Date</th>
			<th>Confirmation Number</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="booking" items="${bookings}">
			<tr>
				<td>${booking.hotel.name}</td>
				<td>${booking.hotel.address}</td>
				<td>${booking.hotel.city}, ${booking.hotel.state}</td>
				<td>${booking.checkinDate}</td>
				<td>${booking.checkoutDate}</td>
				<td>${booking.id}</td>
				<td>
					<portlet:actionURL var="actionUrl">
						<portlet:param name="execution" value="${flowExecutionKey}" />
						<portlet:param name="_eventId" value="cancelBooking" />
						<portlet:param name="bookingId" value="${booking.id}" />
					</portlet:actionURL>
					<a href="${actionUrl}">Cancel</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty bookings}">
		<tr>
			<td colspan="7">No booking history</td>
		</tr>
		</c:if>
	</tbody>
</table>
