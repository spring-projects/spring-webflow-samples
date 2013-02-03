package org.springframework.samples.webflow.autocomplete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private static List<Person> cache = new ArrayList<Person>();
	
	static {
		cache.add(new Person(0L, "Jamie Carr"));
		cache.add(new Person(1L, "Jean Cobbs"));
		cache.add(new Person(2L, "John Howard"));
		cache.add(new Person(3L, "John Mudra"));
		cache.add(new Person(4L, "Julia Webber"));
	}
	
	public List<String> suggestNames(String text) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			results.add(text + i);
		}
		return results;
	}

	public List<Person> suggestPeople(String text) {
		List<Person> results = new ArrayList<Person>();
		for (Person p : cache) {
			if (p.getName().toLowerCase().startsWith(text.toLowerCase())) {
				results.add(p);
			}
		}
		return results;
	}
	
}
