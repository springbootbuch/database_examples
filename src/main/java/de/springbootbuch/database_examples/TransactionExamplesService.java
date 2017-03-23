package de.springbootbuch.database_examples;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionExamplesService {

	private final JdbcTemplate jdbcTemplate;

	public TransactionExamplesService(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public void doInsert() {
		this.jdbcTemplate.update(
			"Insert into actor(first_name, last_name) "
				+ "values(?, ?)",
			"Chuck", "Norris"
		);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void tryInsert() {
		this.jdbcTemplate.update(
			"Insert into actor(first_name, last_name) "
				+ "values(?, ?)",
			"Chuck", "Norris"
		);
		throw new RuntimeException("Some error here...");
	}
}