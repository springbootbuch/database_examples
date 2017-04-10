package de.springbootbuch.database_examples.springdata;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Part of springbootbuch.de.
 * 
 * Demonstrates the injectable Entity-Manager.
 * 
 * @author Michael J. Simons
 * @author @rotnroll666
 */
public class InjectableEntityManager {
	
	private final EntityManager entityManager;

	public InjectableEntityManager(
		EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<ActorEntity> executeSampleQuery() {
		return this.entityManager
			.createQuery(
				"Select a from ActorEntity a ", ActorEntity.class)
			.getResultList();
	}
}
