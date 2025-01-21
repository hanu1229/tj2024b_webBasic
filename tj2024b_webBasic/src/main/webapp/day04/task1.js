// 함수명을 만들때 내장 함수와 겹치는 경우 오류가 발생하지 않으나 실행이 안될 수도 있음

/** [1] 등록 함수 */
const _write = () => {
	// 1. HTML으로부터 input dom객체 가져오기
	// document.querySelector(선택자) : 선택자를 가진 마크업을 객체로 반환하는 함수
	let contentInput = document.querySelector("#contentInput");
	let ageInput = document.querySelector("#ageInput");
	
	// 2. 입력받은 값 가져오기
	// .value : 마크업의 value 속성값을 가져오는 속성
	let content = contentInput.value;
	let age = ageInput.value;
	
	// 3. 객체화
	// {속성명 : 속성값, 속성명 : 속성값, ...}
	let dataObj = {content : content, age : age};
	
	// 4. fetch 통신
	// method : 통신 타입(GET, POST, PUT, DELETE), headers : 응답값 형태, body : 응답값
	let option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(dataObj)
	}
	fetch(`/tj2024b_webBasic/day03/visit2`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("등록 성공!");
			_findAll();
		} else {
			alert("등록 실패!");
		}
	})
	.catch(error => {console.log(error);});
	
	// 5. 결과에 따른 화면 구현
	
	
}

/**
 * [2] 전체 조회 함수 <p>
 * 실행조건 : 처음 js파일이 로드될때
*/
const _findAll = () => {
	// 1. 어디에, tbody에
	let tbody = document.querySelector("tbody");
	
	// 2. 무엇을, fetch로 받은 자료들을
	let html = ``;
	const option = {method : "GET"}
	fetch(`/tj2024b_webBasic/day03/visit2`, option)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {			
			html += `
			<tr>
				<td>${obj.num}</td>
				<td>${obj.content}</td>
				<td>${obj.age}</td>
				<td>
					<button onclick = "_update(${obj.num})">수정</button>
					<button onclick = "_delete(${obj.num})">삭제</button>
				</td>
			</tr>
			`;
		});
		// 3. 출력, .innerHTML : 지정한 마크업에 html문자열을 넣거나 출력하는 속성
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error);});
}
_findAll();

/** [3] 수정 함수 */
const _update = (num) => {
	// prompt함수로 수정할 content/age 받기
	let content = prompt("new content");
	let age = prompt("new age");
	let values = {num : num, content : content, age : age};
	const option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(values)
	};
	fetch('/tj2024b_webBasic/day03/visit2', option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("수정 성공");}
		else { alert("수정 실패");}
		_findAll();
	})
	.catch(error => {console.log(error);});
}

/** [4] 삭제 함수 */
const _delete = (num) => {
	// 1. 삭제할 식별자 num
	
	// 2. fetch함수를 이용해 서블릿(VisitController.java)에게 HTTP delete Method 처리를 요청
	const option = {method : "DELETE"};
	fetch(`/tj2024b_webBasic/day03/visit2?num=${num}`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("삭제성공"); _findAll();}
		else {alert("삭제실패");}
	})
	.catch(error => {console.log(error);});
}
