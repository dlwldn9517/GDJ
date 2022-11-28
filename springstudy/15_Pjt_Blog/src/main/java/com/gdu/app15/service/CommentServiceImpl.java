package com.gdu.app15.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app15.domain.CommentDTO;
import com.gdu.app15.mapper.CommentMapper;
import com.gdu.app15.util.PageUtil;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public Map<String, Object> getCommentCount(int blogNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("commentCount", commentMapper.selectCommentCount(blogNo));
		return result;
	}
	
	@Override
	public Map<String, Object> addComment(CommentDTO comment) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("isAdd", commentMapper.insertComment(comment) == 1);	// 삽입의 결과가 1과 같으면 성공, 0이면 실패
		return result;
	}
	
	
	
	
}
