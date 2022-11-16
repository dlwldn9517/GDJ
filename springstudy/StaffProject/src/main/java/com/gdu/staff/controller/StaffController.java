package com.gdu.staff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	
	
	
}
