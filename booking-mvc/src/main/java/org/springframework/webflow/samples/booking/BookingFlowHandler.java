package org.springframework.webflow.samples.booking;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class BookingFlowHandler extends AbstractFlowHandler {

    private static final String DEFAULT_URL = "/hotels/search";

	@Override
	public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest req, HttpServletResponse res) {
		return DEFAULT_URL;
	}

	@Override
	public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response) {
		if (e instanceof NoSuchFlowExecutionException) {
			return DEFAULT_URL;
		}
		else {
			throw e;
		}
	}

}
