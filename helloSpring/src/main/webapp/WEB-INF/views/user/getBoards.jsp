<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${} <%= %> 과 같다.

<% List<> list = request.getAttribute("list"); 
if(list != null)
for ... %> 이런 불필요한게 많다. <% 이것을 사용하면 열고 닫는게 너무 번거로워서 jstl을 사용한다. --%>
<!-- <a href="insertUserForm.do">회원등록</a> -->
<table border="1" style="width: 500px;">
	<tr><td>제목</td><td>글쓴이</td><td>내용</td><td>날짜</td><td>조회수</td></tr>
	<c:forEach items="${list}" var="board">
	<tr><td><a href="updateUserForm.do?id=${board.seq}">${board.title}</a></td><td>${board.writer}</td><td>${board.content}</td><td>${board.regdate}</td><td>${board.cnt}</td></tr> <!-- ${user.id} 이건 public String getId() {}을 호출한다. -->
	</c:forEach>
</table>
</body>
</html>