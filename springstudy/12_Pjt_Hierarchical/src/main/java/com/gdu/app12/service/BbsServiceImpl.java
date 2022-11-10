package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app12.mapper.BbsMapper;
import com.gdu.app12.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsMapper bbsMapper;
	private PageUtil pageUtil;
	
	@Override
	public void findAllBbsList(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addBbs(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addReply(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
