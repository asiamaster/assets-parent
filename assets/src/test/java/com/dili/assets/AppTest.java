package com.dili.assets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
@ExtendWith(SpringExtension.class)
@WebAppConfiguration("src/main/resources")
@SpringBootTest
@ActiveProfiles("dev")
public class AppTest {
	@Test
	public void test() {

	}
}
