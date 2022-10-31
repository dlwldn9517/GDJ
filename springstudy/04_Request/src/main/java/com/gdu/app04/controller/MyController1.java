package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.Member;

@RequestMapping("member")	// URL Mapping이 member로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController1 {
	
	// <a href="${contextPath}/member/detail1">
	@GetMapping("detail1")		  // member/detail1 요청을 처리하시오.
	public String detail1(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 request에 담아 두는 방법
		request.setAttribute("member", member);
		
		return "member/detail";	  // member 폴더 아래 detail.jsp로 forward 하시오.
	}
	
	// location.href='${contextPath}/member/detail2?id=admin&pw=1234';
	@GetMapping("detail2")
	public String detail2(@RequestParam(value="id") String id	// 파라미터 id를 String id에 저장하시오.
			            , @RequestParam(value="pw") String pw	// 파라미터 pw를 String pw에 저장하시오.
			            , Model model) {
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 model에 담아 두는 방법 (이것이 스프링의 방식)
		// request를 이용하는 방식에 비해 보안이 향상되었다.
		model.addAttribute("member", member);   // model은 request를 저장소로 사용한다.
		
		return "member/detail";   // member 폴더 아래 detail.jsp로 forward 하시오.
	}
	
}
