package org.kedu.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration

public class ControllerTest {

	@Inject
	private WebApplicationContext context;
	
	private MockMvc mockMVC;
	
	
	@Before
	public void setup(){

		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void test1()throws Exception {
		
		mockMVC.perform(MockMvcRequestBuilders.get("/doD"));
	}
}
