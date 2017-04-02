package de.springbootbuch.database_examples.springdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MoreExamplesRepositoryIT {
	private static final Logger LOG = LoggerFactory
		.getLogger(FilmSimpleJpaRepositoryIT.class);

	@Autowired
	private MoreExamplesRepository filmRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Test
	public void findAllByActorShouldWork() {
		Example<ActorEntity> example = Example.of(
			new ActorEntity("FAY", "WINSLET"),
			ExampleMatcher.matching()
				.withIgnoreCase()
				.withMatcher("firstName", m -> m.startsWith())
				.withMatcher("lastName", m -> m.exact())
		);

		actorRepository
			.findOne(example)
			.map(filmRepository::findAllByActor)
			.get()
			.stream()
			.map(FilmEntity::getTitle)
			.forEach(LOG::debug);
	}
}
