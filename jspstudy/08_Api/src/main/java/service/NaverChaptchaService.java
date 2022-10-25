package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NaverChaptchaService {

	public String getChaptchaKey(HttpServletRequest request, HttpServletResponse response);
	public void getChaptchaImage(HttpServletRequest request, String key);
	public boolean validateUserInput(HttpServletRequest request);
	
}
