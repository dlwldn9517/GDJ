package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class CircleService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 요청 파라미터
		int radius = Integer.parseInt(request.getParameter("radius"));
		double area = radius * radius * 3.14;
		
		// 포워드 할 데이터
		request.setAttribute("radius", radius);
		request.setAttribute("area", Math.PI * Math.pow(radius, 2));
		request.setAttribute("shape", "circle");
		
		// 어디로 어떻게?
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/output.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
