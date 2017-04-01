package de.springbootbuch.database_examples.springdata;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) @DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class FilmJpaRepositoryIT {

	@Autowired
	private FilmJpaRepository filmJpaRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Test
	public void findAllShouldWork() {
		final List<FilmEntity> films
			= filmJpaRepository.findAll();
		assertThat(films.size(), is(greaterThan(0)));
	}

	@Test
	public void createShouldWork() {
		long cnt = filmJpaRepository.count();
		languageRepository
			.findOneByName("English")
			.map(l -> new FilmEntity("Æon Flux", l))
			.ifPresent(filmJpaRepository::save);
		assertThat(
			filmJpaRepository.count(), is(equalTo(cnt + 1)));
	}
}
