<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>user-login</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">사용자 로그인</h2>	
		<form action="user_login_result.jsp">
			ID <br>
			<input type="text" name="user-id" ><br>
			Pass <br>
			<input type="text" name="pass"  ><br>
			<input type="submit" value="제출">
		</form><br>
		<button><a href="../../main.jsp">돌아가기</a></button>
	</div>
</body>
</html>