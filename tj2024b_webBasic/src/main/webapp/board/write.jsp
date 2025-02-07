<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글쓰기</title>
		<!-- summernote를 사용하기 위한 CSS URL -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css"
		integrity="sha512-rDHV59PgRefDUbMm2lSjvf0ZhXZy3wgROFyao0JxZPGho3oOuWejq/ELx0FOZJpgaE5QovVtRN65Y3rrb7JhdQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>
		
		<jsp:include page = "/header.jsp"></jsp:include>
		
		<div class = "container">
			<form>
				<select class = "cno_select form-select">
					<!--
						option에는 카테고리명 대신 카테고리번호인 식별자를 넣어야 하는 이유
						글 등록시 카테고리명이 아닌 카데고리번호
					-->
					<option value = "1">뉴스</option>
					<option value = "2">이벤트</option>
					<option value = "3">FAQ</option>
					<option value = "4">튜토리얼</option>
					<option value = "5">사용자 리뷰</option>
				</select>
				<input type = "text" class = "title_input form-control"/>
				<textarea name = "editordata" id = "summernote" class = "content_input form-control"></textarea>
				<button class = "btn btn-primary" type = "button" onclick = "onWrite()">등록</button>
			</form>
		</div>
		
		<jsp:include page = "/footer.jsp"></jsp:include>
		
		<!-- JQuery 라이브러리 URL -->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<!-- summernote를 사용하기 위한 스크립트 URL -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js" 
		integrity="sha512-qTQLA91yGDLA06GBOdbT7nsrQY8tN6pJqjT16iTuk08RWbfYmUz/pQD3Gly1syoINyCFNsJh7A91LtrLIwODnw=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js" 
		integrity="sha512-npFeJw8MO1QVbeFuD7rqVR1CpAbOnUMoYnZIxDbz58biKU52Unq7Av3cn+SZ2KD4yOLWj4bOcjIV1+d4aEXAyg==" 
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<!-- 주의할점 : JS를 불러오는 순서가 존재하므로 내가 만든 JS를 가장 아래에서 호출해야한다 -->
		<script src = "/tj2024b_webBasic/js/board/write.js"></script>
	</body>
</html>