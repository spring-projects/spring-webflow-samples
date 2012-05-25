package org.springframework.webflow.samples.booking;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = BookingDateRangeValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface BookingDateRange {

    String message() default "Invalid check-in and check-out date range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
