package ex02_datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_SimpleDateFormat {

	public static void main(String[] args) {
		
		// java.text.SimpleDateFormat 클래스
		// 패턴이 적용된 String 타입의 날짜 반환
		
		Date date1 = new Date();
		java.sql.Date date2 = new java.sql.Date	(System.currentTimeMillis());
		//클래스 명명 규칙으로, 동일한 클래스를 동시에 2개는 불러오지 못한다.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result1 = sdf.format(date1);
		String result2 = sdf.format(date2);
		
		System.out.println(result1);
		System.out.println(result2);
	}

}