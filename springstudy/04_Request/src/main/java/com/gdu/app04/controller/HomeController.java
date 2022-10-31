package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController1 {

	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
}
