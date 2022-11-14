package com.gdu.app13.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.gdu.app13.mapper.UserMapper;
import com.gdu.app13.util.SecurityUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor		// 필드의 @Autowired 역할
@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	private SecurityUtil securityUtil;
	
	
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
	
	@Override
	public Map<String, Object> sendAuthCode(String email) {
		
		// 인증코드 만들기
		String authCode = securityUtil.getAuthCode(6);	// String authCode = securityUtil.generateRandomString(6);
		System.out.println("발송된 인증코드 : " + authCode);
		
		// 이메일 전송을 위한 필수 속성을 Properties 객체로 생성
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");		// 구글 메일로 보냄(보내는 메일은 구글 메일만 가능)
		properties.put("mail.smtp.port", "587");				// 구글 메일로 보내는 포트 번호
		properties.put("mail.smtp.auth", "true");				// 인증된 메일
		properties.put("mail.smtp.starttls.enable", "true");	// TLS 허용
		
		/*
			이메일 보내기 API 사용을 위한 사전 작업
			
			1. 구글 로그인
			2. Google 계정 - 보안
				1) 2단계 인증  - 사용
				2) 앱 비밀번호
					(1) 앱 선택   : 기타
					(2) 기기 선택 : Windows 컴퓨터
					(3) 생성 버튼 : 16자리 앱 비밀번호를 생성해 줌(이 비밀번호를 이메일 보낼 때 사용)
		*/
		
		// 이메일을 보내는 사용자 정보
		String username = "";						// 본인 지메일
		String password = "bcgsblmjuojqgunx";	// 발급 받은 앱 비밀번호
		
		
		return null;
	}

}
