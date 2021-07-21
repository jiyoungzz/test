package com.example.spring01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USER="spring";
	private static final String PW="1234";
	
	@Test //Junit으로 테스트하는 코드
	public void testConnection() throws Exception{
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("오라클에 연결되었습니다.");
			logger.info("오라클에 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
