package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.CircleService;
import service.MyService;
import service.RectangleService;
import service.TriangleService;

@WebServlet("*.do")


public class MyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
	
		MyService myService = null;
		
		ActionForward actionForward = null;
		
		// 요청에 따른 Model의 선택
		switch(command) {
		
		// 비즈니스 로직이 필요한 경우
		case "rectangle.do":
			myService = new RectangleService();
			break;
		case "triangle.do":
			myService = new TriangleService();
			break;	
		case "circle.do":
			myService = new CircleService();
			break;
		
		// 비즈니스 로직이 필요 없는 단순 이동의 경우
		case "input.do":
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			break;
		}
		
		// 선택한 Model의 실행
		if(myService != null) {
			actionForward = myService.execute(request, response);
		}
		
		// 이동(리다이렉트, 포워드)
		if(actionForward != null) {
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getView());
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
