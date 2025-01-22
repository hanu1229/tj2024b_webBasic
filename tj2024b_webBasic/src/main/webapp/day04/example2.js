
// [1] 람다식 함수 정의
const func1 = () => {
	console.log(`func1 execute`);
}

// [2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = () => {
	// Fetch : HTTP 비동기 통신을 제공하는 함수
	// day02에 example1 서블릿 클래스의 doGet 메소드에 매핑
	fetch(`http://localhost:8080/tj2024b_webBasic/day02/example1`);
}

const func3 = () => {
	fetch(
		`/tj2024b_webBasic/day02/example1`,
		{method : `POST`}
	);
}

const func4 = () => {
	fetch(
		`/tj2024b_webBasic/day02/example1`,
		{method : `PUT`}
	);
}

const func5 = () => {
	fetch(
		`/tj2024b_webBasic/day02/example1`,
		{method : `DELETE`}
	);
}

const func6 = () => {
	let name = `유재석`;
	let age = 40;
	fetch(
		`/tj2024b_webBasic/day02/example1?name=${name}&age=${age}`,
		{method : `GET`}
	);
}

const func7 = () => {
	let name = `신동엽`;
	let age = 30;
	const option = {method : `POST`};
	fetch(
		`/tj2024b_webBasic/day02/example1?name=${name}&age=${age}`,
		option
	);
}

const func8 = () => {
	let name = `서장훈`;
	let age = 10;
	const option = {method : `PUT`};
	fetch(
		`/tj2024b_webBasic/day02/example1?name=${name}&age=${age}`,
		option
	);
}

const func9 = () => {
	let name = `김희철`;
	let age = 50;
	const option = {method : `DELETE`};
	fetch(
		`/tj2024b_webBasic/day02/example1?name=${name}&age=${age}`,
		option
	);
}

const func10 = () => {
	let object = {data1 : "유재석", data2 : 50};
	const option = {
		method : "POST",
		headers : {"Content-Type" : "application/json"},
		body :  JSON.stringify(object)
	}
	fetch(`/tj2024b_webBasic/day03/example3`, option);
}

const func11 = () => {
	let object = {data1 : "강호동", data2 : 40};
	const option = {
		method : "PUT",
		headers : {"Content-Type" : "application/json"},
		body : JSON.stringify(object)
	}
	fetch(`/tj2024b_webBasic/day03/example3`, option);
}

const func12 = () => {
	const option = {method : "GET"};
	fetch(`/tj2024b_webBasic/day03/example5`, option).then(
		(response) => response.json()
	).then((data) => {console.log(data);});
}

const func13 = () => {
	const option = {method : "POST"};
	fetch(`/tj2024b_webBasic/day03/example5`, option).then(
		(response) => response.text()).then((data) => {console.log(data);});
}

const func14 = () => {
	const option = {method : "PUT"};
	fetch(`/tj2024b_webBasic/day03/example5`, option)
	.then((response) => response.json())
	.then((data) => {console.log(data);})
	.catch((error) => {console.log(error);});
}

const func15 = () => {
	const option = {method :"DELETE"};
	fetch(`/tj2024b_webBasic/day03/example5`, option)
	.then((response) => response.json())
	.then((data) => {console.log(data);})
	.catch((error) => {console.log(error);});
}

const test = () => {
	const option = {method :"DELETE"};
	fetch(`/tj2024b_webBasic/day03/example5`, option)
	.then((response) => {console.log(response.body.getReader().read() );});
}

/*
	fetch(HTTP URL, {옵션}).then( (response객체) => response.타입()).then((타입변환자료) => {실행문;})
	
	then()
		- 응답객체 : 통신한 응답의 정보가 담긴 HTTP 응답 객체를 반환
			then((응답객체명) => 응답객체명.json())	: response content-type : application/json으로 변환
			then((응답객체명) => 응답객체명.text())	: response content-type : text/plain으로 변환
	then()
		1. 변환된 자료 객체
	catch()

	fetch(HTTP URL);
	
	fetch(HTTP URL, {옵션})
		- URL
			- 통신할 서블릿의 URL 주소
			- 쿼리스트링
		- {옵션}
			- method
				- GET	: fetch(HTTP URL, { method : 'GET'})
					--> GET METHOD는 기본값이므로 생략이 가능하다.
				- POST	: fetch(HTTP URL, { method : 'POST'})
				- PUT	: fetch(HTTP URL, { method : 'PUT'})
				- DELETE: fetch(HTTP URL, { method : 'DELETE})
		
			- headers
				- {"Content-Type" : "application/json"}
			- body
				- 전송할 데이터 자료
		
	fetch(HTTP URL, {옵션})

	
	[참조1]
	`` : 백틱 템플릿 : 문자열 사이에 변수/함수를 호출, 연산식을 넣을 수 있다.
	
	[참조2] : JSON문자열 타입 변환
		- JSON.parse()		: 문자열타입을 JSON타입으로 변환하는 함수
		- JSON.stringify()	: JSON타입을 문자열타입으로 변환하는 함수
*/