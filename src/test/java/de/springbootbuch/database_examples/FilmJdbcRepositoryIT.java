package de.springbootbuch.database_examples;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest(
	includeFilters = 
		@Filter(value = FilmJdbcRepository.class, type = ASSIGNABLE_TYPE)
)
@AutoConfigureTestDatabase(replace = NONE)
public class FilmJdbcRepositoryIT {

	@Autowired
	private FilmJdbcRepository filmJdbcRepository;
	
	@Test
	public void findAllShouldWork() {
		final List<Film> films = filmJdbcRepository.findAll();
		assertThat(films.size(), is(greaterThan(0)));		
	}
}