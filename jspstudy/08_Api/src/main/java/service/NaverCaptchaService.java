package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NaverCaptchaService {

	public String getCaptchaKey();
	public void getCaptchaImage(HttpServletRequest request, String key);
	public boolean validateUserInput(HttpServletRequest request);
	
}
