<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>메인 페이지</h1>
		<div>
			<h2>게시물 등록</h2>
			<table>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input id = "titleInput" type = "text"/></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><input id = "contentInput" type = "text"/></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input id = "writerInput" type = "text"/></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input id = "passwordInput" type = "text"/></td>
					</tr>
				</tbody>
			</table>
			<br/><br/>
			<button onclick = "_create()">게시물 등록</button>
		</div>
		
		<div>
			<h2>게시물 전체 출력</h2>
			<table border = "1">
				<thead>
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
					</tr>
				</thead>
				<tbody id = "printBoard">
					
				</tbody>
			</table>
		</div>
		
		<script src = "boardservice.js"></script>
	</body>
</html>