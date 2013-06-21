/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.webflow.primefaces;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.util.Constants;

/**
 *
 * @author umadeviraju
 */
public class Primefaces35PhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        //do nothing
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        FacesContext context = pe.getFacesContext();

        if (context.getAttributes().get(Constants.REQUEST_CONTEXT_ATTR) == null) {
            context.getAttributes().put(Constants.REQUEST_CONTEXT_ATTR, new DefaultRequestContext());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
    
}
