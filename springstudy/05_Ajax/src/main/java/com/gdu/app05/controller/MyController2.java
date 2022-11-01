package com.gdu.app05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController2 {
	
	@GetMapping("board")
	public String board() {
		return "board";		// board.jsp로 forward
	}
	
	
	// BoardServiceImple의
	// execute1() 메소드 호출
	

}
