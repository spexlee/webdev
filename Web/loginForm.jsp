<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPEXLE</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="loginForm.css">

</head>
<body>
	<h1>
		<span>S</span><span>P</span><span>E</span><span>X</span><span>L</span><span>E</span>
	</h1>
	<form action="LoginServlet" method="post">
		 <div class="search-id mb-3 mx-auto">
	    	<input type="text" class="form-control" 
	    		placeholder="아이디를 입력하세요">
	 	</div>
	  
	 	<div class="search-pw mb-3 mx-auto">
	    	<input type="password" class="form-control" 
	    	placeholder="비밀번호를 입력하세요">
	    	
	 	</div>
	 	<div class="mx-auto">
			<button type="submit" class="btn btn-warning">login</button>
		</div>
	</form>
	<br>
	<div class="joinUs">
	<a class="btn btn-secondary" href="JoinServlet" role="button">Join us</a>
	</div>
</body>
</html>