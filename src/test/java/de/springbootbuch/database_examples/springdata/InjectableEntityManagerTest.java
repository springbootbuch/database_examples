package de.springbootbuch.database_examples.springdata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Part of springbootbuch.de.
 * 
 * Demonstrates the injectable Entity-Manager.
 * 
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest(includeFilters = @Filter(
	type = FilterType.ASSIGNABLE_TYPE, 
	classes = InjectableEntityManager.class)
)
public class InjectableEntityManagerTest {
	
	@Autowired
	private InjectableEntityManager injectableEntityManager;
	
	@Test
	public void selectActors() {
		injectableEntityManager.executeSampleQuery()
			.stream()
			.map(ActorEntity::getLastName)
			.forEach(System.out::println);
	}
}