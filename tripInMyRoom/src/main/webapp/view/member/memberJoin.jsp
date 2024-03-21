<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원가입</title>
</head>

<body>
	<form method="post", action="http://localhost:8085/tripInMyRoom/Controller">
		<div><input type="hidden" name="command" value="memberJoin"></div>
		<div>아이디: <input type="text" name="memberID" id="memberID" placeholder="아이디를 입력하세요." pattern="[a-z0-9_-]*" autocomplete="off" required/></div>
		<div>비밀번호: <input type="password" name="memberPWD" id="memberPWD" placeholder="비밀번호를 입력하세요." pattern="[a-zA-Z0-9_\-!@#$%^&*()+='{}|;:,.<>?/[\]`~]*" autocomplete="off" required/></div>
		<div>비밀번호 확인: <input type="password" name="memberPWDConfirm" id="memberPWDConfirm" placeholder="비밀번호를 한 번 더 입력하세요." pattern="[a-zA-Z0-9_\-!@#$%^&*()+='{}|;:,.<>?/[\]`~]*" autocomplete="off" required/></div>
		<div>이메일: <input type="email" name="memberEmail" id="memberEmail" placeholder="이메일을 입력하세요." required/></div>
		<div>이름: <input type="text" name="memberName" id="memberName" placeholder="이름을 입력하세요." required/></div>
		<div>생년월일: <input type="date" name="birthdate" id="birthdate" placeholder="6자리로 입력하세요." required/></div>
		<input type="radio" value="female" name="gender"/>여성
        <input type="radio" value="male" name="gender"/>남성
        <div>휴대전화번호: <input type="tel" name="phone" id="phone" placeholder="숫자만 입력하세요." required/></div>
		<div>나이: <input type="number" name="memberAge" id="memberAge" placeholder="만 나이를 입력하세요." min="0" required/></div>
		<div><input type="submit" name="submit" id="submit" value="Join"/></div>		
	</form>	
		<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
	    <% if(errorMessage != null) { %><p style="color: red;"><%= errorMessage %></p><% } %>
</body>
</html>