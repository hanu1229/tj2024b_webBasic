<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>JSP 파일</h3>
	<h6>JSP 파일은 서블릿과 다르게 자동으로 경로가 설정 된다.</h6>
	<div>
		<button onclick = "func1(3, 4)"> 선언적 함수 실행 </button>
		<button onclick = "func2(5, 1)"> 익명 함수 실행 </button>
		<button onclick = "func3(10, 7)"> 람다식 함수 실행 </button>
	</div>
	
	<script src = "example1.js"></script>

</body>
</html>