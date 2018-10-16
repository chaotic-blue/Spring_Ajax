<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xhr.jsp</title>

<script>
	function dupcheck(){
		//1.xhr 객체 생성
		var xhr = new XMLHttpRequest();
		
		//3. 콜백함수
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4) // 4 전송완료 되었음.
				if(xhr.status == 200) { // status 200 = 전송 OK
					//결과처리
					/* var jsondata = eval("("+xhr.responseText + ")"); */
					var datas = xhr.responseXML;
					var userid = datas.getElementsByTagName("userid")[0].firstChild.nodeValue;
					var result = datas.getElementsByTagName("result")[0].firstChild.nodeValue;
					/* var jsondata = JSON.parse(xhr.responsText); //String -> JSON object로 바꿔줌. */
					document.getElementById("result").innerHTML = "xml: " + userid + ":" + result;
				} else {
					alert(xhr.status + ":" + xhr.statusText);// 에러 메시지
				} else {
					document.getElementById("result").innerHTML = "처리중";//로딩줄 이미지
				}
		}
		
		
		//2. open (서버연결)
		//쿼리문자열
		var param = "?userid=" + document.getElementById("userid").value;
		xhr.open("get", "LoginCheck" + param);
		
		
		//4. send
		xhr.send();
	}
	
</script>
</head>
<body>

<form>
	<input type="text" name="userid" id="userid" onchange="dupcheck()"> <span id="result"></span>
	<input type="text" name="userpw" id="userpw"/>
	<input type="submit" value="로그인"/>
	
</form>

</body>
</html>