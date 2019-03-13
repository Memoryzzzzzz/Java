package com.example.SpringBoot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.SpringBoot.controller.SteelController;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {
    
    private MockMvc mvc;

	@Test
	public void contextLoads() {
	}
	@Before
	public void setup(){
	    mvc = MockMvcBuilders.standaloneSetup(new SteelController()).build();
	}
	@Test
	public void gethello(){
	    try {
            mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
}
