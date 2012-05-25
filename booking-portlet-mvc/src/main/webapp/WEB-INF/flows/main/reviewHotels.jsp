<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Hotel Results</h2>

<portlet:actionURL var="changeSearchUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
	<portlet:param name="_eventId" value="changeSearch" />
</portlet:actionURL>
<a href="${changeSearchUrl}">Change Search</a>
	
<table class="summary">
	<thead>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>City, State</th>
			<th>Zip</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="hotel" items="${hotels}">
			<tr>
				<td>${hotel.name}</td>
				<td>${hotel.address}</td>
				<td>${hotel.city}, ${hotel.state}, ${hotel.country}</td>
				<td>${hotel.zip}</td>
				<td>
					<portlet:actionURL var="actionUrl">
						<portlet:param name="execution" value="${flowExecutionKey}" />
						<portlet:param name="_eventId" value="select" />
						<portlet:param name="hotelId" value="${hotel.id}" />
					</portlet:actionURL>
					<a href="${actionUrl}">View Hotel</a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty hotels}">
		<tr>
			<td colspan="5">No hotels found</td>
		</tr>
		</c:if>
	</tbody>
</table>

<c:if test="${searchCriteria.page > 0}">
	<portlet:actionURL var="prevResultsUrl">
		<portlet:param name="execution" value="${flowExecutionKey}" />
		<portlet:param name="_eventId" value="previous" />
	</portlet:actionURL>
	<a href="${prevResultsUrl}">Previous Results</a>
</c:if>
<c:if test="${not empty hotels && fn:length(hotels) == searchCriteria.pageSize}">
	<portlet:actionURL var="moreResultsUrl">
		<portlet:param name="execution" value="${flowExecutionKey}" />
		<portlet:param name="_eventId" value="next" />
	</portlet:actionURL>
	<a href="${moreResultsUrl}">More Results</a>
</c:if>		

