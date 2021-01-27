<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록화면</title>
</head>
<body>
	<h1>사원등록</h1>
	<form action="EmpServlet" method="post"> 
	<table>
<!-- select 할때만 get을 사용함, insert update delete는 post방식이 적절함-->
		<tr>
			<td>사원번호</td>
			<td><input type = "text" name ="empno" size = "10"></td>
		</tr>
		<tr>
			<td>사원명 </td>
			<td><input type = "text" name = "empnm" size = "10"></td>
		</tr>
		<tr>
			<td>부서번호</td>
			<td>
				<select name = "deptno">
				<option value = "001">기획부</option>
				<option value = "002">영업부</option>
				<option value = "003">인사부</option>
				<option value ="004">총무부</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td> 
				<input type = "radio" name = "sex" value = "남"> 남
				<input type = "radio" name = "sex" value = "여"> 여
				<!-- name이 다르면 별개로 묶인다 -->
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<input type = "checkbox" name = "hobby" value = "01"> 코딩
				<input type = "checkbox" name = "hobby" value = "02"> 탱고
				<input type = "checkbox" name = "hobby" value = "03"> 유튜브 보기
			</td>
		</tr>
		<tr>
			<td colspan ="2">
				<input type = "submit" value = "사원등록">
<!--  input 태그는 인라인 element 이기 때문에 한 줄로 입력 됨 -->
			</td>
		</tr>
	</table>
	</form>
</body>
</html>