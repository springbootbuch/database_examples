package de.springbootbuch.database_examples.jdbc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;
import static org.springframework.test.jdbc.JdbcTestUtils.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@JdbcTest(
	includeFilters = @Filter(value = Service.class))
@AutoConfigureTestDatabase(replace = NONE)
public class TransactionExamplesServiceIT {

	@Autowired
	private TransactionExamplesService examplesService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	@Rollback(false)
	public void tryInsertShouldWork() {
		try {
			examplesService.tryInsert();
		} catch(RuntimeException e) {
			assertThat(e.getMessage())
				.isEqualTo("Some error here...");
		}
		assertThat(
			countRowsInTableWhere(
				jdbcTemplate, 
				"actor", "first_name like 'Chuck%'"))
			.isEqualTo(0);
	}
	
	@Test	
	public void doInsertShouldWork() {
		examplesService.doInsert();
		assertThat(
			countRowsInTableWhere(
				jdbcTemplate, 
				"actor", "first_name like 'Chuck%'"))
			.isEqualTo(1);
	}
	
	@Test
	public void countSomethingShouldWork() {
		assertThat(examplesService.countSomething()).isGreaterThan(0L);
	}
}
