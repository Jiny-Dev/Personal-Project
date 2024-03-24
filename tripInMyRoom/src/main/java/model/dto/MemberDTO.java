package model.dto;

import java.util.Date;

public class MemberDTO {
	 private int memberID;
	 private String memberPWD;
	 private String memberPWDConfirm;
	 private String memberEmail;
	 private String memberName;
	 private Date birthdate;
	 private char gender;
	 private String phone;
	 private int memberAge;
	 
	 public int getmemberID() {
		 return memberID;
	 }
	 public void setmemberID(int memberID) {
		 this.memberID = memberID;
	 }
	 public String getmemberPWD() {
		 return memberPWD;
	 }
	 public void setmemberPWD(String memberPWD) {
		 this.memberPWD = memberPWD;
	 }
	 public String getmemberPWDConfirm() {
		 return memberPWDConfirm;
	 }
	 public void setmemberPWDConfirm(String memberPWDConfirm) {
		 this.memberPWDConfirm = memberPWDConfirm;
	 }
	 public String getmemberEmail() {
		 return memberEmail;
	 }
	 public void setmemberEmail(String memberEmail) {
		 this.memberEmail = memberEmail;
	 }
	 public String getmemberName() {
		 return memberName;
	 }
	 public void setmemberName(String memberName) {
		 this.memberName = memberName;
	 }
	 public Date getbirthdate() {
		 return birthdate;
	 }
	 public void setbirthdate(Date birthdate) {
		 this.birthdate = birthdate;
	 }
	 public char getgender() {
		 return gender;
	 }
	 public void setgender(char gender) {
		 this.gender = gender;
	 }
	 public String getphone() {
		 return phone;
	 }
	 public void setphone(String phone) {
		 this.phone = phone;
	 }
	 public int getmemberAge() {
		 return memberAge;
	 }
	 public void setmemberAge(int memberAge) {
		 this.memberAge = memberAge;
	 }

}
