


console.log("login.js open");

/** 로그인 요청 함수 */
let onLogin = () => {
	
	// [1] html input dom 가져오기
	let midInput = document.querySelector(".midinput");
	let mpwdInput = document.querySelector(".mpwdinput");
	// [2] input 입력값 가져오기
	let mid = midInput.value;
	let mpwd = mpwdInput.value;
	// [3] 유효성 검사
		
	// [4] 보낼 데이터로 객체(JSON)화
	const obj = {mid : mid, mpwd : mpwd};
	const option = {
		// 요청할 http method 선택
		method : "POST",
		// 요청할 http body 타입 설정
		headers : {"Content-Type" : "application/json"},
		// 요청할 http 자료, 자료를 JSON형식의 문자열 타입으로 변환
		body : JSON.stringify(obj)
	};
	// [5] fetch
	fetch(`/tj2024b_webBasic/member/login`, option)
	.then(response => response.json())
	.then(data => {
		if(data > 0) {
			alert("로그인 성공");
			clientWebSocket.send(`${mid}님 접속했어요`);
			location.href = "/tj2024b_webBasic/index.jsp";
		}
		else { alert("로그인 실패"); }
	})
	.catch(error => { console.log(error); });
	
}