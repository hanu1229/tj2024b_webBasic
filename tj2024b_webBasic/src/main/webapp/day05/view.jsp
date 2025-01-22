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
			<h3>게시물 개별 조회 : 상세페이지로 선택한 특정 게시물을 조회합니다.</h3>
			<a href = "update.jsp?bno=1">수정</a>
		</div>
		<jsp:include page = "/day05/footer.jsp"/>
		
	</body>
</html>