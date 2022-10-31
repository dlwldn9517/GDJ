package com.gdu.app03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app03.domain.Notice;

@Configuration
public class SpringBeanConfig {

	@Bean
	public Notice notice1() {
		Notice notice = new Notice();
		notice.setNoticeNo(1);
		notice.setTitle("일반공지");
		return notice;
	}
	
}
