<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Confirm Hotel Booking</h2>

<portlet:actionURL var="actionUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<form:form id="confirm" modelAttribute="booking" action="${actionUrl}">
	<fieldset>
		<table>
			<tr class="field">
				<td class="label">Name:</td>
				<td class="output">${booking.hotel.name}</td>
			</tr>
			<tr class="field">
				<td class="label">Address:</td>
				<td class="output">${booking.hotel.address}</td>
			</tr>
			<tr>
				<td class="label">City, State:</td>
				<td class="output">${booking.hotel.city}, ${booking.hotel.state}</td>
			</tr>
			<tr class="field">
				<td class="label">Zip:</td>
				<td class="output">${booking.hotel.zip}</td>
			</tr>
			<tr class="field">
				<td class="label">Country:</td>
				<td class="output">${booking.hotel.country}</td>
			</tr>
	        <tr class="field">
	            <td class="label">Total payment:</td>
	            <td class="output">
	            	<spring:bind path="total">${status.value}</spring:bind>
	            </td>
	        </tr>
			<tr class="field">
				<td class="label">Check In Date:</td>
				<td class="output">
					<spring:bind path="checkinDate">${status.value}</spring:bind>
				</td>
			</tr>
			<tr class="field">
				<td class="label">Check Out Date:</td>
				<td class="output">
					<spring:bind path="checkoutDate">${status.value}</spring:bind>
				</td>
			</tr>
			<tr class="field">
				<td class="label">Credit Card #:</td>
				<td class="output">${booking.creditCard}</td>
			</tr>
			<tr>
				<td colspan="2" class="buttonGroup">
					<input type="submit" name="_eventId_confirm" value="Confim"/>&#160;
					<input type="submit" name="_eventId_revise" value="Revise"/>&#160;
					<input type="submit" name="_eventId_cancel" value="Cancel"/>&#160;
				</td>
			</tr>
		</table>
	</fieldset>
</form:form>
