package de.springbootbuch.database_examples.springdata;

import org.springframework.data.repository.CrudRepository;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public interface CustomerRepository extends 
	CrudRepository<CustomerEntity, Integer>,
	PersonFragment,
	CustomerBulkLoader{
}
