package com.gdu.app13.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);

}
