
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
<!-- request안에서 꺼내는 것 -->
<!-- 수정 입력할 수 있는 FORM -->
<form action="ModifyServlet" method= "post">
		이름 : <input type="text" name="name" size="10" value="${member.name }"/><br/> <!-- 여기서 name은 session에서 출력한 것 -->
		아이디 :  ${id }<br/> <!-- 아이디는 input이 있으면 안됨  -->
		비밀번호 : <input type="password" name="pw" size="10"/><br/>
		전화번호 : 
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
		</select> <!-- 인라인 input -->	
		-
		<input type="text" name="phone2" size="4" value="${member.phone2 }"/>
		-
		<input type="text" name="phone3" size="4" value="${member.phone3 }"/>
		<br/>
		
		<!-- jstl로 작성 -->
		<c:if test="${member.gender == 'man' }">
		
		성별 : <input type="radio" name="gender" value="man" checked="checked">남
		     <input type="radio" name="gender" value="woman">여
		</c:if>
		
		<c:if test="${member.gender == 'woman' }">
		성별 : <input type="radio" name="gender" value="man" >남
		     <input type="radio" name="gender" value="woman" checked="checked">여
		</c:if>
		<br/>
		<input type="submit" value="회원수정" />
</form>	
</body>
</html>