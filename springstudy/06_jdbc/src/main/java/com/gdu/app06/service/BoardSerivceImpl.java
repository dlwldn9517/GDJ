package com.gdu.app06.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;

@Service	// Service가 사용하는 @Component == @configuration, @bean
public class BoardSerivceImpl implements BoardService {

	@Override
	public List<BoardDTO> findAllBoards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
