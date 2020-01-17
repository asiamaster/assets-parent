package com.dili.assets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration("src/main/resources")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("dev")
@TestInstance(Lifecycle.PER_CLASS)
public class AppTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@MockBean
	ErrorAttributes attributes;
	@Autowired
	MappingJackson2HttpMessageConverter converter;
	@Autowired
	DataSource ds;

	protected String toJson(Object value) {
		if (value == null) {
			return "";
		} else {

			try {
				return converter.getObjectMapper().writeValueAsString(value);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			return String.valueOf(value);
		}
	}

	@BeforeAll
	public void beforeAll() {
    	System.setProperty("org.jooq.no-logo", "true");
    	System.setProperty("decorator.datasource.enabled", "true");
		logger.info("beforeAll");

	}

	@BeforeEach
	public void beforeEach() {
		logger.info("beforeEach");
	}

	@Test
	public void test() throws SQLException {
		logger.info("test");
		this.ds.getConnection().createStatement().execute("select 1");
	}

	@Test
	public void test2() {
		logger.info("test2");
		logger.info("json={}",this.toJson(new HashMap<String, String>()));
	}
}
