import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");
		String now = sdf.format(date);
		
		request.setAttribute("result", now);
		
	}
	
}
