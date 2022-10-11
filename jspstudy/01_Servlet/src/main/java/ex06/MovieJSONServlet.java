package ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/MovieJSONServlet")


public class MovieJSONServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 아이디, 시크릿
		String clientId = "r8AzKZxCTRl5CxIreAMx";
		String clientSecret = "PxjZVSOTBc";
		
		// 요청 파라미터(검색어, 검색결과수)
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		String display = request.getParameter("display");
		
		// 응답할 JSON 객체 만들기
		JSONObject obj = new JSONObject();
		obj.put("query", query);
		obj.put("display", display);
	
		// 응답
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.close();
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query=" + query + "&display=" + display;
		URL url = null;
		HttpURLConnection con = null;
		
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		
		BufferedReader reader = null;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
