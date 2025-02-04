


console.log("info.js open");

/** 현재 로그인 회원정보 요청 함수 (최초 한번 실행 필요) */
let getmyInfo = () => {
	
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/member/info`, option)
	.then(response => response.json())
	.then(data => {
		if(data != null) {
			document.querySelector(".mpoint").value = data.mpoint;
			document.querySelector(".mid").value = data.mid;
			document.querySelector(".mname").value = data.mname;
			document.querySelector(".mphone").value = data.mphone;
			document.querySelector(".mimg").src = `/tj2024b_webBasic/upload/${data.mimg}`;
		}
	})
	.catch(error => { console.log(error); });
	
}
getmyInfo();

/** 회원 탈퇴 요청 함수 */
let onDelete = () => {
	
	// alert : 알림창, confirm : 확인/취소 알림창, prompt : 입력상자 알림창
	let result = confirm("정말 탈퇴 하실건가요?");
	// 만약 취소 버튼을 클릭 했다면 탈퇴 요청을 취소
	if(result == false) { return; } 
	
	const option = {method : "DELETE"};
	fetch(`/tj2024b_webBasic/member/info`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("탈퇴 성공");
			location.href = `/tj2024b_webBasic/index.jsp`;
		} else {
			alert("탈퇴 실패 : 관리자에게 문의");
		}
	})
	.catch(error => { console.log(error); });
	
}

/** 회원수정 페이지 이동 함수 */
let onUpdate = () => {
	// 현재 페이지와 이동할 페이지가 같은 폴더라면 파일명만 작성이 가능
	// 만약 다른 폴더라면 프로젝트명부터 작성
	// 로그인한 회원번호가 톰캣 세션번호에 있기 때문에 굳이 회원번호를 옮길 필요가 없다.
	location.href = "/tj2024b_webBasic/member/update.jsp";
	
}

/** 포인트 내역 전체 출력 함수 */
let printPointLog = () => {
	
	let tbody = document.querySelector("tbody");
	let html = ``;
	let count = 1;
	
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/member/point`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			html += `
			<tr>
				<td class = "point_td">${count++}</td>
				<td class = "point_td">${obj.title}</td>
				<td class = "point_td">${obj.point}</td>
				<td class = "point_td">${obj.date}</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
printPointLog();