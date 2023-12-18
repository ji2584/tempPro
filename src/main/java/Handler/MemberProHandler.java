package Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MemberDao;
import Model.KicMember;



public class MemberProHandler implements CommandHandler {
	
	      public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	    	  
	    	  KicMember kicmem = new KicMember();
	    	  request.setCharacterEncoding("utf-8");
	    	  String id = request.getParameter("id");
	    	  String pass = request.getParameter("pass");
	    	  String name = request.getParameter("name");
	    	  int gender = Integer.parseInt(request.getParameter("gender")) ;
	    	  String tel = request.getParameter("tel");
	    	  String email = request.getParameter("email");
	    	  kicmem.setId(id);
	    	  kicmem.setPass(pass);
	    	  kicmem.setName(name);
	    	  kicmem.setGender(gender);
	    	  kicmem.setTel(tel);
	    	  kicmem.setEmail(email);


	    	  MemberDao md = new MemberDao();
	    	  int num = md.insertMember(kicmem);
	    	  String msg = "저장 하였습니다.";
	    	  String url = "/member/loginForm";
	    	  
	    	  request.setAttribute("msg", msg);
	    	  request.setAttribute("url", url);
	    	  
	    	  return "/WEB-INF/view/alert.jsp";    	  
	    	  	    	  	    	  	    	  	    	  	    	  	    	  
	    	
	      
	      
}
} 