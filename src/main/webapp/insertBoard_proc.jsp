<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="com.global.biz.board.BoardVO" %>
<%

// 사용자 입력 정보 추출
request.setCharacterEncoding("utf-8");

String title = request.getParameter("title"); 
String writer = request.getParameter("writer");
String content = request.getParameter("content");

// 데이터베이스 연동
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);

BoardDAO boardDAO = new BoardDAO();
boardDAO.insertBoard(vo);

// 화면 네이게이션 구성
response.sendRedirect("getBoardList.jsp");

%>