package com.gdu.app13.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app13.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String, Object> isReduceId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("isUser", userMapper.selectUserById(id) != null);    // select 결과가 null이 아니면(조회 되었으면) true
		result.put("isRetireUser", userMapper.selectRetireUserById(id) != null);    // select 결과가 null이 아니면(조회 되었으면) true
      	return result;
	}
	
	@Override
	public Map<String, Object> isReduceEmail(String email) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("isUser", userMapper.selectUserByEmail(email) != null);
		return result;
	}

}
