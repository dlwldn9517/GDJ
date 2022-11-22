package com.gdu.app14.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.UploadDTO;



public interface UploadService {
	
	public List<UploadDTO> getUploadList();
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void getUploadByNo(int uploadNo, Model model);	// 2가지를 싣어야 함. model에 싣으면 편함
	public ResponseEntity<Resource> download(String userAgent, int attachNo);
	public void removeAttachByAttachNo(int attachNo);
	
}