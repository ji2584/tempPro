package Controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Handler.CommandHandler;
import Handler.NullHandler;



//@WebServlet("/bbb")

public class MemberController extends HttpServlet { 
	//<커맨드,핸들러인스턴스>매핑 정보 저장
	private Map<String,CommandHandler> CommandHandlerMap = 
			new HashMap<>();
	
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
		String configFile = getInitParameter("configFile");
		System.out.println(configFile);
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
			
		}
		System.out.println(prop);
		Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			
			try {
				Class<?>handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = 
						(CommandHandler)handlerClass.newInstance();
				CommandHandlerMap.put(command, handlerInstance);
			}catch (InstantiationException e) {
				e.printStackTrace();
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		System.out.println(CommandHandlerMap);
	}
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		doProcess(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		doProcess(req, resp);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("doProcess");
			String command = request.getRequestURI();//url
			if(command.indexOf(request.getContextPath())==0){//request.getContextPath() project
				command = command.substring(request.getContextPath().length()+1);
			}
			System.out.println(command);//project명 제거
			
			
	CommandHandler handler = CommandHandlerMap.get(command);
	if(handler == null) {
		handler = new NullHandler();
	}
	String viewPage = null;
	try {
		viewPage = handler.process(request,  response);
		
	} catch(Exception e) {
		e.printStackTrace();
	}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward (request, response);
	
			
	}
	
	
	
	

}
