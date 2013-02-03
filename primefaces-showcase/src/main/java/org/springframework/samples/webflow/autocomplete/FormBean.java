package org.springframework.samples.webflow.autocomplete;

import java.io.Serializable;

public class FormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	private Person person;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
