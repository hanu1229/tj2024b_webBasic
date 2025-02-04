

console.log("update.js open");

// 대부분 수정은 기존의 데이터를 먼저 보여줘야한다.
/** 현재 로그인 회원정보 요청 함수 (최초 한번 실행 필요) */
let getmyInfo = () => {
	
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/member/info`, option)
	.then(response => response.json())
	.then(data => {
		if(data != null) {
			document.querySelector(".mid").value = data.mid;
			document.querySelector(".mname").value = data.mname;
			document.querySelector(".mphone").value = data.mphone;
			document.querySelector(".mimg").src = `/tj2024b_webBasic/upload/${data.mimg}`;
		}
	})
	.catch(error => { console.log(error); });
	
}
getmyInfo();

/** 회원정보 수정 요청 함수 */
let onUpdate = () => {
	let mpwd = document.querySelector(".mpwd").value;
	let mname = document.querySelector(".mname").value;
	let mphone = document.querySelector(".mphone").value;
	let obj = {mpwd : mpwd, mname : mname, mphone : mphone};
	const option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	};
	
	fetch(`/tj2024b_webBasic/member/info`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("회원정보 수정 성공");
			location.href = `/tj2024b_webBasic/member/info.jsp`;
		} else {
			alert("회원정보 수정 실패 : 관리자에게 문의");
		}
	})
	.catch(error => { console.log(error); });
	
}