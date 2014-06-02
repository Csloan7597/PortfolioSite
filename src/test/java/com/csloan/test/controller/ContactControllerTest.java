package com.csloan.test.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.csloan.controller.ContactController;
import com.csloan.data.Message;
import com.csloan.service.MailService;

public class ContactControllerTest {

	@Mock
	private MailService mailService;

	@Mock
	private Message templateMessage;

	@InjectMocks
	private ContactController contactController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		// Configure a view resolver to avoid loading spring context
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(contactController)
				.setViewResolvers(viewResolver).build();
	}

	@Test
	public void getContactPageTest() throws Exception {
		// Check a message object is sent along with the right view, & no
		// 'message is sent' response
		mockMvc.perform(get("/contact")).andExpect(status().isOk())
				.andExpect(view().name("contact"))
				.andExpect(model().attributeExists("message", "messageSent"))
				.andExpect(model().attribute("messageSent", false));
	}

	@Test
	public void addMessageTest() throws Exception {
		// Send a POST message which should return fine
		mockMvc.perform(
				post("/contact/addMessage").param("name", "Spring Tester")
						.param("subject", "RE: Test")
						.param("email", "tester@spring.me")
						.param("message", "I am testing!"))
				.andExpect(view().name("contact"))
				.andExpect(model().attributeExists("message", "messageSent"))
				.andExpect(model().attributeDoesNotExist("errorMessage"))
				.andExpect(model().attribute("messageSent", true));
	}

	@Test
	public void addMessageRuntimeExceptionTest() throws Exception {
		// Let mocked service throw a runtimeexception due to some unexpected
		// error
		doThrow(new RuntimeException("test")).when(mailService)
				.sendMessageAsMail(any(Message.class));

		// Send a POST message which should return the error
		mockMvc.perform(
				post("/contact/addMessage").param("name", "Spring Tester")
						.param("subject", "RE: Test")
						.param("email", "tester@spring.me")
						.param("message", "I am testing!"))
				.andExpect(view().name("contact"))
				.andExpect(
						model().attributeExists("message", "messageSent",
								"errorMessage"))
				.andExpect(model().attribute("messageSent", false))
				.andExpect(model().attribute("errorMessage", "test"));
	}

}
