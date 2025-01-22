

/** 게시물 등록 */
let _create = () => {
	let titleInput = document.querySelector("#titleInput");
	let contentInput = document.querySelector("#contentInput");
	let writerInput = document.querySelector("#writerInput");
	let passwordInput = document.querySelector("#passwordInput");
	let title = titleInput.value, content = contentInput.value;
	let writer = writerInput.value, password = passwordInput.value;
	let object = {btitle : title, bcontent : content, bwriter : writer, bpwd : password};
	console.log(object);
	let option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	}
	fetch(`/tj2024b_webBasic/day05/board`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("등록 성공!"); }
		else { alert("등록 실패!"); }
		_findAll();
	})
	.catch(error => { console.log(error); }); 
}

/** 게시물 전체 조회 */
let _findAll = () => {
	let tbody = document.querySelector("#printBoard");
	let html = ``;
	const option = { method : "GET"};
	fetch(`/tj2024b_webBasic/day05/board`, option)
	.then( response => response.json() )
	.then( data => {
		console.log(data);
		data.forEach( (obj) => {
			console.log(obj);
			html += `
				<tr>
					<td>${obj.bno}</td>
					<td><a href = "boardview.jsp?bno=${obj.bno}">${obj.btitle}</a></td>
					<td>${obj.bwriter}</td>
					<td>${obj.bview}</td>
					<td>${obj.bdate}</td>
				</tr>
			`;
		} );
		tbody.innerHTML = html;
	} )
	.catch((error) => { console.log(error); });
}
_findAll();

