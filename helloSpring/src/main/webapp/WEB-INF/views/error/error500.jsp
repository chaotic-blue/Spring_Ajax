<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %> <!--  isErrorPage="true" 명시하여 에러페이지라고 알려줌 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
에러 : <%=exception.getMessage() %> <br>
관리자에게 문의하세요. 010-1111-2222
</body>
</html>