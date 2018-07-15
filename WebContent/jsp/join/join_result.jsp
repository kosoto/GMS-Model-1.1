<%@page import="service.MemberServiceImpl"%>
<%@page import="service.MemberService"%>
<%@page import="repository.MemberDAOImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입결과</title>
</head>
<body>
	<%
	MemberBean member = new MemberBean();
	member.setMemberId(request.getParameter("user-id"));
	member.setPass(request.getParameter("pass"));
	member.setName(request.getParameter("name"));
	member.setSsn(request.getParameter("ssn"));
	String result = MemberServiceImpl.getInstance().join(member);
	%>
	<h3><%=result %></h3>
	<a href="../login/user_login_form.jsp">로그인하기</a>
</body>
</html>