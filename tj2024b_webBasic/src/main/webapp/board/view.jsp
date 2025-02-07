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
		
		<div class ="contaoner">
			<div>
				작성자 : <span class = "mid_box">작성자 구역</span>
				 / 조회수 : <span class = "bview_box">조회수 구역</span>
				 / 작성일 : <span class = "bdate_box">작성일 구역</span>
			</div>
			<div class = "title_box">제목이 들어갈 구역</div>
			<div class = "content_box">본문이 들어갈 구역</div>
		</div>
		
		<jsp:include page = "/footer.jsp"></jsp:include>
		<script src = "/tj2024b_webBasic/js/board/view.js" type = "text/javascript"></script>
		
	</body>
</html>