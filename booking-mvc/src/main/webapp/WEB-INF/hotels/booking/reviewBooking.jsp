<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="bookingForm">
	<div class="span-5">
		<h3>${booking.hotel.name}</h3>
		
		<address>
			${booking.hotel.address}
			<br/>
			${booking.hotel.city}, ${booking.hotel.state}, ${booking.hotel.zip}
			<br/>
			${booking.hotel.country}
		</address>
	</div>
	<div class="span-12 last">
		<form:form id="confirm" modelAttribute="booking" action="${flowExecutionUrl}">
		<fieldset>
			<legend>Confirm Booking Details</legend>
			<div>
				<div class="span-4">Check In:</div>
				<div class="last">
					<p><spring:bind path="checkinDate">${status.value}</spring:bind></p>
				</div>
			</div>
			<div>
				<div class="span-4">Checkout:</div>
				<div class="last">
					<p><spring:bind path="checkoutDate">${status.value}</spring:bind></p>
				</div>
			</div>
	        <div>
	            <div class="span-4">Number of Nights:</div>
	            <div class="last">
	            	<p><spring:bind path="nights">${status.value}</spring:bind></p>
	            </div>
	        </div>
	        <div>
	            <div class="span-4">Total Payment:</div>
	            <div class="last">
	            	<p><spring:bind path="total">${status.value}</spring:bind></p>
	            </div>
	        </div>
			<div>
				<div class="span-4">Credit Card #:</div>
				<div class="last">
					<p>${booking.creditCard}</p>
				</div>
			</div>
			<div>
				<button type="submit" name="_eventId_confirm">Confirm</button>
				<button type="submit" name="_eventId_revise" id="revise">Revise</button>
				<button type="submit" name="_eventId_cancel">Cancel</button>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'revise',event:'onclick',formId:'confirm'}));
				</script>
			</div>
		</fieldset>
		</form:form>
	</div>

</div>
