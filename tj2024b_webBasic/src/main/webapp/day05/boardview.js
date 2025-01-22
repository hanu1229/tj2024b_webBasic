let pwd = "";

/** 게시물 개별 조회 */
let find = () => {
	// 1. 전체 URL의 쿼리스트링 매개변수를 가져오기
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
		number.innerHTML = `${data.bno}`;
		title.value = `${data.btitle}`;
		writer.innerHTML = `${data.bwriter}`;
		view.innerHTML = `${data.bview}`;
		date.innerHTML = `${data.bdate}`;
		content.innerHTML = data.bcontent;
		pwd = data.bpwd;
		console.log(content.innerHTML);
	})
	.catch(error => {console.log(error);});
}
find();

/** 게시물 수정 */
let _update = () => {
	let check = prompt("게시물을 수정하시려면\n비밀번호 입력 : ");
	if(pwd == check) {		
		let number = document.querySelector("#number").innerHTML;
		let title = document.querySelector("#title").value;
		let writer = document.querySelector("#writer").innerHTML;
		let view = document.querySelector("#view").innerHTML;
		let date = document.querySelector("#date").innerHTML;
		let content = document.querySelector("#content").value;
		console.log(`${number} / ${title} / ${writer} / ${view} / ${date} / ${content}`);
		let object = {bno : number, btitle : title, bcontent : content};
		let option = {
			method : "PUT",
			headers : {"Content-Type" : "application/json"},
			body : JSON.stringify(object)
		}
		fetch(`/tj2024b_webBasic/day05/board`, option)
		.then(response => response.json())
		.then(data => {})
		.catch(error => { console.log(error); });
	}

}

/** 게시물 삭제 */
let _delete = () => {
	let check = prompt("게시물을 삭제하시려면\n비밀번호 입력 : ");
	if(pwd == check) {
		let bno = document.querySelector("#number").innerHTML;
		let option = {method : "GET"};
		fetch(`/tj2024b_webBasic/day05/board?bno=${bno}`, option)
		.then(response => response.json())
		.then(data => {  
			if(data == true) {
				alert("삭제 성공");
				location.href = '/tj2024b_webBasic/day05/boardservice.jsp';
			}
			else { alert("삭제 실패"); }
		})
		.catch(error => { console.log(error); });
	}
}


