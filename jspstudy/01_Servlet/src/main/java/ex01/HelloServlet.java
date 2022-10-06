package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Servlet
	
	1. 웹 화면을 만드는 자바 클래스
	2. JSP/Servlet Container (Tomcat)에 의해서 실행
	3. 서블릿을 실행하면 웹 브라우저가 실행됨
	4. URL
		프로토콜://호스트:포트번호/컨텍스트패스/URLMapping     → 호스트:포트번호 - 같은 로컬호스트, 컨텍스트패스 - 같은 프로젝트, URLMapping - 서블릿이며, 서블릿이름과 같다
		http://localhost:9090/01_Servlet/HelloServlet
*/


@WebServlet("/HelloServlet")	// URL Mapping


public class HelloServlet extends HttpServlet {	  // Servlet은 HttpServlet을 상속 받으면 된다.
	
    /*
       	1. 생성자
       		1) 가장 먼저 호출
       		2) 생성자 호출 뒤 init() 메소드가 호출
    */
    public HelloServlet() {
        super();
        System.out.println("생성자");
    }

	/*
		2. 초기화
			1) 각종 초기화 정보 실행
			2) 서블릿 환경 설정 처리
			3) init() 메소드 호출 뒤 service() 메소드 호출
	*/
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	/*
		3. 서비스
			1) 클라이언트의 요청마다 매번 호출
			2) GET 방식의 요청은 doGet() 메소드 호출, POST 방식의 요청은 doPost() 메소드 호출
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
		4. doGet
			1) GET 방식의 요청을 처리
			2) 요청 메소드가 GET인 경우
				(1) $.ajax({
					'type': 'GET',
					'url': '/01_Servlet/HelloServlet'
				});
				(2) <a href="http://localhost:9090/01_Servlet/HelloServlet">링크</a>
				(3) <form method="GET"> 또는 <form>
				(4) location.href='http://localhost:9090/01_Servlet/HelloServlet'
					open('http://localhost:9090/01_Servlet/HelloServlet')
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
