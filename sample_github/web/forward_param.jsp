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
		/* request가 넘어갔기 떄문에 꺼낼 수 있는 것 */
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		out.println("아이디 : " + id ); /* 원시적인 표시 */
		out.println("비밀번호 : " + pw + "<br>");
	%>
	<h1>forward_param.jsp 페이지입니다</h1>
	아이디 : <%=id %> <!-- 표현식  -->
	비밀번호 : <%=pw %> <br>
	아이디 : ${param.id } <!-- el 방식  -->
	비밀번호 : ${param.pw } <!-- param : getParameter하라는 것 -->
</body>
</html>