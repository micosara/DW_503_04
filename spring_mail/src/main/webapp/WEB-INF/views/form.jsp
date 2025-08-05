<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sendMail" method="post" enctype="multipart/form-data">
		받는사람 : <input type="email" name="receiver" ><br/>
		보내는사람 : <input type="email" name="sender"><br/>
		제목 : <input type="text" name="title" /><br/>
		내용 : <textArea name="content" rows="10" cols="50"></textArea><br/>
		첨부파일 : <input type="file" name="file" /><br/>
		<input type="submit" value="메일보내기" />
	</form>
</body>
</html>