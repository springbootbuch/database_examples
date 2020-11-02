package de.springbootbuch.database_examples.springdata;

import java.util.Optional;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FilmSimpleJpaRepositoryIT {
	
	private static final Logger LOG = LoggerFactory
		.getLogger(FilmSimpleJpaRepositoryIT.class);

	@Autowired
	private FilmSimpleJpaRepository filmRepository;

	@Test
	public void findOneShouldWork() {
		Optional<FilmEntity> film;
		
		film = filmRepository.findById(-1);
		assertThat(film.isPresent(), is(false));
		
		film = filmRepository.findById(1);
		assertThat(film.isPresent(), is(true));
	}
	
	@Test
	public void findAllShouldWork() {
		try (
			Stream<FilmEntity> stream = 
				filmRepository.findAll()
		) {
			stream.map(FilmEntity::getTitle)
				.forEach(LOG::debug);
		}
	}
	
	@Test
	public void countAllByTitleLikeShouldWork() {
		assertThat(
			filmRepository
				.countAllByTitleLike("A%"), 
			is(46L));
	}
}
