package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;

public class MemberDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	
	// singleton pattern
	private static MemberDao dao = new MemberDao();
	private MemberDao() {
		try {
			
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	
	// 모든 method는 SqlSessionFactory로부터 SqlSession을 얻어서 사용
	// method
	
	String mapper = "mybatis.mapper.member.";
	
	// 1. 회원 목록
	public List<Member> selectAllMembers() {
		SqlSession ss = factory.openSession();
		List<Member> members = ss.selectList(mapper + "selectAllMembers");
		ss.close();
		return members;
	}
	
	// 2. 회원수
	public int selectAllMembersCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllMembersCount");
		ss.close();
		return count;
	}
	
	// 3. 
	
	
	
	
}

