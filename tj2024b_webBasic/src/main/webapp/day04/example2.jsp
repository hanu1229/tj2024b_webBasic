<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h3>[1] 클릭 이벤트로 람다식 함수 호출</h3>
		<button onclick = "func1()">func1</button>
		
		<h3>[2] Fetch함수를 이용한 HTTP통신</h3>
		<button onclick = "func2()">func2(GET)</button>
		<button onclick = "func3()">func3(POST)</button>
		<button onclick = "func4()">func3(PUT)</button>
		<button onclick = "func5()">func3(DELETE)</button>
	
		<h3>[3] Fetch함수를 이용한 HTTP QueryString</h3>
		<button onclick = "func6()"> func6(GET)</button>
		<button onclick = "func7()"> func7(POST)</button>
		<button onclick = "func8()"> func8(PUT)</button>
		<button onclick = "func9()"> func9(DELETE)</button>
		
		<h3>[4] Fetch함수를 이용한 HTTP Header Body</h3>
		<button onclick = "func10()">func10(POST)</button>
		<button onclick = "func11()">func11(PUT)</button>
		<div>GET / DELETE method는 body 비권장</div>
		
		<h3>[5] Fetch함수를 이용한 HTTP HEADER BODY 응답 통신</h3>
		<button onclick = "func12()">func12(GET)</button>
		<button onclick = "func13()">func13(POST)</button>
		<button onclick = "func14()">func14(PUT)</button>
		<button onclick = "func15()">func15(DELETE)</button>
		<button onclick = "test()">test</button>
		
	</div>

	<script src = "example2.js"></script>
</body>
</html>