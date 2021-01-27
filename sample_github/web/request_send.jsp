<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	/* int로변환해서 바로 대입하여라, 예외처리도 잘 해야 함*/
	if (age >= 20){
		response.sendRedirect("pass.jsp");
		/* response를 클라이언트라고 해도 된다.
		즉 클라이언트한테 redirect해라 (방향을 바꿔라)고 명함*/
	}else{
		response.sendRedirect("ng.jsp");
		
	}
	
	
%>
</body>
</html>