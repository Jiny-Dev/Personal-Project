package main.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.commandHandler.CommandHandler;

public class MenuHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html;charset=UTF-8");
        
        //전체 메뉴
        // 뷰 페이지에서 사용할 정보 저장
        String allMenu = request.getParameter("");
        String bestMenu = request.getParameter("");
        request.setAttribute("allMenu", allMenu);

        // 뷰페이지 리턴 (상대 경로 사용)
        return "/view/menu/allMenu.jsp";
        
    }

    
}
