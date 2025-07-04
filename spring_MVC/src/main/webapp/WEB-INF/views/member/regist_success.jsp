<%@page import="com.spring.command.RegistCommand"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<li>아이디 : ${command.username } </li>
		<li>패스워드 : ${command.password } </li>
		<li>이름 : ${command.name } </li>
		<li>이메일 : ${command.email } </li>
		<li>전화번호 : ${command.phone } </li>
		<li>주소 : ${command.addr } </li>
	</ul>
</body>
</html>