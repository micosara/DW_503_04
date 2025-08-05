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
		<li>받는 사람 : ${mailRequest.receiver }</li>
		<li>보내는 사람 : ${mailRequest.sender }</li>
		<li>제목 : ${mailRequest.title }</li>
		<li>내용 : ${mailRequest.content }</li>
		<li>첨부파일 : ${mailRequest.file.getOriginalFilename() }</li>
	</ul>
</body>
</html>