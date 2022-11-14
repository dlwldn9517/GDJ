package com.gdu.app13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/agree")
	public String agree() {
		return "user/agree";
	}
}
