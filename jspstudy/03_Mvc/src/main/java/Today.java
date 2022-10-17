

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet({"/today.do", "now.do"})
@WebServlet("*.do")	// .do로 끝나는 모든 요청


public class Today extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청
		request.setCharacterEncoding("UTF-8");
		
		// 요청 확인(/today.do 인지 /now.do 인지)
		String requestURI = request.getRequestURI();							// requestURI  : /03_Mvc/today.do 또는 /03_Mvc/now.do
		String contextPath = request.getContextPath();							// contextPath : /03_Mvc
		String command = requestURI.substring(contextPath.length() + 1 );		// command     : today.do 또는 now.do
		
		// 요청에 따른 Model의 선택
		switch(command) {
		case "today.do":
			TodayService todayService = new TodayService();
			todayService.execute(request, response);
			break;
		case "now.do":
			NowService nowService = new NowService();
			nowService.execute(request, response);
			break;
		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
