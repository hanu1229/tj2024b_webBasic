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
		
		<div class = "container">
			<button onclick = "location.href = 'write.jsp'">글작성</button>
			<table class = "table boardlist">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
		
		<jsp:include page = "/footer.jsp"></jsp:include>
		
		<script src = "/tj2024b_webBasic/js/board/board.js"></script>
		
	</body>
</html>