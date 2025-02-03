


console.log("signup.js open");

/** 회원가입 요청 함수 */
let onSignUp = () => {
	
	// 1. 입력받은 자료를 가져오기 (form을 한번에 가져오기)
	// 첨부파일 때문에 application/json 대신 multipart/form-data를 사용
	// form-data로 전송할 경우에는 속성명들을 'name'속성으로 식별(사용)한다.
	let signupform = document.querySelector("#signupform");
	console.log(signupform);
	
	// 2. fetch를 이용한 'multipart/form-data'를 전송하는 방법
	// [1] 전송할 폼을 바이트(바이너리/스트림)데이터로 변환, FormData 클래스, new FormData(Form DOM);
	const signupformData = new FormData(signupform);
	// 만일 html 폼에 없는 데이터를 폼데이터에 추가하는 방법
	// signupformData.append("속성명" , 값);
	// [2] fetch 옵션
	const option = {
		method : "POST",
		// 기본값이라 생략한다.
		// headers : {"Content-Type" : "multipart/form-data"}
		// JSON.stringify()를 하지 않는 이유는 폼 전송이 json형식이 아니기 때문이다.
		body : signupformData
	};
	// [3] fetch 요청과 응답
	fetch(`/tj2024b_webBasic/member/signup`, option)
	.then(response => response.json())
	.then(data => {
		// 회원가입 성공 시 메시지 출력 후 로그인 페이지로 이동
		if(data == true) { alert("회원가입 성공"); location.href = "/tj2024b_webBasic/member/login.jsp"; }
		// 이유는 다양
		else { alert("회원가입 실패"); }
	})
	.catch(error => { console.log(error); });
	
	
}