package org.springframework.webflow.samples.booking;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookingDateRangeValidator implements ConstraintValidator<BookingDateRange, Booking> {

    public void initialize(BookingDateRange bookingDateRange) {
    }

    public boolean isValid(Booking booking, ConstraintValidatorContext context) {
	if ((booking.getCheckinDate() != null) && (booking.getCheckoutDate() != null)
		&& booking.getCheckoutDate().before(booking.getCheckinDate())) {
	    return false;
	}
	return true;
    }

}
