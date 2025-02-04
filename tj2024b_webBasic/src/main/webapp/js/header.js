


console.log("header.js open");
/** 로그인 정보 요청 함수 */
let getLoginInfo = () => {
	let loginmenu = document.querySelector("#loginmenu");
	let html = ``;
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/member/info`, option)
	.then(response => response.json())
	.then(data => {
		// 코드가 변경 후 서버가 자동 재실행이 되면 세션 초기화됨
		if(data == null) {
			console.log("비로그인상태");
			html += `
			<li class="nav-item">
				<!-- class = "nav-link active"로 작성시 글자가 검은색으로 나옴 -->
				<a class="nav-link" aria-current="page" href="/tj2024b_webBasic/member/login.jsp">로그인</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/tj2024b_webBasic/member/signup.jsp">회원가입</a>
			</li>
			`;
		}
		else {
			console.log("로그인 상태");
			html +=
			`
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle custom_dropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					<img class = "header_profile" src = "/tj2024b_webBasic/upload/${data.mimg}"/>${data.mname} 님
				</a>
				<ul class="dropdown-menu">
				<li><a class="nav-link" style = "cursor : pointer;" href = "/tj2024b_webBasic/member/info.jsp">마이페이지</a></li>
				<li><a class="nav-link" style = "cursor : pointer;" onclick = "onLogOut()">로그아웃</a></li>
				</ul>
			</li>
			`;
		}
		loginmenu.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
// JS가 열렸을때 최초 1번 실행
getLoginInfo();

/** 로그아웃 요청 함수 */
let onLogOut = () => {
	
	const option = { method : "DELETE"}
	fetch(`/tj2024b_webBasic/member/login`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("로그아웃합니다.");
			location.href = "/tj2024b_webBasic/member/login.jsp";
		}
	})
	.catch(error => { console.log(error); });
	
}