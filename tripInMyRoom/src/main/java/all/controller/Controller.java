package all.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.commandHandler.CommandHandler;
import main.handler.MenuHandler;
import member.handler.LoginHandler;
import member.handler.MemberJoinHandler;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String command = request.getParameter("command");

	    // 로그인 핸들러 호출
	    if ("login".equals(command)) {
	        CommandHandler handler = new LoginHandler();
	        try {
	            String viewPage = handler.process(request, response);
	            request.getRequestDispatcher(viewPage).forward(request, response);
	        } catch (Exception e) {
	            handleException(e, request, response);
	        }
	    }
	    
	    // 회원가입 핸들러 호출
	    if ("memberJoin".equals(command)) {
	        CommandHandler handler = new MemberJoinHandler();
	        try {
	            String viewPage = handler.process(request, response);
	            request.getRequestDispatcher(viewPage).forward(request, response);
	        } catch (Exception e) {
	            handleException(e, request, response);
	        }
	    }
	    
	    // 메뉴 핸들러 호출
	    if ("menu".equals(command)) {
	        CommandHandler handler = new MenuHandler(); // 합쳐진 핸들러를 사용
	        try {
	            String viewPage = handler.process(request, response);
	            request.getRequestDispatcher(viewPage).forward(request, response);
	        } catch (Exception e) {
	            handleException(e, request, response);
	        }
	    }
	}   

	// 예외 처리 메서드
	private void handleException(Exception e, HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    e.printStackTrace();
	    response.sendRedirect("/error-page.jsp");
	}
}