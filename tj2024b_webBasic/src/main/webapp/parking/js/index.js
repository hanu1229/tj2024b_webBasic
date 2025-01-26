
let path = `/tj2024b_webBasic/day06/parking`;

/** 입차 함수 */
let inCar = () => {
	let location = document.querySelector("#locationInput");
	let carInput = document.querySelector("#carInput");
	let object = {pno : Number(location.value), car : carInput.value, state : 0, price : 0};
	console.log(object);
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	};
	fetch(path, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("입차 성공!");
			location.value = "";
			carInput.value = "";
		} else { alert("입차 실패!"); }
		parkingPrint();
	})
	.catch(error => { console.log(error); });
}

/** 출차 함수 */
let outCar = () => {
	let carInput = document.querySelector("#carInput");
	let car = carInput.value;
	console.log(car);
	const option = {method : "DELETE"};
	fetch(`${path}?car=${car}`, option)
	.then(response => response.json())
	.then(data => {
		if(data == true) {
			alert("출차 성공!");
			carInput.value = "";
		} else { alert("입차 실패!"); }
		parkingPrint()
	})
	.catch(error => { console.log(error); });
}

// 주차 상태 확인
const parkingPrint = () => {
	// 1. DOM 객체 가져오기
	let parkform = document.querySelector('.parkform');
	// 2. fetch 통신
	let html = '';
	const option = { method : 'GET' }
	fetch( path , option )
		.then( r => r.json() )
		.then( data => {
			// 주차 데이터 배열에서 주차된 번호만 추출
		    const parkingArr = data.map(obj => obj.pno);
			
			// 20개 div 생성
			for( let i = 1 ; i <= 20 ; i++ ){
				// 주차여부 확인
				const isParking = parkingArr.includes(i);
				html += `<div class="parkingSpot ${ isParking ? 'full' : 'empty' }"> 
							${ isParking ? '불가능' : '주차구역 ' + i }
						</div> `
			} // for end
			
			// 20개 div 출력
			parkform.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); } )
	
} // f end