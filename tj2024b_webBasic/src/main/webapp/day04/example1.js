
console.log(`example.js 실행`);

/* 1. JS 자료 */
// Number(숫자)
console.log(3);
console.log(3.14);
// Boolean(논리)
console.log(true);
// null(객체가 없다)
console.log(null);
// undefined(정의가 없다)
console.log(undefined);
// String(문자열)
console.log("안녕1");
console.log('안녕2');
console.log(`안녕3`);
// Array(배열)
console.log([3, 3.14, true, `안녕4`]);
// function(함수)
console.log(function 함수명() {});
// Object(json)
console.log({"속성명1" : 3, "속성명2" : `안녕4`});

/* JS 함수 */
// 1. 선언적 함수 : function 함수명(매개변수명, 매개변수명) {실행문;}
function func1(a, b) {
	let c = a + b;
	console.log(`func1 execute : return ${c}`);
	return c;
}
// 함수 호출
let result1 = func1(3, 4);
console.log(result1);
// 2. 익명 함수 : function(매개변수명, 매개변수명) {실행문;}
const func2 = function(a, b) {
	let c= a + b;
	console.log(`func2 execute : return ${c}`);
	return c;
}
let result2 = func2(3, 4);
console.log(result2);
// 3. 람다식 : (매개변수명, 매개변수명) => {실행문;}
const func3 = (a, b) => {
	let c = a + b;
	console.log(`func3 execute : return ${c}`);
	return c;
}
let result3 = func3(10, 7);
console.log(result3);

/* 람다식 함수의 활용처 */
const words = [`사과`, `수박`, `딸기`, `오렌지`];
// 배열내 모든 요소 값들을 하나씩 출력
for(let index = 0; index < words.length; index++) {
	console.log(words[index]);
}
// foreach문 : 배열명.forEach(반복할변수명 => {실행문;})
// 배열내 요소를 하나씩 반복 변수명에 대입하고 반복 실행
words.forEach((word) => {console.log(word)});
// map : 배열명.map()
// 배열내 요소를 하나씩 반복 변수명에 대입하고 반복 실행
words.map((word) => {console.log(word)});
// ※ forEach와 map함수의 차이점
// forEach함수는 return이 없고 map함수는 return을 지원한다.
let newWords1 = words.forEach((index) => {return index;});
// undefined
console.log(newWords1);
// [값1, 값2, 값3, ...]
let newWords2 = words.map((index) => {return index;});
console.log(newWords2);