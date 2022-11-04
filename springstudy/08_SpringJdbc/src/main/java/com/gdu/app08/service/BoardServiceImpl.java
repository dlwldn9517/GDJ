package com.gdu.app08.service;

import java.util.List;

import com.gdu.app08.domain.BoardDTO;
import com.gdu.app08.repository.BoardDAO;


public class BoardServiceImpl implements BoardService {

	private BoardDAO dao;
	
	// 생성자의 매개변수 BoardDAO dao로 new BoardDAO()가 주입되고 있다.
	// BoardAppContext.java 참고
	public BoardServiceImpl(BoardDAO dao) {	
		super();
		this.dao = dao;
	}
	
	// 복습. 이러한 방법도 있다.
	// AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BoardAppContext.class);
	// private BoardDAO dao = ctx.getBean("dao", BoardDAO.class);	// Bean의 이름(id) = 메소드명(ex. dao)
	
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}

	

}
