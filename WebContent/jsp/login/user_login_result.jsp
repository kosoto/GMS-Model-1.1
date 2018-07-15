<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%@ page import="service.*" %>
<%@ page import="domain.*" %>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","kstad", "1234" -->
<!doctype html>
<html lang="en">
<head>
<%
MemberBean m = new MemberBean();
m.setMemberId(request.getParameter("user-id"));
m.setPass(request.getParameter("pass"));
if(MemberServiceImpl.getInstance().login(m)){

%>
	<!-- <meta charset="UTF-8" />	 -->
<meta http-equiv="refresh" content="0;url='../mypage/my_page.jsp'">
	<title>Document</title>
</head>
<body>
<%		
			
}else{
%> 
<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>	
<h3>로그인실패</h3>
<a href="user_login_form.jsp">다시 로그인하기</a>
<%
}
%>
	
</body>
</html>