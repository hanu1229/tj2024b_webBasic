<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<jsp:include page = "/header.jsp"></jsp:include>
		
		<div>
			<div id = "msg-box" class = "mb-3"></div>
			<textarea id = "msg-input"></textarea>
			<button type = "button" onclick = "onMsgSend()">전송</button>
		</div>
	
	<script src = "/tj2024b_webBasic/js/chatting/chatting.js"></script>
	</body>
</html>