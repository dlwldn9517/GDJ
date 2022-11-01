package com.gdu.app05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController1 {

	@GetMapping("/")
	public String index() {
		return "index";	  // index.jsp로 forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member";  // member.jsp로 forward
	}
	
}
