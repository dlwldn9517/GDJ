package com.gdu.app13.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.gdu.app13.domain.UserDTO;
import com.gdu.app13.service.UserService;

public class KeepLoginInterceptor implements HandlerInterceptor {

	
	@Autowired
	private UserService userService;
   
	// 컨트롤러의 모든 요청 이전에 KeepLoginInterceptor가 개입
	// 컨트롤러의 모든 요청 이전에 개입한다는 코드를 servlet-context.xml에 작성해둔다.
   
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
      
		// 로그인이 되어 있지 않은 경우 + 쿠키에 keepLogin이 남아있는 경우 → 로그인 유지 동작 (자동 로그인)
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			
			// 쿠키에 keeplogin이 있는가
			// 스프링에서는 특정 쿠키를 가져올 수 있음
			Cookie cookie = WebUtils.getCookie(request, "keepLogin");
			if(cookie != null) {
            
	            // 자동 로그인 수행
	            // keeplogin에 저장된 쿠키값 가져오는 것
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("sessionId", cookie.getValue());
	            
	            UserDTO loginUser = userService.getUserBySessionId(map);
	            if(loginUser != null) {
	            	session.setAttribute("loginUser", loginUser);
	            }
			}
		}
		return true; // 컨트롤러의 요청을 처리하는 메소드가 수행된다.
		
   }
	
}
