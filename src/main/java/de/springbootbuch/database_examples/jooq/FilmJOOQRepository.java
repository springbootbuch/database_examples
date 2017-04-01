package de.springbootbuch.database_examples.jooq;

import de.springbootbuch.database_examples.Film;
import static de.springbootbuch.database_examples.jooq.Tables.FILM;
import java.time.Year;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class FilmJOOQRepository {
	private final DSLContext create;

	public FilmJOOQRepository(DSLContext create) {
		this.create = create;
	}

	public List<Film> findAll() {
		return this.create
			.selectFrom(FILM)
			.fetch(r -> new Film(
				r.getTitle(),
				Year.of(r.getReleaseYear()))
			);
	}
}