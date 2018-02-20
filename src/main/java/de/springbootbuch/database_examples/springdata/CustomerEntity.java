package de.springbootbuch.database_examples.springdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Entity
@Table(name = "customer")
public class CustomerEntity extends Person {

	private static final long serialVersionUID = -7809126731753145895L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	protected CustomerEntity() {
	}

	public CustomerEntity(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Integer getId() {
		return id;
	}
}
