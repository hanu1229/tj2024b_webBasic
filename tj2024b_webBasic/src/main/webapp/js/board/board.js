

console.log("board.js open");
// [1] URL경로상의 cno 매개변수를 구하는 법
console.log(new URL(location.href).searchParams);
console.log(new URL(location.href).searchParams.get("cno"));

/** 지정한 카테고리별 게시물 조회 요청 */
let findAll = () => {
	
	// 1. 현재 페이지의 카테고리 구하기
	let cno = new URL(location.href).searchParams.get("cno");
	let page = new URL(location.href).searchParams.get("page");
	// 만약 page 쿼리스트링이 없을경우 1페이지로 설정
	if(page == null) { page = 1; }
	// 2. fetch option
	const option = {method : "GET"};
	// 3. fetch
	fetch(`/tj2024b_webBasic/board?cno=${cno}&page=${page}`, option)
	.then(response => response.json())
	.then(data => {
		console.log(data);
		
		// 4. 출력할 DOM객체의 반환
		let boardlist = document.querySelector(".boardlist > tbody");
		// 5. 출력할 내용을 담을 변수 선언
		let html = ``;
		// 6. 서블릿으로 응답받은 자료들을 반복문으로 처리
		let boardList = data.data;
		boardList.forEach(board => {
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
		getPageBtn(data, cno);
	})
	.catch(error => { console.log(error); });
	
}
findAll();

/** 페이지 버튼 생성 함수, 실행조건 : 게시물 출력 후 */
let getPageBtn = (data, cno) => {
	// 문자열로 들어올 수 있기때문에 숫자로 변환해야한다.
	let page = parseInt(data.page);
	let pagebtnBox = document.querySelector(".pagebtnbox");
	let html = ``;
	html += `
	<li class="page-item">
		<a class="page-link" href="board.jsp?cno=1&page=${page <= 1 ? 1 : page-1}">이전</a>
	</li>
	`;
	// 1부터 10까지 버튼만들기. 최대페이지. 현재페이지의 버튼의 시작번호, 현재페이지의 끝버튼의 끝번호
	// startbtn ~ endbtn
	// for(let index = 0; index < 10; index++) {
	for(let index = data.startbtn; index <= data.endbtn; index++) {
		html += `
		<li class="page-item">
			<a class="page-link ${page == index ? 'active' : ''} " href="board.jsp?cno=${cno}&page=${index}">${index}</a>
		</li>
		`;
	}
	html += `
	<li class="page-item">
		<a class="page-link" href="board.jsp?cno=${cno}&page=${page >= data.totalpage ? page : page + 1}">다음</a>
	</li>
	`;
	pagebtnBox.innerHTML = html;
	
}


