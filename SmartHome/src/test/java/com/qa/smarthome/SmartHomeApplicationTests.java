package com.qa.smarthome;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.smarthome.model.IoT;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:IoT-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class SmartHomeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		IoT testIoT = new IoT(null, null, null, "smart plug outlet", "2019", null, null, "Samsung", null, null, null);
		String testIoTAsJSON = this.mapper.writeValueAsString(testIoT);
		System.out.println("Request Body: " + testIoTAsJSON);

		RequestBuilder req = post("/SmartHome/create").contentType(MediaType.APPLICATION_JSON).content(testIoTAsJSON);

		testIoT.setId(3L);
		String responseBody = this.mapper.writeValueAsString(testIoT);
		System.out.println("Response Body: " + responseBody);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(responseBody);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetOne() throws Exception {

		this.mvc.perform(get("/SmartHome/get/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(null)));
	}

	@Test
	void testGetAll() throws Exception {
		final String resultString = this.mvc.perform(get("/SmartHome/getAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<IoT> results = Arrays.asList(mapper.readValue(resultString, IoT[].class));
		assertThat(results);

	}

	@Test
	void testUpdate() throws Exception {
		final IoT testIoT = new IoT(1L, null, null, "smart plug outlet", "v2", null, null, "Samsung", null, null, null);
		String resultString = this.mvc
				.perform(put("/SmartHome/update/3").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testIoT)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		IoT result = this.mapper.readValue(resultString, IoT.class);
		assertThat(result).isEqualTo(testIoT);

	}

	@Test
	void testDelete() throws Exception {

		this.mvc.perform(delete("/SmartHome/delete/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
