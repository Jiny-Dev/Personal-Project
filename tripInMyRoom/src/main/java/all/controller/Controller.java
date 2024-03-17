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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandHandler handler = new LoginHandler();
        try {
            String viewPage = handler.process(request, response);
            request.getRequestDispatcher(viewPage).forward(request, response);
        } catch (Exception e) { //이 부분은 잘 모르겟심
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        
        // POST 요청을 처리하는 부분에서 MenuHandler 호출
        CommandHandler menuHandler = new MenuHandler();
        try {
            String viewPage = menuHandler.process(request, response);
            request.getRequestDispatcher(viewPage).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandHandler handler = new MenuHandler(); // MenuHandler를 호출하도록 변경
        try {
            String viewPage = handler.process(request, response);
            request.getRequestDispatcher(viewPage).forward(request, response);
        } catch (Exception e) { 
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
