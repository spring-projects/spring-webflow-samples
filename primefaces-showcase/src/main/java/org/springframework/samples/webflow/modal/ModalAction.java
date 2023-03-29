package org.springframework.samples.webflow.modal;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class ModalAction {

	public void addInfoMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
