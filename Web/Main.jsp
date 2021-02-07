<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPEXLE</title>
</head>
<body>
<h1>회원관리 프로그램</h1>
<h3>${name }님 회원목록</h3>
<a href= "LogoutServlet">로그아웃</a>
<a href= "ModifyServlet">정보수정</a>
<!-- 테이블로 구성 -->
<table border="1">
	<tr>
		<th>이름</th><th>연락처</th><th>성별</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach items="${members }" var="member"> <!-- items: request놈의 것을 빼오는 것 -->
	<!-- members에서 하나 씩 빼와서 member에 넣어주는 것! => 컬렉션 -->
	<!-- members는 하나하나가 memberVO인 것 => name, id, pw, phone123,gender가 있었음 -->
	<!-- tr이 반복되어야 하기 때문에 반복문 안에 기입-->
		<tr> 
			<td>${member.name }</td>
			<td>${member.phone1 }-${member.phone2 }-${member.phone3 }</td>
			<td>${member.gender }</td>
			<td><a href="ModifyServlet?id=${member.id }">수정</a></td> 			
			<td><a href="DeleteServlet?id=${member.id }">삭제</a></td> 			
		</tr>
	</c:forEach>
</table>	
</body>
</html>