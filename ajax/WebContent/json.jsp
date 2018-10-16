<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	//json javascript object noation
		var obj = {deptno : 10, first_name : 'scott', salary : 2000};
		document.write(obj.first_name) //이름 출력
		var arr = [
			{deptno : 10, first_name : 'scott', salary : 2000},
			{deptno : 20, first_name : 'hong', salary : 2000},
			{deptno : 30, first_name : 'kim', salary : 2000}
		]
		
		var arr = [
			{deptno : [1,2,3], first_name : 'scott', salary : 2000},
			{deptno : 20, first_name : 'hong', salary : 2000},
			{deptno : 30, first_name : 'kim', salary : 2000}
		]
		
		document.write(arr[0].deptno[0]); //두번째 사원 이름
		</script>
</body>
</html>