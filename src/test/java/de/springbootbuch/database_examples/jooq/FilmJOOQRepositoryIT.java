package de.springbootbuch.database_examples.jooq;

import de.springbootbuch.database_examples.Film;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.ComponentScan;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
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
		assertThat(films.size(), is(greaterThan(0)));
	}
}