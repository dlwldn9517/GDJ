package com.gdu.app15.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app15.domain.CommentDTO;

@Mapper
public interface CommentMapper {

	public int selectCommentCount(int blogNo);
	public int insertComment(CommentDTO comment);
	
	
	
}
