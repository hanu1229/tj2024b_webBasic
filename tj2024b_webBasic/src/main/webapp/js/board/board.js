

console.log("board.js open");
// [1] URL경로상의 cno 매개변수를 구하는 법
console.log(new URL(location.href).searchParams);
console.log(new URL(location.href).searchParams.get("cno"));

/** 지정한 카테고리별 게시물 조회 요청 */
let findAll = () => {
	
	// 1. 현재 페이지의 카테고리 구하기
	let cno = new URL(location.href).searchParams.get("cno");
	// 2. fetch option
	const option = {method : "GET"};
	// 3. fetch
	fetch(`/tj2024b_webBasic/board?cno=${cno}`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		
		// 4. 출력할 DOM객체의 반환
		let boardlist = document.querySelector(".boardlist > tbody");
		// 5. 출력할 내용을 담을 변수 선언
		let html = ``;
		// 6. 서블릿으로 응답받은 자료들을 반복문으로 처리
		data.forEach(board => {
			// 7. 게시물 하나씩 html 테이블의 행으로 표현하기
			html += `
			<tr>
				<td>${board.bno}</td>
				<td><a href = "/tj2024b_webBasic/board/view.jsp?bno=${board.bno}">${board.btitle}</a></td>
				<td>${board.mid}</td>
				<td>${board.bdate}</td>
				<td>${board.bview}</td>
			</tr>
			`;
		});
		boardlist.innerHTML = html;
	})
	.catch(error => { console.log(error); });
	
}
findAll();