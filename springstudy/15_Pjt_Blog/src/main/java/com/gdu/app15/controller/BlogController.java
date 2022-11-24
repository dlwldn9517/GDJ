package com.gdu.app15.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app15.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/blog/list")
	public String list(HttpServletRequest request, Model model)	{
		model.addAttribute("request", request);	// model에 request를 저장하기
		blogService.getBlogList(model);			// model만 넘기지만 이미 model에 request가 들어 있어서 서비스단에서 model로부터 request를 꺼낸다.
		return "blog/list";						// 이렇게 하면 모든 서비스의 매개변수를 모델로 통일 가능. 
												// 서비스 하나당 메소드 하나 있을 때 매개변수의 통일이 필요한데 모델 하나로만 쓴다. (request response 각각 필요한거 담아서 사용 가능)
	}
	
	@GetMapping("/blog/write")
	public String write() {
		return "blog/write";
	}
	
	@PostMapping("/blog/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		blogService.saveBlog(request, response);
	}
	
	@PostMapping(value="/blog/uploadImage", produces="application/json")
	public Map<String, Object> uploadImage(MultipartHttpServletRequest multipartRequest) {	// 이미지 첨부가 가능한 request 
		return blogService.saveSummernoteImage(multipartRequest);
	}
	
	
	
	
	
	
}
