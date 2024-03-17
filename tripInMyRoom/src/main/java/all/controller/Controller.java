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
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		
		CommandHandler handler = new MenuHandler(); // 합쳐진 핸들러를 사용

	    try {
	        String viewPage = handler.process(request, response);
	        request.getRequestDispatcher(viewPage).forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}
		
/*		// 메뉴1 핸들러 호출
		else if ("menu1".equals(command)) {
			CommandHandler handler = new AllMenuHandler();
			try {
				String viewPage = handler.process(request, response);
				request.getRequestDispatcher(viewPage).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		// 메뉴2 핸들러 호출
		else if ("menu2".equals(command)) {
			CommandHandler handler = new BestMenuHandler();
			try {
				String viewPage = handler.process(request, response);
				request.getRequestDispatcher(viewPage).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
		// 메뉴3 핸들러 호출
				else if ("menu3".equals(command)) {
					CommandHandler handler = new countryMenuHandler();
					try {
						String viewPage = handler.process(request, response);
						request.getRequestDispatcher(viewPage).forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
				}
		// 메뉴4 핸들러 호출
				else if ("menu4".equals(command)) {
					CommandHandler handler = new themeMenuHandler();
					try {
						String viewPage = handler.process(request, response);
						request.getRequestDispatcher(viewPage).forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
				}
		// 메뉴5 핸들러 호출
				else if ("menu5".equals(command)) {
					CommandHandler handler = new storeMenuHandler();
					try {
						String viewPage = handler.process(request, response);
						request.getRequestDispatcher(viewPage).forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
				}
		// 메뉴6 핸들러 호출
				else if ("menu6".equals(command)) {
					CommandHandler handler = new eventMenuHandler();
					try {
						String viewPage = handler.process(request, response);
						request.getRequestDispatcher(viewPage).forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
				}
	}
*/		

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
