package com.global.biz;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import jdk.nashorn.internal.runtime.logging.Logger;





public class JDBCTests {

	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testConnection() {
		try {
		Connection con =
		DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"scott",
				"tiger");
		System.out.println("데이터베이스 연결성공....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
