package de.springbootbuch.database_examples.jooq;

import static org.assertj.core.api.Assertions.*;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@JdbcTest
@ImportAutoConfiguration(JooqAutoConfiguration.class)
public class ConfigIT {

	@Autowired
	private DSLContext dSLContext;

	@Test
	public void dialectShouldBePickedUp() {
		assertThat(dSLContext.configuration().dialect()).isEqualTo(SQLDialect.POSTGRES);
	}
}
