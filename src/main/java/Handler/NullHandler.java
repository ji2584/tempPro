package Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class NullHandler implements CommandHandler{
	
	
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
			req.setAttribute("msg", "url이 없습니다.");

			return "/WEB-INF/view/Null.jsp";

}

}
