

console.log("chatting.js open");
// [1] WebSocket클래스를 이용하여 클라이언트 소켓 구현
// new WebSocket(`서버소켓주소`);
let clientSocket = new WebSocket(`ws://localhost:8080/tj2024b_webBasic/chatsocket`);

// [2] 접속/연결(상태유지)된 서버소켓에게 메세지 전송, .send("메세지");
// fetch처럼 비동기 처리를 하기 때문에 언제 처리가 완료될지 모르기 때문이다.
// 비동기 통신 : 요청하고 응답이 올때까지 JS코드들을 대기하지 않는 구조
// 오류 발생 : 접속 요청 후 응갑 성공 전에 실행 했기 때문이다.
// clientSocket.send(`서버소켓아 안녕!`);

/** 전송버튼을 클릭했을때 실행될 함수 */
let onMsgSend = () => {
	let msgInput = document.querySelector("#msg-input");
	let msgBox = document.querySelector("#msg-box");
	let msg = msgInput.value;
	console.log(`message type : ${typeof(msg)}`);
	console.log(`message : ${msg}`);
	clientSocket.send(msg);
	
}

/** 클라이언트소켓이 서버소켓에게 메세지를 받았을때 실행되는 함수 */
clientSocket.onmessage = (event) => {
	let msgInput = document.querySelector("#msg-input");
	let msgBox = document.querySelector("#msg-box");
	console.log("서버소켓에게서 메세지가 왔다.");
	console.log(event);
	console.log(event.data);
	msgBox.innerHTML += `<div> ${event.data}</div>`;
	msgInput.value = "";
	
}




