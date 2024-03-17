<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Enjoy! Special Trip!</title>
</head>

<body>
	<!-- 메뉴 -->
	<div>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu1">
            <button type="submit">전체메뉴</button>
        </form>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu2">
            <button type="submit">베스트</button>
        </form>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu3">
            <button type="submit">국가/지역</button>
        </form>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu4">
            <button type="submit">계절/테마</button>
        </form>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu5">
            <button type="submit">스토어</button>
        </form>
        <form action="/tripInMyRoom/Controller" method="post">
            <input type="hidden" name="command" value="menu6">
            <button type="submit">이벤트</button>
        </form>
    </div>
	<hr/>
</body>
</html>