<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>View Hotel</h2>

<portlet:actionURL var="actionUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<form:form id="hotel" modelAttribute="hotel" action="${actionUrl}">
	<input type="hidden" name="execution" value="${flowExecutionKey}" />
	<fieldset>
		<table>
			<tr class="field">
				<td class="label">Name:</td>
				<td class="output">${hotel.name}</td>
			</tr>
			<tr class="field">
				<td class="label">Address:</td>
				<td class="output">${hotel.address}</td>
			</tr>
			<tr class="field">
				<td class="label">City:</td>
				<td class="output">${hotel.city}</td>
			</tr>
			<tr class="field">
				<td class="label">State:</td>
				<td class="output">${hotel.state}</td>
			</tr>
			<tr class="field">
				<td class="label">Zip:</td>
				<td class="output">${hotel.zip}</td>
			</tr>
			<tr class="field">
				<td class="label">Country:</td>
				<td class="output">${hotel.country}</td>
			</tr>
		    <tr class="field">
		        <td class="label">Nightly rate:</td>
		        <td class="output">
		        	<spring:bind path="price">${status.value}</spring:bind>
		        </td>
		    </tr>
			<tr class="field">
				<td colspan="2" class="buttonGroup">
					<input type="submit" name="_eventId_book" value="Book Hotel"/>&#160;
					<input type="submit" name="_eventId_cancel" value="Back to Search"/>&#160;
				</td>
			</tr>
		</table>
	</fieldset>
</form:form>
