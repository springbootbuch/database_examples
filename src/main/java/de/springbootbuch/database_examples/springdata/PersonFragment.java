package de.springbootbuch.database_examples.springdata;

import java.util.List;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public interface PersonFragment {
	class PersonQuery {
	}
	
	
	public List<Person> search(PersonQuery query);
}
