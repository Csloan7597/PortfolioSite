package com.csloan.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.csloan.controller.HomeController;

@ContextConfiguration
public class HomeControllerTest {

	private MockMvc mockMvc;
	private HomeController homeController = new HomeController();

	@Before
	public void setUp() throws Exception {
		// Configure a view resolver to avoid loading spring context
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(homeController)
				.setViewResolvers(viewResolver).build();
	}

	@Test
	public void getHomePageTest() throws Exception {
		mockMvc.perform(get("/home")).andExpect(status().isOk())
				.andExpect(view().name("home"));
	}

	@Test
	public void getAboutPageTest() throws Exception {
		mockMvc.perform(get("/about")).andExpect(status().isOk())
				.andExpect(view().name("about"));
	}

}
