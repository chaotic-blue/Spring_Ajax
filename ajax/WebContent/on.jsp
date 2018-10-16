<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>on.jsp</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

	/* $(function(){ // 직접형
		//li 태그에 마우스 오버 이벤트 지정하는 부분
		$("li").on("mouseover", function(){
			$(this).css("backgroundColor", "yellowgreen");
		});
		
		//li 태그에 마우스 오버 이벤트 지정하는 부분
		$("li").on("mouseout", function(){
			$(this).css("backgroundColor", ""); //"" 아무것도 없는 색으로 만들기위해 빈칸
		});
		
		//버튼 누르면 목록추가 이벤트 
		$("#btnAdd").on("click", function(){
			var bookname=prompt("도서명 입력");
			$("ul").append("<li>"+bookname);
		})
		
	}); */
	
	 $(function(){ // 위임형
	//li 태그에 마우스 오버 이벤트 지정하는 부분
	$("ul").on("mouseover","li", function(){
		$(this).css("backgroundColor", "yellowgreen");
	});
	
	//li 태그에 마우스 오버 이벤트 지정하는 부분
	$("ul").on("mouseout","li", function(){
		$(this).css("backgroundColor", ""); //"" 아무것도 없는 색으로 만들기위해 빈칸
	});
	
	//버튼 누르면 목록추가 이벤트 
	$("#btnAdd").on("click", function(){
		var bookname=prompt("도서명 입력");
		$("ul").append("<li>"+bookname);
	})
	
}); 
</script>

</head>
<body>
<pre>
	직접형 : 이벤트대상.on(type, 핸들러)
	위임형 : 부모태그.on(type, 이벤트대상, 핸들러) on == delagte (같음)
</pre>
<input type="button" id="btnAdd" value="신규도서추가"/>
<ul>
	<li>java
	<li>jsp
</ul>
</body>
</html>