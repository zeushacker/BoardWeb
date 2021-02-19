package com.global.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;

//DAO(Data Access Object)
@Repository
//public class BoardDAOSpring extends JdbcDaoSupport{
public class BoardDAOSpring {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	// SQL 명령들 
		/*
		  private final String BOARD_INSERT =
		 
				"insert into board(seq, title, writer, content) "
				+ "values((select nvl(max(seq), 0)+1 from board), ?,?,?)";
				*/
		private final String BOARD_INSERT =
				"insert into board(seq, title, writer, content) "
				+ "values(?, ?,?,?)";
		private final String BOARD_UPDATE =
				"update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE =
				"delete board where seq=?";
		private final String BOARD_GET =
				"select * from board where seq=?";
		private final String BOARD_LIST =
				"select * from board order by seq desc";
	
		//setDataSource 메소드를 호출하여 데이터소스 객체를 의존성 주입을 했다.
		
		
		//CRUD 기능의 메소드 구현
		// 글 등록
		// update() : insert, update, delete 구문을 처리할때 사용
		public void insertBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 insertBoard() jdbcTemplate기능 처리....");
			//getJdbcTemplate().update(BOARD_INSERT,
			jdbcTemplate.update(BOARD_INSERT,vo.getSeq(),
					vo.getTitle(), vo.getWriter(), vo.getContent());
		}
		
		// 글 수정
		public void updateBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 updateBoard() 기능 처리....");
			jdbcTemplate.update(BOARD_UPDATE, 
					vo.getTitle(), vo.getContent(), vo.getSeq());
		}
		
		// 글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리....");
			jdbcTemplate.update(BOARD_DELETE,vo.getSeq() );
		}
		
		// 글 상세 조회
		//  검색된 정수값을 리턴받으려면 queryForInt() 메소드를 사용함
		//  검색결과를 특정 자바 객체로 매핑하여 리턴 받을때는 queryForObject() 메소드를 사용함
		// 자바 객체로 매핑할때 RowMapper 객체를 반드시 지정해야함
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoard() 기능 처리....");
			Object[] args = {vo.getSeq()};
			return jdbcTemplate.queryForObject(BOARD_GET, 
					args, new BoardRowMapper());
			//queryForObject() 객체 하나를 검색할때 사용하는 메소드
		}
		
		// 글 목록 조회
		// query() : select 문의 실행 결과가 목록일때 사용하는 메소드
		// 여러건의 행 정보가 검색되면 검색된 레코드 수만큼 BoardRowMapper 
		// 객체의 mapRow() 메소드가 실행됨 
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> Spring JDBC로 getBoardList() jdbcTemplate 기능 처리....");
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());			
		}
		
	
		
	
	
	
	
	
	
	
	
	
	
	
}
