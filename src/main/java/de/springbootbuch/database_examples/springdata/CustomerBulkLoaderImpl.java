package de.springbootbuch.database_examples.springdata;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public class CustomerBulkLoaderImpl implements CustomerBulkLoader {

	@Override
	public void loadCustomers(String fileName) {
		System.out.println("Loading customers from " + fileName);
	}
}
