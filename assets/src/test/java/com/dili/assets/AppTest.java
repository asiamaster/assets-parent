package com.dili.assets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
@ExtendWith(SpringExtension.class)
@WebAppConfiguration("src/main/resources")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("dev")
@TestInstance(Lifecycle.PER_CLASS)
public class AppTest {
	protected Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@MockBean
	ErrorAttributes attributes;
	
	@BeforeAll
	public void beforeAll() {
		logger.info("beforeAll");
		
	}
	@BeforeEach
	public void beforeEach() {
		logger.info("beforeEach");
	}
	@Test
	public void test() {
		logger.info("test");
	}
	@Test
	public void test2() {
		logger.info("test2");
	}
}
