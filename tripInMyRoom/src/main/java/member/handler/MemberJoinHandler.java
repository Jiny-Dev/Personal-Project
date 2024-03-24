package member.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import all.commandHandler.CommandHandler;
import member.service.MemberService;
import model.dto.MemberDTO;

public class MemberJoinHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        /*
        CREATE TABLE memberform(
        	memberID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        	memberPWD VARCHAR(15) NOT NULL,
        	memberPWDConfirm VARCHAR(15) NOT NULL,
        	memberEmail VARCHAR(64) NOT NULL,
        	memberName VARCHAR(10) NOT NULL,
        	hiredate DATE NOT NULL,
        	gender CHAR(1),
        	phone VARCHAR(12) NOT NULL,
        	memberAge INT CHECK(memberAge>=19),
         UNIQUE(memberID)  
        );
        */
        MemberDTO MemberDTO = new MemberDTO();
        
        int memberID = Integer.parseInt(request.getParameter("memberID"));
        String memberPWD = request.getParameter("memberPWD");
        String memberPWDConfirm = request.getParameter("memberPWDConfirm");
        String memberEmail = request.getParameter("memberEmail");
        String memberName = request.getParameter("memberName");
        String birthdateStr = request.getParameter("birthdate");
        char gender = request.getParameter("gender").charAt(0); //.charAt(0)은 문자열에서 첫 번째 문자를 추출하는 메서드
        String phone = request.getParameter("phone");
        int memberAge = Integer.parseInt(request.getParameter("memberAge"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = null;
        birthdate = sdf.parse(birthdateStr);

        MemberDTO.setbirthdate(birthdate);
        
        
        if (memberEmail.length() < 5 || memberEmail.length() > 20 || 
        		!memberEmail.matches("[a-z]+") && !memberEmail.matches("[a-z0-9]+")) {
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
    
    private void registerMember(MemberDTO memberDTO) {
        MemberService memberService = new MemberService();
        try {
            memberService.registerMember(memberDTO);
        } catch (Exception e) {
            // 회원 가입 실패 처리
            e.printStackTrace();
        }
    }
 
}

