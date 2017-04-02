package de.springbootbuch.database_examples.jdbc;

import de.springbootbuch.database_examples.Film;
import java.time.Year;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Part of springbootbuch.de.
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Repository
public class FilmJdbcRepository {
	private final JdbcTemplate jdbcTemplate;

	public FilmJdbcRepository(
		JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Film> findAll() {
		return this.jdbcTemplate.query(
			"Select title, release_year from film",
			(rs, rowNum) ->
				new Film(
					rs.getString("title"),
					Year.of(rs.getInt("release_year")))
		);
	}
}
