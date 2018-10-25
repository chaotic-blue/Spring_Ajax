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
			if(xhr.readyState == 4) {//전송완료
				if(xhr.status == 200) {//전송 OK
					//결과처리 - json
					//var jsondata = eval( "(" + xhr.responseText + ")");
					//var jsondata = JSON.parse(xhr.responseText); // String -> JSON object 로 변환 
					//document.getElementById("result").innerHTML = jsondata.userid + ":" + jsondata.result;
					
					//결과처리 - xml
 					var datas = xhr.responseXML;
					var userid = datas.getElementsByTagName("userid")[0].firstChild.nodeValue;
					var result = datas.getElementsByTagName("result")[0].firstChild.nodeValue;
					document.getElementById("result").innerHTML = "xml:"+userid + ":" + result; 
					
				} else {
					//에러 메시지
					alert(xhr.status + ":" + xhr.statusText);
				}				
			}else {
				//로딩중 이미지
				document.getElementById("result").innerHTML = "처리중";
			}			
		}
		//2. open (요청방식, url, 비동기, id, pw)서버 연결
		//쿼리 문자열
		var param = "?id=" + document.getElementById("userid").value;
		xhr.open("get", "LoginCheck.do"+param);

		//4. send
		xhr.send();
	}
</script>
</head>
<body>
<form>
	<input type="text" name="userid" id="userid" onchange="dupcheck()" /><span id="result"></span>
	<input type="text" name="userpw" id="userpw" />
	<input type="submit" value="로그인" />
</form>
</body>
</html>