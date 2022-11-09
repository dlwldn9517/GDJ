package com.gdu.app11.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class PageUtil {

	private int page;	// 현재 페이지 (파라미터로 받아온다.)
	private int totalRecord;	// 전체 레코드 개수 (DB에서 구해온다.)
	private int recordPerPage = 10;	// 페이지에 표시할 레코드 개수 (임의로 정한다.)
	private int begin;	// 가져올 목록의 시작 번호 (계산한다.)
	private int end;	// 가져올 목록의 끝 번호 (계산한다.)
	
	public void setPageUtil(int page, int totalRecord) {
		
		// page, totalRecord 필드 저장
		this.page = page;
		this.totalRecord = totalRecord;
		
		// begin, end 계산
		begin = (page - 1) * recordPerPage + 1;
		end = begin + recordPerPage - 1;
		if(end > totalRecord) {
			end = totalRecord;
		}
		
	}
	
	
}
