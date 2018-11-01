<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing websockets</title>
</head>
<body>
	<fieldset>
		<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
		<br />
		<!-- 채팅창 -->
		<input type="button" value="조회" onclick="send()" />
		<input type="button" value="전체조회" onclick="sendall()" />
	</fieldset>
</body>

<script type="text/javascript">
	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://localhost/spring/springserver.do');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		//textarea.value += "상대 : " + event.data + "\n";
		var user = JSON.parse(event.data);
		if(msgvo.cmd == "get") {
			textarea.value += msgvo.msg.name + "," + msgvo.msg.role;
		} 
		
		else if(msgvo.cmd == "all") {
			/* for( i in msgvo.msg ){ */
				for(i=0; i<msgvo.msg.length; i++) {
				textarea.value += user.msg[i].name + "," + user.msg[i].role;
			}
		}
		/* textarea.value += user.name +"," + user.role; */
		chatAreaScroll();
	}
	function onOpen(event) {
		textarea.value += "연결 성공\n";
	}
	function onError(event) {
		console.log(event);
		alert(event.data);
	}
	function send() {
		textarea.value += "나 : " + inputMessage.value + "\n";
		
		var msg = {
				cmd: "get",
				msg: document.getElementById("inputMessage").value,
				id: "홍길동" //세션로그인id
				};
		
		webSocket.send(JSON.stringify(msg));
		inputMessage.value = "";
	}
	
	function sendall() {
		textarea.value += "나 : " + inputMessage.value + "\n";
		
		var msg = {
				cmd: "get",
				id: "사용자" //세션로그인id
				};
		
		webSocket.send(JSON.stringify(msg));
		inputMessage.value = "";
	}
	
	function chatAreaScroll() {
		//using jquery
		var textArea = $('#messageWindow');
		textArea.scrollTop(textArea[0].scrollHeight - textArea.height());
		textArea.scrollTop(textArea[0].scrollHeight);
		//using javascript
		var textarea = document.getElementById('messageWindow');
		textarea.scrollTop = textarea.scrollHeight;
	}
</script>
</html>