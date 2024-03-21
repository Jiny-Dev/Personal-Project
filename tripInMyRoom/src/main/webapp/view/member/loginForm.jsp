<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Check-In</title>
</head>

<body>
	<form method="post", action="http://localhost:8085/tripInMyRoom/Controller">
		<input type="hidden" name="command" value="login">
		<input type="text" name="memberID" id="memberID" placeholder="아이디를 입력하세요."/>
		<input type="password" name="memberPWD" id="memberPWD" placeholder="비밀번호를 입력하세요."/>
		<input type="submit" name="submit" id="submit" value="Login"/>		
	</form>	
		<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
	    <% if(errorMessage != null) { %><p style="color: red;"><%= errorMessage %></p><% } %>
</body>
</html>