<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h3>회원정보 등록</h3>
<form action="./insertBoard.do" method="post" enctype="multipart/form-data">
	title <input type="text" name="title"><br>
	writer <input type="text" name="writer"><br>
	content<textarea rows="5" cols="40" name="contnet"></textarea><br>
	<input type="file" name="uploadFile"><br>
	<input type="file" name="uploadFile"><br>
	<input type="file" name="uploadFile"><br>
	<input type="submit" value="등록">
	
</form>
</body>
</html>