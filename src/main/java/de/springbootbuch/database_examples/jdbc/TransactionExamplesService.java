package de.springbootbuch.database_examples.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class TransactionExamplesService {

	private final JdbcTemplate jdbcTemplate;
	
	private final TransactionTemplate transactionTemplate;

	public TransactionExamplesService(JdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.transactionTemplate = transactionTemplate;
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
	
	public long countSomething() {	
		return this.transactionTemplate.execute(t ->
			this.jdbcTemplate.queryForObject(
					"select count(*) from actor", Long.class)
		);
	}
}