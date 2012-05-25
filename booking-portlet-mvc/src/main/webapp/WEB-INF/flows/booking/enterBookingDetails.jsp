<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Book Hotel</h2>

<portlet:actionURL var="actionUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>
<form:form id="booking" modelAttribute="booking" action="${actionUrl}">
		<spring:hasBindErrors name="booking">
			<div class="error">
				<spring:bind path="booking.*">
					<c:forEach items="${status.errorMessages}" var="error">
						<span><c:out value="${error}"/></span><br>
					</c:forEach>
				</spring:bind>
			</div>
		</spring:hasBindErrors>
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
			<tr class="field">
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
	            <td class="label">Nightly rate:</td>
	            <td class="output">
		        	<spring:bind path="booking.hotel.price">${status.value}</spring:bind>
	            </td>
	        </tr>
			<tr class="field">
				<td class="label">
					<label for="checkinDate">Check In Date:</label>
				</td>
				<td class="input">
					<form:errors path="checkinDate" cssClass="errors"/>
					<form:input path="checkinDate"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="checkoutDate">Check Out Date:</label>
				</td>
				<td class="input">
					<form:errors path="checkoutDate" cssClass="errors"/>
					<form:input path="checkoutDate"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="beds">Room Preference:</label>
				</td>
				<td class="input">
					<form:select id="beds" path="beds">
						<form:option label="One king-size bed" value="1"/>
						<form:option label="Two double beds" value="2"/>
						<form:option label="Three beds" value="3"/>
					</form:select>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="smoking">Smoking Preference:</label>
				</td>
				<td class="input">
					<form:radiobutton id="smoking" path="smoking" label="Smoking" value="true"/>
					<form:radiobutton path="smoking" label="Non Smoking" value="false"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="creditCard">Credit Card #:</label>
				</td>
				<td class="input">
					<form:errors path="creditCard" cssClass="errors"/>
					<form:input id="creditCard" path="creditCard"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="creditCardName">Credit Card Name:</label>
				</td>
				<td class="input">
					<form:errors path="creditCardName" cssClass="errors"/>
					<form:input id="creditCardName" path="creditCardName"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="creditCardExpiryMonth">Expiration Date:</label>
				</td>
				<td class="input">
					<form:select id="creditCardExpiryMonth" path="creditCardExpiryMonth">
						<form:option label="Jan" value="1"/>
						<form:option label="Feb" value="2"/>
						<form:option label="Mar" value="3"/>
						<form:option label="Apr" value="4"/>
						<form:option label="May" value="5"/>
						<form:option label="Jun" value="6"/>
						<form:option label="Jul" value="7"/>
						<form:option label="Aug" value="8"/>
						<form:option label="Sep" value="9"/>
						<form:option label="Oct" value="10"/>
						<form:option label="Nov" value="11"/>
						<form:option label="Dec" value="12"/>
					</form:select>
					<form:select path="creditCardExpiryYear">
						<form:option label="2008" value="1"/>
						<form:option label="2009" value="2"/>
						<form:option label="2010" value="3"/>
						<form:option label="2011" value="4"/>
						<form:option label="2012" value="5"/>
					</form:select>
				</td>
			</tr>
			<tr class="field">
				<td colspan="2" class="buttonGroup">
					<input type="submit" name="_eventId_proceed" value="Proceed"/>&#160;
					<input type="submit" name="_eventId_cancel" value="Cancel"/>&#160;
				</td>
			</tr>
		</table>
	</fieldset>
</form:form>
