

console.log("view.js open");
// [*] 조회할 bno(게시물번호)는 게시물 링크를 클릭했을때 넘긴다.
// -view.jsp?bno=1 처럼
/** 게시물 1개 조회하기 */
let findByBno = () => {
	
	// 1. URL주소상의 bno(게시물번호)를 가져오기
	let bno = new URL(location.href).searchParams.get("bno");
	// 2. fetch option
	const option = {method : "GET"};
	// 3. fetch
	fetch(`/tj2024b_webBasic/board/view?bno=${bno}`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		document.querySelector(".mid_box").innerHTML = data.mid;
		document.querySelector(".bview_box").innerHTML = data.bview;
		document.querySelector(".bdate_box").innerHTML = data.bdate;
		document.querySelector(".title_box").innerHTML = data.btitle;
		document.querySelector(".content_box").innerHTML = data.bcontent;
	})
	.catch(error => {console.log(error); });
	
}
findByBno();

/** 댓글 쓰기 */
let onReplyWrite = () => {
	
	// 입력받은 값 가져오기
	let rcontentinput = document.querySelector(".rcontentinput");
	let rcontent = rcontentinput.value;
	let bno = new URL(location.href).searchParams.get("bno");
	let obj = {rcontent : rcontent, bno : bno};
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(obj)
	};
	fetch(`/tj2024b_webBasic/board/reply`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {			
			alert("댓글쓰기 완료");
			replyfindAll();
		} else {
			alert("댓글쓰기 실패 : 로그인 해주세요");
		}
	})
	.catch(error => { console.log(error); });
	
	
}

/** 현재 게시물의 댓글 전체 조회 */
let replyfindAll = () => {
	
	let bno = new URL(location.href).searchParams.get("bno");
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/board/reply?bno=${bno}`, option)
	.then(response => response.json())
	.then(data => {
		
		let replybox = document.querySelector(".replybox");
		let html = ``;
		
		data.forEach(reply => {
			html += `
			<div class="card mt-3">
			  <div class="card-header">
			  	<img src = "/tj2024b_webBasic/upload/${reply.mimg}" style = "width : 30px;"/>
			    ${reply.mid}
			  </div>
			  <div class="card-body">
			  	${reply.rcontent}
			  </div>
			</div>
			`;
		});
		replybox.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
replyfindAll();
