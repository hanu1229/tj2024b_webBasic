<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>게시물 수정 페이지</h2>
		<div>
			<div>게시물 번호 : <span id = "number"></span></div>
			<div>제목 : <input id = "title" type = "text"/></div>
			<div>
				작성자 : <span id = "writer"></span>
				조회수 : <span id = "view"></span>
				작성일자 : <span id = "date"></span>
			</div>
			<div>내용 : </div>
			<textarea id = "content" rows = "10" cols = "50"></textarea>
			<div>			
				<button onclick = "_update()">완료</button>
			</div>
		</div>
		
		<script src = "boarddetail.js"></script>
	</body>
</html>