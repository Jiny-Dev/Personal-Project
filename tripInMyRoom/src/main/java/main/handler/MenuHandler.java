package main.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.commandHandler.CommandHandler;

public class MenuHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("text/html;charset=UTF-8");

        String command = request.getParameter("command");
        String menu = "";
        String viewPage = "/view/menu/";

        // 메뉴
        if ("menu1".equals(command)) {
            menu = "allMenu";
            viewPage += "allMenu.jsp";
        } else if ("menu2".equals(command)) {
            menu = "bestMenu";
            viewPage += "bestMenu.jsp";
        } else if ("menu3".equals(command)) {
            menu = "countryMenu";
            viewPage += "countryMenu.jsp";
        } else if ("menu4".equals(command)) {
            menu = "themeMenu";
            viewPage += "themeMenu.jsp";
        } else if ("menu5".equals(command)) {
            menu = "storeMenu";
            viewPage += "storeMenu.jsp";
        } else if ("menu6".equals(command)) {
            menu = "eventMenu";
            viewPage += "eventMenu.jsp";
        } 
     

        // 해당 메뉴 정보 저장, 전달
        request.setAttribute(menu, request.getParameter(menu));

        // 뷰페이지 리턴
        return viewPage;
    }
}
