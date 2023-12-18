package Handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MemberDao;
import Model.KicMember;



public class MemberInfoHandler implements CommandHandler{
	
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		
		MemberDao md = new MemberDao();
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("id");
		KicMember mem = md.oneMember(login);
		request.setAttribute("mem", mem);

			return "/WEB-INF/view/member/memberinfo.jsp";

}

}
