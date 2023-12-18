package Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormHandler implements CommandHandler {
	
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
  	  	return"/WEB-INF/view/member/loginForm.jsp";
    
    
}
} 