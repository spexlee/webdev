<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
	<h1> main.jsp 페이지입니다. </h1>
	<jsp:forward page="sub.jsp"/><!-- sub.jsp로 이동하라는 명령 -->
	<!-- /를 하는 순간 닫히는 부분이 사라짐 -->
	<!-- JSP용 forward 태그라는 의미 -->
</body>
</html>