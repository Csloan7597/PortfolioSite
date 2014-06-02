package com.csloan.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.csloan.controller.CVController;

public class CVControllerTest {

	private MockMvc mockMvc;
	private CVController cvController = new CVController();

	@Before
	public void setUp() throws Exception {
		// Configure a view resolver to avoid loading spring context
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(cvController)
				.setViewResolvers(viewResolver).build();
	}

	@Test
	public void getCVPageTest() throws Exception {
		mockMvc.perform(get("/cv")).andExpect(status().isOk())
				.andExpect(view().name("cv"));
	}
}
