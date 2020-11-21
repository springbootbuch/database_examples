package de.springbootbuch.database_examples.springdata;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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
		assertThat(films.size()).isGreaterThan(0);
	}

	@Test
	public void createShouldWork() {
		long cnt = filmRepository.count();
		languageRepository
			.findOneByName("English")
			.map(l -> new FilmEntity("Æon Flux", l))
			.ifPresent(filmRepository::save);
		assertThat(
			filmRepository.count()).isEqualTo(cnt + 1);
	}
}
