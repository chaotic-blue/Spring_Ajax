<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function go_page(p) {
		document.frm.page.value = p;
		document.frm.submit();
	}
	
	function sort(s) {
		document.frm.sort.value = s;
		document.frm.submit();
	}
</script>
</head>
<body>
<img src="./images/aass.png" style="width: 200px"> <!-- servlet-context.xml에 맵핑 시켜놓아 images폴더 찾아 들어감.. 일일히 경로 맞춰줄 필요 x -->
<%-- ${} <%= %> 과 같다.

<% List<> list = request.getAttribute("list"); 
if(list != null)
for ... %> 이런 불필요한게 많다. <% 이것을 사용하면 열고 닫는게 너무 번거로워서 jstl을 사용한다. --%>

<%-- <c:if test="${userSearchDTO.searchCondition=='id'}">
	<%out.print("selected='selected'"); %>
</c:if>
<c:if test="${userSearchDTO.searchCondition=='name'}">
	<%out.print("selected='selected'"); %>
</c:if> --%>
<form action="getUsers.do" name="frm">
	<input type="hidden" name="page" value="1">
	<input type="hidden" name="sort" value="id">
	role<select name="role">
	<option value="">선택</option> 
		<c:forEach items="${roleMap}" var="temp">
			<option value="${temp.key}">${temp.value}</option>
		</c:forEach>
	</select>
	<select name="searchCondition">
		<option value="id" >아이디</option>
		<option value="name" >이름</option>
	</select>
	<input type="text" name="searchKeyword" value="${userSearchDTO.searchKeyword}">
	<input type="submit" value="검색">
</form>

<script>
	document.frm.searchCondition.value='${userSearchDTO.searchCondition}';
</script>

	
<a href="insertUserForm.do">회원등록</a>
<table border="1" style="width: 500px;">
	<tr>
	<td><a href="#" onclick="sort('id')">아이디</a></td>
	<td>패스워드</td>
	<td><a href="#" onclick="sort('name')">이름</a></td>
	<td>롤</td>
	</tr>
	<c:forEach items="${list}" var="user">
	<tr><td><a href="updateUserForm.do?id=${user.id}">${user.id}</a></td><td>${user.password}</td><td>${user.name}</td><td>${user.role}</td></tr> <!-- ${user.id} 이건 public String getId() {}을 호출한다. -->
	</c:forEach>
</table>
<my:paging paging="${paging}" jsFunc="go_page"/>
</body>
</html>