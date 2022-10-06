package ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/my")
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		// 	  1) 클라이언트 → 서버로 보내는 요청 또는 데이터
		//	  2) HttpServletRequest request 객체가 처리 (Tomcat이 있어야 사용 가능)
		
		// 1) 요청에 포함된 한글 처리(문자셋 : UTF-8)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 파라미터(Parameter) 확인
		// 	  (1) URL?파라미터=값&파라미터=값
		// 	  (2) 모든 파라미터는 String 타입!
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		// null 처리
		int age = 0;
		if(strAge != null) {
			age = Integer.parseInt(strAge);
		}
		
		// 2. 응답
		//    1) 서버 → 클라이언트로 보내는 응답
		//    2) HttpServletResponse response 객체가 처리 (Tomcat이 있어야 사용 가능)
		
		// 1) 사용자에게 전달할 데이터의 형식을 HTML 문서로 결정한다.
		//    MIME-TYPE을 활용
		//    (1) HTML  : text/html
		//    (2) CSS   : text/css
		//    (3) JS    : text/javascript
		//    (4) XML   : application/xml
		//    (5) JSON  : application/json
		response.setContentType("text/html");
		
		// 2) 응답에 포함되는 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// 1) MIME-TYPE + 2) 문자셋
		response.setContentType("text/html; charset=UTF-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
