<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function(){
		$("#tabs").tabs({
			active:2,
			collapsible: true, //탭 접고, 열기 속성 collapsible
			heightStyle: "fill", //fill or auto 패널의 높이
			show: { effect: "snake", duration: 1000 }, // 탭 전환시 기존 내용 사라짐 애니메이션하고 다른 탭으로 넘어감.
			activate: function( event, ui ) {
				/* console.log(ui.oldTab.html()); */ //.html() 이렇게 붙여주면 이전 탭에 있던 경로 div 정보 받아옴.
				console.log($(ui.newPanel).attr("id"));
			},
			event: "mouseover"
				
		});
		//dialog 부분
		$("#msg").dialog({ autoOpen:false, //autoOpen 자동 dialog 막아놈 : false
			buttons : {"확인": addUser, "취소" : function(){$("#msg").dialog("close"); }	}, //확인누르면 addUser함수 처리 (익명함수도 사용해도 된다.), 취소는 dialog 닫기
			modal : true //모달창 활성화 
		}); 
		
		function addUser(){ //확인버튼 눌렀을 시 명령 처리 부분
			alert("등록완료");
		}
		
		//dialog 버튼 클릭 이벤트
		$("#btnMsg").on('click', function(){ //버튼 클릭 했었을 시
			$("#msg").dialog("open"); //dialog 오픈시킨다.
		});
		
		//날짜 입력(달력)
		$("#birth").datepicker({
			dateFormat: "yy-mm-dd",
			maxDate: "+1m +1w", //maxDate: new Date(2018,9,20) //이런식으로도 달력 범위 제한 
			dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ], //달력 요일 변경
			monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ], //월 변경
			
			onSelect : function(strDate, obj){
				$("#birth2").val(obj.currentYear); //.currentYear 년도만 뽑아 오고 싶을때...
				/* console.log(obj); */ //날짜 전체 obj .. 날짜 전체 받고 싶을 때 ....
			}
			
		});
	});
</script>

<title>tab.jsp</title>
</head>
<body>

<input type="text" id="birth"><input type="text" id="birth2">
<input type="button" id="btnMsg" value="open dialog"/>
<div id="msg">제이쿼리 ui 테스트 페이지입니다.</div> <!-- dialog 부분 -->
 
	<!-- <div id="tabs">
	<ul>
		<li><a href="#menu1">메뉴1</a></li>
		<li><a href="#menu2">메뉴2</a></li>
		<li><a href="#menu3">메뉴3</a></li>
	</ul>
	
	<div id="menu1">공지사항<br><br> ㅇㅇ....</div>
	<div id="menu2">자유게시판<br><br><br><br>ㅇㅇ....</div>
	<div id="menu3">관리페이지<br><br><br><br><br><br>ㅇㅇ....</div>
	</div> -->
	
	<div id="tabs">
	<ul>
		<li><a href="#menu1">메뉴1</a></li>
		<li><a href="menu2.jsp">메뉴2</a></li> <!-- jsp 파일 내용 불러옴  -->
		<li><a href="menu3.jsp">메뉴3</a></li>
	</ul>
	
	<div id="menu1">공지사항<br><br> ㅇㅇ....</div>

	</div>
	
	
	
</body>
</html>