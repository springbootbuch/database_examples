package de.springbootbuch.database_examples.jooq;

import static de.springbootbuch.database_examples.jooq.Tables.ACTOR;
import static de.springbootbuch.database_examples.jooq.Tables.FILM;
import static de.springbootbuch.database_examples.jooq.Tables.FILM_ACTOR;
import static de.springbootbuch.database_examples.jooq.Tables.LANGUAGE;
import java.util.Map;
import org.jooq.DSLContext;
import org.jooq.Record3;
import static org.jooq.impl.DSL.count;
import org.springframework.stereotype.Repository;

@Repository
public class JOOQExampleQueries {

	private final DSLContext create;

	public JOOQExampleQueries(DSLContext create) {
		this.create = create;
	}

	public Map<String, Record3<String, String, Integer>>
		generateLanguageStatistics() {
		return this.
			create
				.select(ACTOR.LAST_NAME, LANGUAGE.NAME, count())
				.from(ACTOR)
					.join(FILM_ACTOR).using(ACTOR.ACTOR_ID)
					.join(FILM).using(FILM_ACTOR.FILM_ID)
					.join(LANGUAGE).using(FILM.LANGUAGE_ID)
				.groupBy(ACTOR.LAST_NAME, LANGUAGE.NAME)
				.fetch().intoMap(ACTOR.LAST_NAME);
	}
}