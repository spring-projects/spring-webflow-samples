package org.springframework.samples.webflow.jsf;

import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
public class FacesHelper {

	/**
	 * This method can be used in a Facelets View to render a box around <h:messages/> conditionally.
	 * Note that this is only necessary with vanilla JSF. With PrimeFaces you can use <p:messages/>
	 * or <p:growl>.
	 * 
	 * @return true if there are messages to display
	 */
	public boolean isError() {
		return FacesContext.getCurrentInstance().getMessages().hasNext();
	}
	
}
