package org.springframework.samples.webflow.autocomplete;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.util.StringUtils;

@FacesConverter(value="personConverter")
public class PersonConverter implements Converter {

	private static List<Person> cache = new ArrayList<Person>();
	
	static {
		cache.add(new Person(0L, "Jamie Carr"));
		cache.add(new Person(1L, "Jean Cobbs"));
		cache.add(new Person(2L, "John Howard"));
		cache.add(new Person(3L, "John Mudra"));
		cache.add(new Person(4L, "Julia Webber"));
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (StringUtils.hasText(value)) {
			for (Person p : cache) {
				if (p.getName().equals(value)) {
					return p;
				}
			}
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((Person) value).getName());
        }
        return null;
	}

}
