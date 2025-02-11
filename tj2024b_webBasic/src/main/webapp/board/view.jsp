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
		
		<div class ="continer">
			<div>
				작성자 : <span class = "mid_box">작성자 구역</span>
				 / 조회수 : <span class = "bview_box">조회수 구역</span>
				 / 작성일 : <span class = "bdate_box">작성일 구역</span>
			</div>
			<div class = "title_box" style = "text-align : center; font-size : 30px;">제목이 들어갈 구역</div><br/><br/>
			<div class = "content_box">본문이 들어갈 구역</div><br/><br/>
		</div>
		
		<div>
			<textarea class = "rcontentinput form-control"></textarea>
			<button class = "btn btn-primary mt-5" type = "button" onclick = "onReplyWrite()">댓글 개시</button>
		</div>
		<div class = "replybox mt-5">
			<div class="card mt-3">
			  <div class="card-header">
			    Quote
			  </div>
			  <div class="card-body">
			    <blockquote class="blockquote mb-0">
			      <p>A well-known quote, contained in a blockquote element.</p>
			      <footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
			    </blockquote>
			  </div>
			</div>
		</div>
		
		<jsp:include page = "/footer.jsp"></jsp:include>
		<script src = "/tj2024b_webBasic/js/board/view.js" type = "text/javascript"></script>
		
	</body>
</html>