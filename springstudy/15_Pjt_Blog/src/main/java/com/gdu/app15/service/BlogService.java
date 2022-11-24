package com.gdu.app15.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface BlogService {

	public void getBlogList(Model model);
	public void saveBlog(HttpServletRequest request, HttpServletResponse response);
	
	
}
