

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