package org.springframework.samples.webflow.validation;

import java.io.Serializable;
import java.util.Date;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date startDate;
	
	private Date endDate;
	
	private boolean stateValidationEnabled;

	private boolean globalValidationEnabled;

	public void validateEdit(ValidationContext validationContext) {
		if (stateValidationEnabled && startDate.after(endDate)) {
			MessageContext messageContext = validationContext.getMessageContext(); 
			messageContext.addMessage(new MessageBuilder().error().code("startDateBeforeEndDate.viewState").build());
		}
	}
	
	public void validate(ValidationContext validationContext) {
		if (globalValidationEnabled && startDate.after(endDate)) {
			MessageContext messageContext = validationContext.getMessageContext(); 
			messageContext.addMessage(new MessageBuilder().error().code("startDateBeforeEndDate.global").build());
		}
	}

	public boolean validateDates(MessageContext messageContext) {
		if (startDate.after(endDate)) {
			messageContext.addMessage(new MessageBuilder().error().code("startDateBeforeEndDate.validationMethod").build());
			return false;
		}
		return true;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isStateValidationEnabled() {
		return stateValidationEnabled;
	}

	public void setStateValidationEnabled(boolean stateValidationEnabled) {
		this.stateValidationEnabled = stateValidationEnabled;
	}

	public boolean isGlobalValidationEnabled() {
		return globalValidationEnabled;
	}

	public void setGlobalValidationEnabled(boolean globalValidationEnabled) {
		this.globalValidationEnabled = globalValidationEnabled;
	}
	
}
