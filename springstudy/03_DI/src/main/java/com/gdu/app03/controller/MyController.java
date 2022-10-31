package com.gdu.app03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app03.domain.Board;

@Controller
public class MyController {
	
	/*
		@RequestMapping(value="/", method=RequestMethod.GET)
		@RequestMapping(value="/", method=RequestMethod.POST)
		
		Spring4부터 새로운 애너테이션으로 바꿀 수 있다.
		
		@GetMapping("/")
		@PostMapping("/")
	*/

	@GetMapping("/")  // http://localhost:9090/app03으로 접속하면 처리되는 메소드
	public String welcome() {
		return "default";
		// ViewResolver에 의해서
		// return "/WEB-INF/views/default.jsp"로 해석된다.
	}


	/*
		Container에 등록된 Bean을 가져오는 방법
		
		@Inject    : 타입(class)이 일치하는 Bean을 가져오는 애너테이션
		@Resource  : 이름(id)이    일치하는 Bean을 가져오는 애너테이션
		@Autowired : 타입(class)이 일치하는 Bean을 가져오는 애너테이션(실무에서 주로 사용)
	*/
	
	/*
		@Autowired 사용 방법
		
		1. 필드로 생성된 Bean 가져오기
			1) 필드마다 @Autowired를 추가한다. (필드가 10개이면 @Autowired도 10번 작성)
			2) 필드가 많으면 사용하지 않는다.
			
		2. 생성자를 이용해 Bean 가져오기
			1) 생성자의 매개변수로 Bean을 가져온다.
			2) @Autowired를 작성할 필요가 없다.
			
		3. 메소드를 이용해 Bean 가져오기
			1) 메소드의 매개변수로 Bean을 가져온다.
			2) @Autowired를 작성해야 한다.
			3) 일반적으로 setter를 사용하지만 setter가 아니어도 상관 없다.
	*/
	
	// 1. 필드로 생성된 Bean 가져오기
	// @Autowired
	// private Board board;	// 객체 변수명은 아무 역할을 하지 않고, Autowired는 type만 확인 함
	
	
	/*
		@Autowired는 타입(class)이 일치하는 Bean을 Container에서 가져온다.
		
		@Autowird
		private Board board;  // 타입(class)이 Board인 Bean을 Container에서 가져오거라.
		
		---- Container -----------------
		<bean id="board1" class="Board">
		--------------------------------
	*/
	
	
	// 2. 생성자를 이용해 Bean 가져오기
	/*
		private Board board;
		
		@Autowired	// 생성자에는 @Autowired를 생략할 수 있다.
		public MyController(Board board) {	// 매개변수 Board board로 타입이 Board인 Bean을 Container에서 가져오거라.
			super();
			this.board = board;
		}
	*/
	
	
	// 3. 메소드를 이용해 Bean 가져오기
	
	private Board board;
	
	@Autowired	// 일반 메소드는 @Autowired를 반드시 작성해야 한다.
	public void setBoard(Board board) {	 // 매개변수 Board board로 Board 타입의 Bean을 Container에서 가져오거라.
		this.board = board;
	}


	@GetMapping("board/detail") // @GetMapping("/board/detail")
	public void boardDetail() {
		System.out.println(board.getBoardNo());
		System.out.println(board.getTitle());
		System.out.println(board.getCreateDate());
	}
	
	
}
