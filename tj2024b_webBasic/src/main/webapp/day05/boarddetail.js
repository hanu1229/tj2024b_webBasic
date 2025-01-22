

/** 수정할 게시물 출력 */
let _print = () => {
	let bno = new URL(location.href).searchParams.get("bno");
	let number = document.querySelector("#number");
	let title = document.querySelector("#title");
	let writer = document.querySelector("#writer");
	let view = document.querySelector("#view");
	let date = document.querySelector("#date");
	let content = document.querySelector("#content");
	let option = {method : "GET"};
	fetch(`/tj2024b_webBasic/day05/board/view?bno=${bno}`, option)
	.then(response => response.json())
	.then(data => {
		number.innerHTML = data.bno;
		title.value = data.btitle;
		writer.innerHTML = data.bwriter;
		view.innerHTML = data.bview;
		date.innerHTML = data.bdate;
		content.value = data.bcontent;
	})
	.catch(error => { console.log(error); });
	
}
_print();

/** 게시물 수정 */
let _update = () => {
	let bno = new URL(location.href).searchParams.get("bno");
	let title = document.querySelector("#title").value;
	let content = document.querySelector("#content").value;
	let object = {bno : bno, btitle : title, bcontent : content};
	let option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	fetch(`/tj2024b_webBasic/day05/board`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("수정 성공");
			location.href = `/tj2024b_webBasic/day05/boardview.jsp?bno=${bno}`;
		} else { alert("수정 실패"); }
	})
}