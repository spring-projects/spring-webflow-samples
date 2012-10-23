package org.springframework.webflow.samples.booking;

import java.util.Calendar;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookingValidator implements Validator {

    public boolean supports(Class clazz) {
	return Booking.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
	Booking booking = (Booking) obj;
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, -1);
	if (booking.getCreditCard() == null || "".equals(booking.getCreditCard())) {
	    errors.rejectValue("creditCard", null, "Credit card number must be provided");
	}
	if (booking.getCreditCardName() == null || "".equals(booking.getCreditCardName())) {
	    errors.rejectValue("creditCardName", null, "Credit card name must be provided");
	}
	if (booking.getCheckinDate() == null || booking.getCheckinDate().before(calendar.getTime())) {
	    errors.rejectValue("checkinDate", null, "Check in date must be a future date");
	} else if (booking.getCheckoutDate() == null || !booking.getCheckinDate().before(booking.getCheckoutDate())) {
	    errors.rejectValue("checkoutDate", null, "Check out date must be later than check in date");
	}
    }

}
