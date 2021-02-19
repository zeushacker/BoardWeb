package com.global.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.global.biz.common.JDBCUtil;
import com.global.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	// JDBC 관련변수
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET ="select * from users where id=? and password=?";
	
	
	// 메소드 구현
	public UserVO getUser(UserVO vo) {
		
		UserVO user = null;
		
		try {
			System.out.println("=====> JDBC로 getUser() 기능 처리 .....");
			con = JDBCUtil.getConnection();
			
			stmt = con.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, con);
		}
		return user;
	}
}
