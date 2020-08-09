package com.casestudy.spring;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = GreetingController.class)
public class ApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homePage() throws Exception {
		mockMvc.perform(get("/index.html"))
				.andExpect(content().string(containsString("Greetings!!!")));
	}

	@Test
	public void greeting() throws Exception {
		mockMvc.perform(get("/greeting"))
				.andExpect(content().string(containsString("Hello, World!")));
	}

	@Test
	public void greetingWithUser() throws Exception {
		mockMvc.perform(get("/greeting").param("name", "Mayur"))
				.andExpect(content().string(containsString("Hello, Mayur!")));
	}

	@Test
        public void countchartest() throws Exception {
                mockMvc.perform(get("/countcharacters").param("word","TestString"))
                                .andExpect(content().string(containsString("Number of Vowels: 2")));
        }

	@Test
        public void countchartest1() throws Exception {
                mockMvc.perform(get("/countcharacters").param("word","TestString"))
                                .andExpect(content().string(containsString("Number of Consonants: 8")));
        }

}

