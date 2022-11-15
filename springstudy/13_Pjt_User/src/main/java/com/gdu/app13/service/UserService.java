package com.gdu.app13.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
	public void join(HttpServletRequest request, HttpServletResponse response);
	public void retire(HttpServletRequest request, HttpServletResponse response);
	
}
