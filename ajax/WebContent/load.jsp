<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>load.jsp</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script> 
<style>
	/* input:focus { background-color: green;} */
</style>

<script>
	$(function(){ 
		/* =======================
			댓글목록 이벤트 핸들러
			=====================*/
	
		//이벤트타겟(대상)
		$("#btnReq").click(function(e){ //id = btnReq 버튼 클릭했을때 이벤트 핸들러
			
			//1.load
			//$("#result").load("menu1.jsp",function(){alert('완료');}); //result 태그에 바로 넣어줌 menu1의 내용을
			//2.get
			/* $.get("menu1.jsp", function(data){$("#result").html(data)}); */
			//3.ajax 
			$.ajax({url: "menu1.jsp", 
					type: "get", 
					//dataType : "html", (기본 html 디폴트라 생략가능) 
					/* success: function(data){$("#result").html(data) */ 
							}).done(function(data){
								$("#result").html(data);
								})
								
								.fail(function(){
									alert("error");
								})
								
								.always(function() {
									alert("complete");
								});
		});
		
		/* =======================
		댓글등록 이벤트 핸들러
		=====================*/
		$("#btnReply").on("click", function(){
				var param = $("#frm").serialize();
				console.log(param);
		}); //이벤트 대상이란 이벤트핸들러를 연결(bind)
		
		
		
		
	}); /* //ready 이벤트 == window.onload */
	
/* 	function (){
		fgffff
	} 단순 function() 익명함수 부분*/
</script>
</head>

<!-- onclick 같은건 이벤트 리스너(이벤트 사건을 듣고 반응한다는 것) -->
<!-- 이벤트 타입 : click, dblclick, press, keyup, load -->
<!-- 이벤트 리스너 : on(type) 이벤트 타입앞에 on만 붙이면 리스너 -->
<!-- 이벤트 핸들러 : 이벤트 처리 함수, 처리명령  -->
<!-- 이벤트 객체(event) : 이벤트 정보가 담긴다.  -->
<body>

댓글목록<br>

	<input type="button" value="요청" id="btnReq">
	<!-- <input type="button" value="요청" id="btnReq" onclick="function()"> -->
	<div id="result"></div>
	
댓글쓰기<br>
<form id="frm">
	<input type="text" name="writer"/>
	<input type="text" name="content"/>
	<input type="button" value="댓글쓰기" id="btnReply"/>
</form>
</body>
</html>

