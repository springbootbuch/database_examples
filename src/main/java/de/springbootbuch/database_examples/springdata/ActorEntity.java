package de.springbootbuch.database_examples.springdata;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class ActorEntity implements Serializable {
	
	private static final long serialVersionUID = -7730563195268648199L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private Integer id;
	
	private String firstName;
	
	private String lastName;

	protected ActorEntity() {
	}

	public ActorEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "ActorEntity{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
	}
}