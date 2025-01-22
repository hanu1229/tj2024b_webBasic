<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h1>게시물 상세 페이지</h1>
		<div>
			<div>게시물번호 : <span id ="number"></span></div>
			<div>제목 : <input id = "title" type = "text"/></div>
			<span> 작성자 : <span id = "writer"></span></span>
			<span> 조회수 : <span id = "view"></span></span>
			<span> 작성일자 : </span><span id = "date"></span><br/>
			<div>내용 : </div>
			<textarea id = "content" rows="10" cols="50"></textarea>
			<br/><br/>
			<div>
				<button onclick = "_update()">수정</button>
				<button onclick = "">삭제</button>
				<button onclick = "location.href = '/tj2024b_webBasic/day05/boardservice.jsp'">뒤로가기</button>
			</div>
		</div>
		
		<script src = "boardview.js"></script>
	</body>
</html>