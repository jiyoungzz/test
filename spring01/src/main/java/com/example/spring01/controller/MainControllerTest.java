package com.example.spring01.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MainControllerTest {
	private static final Logger logger=
			LoggerFactory.getLogger(MainControllerTest.class);
	
	@Inject //의존관계 주입
	WebApplicationContext wac;
	
	MockMvc mockMvc; // 가상 컨트롤러 테스트
	

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup...");
	}

	@Test
	public void testMain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"));
		logger.info("test main...");
	}

	@Test
	public void testGugu() {
		mockMvc.perform(MockMvcRequestBuilders.get("/gugu.do"));
		logger.info("test gugu...");
	}

	@Test
	public void testGugu_result() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/gugu_result.do"));
		logger.info("test gugu_result...");
	}

}
