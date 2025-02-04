<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>내정보 수정</title>
	<link rel = "stylesheet" href = "/tj2024b_webBasic/css/member/info.css">
	</head>
	<body>
		
		<jsp:include page="/header.jsp"></jsp:include>
		<!-- 내정보 수정 -->
		<div class="container col-xl-10 col-xxl-8 px-4 py-5">
			<div class="row align-items-center g-lg-5 py-5">
				<!-- 내정보 확인 구역 -->
				<div class="col-md-10 mx-auto col-lg-5">
					<form id = "signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
						<div class="form-floating mb-3 mimgbox">
							<img src = "" class = "mimg"/>
						</div>
						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input readonly type="text" name = "mid" class="form-control mid" id="floatingInput" placeholder="계정아이디">
							<label for="floatingInput">계정아이디</label>
						</div>
						<!-- 새로운 비밀번호 -->
						<div class="form-floating mb-3">
							<input type="text" name = "mpwd" class="form-control mpwd" id="floatingName" placeholder="닉네임">
							<label for="floatingPassword">새로운 비밀번호</label>
						</div>
						<!-- 닉네임 -->
						<div class="form-floating mb-3">
							<input type="text" name = "mname" class="form-control mname" id="floatingName" placeholder="닉네임">
							<label for="floatingPassword">닉네임</label>
						</div>
						<!-- 연락처 -->
						<div class="form-floating mb-3">
							<input type="text" name = "mphone" class="form-control mphone" id="floatingPhone" placeholder="연락처">
							<label for="floatingPassword">연락처</label>
						</div>
						<hr class = "my-4">
						<button class="w-100 btn btn-lg btn-primary" type="button" onclick = "onUpdate()">회원수정</button>
					</form>
				</div>
			</div>
		</div>
	
	<script src = "/tj2024b_webBasic/js/member/update.js"></script>
	</body>
</html>