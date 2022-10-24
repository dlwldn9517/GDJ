package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDao;

public class MemberAddService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String address = request.getParameter("address");
		
		// 삽입할 Member member 생성
		Member member = Member.builder()
				.id(id)
				.name(name)
				.gender(gender)
				.grade(grade)
				.address(address)
				.build();
		
		// 삽입
		int result = MemberDao.getInstance().insertMember(member);
		
		// 응답 데이터 형식 (JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터
		/*
			삽입 성공
			{
				"isSuccess": true
			}
			
			삽입 실패
			{
				"isSuccess": false
			}
		*/
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", result > 0);
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.close();
		
	}

}
