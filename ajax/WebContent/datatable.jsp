<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>datatable.jsp</title>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script>
	$(function(){ //jQuery 데이터 테이블 가져와서 씀.
		$("#empList").DataTable();
		//$("#empList").DataTable({ajax:{}}); 아작스 사용시
	});
</script>

</head>
<body>
<table id="empList">
	<thead>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>부서</th>
			<th>직급</th>
		</tr>
	</thead>
	<tbody>
	
		<tr><td>100</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>110</td><td>정현욱</td><td>개발</td><td>대리</td></tr>
		<tr><td>120</td><td>손준우</td><td>개발</td><td>주임</td></tr>
		<tr><td>130</td><td>문준영</td><td>개발</td><td>부장</td></tr>
		<tr><td>140</td><td>홍지상</td><td>개발</td><td>사장</td></tr>
		<tr><td>150</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>160</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>170</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>180</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>150</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>160</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>170</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>180</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>150</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>160</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>170</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		<tr><td>180</td><td>홍길동</td><td>개발</td><td>차장</td></tr>
		
	</tbody>
</table>
</body>
</html>