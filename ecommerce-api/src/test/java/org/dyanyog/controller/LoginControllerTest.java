package org.dyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.dnyanyog.ECommerceApiMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ContextConfiguration(classes = ECommerceApiMain.class)
@AutoConfigureMockMvc
public class LoginControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void verifyingLoginSuccessResponse() throws Exception {
		String loginRequest="{\r\n"
				+ "    \"user\":\"kishor\",\r\n"
				+ "    \"password\":\"kishor123\"\r\n"
				+ "}";
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/auth/login").content(loginRequest).contentType("application/json").accept("application/json");
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
		.andExpect(jsonPath("$.responseCode").value("0000"))
		.andExpect(jsonPath("$.messege").value("Successful"))
		.andReturn();
	}
	
	@Test
	public void verifyingLoginrequestWithIncorrectPassword() throws Exception {
		String loginRequest="{\r\n"
				+ "    \"user\":\"onhkar\",\r\n"
				+ "    \"password\":\"onkarr123\"\r\n"
				+ "}";
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/auth/login").content(loginRequest).contentType("application/json").accept("application/json");
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.responseCode").value("911")).andExpect(jsonPath("$.messege").value("Invalid User")).andReturn();
	}
	

}
