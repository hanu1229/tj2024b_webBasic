<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div id="map" style="width:100%;height:700px;"></div>
		<button style = "display : none;" class="btn btn-primary 사이드바" type="button" data-bs-toggle="offcanvas" data-bs-target="#staticBackdrop" aria-controls="staticBackdrop">
			Toggle static offcanvas
		</button>
		<div class="offcanvas offcanvas-start" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop" aria-labelledby="staticBackdropLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="staticBackdropLabel">상세정보</h5>
				<button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<div class = "약국명"></div>
				<div class = "전화번호"></div>
				<div class = "주소"></div>
			</div>
		</div>

		<!-- 제이쿼리 -->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<!-- 부트스트랩 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- 카카오API -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5152ca192d0ce6a65bcf37f185023083&libraries=clusterer"></script>
		<!-- 사용자 스크립트 -->
		<script type="text/javascript" src="kakao.js"></script>
	</body>
</html>