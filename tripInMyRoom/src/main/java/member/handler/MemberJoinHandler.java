package member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.commandHandler.CommandHandler;

public class MemberJoinHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("memberID");
        String memberPWD = request.getParameter("memberPWD");
        String memberPWDConfirm = request.getParameter("memberPWDConfirm");
        String memberEmail = request.getParameter("memberEmail");
        String memberName = request.getParameter("memberName");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        int memberAge = Integer.parseInt(request.getParameter("memberAge"));

        if (memberID.length() < 5 || memberID.length() > 20 || 
        		!memberID.matches("[a-z]+") && !memberID.matches("[a-z0-9]+")) {
            String errorMessage = "아이디는 최소 5자 이상 20자 이내의 소문자만 허용되거나 소문자와 숫자의 조합이어야 합니다.";
            request.setAttribute("errorMessage", errorMessage);
            return "/view/member/memberJoin.jsp";
        }


        if (memberPWD.length() < 8 || memberPWD.length() > 16 ||
        		!memberPWD.matches(".*[0-9].*") || 
                !memberPWD.matches(".*[a-z].*") || 
                !memberPWD.matches(".*[A-Z].*") || 
                !memberPWD.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            String errorMessage = "비밀번호는 최소 8자 이상 16자 대소문자, 숫자, 특수문자가 적어도 하나씩 포함되어야 합니다";
            request.setAttribute("errorMessage", errorMessage);
            return "/view/member/memberJoin.jsp";
        }


        if (!memberPWD.equals(memberPWDConfirm)) {
            String errorMessage = "비밀번호 확인이 일치하지 않습니다.";
            request.setAttribute("errorMessage", errorMessage);
            return "/view/member/memberJoin.jsp";
        }

        if (memberAge < 19) {
            String errorMessage = "만 19세 이상만 가입할 수 있습니다.";
            request.setAttribute("errorMessage", errorMessage);
            return "/view/member/memberJoin.jsp";
        }

        return "/view/member/loginForm.jsp";
    }
}

