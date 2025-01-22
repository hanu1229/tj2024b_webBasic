<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	
		<jsp:include page = "/day05/header.jsp"/>
		<div>
			<h3>게시판 : 커뮤니티를 제공합니다.</h3>
			<a href = "/tj2024b_webBasic/day05/write.jsp">글쓰기</a>
			<button onclick = "location.href='/tj2024b_webBasic/day05/write.jsp'">글쓰기</button>
			<!-- location.href는 자바스크립트에서 제공하는 페이지 이동 관련 속성 -->
			<br/><br/>
			<table border = "1">
				<thead>
					<tr>
						<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th><th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td><td><a href = "view.jsp?bno=1">안녕하세요1</a></td>
						<td>2025-01-22 11:09:05</td><td>유재석</td><td>30</td>
					</tr>
					<tr>
						<td>2</td><td><a href = "view.jsp?bno=2">안녕하세요2</a></td>
						<td>2025-01-22 11:12:15</td><td>강호동</td><td>4</td>
					</tr>
				</tbody>
			</table>
		</div>
		<jsp:include page = "/day05/footer.jsp"/>
		
	</body>
</html>