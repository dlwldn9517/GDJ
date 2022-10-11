package ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieServlet")


public class MovieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 클라이언트 아이디, 시크릿
		String clientId = "r8AzKZxCTRl5CxIreAMx";
		String clientSecret = "PxjZVSOTBc";
		
		// 요청 파라미터(검색어)
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		
		// 검색어 UTF-8 인코딩
		try {
			query = URLEncoder.encode(query, "UTF-8"); 
		} catch (UnsupportedEncodingException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("검색어 인코딩 실패");
			out.close();
		}
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query=" + query;
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			// 잘못된 형태의 URL
	         response.setContentType("text/plain; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("API URL이 잘못되었습니다. : "); // responseText로 넘어감
	         out.close();
		} catch (IOException e) {
			 response.setContentType("text/plain; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("API 연결이 실패했습니다. : "); // responseText로 넘어감
	         out.close();
		}
		
		// API 요청
		try {
			// 요청 메소드
			con.setRequestMethod("GET");
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
		} catch (IOException e) {
			 response.setContentType("text/plain; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("API 요청이 실패했습니다. : "); // responseText로 넘어감
	         out.close();
		}
		
		// 응답 스트림 생성(정상 스트림, 에러 스트림)
		try {
			int responseCode = con.getResponseCode();	// 응답코드(status)를 의미
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
