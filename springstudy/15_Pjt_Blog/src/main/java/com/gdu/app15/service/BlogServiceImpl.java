package com.gdu.app15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app15.mapper.BlogMapper;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	
	
}
