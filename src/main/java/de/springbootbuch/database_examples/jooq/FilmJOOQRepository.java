package de.springbootbuch.database_examples.jooq;

import de.springbootbuch.database_examples.Film;
import static de.springbootbuch.database_examples.jooq.Tables.FILM;
import java.time.Year;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * Part of springbootbuch.de.
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Repository
public class FilmJOOQRepository {
	private final DSLContext ctx;

	public FilmJOOQRepository(DSLContext ctx) {
		this.ctx = ctx;
	}

	public List<Film> findAll() {
		return this.ctx
			.select(FILM.TITLE, FILM.RELEASE_YEAR)
			.from(FILM)
			.fetch(r -> new Film(
				r.get(FILM.TITLE),
				Year.of(r.get(FILM.RELEASE_YEAR)))
			);
	}
}