package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")

public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// 요청
	request.setCharacterEncoding("UTF-8");
	
	
	// 변수(파라미터)
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String city = request.getParameter("city");

	
	// 배열(파라미터)
	String[] phone = request.getParameterValues("phone");
	String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2]; 
	String[] agree = request.getParameterValues("agree");
	
	
	// 응답
	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = response.getWriter();
	out.println("<h3>아이디 : " + id + "</h3>");
	out.println("<h3>비밀번호 : " + pwd + "</h3>");
	out.println("<h3>성별 : " + gender + "</h3>");
	out.println("<h3>도시 : " + city + "</h3>");
	out.println("<h3>연락처 : " + strPhone + "</h3>");
	out.println("<h3>동의여부 : " + Arrays.toString(agree) + "</h3>");
	List<String> list = Arrays.asList(agree);
	if(list.contains("marketing")) {
		out.println("<h3>마케팅 동의한 회원</h3>");
	}
	out.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
