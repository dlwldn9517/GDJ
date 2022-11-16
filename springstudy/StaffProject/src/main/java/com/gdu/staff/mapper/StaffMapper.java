package com.gdu.staff.mapper;

import org.apache.ibatis.annotations.Mapper;

/*
	@Mapper
	안녕. 난 mybatis의 매퍼와 직접 연결되는 인터페이스야.
	내가 가진 메소드를 호출하면 매퍼의 쿼리문이 바로 호출되지.
	내 메소드 이름은 쿼리문의 id와 같아야 해.
	날 찾으려면 @MapperScan이 필요해. (DBConfig에 추가할거야.)
*/
@Mapper
public interface StaffMapper {
	

}
