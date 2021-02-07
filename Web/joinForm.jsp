<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome to SPEXLE!</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="JoinForm.css">
</head>
<body>
	<h1>
		<span>S</span><span>P</span><span>E</span><span>X</span><span>L</span><span>E</span>
	</h1>
	<h3>
	Welcome!
	</h3>
	<form action="JoinServlet" method="post" name="joinform">
		 <div class="input-id mb-3 mx-auto">
	    	<input type="text" class="form-control" value="${member.name }"
	    		placeholder="생성할 아이디를 입력하세요">
	 	</div>
	  
	 	<div class="input-pw mb-3 mx-auto">
	    	<input type="password" class="form-control" value="${member.pw }"
	    	placeholder="생성할 비밀번호를 입력하세요">
	 	</div>
	 	
	 	<div class="input-name mb-3 mx-auto">
	    	<input type="text" class="form-control" value="${member.pw }"
	    	placeholder="이름을 입력하세요">
	 	</div>
	 	Telephone number
	 	<div class="input-phone mb-3 mx-auto">
	    	<input type="text" class="form-control" value="${member.phone1 }">-
	    	<input type="text" class="form-control" value="${member.phone2 }">-
	    	<input type="text" class="form-control" value="${member.phone3 }">
	 	</div>
	 	<div class="mx-auto">
			<button type="submit" class="btn btn-warning">sign in</button>
		</div>
	</form>
</body>
</html>