<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>내정보</title>
	<link rel = "stylesheet" href = "/tj2024b_webBasic/css/member/info.css">
	</head>
	<body>
		
		<jsp:include page="/header.jsp"></jsp:include>
		<!-- 내정보 -->
		<div class="container col-xl-10 col-xxl-8 px-4 py-5">
			<div class="row align-items-center g-lg-5 py-5">
				<!-- 왼쪽 메시지 구역 -->
				<div class="col-lg-7 text-center text-lg-start">
					<table class = "point_table">
						<thead>
							<tr>
								<th class = "point_th">번호</th>
								<th class = "point_th">내용</th>
								<th class = "point_th">포인트</th>
								<th class = "point_th">날짜</th>								
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
				<!-- 내정보 확인 구역 -->
				<div class="col-md-10 mx-auto col-lg-5">
					<form id = "signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
						<div class="form-floating mb-3 mimgbox">
							<img src = "" class = "mimg"/>
						</div>
						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input readonly type="text" name = "mpoint" class="form-control mpoint" id="floatingInput" placeholder="계정아이디">
							<label for="floatingInput">포인트</label>
						</div>
						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input readonly type="text" name = "mid" class="form-control mid" id="floatingInput" placeholder="계정아이디">
							<label for="floatingInput">계정아이디</label>
						</div>
						<!-- 닉네임 -->
						<div class="form-floating mb-3">
							<input readonly type="text" name = "mname" class="form-control mname" id="floatingName" placeholder="닉네임">
							<label for="floatingPassword">닉네임</label>
						</div>
						<!-- 연락처 -->
						<div class="form-floating mb-3">
							<input readonly type="text" name = "mphone" class="form-control mphone" id="floatingPhone" placeholder="연락처">
							<label for="floatingPassword">연락처</label>
						</div>
						<button class="w-100 btn btn-lg btn-primary" type="button" onclick = "onUpdate()">회원수정</button>
						<hr class = "my-4">
						<button class="w-100 btn btn-lg btn-primary" type="button" onclick = "onDelete()">회원탈퇴</button>
					</form>
				</div>
			</div>
		</div>
	
	<script src = "/tj2024b_webBasic/js/member/info.js"></script>
	</body>
</html>