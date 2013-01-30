package org.springframework.samples.webflow.poller;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CurrentTimeBean {

	public Date getTime() {
		return new Date();
	}

}
