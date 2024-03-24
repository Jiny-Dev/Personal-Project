package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dto.MemberDTO;

public class MemberDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/memberSchema";
	private static final String membrID = "memberID";
    private static final String memberEmail = "memberEmail";
    private static final String memberPWD = "memberPWD";
    
	//추가
    public void addMember(MemberDTO memberDTO) {
    	String sql = "INSERT INTO member (memberID, memberPWD, memberEmail, memberName, birthdate, gender, phone, memberAge) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }
    
    // 회원 조회
    public MemberDTO getMember(String memberEmail) {
    	String sql = "SELECT * FROM member WHERE memberID = ?";
        MemberDTO memberDTO = null;
		return memberDTO;
    }
    
    // 모든 회원조회
    public List<MemberDTO> getAllMembers() {
    	String sql = "SELECT * FROM member";
        List<MemberDTO> members = new ArrayList<>();
		return members;
    }
    
    //업데이트
    public void updateMember(MemberDTO memberDTO) {
    	String sql = "UPDATE member SET WHERE memberID = ?, memberPWD = ?, memberEmail = ?, memberName = ?, birthdate = ?, gender = ?, phone = ?, memberAge = ?";
    }
    
    //삭제
    public void deleteMember(int memberID) {
    	String sql = "DELETE FROM member WHERE memberID = ?";
    }
    
   
}
