package member.service;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class MemberService {
    private MemberDAO memberDAO;
    
    public MemberService() {
        memberDAO = new MemberDAO();
    }
    // 회원 가입
    public void registerMember(MemberDTO memberDTO) throws Exception {
        // 유효성 검사
        validateMemberInfo(memberDTO);
        
        // 회원 정보 저장
        memberDAO.addMember(memberDTO);
    }
    
    // 회원 가입 유효성 검사 메서드
    private void validateMemberInfo(MemberDTO memberDTO) throws Exception {
        if (memberDTO.getmemberEmail().length() < 5 || memberDTO.getmemberEmail().length() > 20 || 
            !memberDTO.getmemberEmail().matches("[a-z]+") && !memberDTO.getmemberEmail().matches("[a-z0-9]+")) {
            throw new Exception("이메일은 최소 5자 이상 20자 이내의 소문자만 허용되거나 소문자와 숫자의 조합이어야 합니다.");
        }
        
        if (memberDTO.getmemberPWD().length() < 8 || memberDTO.getmemberPWD().length() > 16 ||
            !memberDTO.getmemberPWD().matches(".*[0-9].*") || 
            !memberDTO.getmemberPWD().matches(".*[a-z].*") || 
            !memberDTO.getmemberPWD().matches(".*[A-Z].*") || 
            !memberDTO.getmemberPWD().matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new Exception("비밀번호는 최소 8자 이상 16자 대소문자, 숫자, 특수문자가 적어도 하나씩 포함되어야 합니다.");
        }

        if (!memberDTO.getmemberPWD().equals(memberDTO.getmemberPWDConfirm())) {
            throw new Exception("비밀번호 확인이 일치하지 않습니다.");
        }

        if (memberDTO.getmemberAge() < 19) {
            throw new Exception("만 19세 이상만 가입할 수 있습니다.");
        }
    }
}
