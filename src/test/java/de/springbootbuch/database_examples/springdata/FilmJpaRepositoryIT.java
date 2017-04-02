package de.springbootbuch.database_examples.springdata;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FilmJpaRepositoryIT {

	@Autowired
	private FilmJpaRepository filmRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Test
	public void findAllShouldWork() {
		final List<FilmEntity> films
			= filmRepository.findAll();
		assertThat(films.size(), is(greaterThan(0)));
	}

	@Test
	public void createShouldWork() {
		long cnt = filmRepository.count();
		languageRepository
			.findOneByName("English")
			.map(l -> new FilmEntity("Æon Flux", l))
			.ifPresent(filmRepository::save);
		assertThat(
			filmRepository.count(), is(cnt + 1));
	}
}
