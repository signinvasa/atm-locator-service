package com.mobiquity.atmlocator;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class to test the Rest api.
 * 
 * @author Madanmohan Vasa
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class AtmLocatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnListOfAllAtms() throws Exception {
		this.mockMvc.perform(get("/api/v1/locator/atms")).andExpect(status().isOk())
				.andExpect(content().string(containsString("address")));
	}

	@Test
	public void shouldReturnListOfAtmsForCity() throws Exception {
		this.mockMvc.perform(get("/api/v1/locator/atms?city=deventer")).andExpect(status().isOk())
				.andExpect(content().string(containsString("address")));
	}

}
