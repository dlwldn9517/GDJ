package com.gdu.app05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;
import com.gdu.app05.service.MemberServiceImpl;

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
	
	// field
	private MemberService memberservice = new MemberServiceImpl();
	
	/*
		@ResponseBody
		
		안녕. 난 ajax 처리하는 메소드야.
		내가 반환하는 값은 뷰(JSP) 이름이 아니고, 어떤 데이터(text, json, xml 등)야.
	*/
	
	@ResponseBody
	@GetMapping(value="member/detail1"
			  , produces="text/plain; charset=UTF-8")	// produces : 응답 데이터 타입(MIME-TYPE)
	public String detail1(HttpServletRequest request) {
		String str = memberservice.execute1(request);
		return str;	 // jsp로 인식하지 않도록 해야함
	}
	
	@ResponseBody
	@GetMapping(value="member/detail2"
			  , produces="application/json; charset=UTF-8")
	public Member detail2(@RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		Member member = memberservice.execute2(id, pw);
		return member;	// jackson이 member 객체를 {"id":아이디, "pw":패스워드} 형식의 JSON으로 바꿔서 전달
		
		/*
			추억의 코드
			JSONPObject obj = new JSONPObject(member);
			return obj.toString();
		*/
	}
	
	
	
	
	
}
