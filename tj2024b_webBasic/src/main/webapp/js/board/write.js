

console.log("write.js open");

$(document).ready(function() {
	$("#summernote").summernote({
		lang : "ko-KR",
		placeholder : "Hello Bootstrap 5",
		tabsize : 2,
		height : 400
	});
});

/** 글쓰기 요청 함수 */
let onWrite = () => {
	
	// 첨부파일이 존재한다면 무조선 form 전송을 해야한다.
	// 1. 입력받은 값ㄱ들을 가져오기 위해서 DOM 객체 호출
	let cnoSelect = document.querySelector(".cno_select");
	let titleInput = document.querySelector(".title_input");
	let contentInput = document.querySelector(".content_input");
	// 2. DOM 객체에서 입력받은 value값 호출
	let cno = cnoSelect.value;
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	console.log(bcontent);
	// 3. 값들을 묶어주는 객체(json)만들기
	let obj = {cno : cno, btitle : btitle, bcontent : bcontent};
	// 4. fetch option
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	};
	// 5. fetch
	fetch(`/tj2024b_webBasic/board`, option)
	.then(response => response.json())
	.then(data => {
		if(data) {
			alert("등록 성공");
			location.href = `/tj2024b_webBasic/board/board.jsp?cno=${cno}`;
		} else {
			alert("등록 실패");
		}
	})
	.catch(error => { console.log(error); });
	
}