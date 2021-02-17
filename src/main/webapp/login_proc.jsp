<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="com.global.biz.user.impl.UserDAO" %>
 <%@ page import="com.global.biz.user.UserVO" %>
 
 <%
 // 사용자 입력 정보 추출
 String id = request.getParameter("id");
 String password = request.getParameter("password");
 
 //데이터베이스 연동
   UserVO vo = new UserVO();
   vo.setId(id);
   vo.setPassword(password);
   
   UserDAO userDAO = new UserDAO();
   UserVO user = userDAO.getUser(vo);
   
   // 화면 네비이게이션
   if(user != null) {
	   response.sendRedirect("getBoardList.jsp");
   }else {
	   response.sendRedirect("login.jsp");
   }
  
 %>