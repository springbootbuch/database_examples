package de.springbootbuch.database_examples.jooq;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.context.annotation.FilterType.*;

import de.springbootbuch.database_examples.Film;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@JooqTest(
	includeFilters =
		@ComponentScan.Filter(value = FilmJOOQRepository.class, type = ASSIGNABLE_TYPE)
)
public class FilmJOOQRepositoryIT {

	@Autowired
	private FilmJOOQRepository filmJOOQRepository;

	@Test
	public void findAllShouldWork() {
		final List<Film> films = filmJOOQRepository.findAll();
		assertThat(films.size()).isGreaterThan(0);
	}
}
