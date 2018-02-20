package de.springbootbuch.database_examples.springdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public class PersonFragmentImpl implements PersonFragment {

	@Override
	public List<Person> search(PersonQuery query) {
		// Search or whatever...
		return new ArrayList<>();
	}
}
