package com.gdu.app05.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gdu.app05.domain.Board;

public class BoardServiceImpl implements BoardService {

	/*
			ResponseEntity<T> 클래스
			
			안녕. 난 Ajax 응답 데이터를 만들기 위한 전용 클래스야.
			
			new ResponseEntity<T>(T body, HttpHeaders header, HttpStatus status)
			1) T body 			  : 실제 응답할 데이터
			2) HttpHeaders header : 응답 헤더
			3) HttpStatus status  : 응답 코드 (200, 404, 500 등)
	 */
	
	@Override
	public ResponseEntity<Board> execute1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board(title, content);
		
		ResponseEntity<Board> entity = null;
		if(title.isEmpty()) {
			entity = new ResponseEntity<Board>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);	// INTERNAL_SERVER_ERROR : 500번 (자바 코드 에러)
		}
		
		return entity;
	}

	@Override
	public ResponseEntity<Board> execute2(String title, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Board> execute3(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
