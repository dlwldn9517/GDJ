package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	
	// singleton pattern
	private static StudentDao dao = new StudentDao();
	private StudentDao() {
		try {
			
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static StudentDao getInstance() {
		return dao;
	}
	
	
	// 모든 method는 SqlSessionFactory로부터 SqlSession을 얻어서 사용
	// method
	

}
