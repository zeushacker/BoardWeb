package com.global.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOMybatis boardDAO;
	//private BoardDAOSpring boardDAO;
	//private BoardDAO boardDAO;
	//private LogAdvice log;
	
	
	public BoardServiceImpl() {
	//log = new LogAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
	/*
		if(vo.getSeq() == 0) {
			 throw new  IllegalArgumentException("0번 글은 등록 할 수 없습니다."); 
		 }
	*/
		//boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
       boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
        boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLog();
		return boardDAO.getBoardList(vo);
	}

}
