package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import all.commandHandler.CommandHandler;

public class LoginHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("userID");
        String password = request.getParameter("userPWD");

        if ("wonjiny".equals(userId) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            return "/view/main/mainForm.jsp";
        } else {
            String errorMessage = "아이디 또는 비밀번호가 잘못되었습니다. 다시 시도해주세요.";
            request.setAttribute("errorMessage", errorMessage);
            return "/view/member/loginForm.jsp";
        }
    }
}
