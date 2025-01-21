

/** 1. 대기명단 등록 */
let _write = () => {
	let phoneInput = document.querySelector("#phoneInput");
	let peopleInput = document.querySelector("#peopleInput");
	let phone = phoneInput.value;
	let people = peopleInput.value;
	let object = {phone : phone, people : people};
	let option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	}
	fetch(`/tj2024b_webBasic/day03/waiting2`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("등록 성공"); }
		else { alert("등록 실패"); }
		_print();
	})
	.catch(error => {console.log(error)});
}

/** 2. 대기명단 출력 */
let _print = () => {
	let tbody = document.querySelector("#printTbody");
	let html = ``;
	let count = 0;
	fetch(`/tj2024b_webBasic/day03/waiting2`)
	.then(response => response.json())
	.then(data => {
		data.forEach(obj => {
			html += `
			<tr>
				<td>${++count}</td>
				<td>${obj.num}</td>
				<td>${obj.phone}</td>
				<td>${obj.people}</td>
				<td>
					<button onclick="_update(${obj.num}, '${obj.phone}')">인원수 수정</button>
					<button onclick="_delete(${obj.num})">명단 삭제</button>
				</td>
			</tr>
			`;
		});
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error);});
}
_print();

/** 3. 대기명단 수정 */
let _update = (num, phone) => {
	console.log(phone);
	let people = prompt("new people count : ");
	let object = {num : num, phone : phone, people : people};
	let option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	fetch(`/tj2024b_webBasic/day03/waiting2`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("수정 성공"); }
		else { alert("수정 실패"); }
		_print();
	})
	.catch(error => {console.log(error);});
}

/** 4. 대기명단 삭제 */
let _delete = (num) => {
	let option = {method : "DELETE"};
	fetch(`/tj2024b_webBasic/day03/waiting2?num=${num}`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) { alert("삭제 성공"); }
		else { alert("삭제 실패"); }
		_print();
	})
	.catch(error => {console.log(error);});
}
