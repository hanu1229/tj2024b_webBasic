package web.controller.chatting;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

// 서블릿클래스가 아닌 웹소캣클래스를 사용할 예정
// @WebServlet vs @serverEndpoint
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	
	// 메소드들이 매개변수로 받는 Session은 Session당사자를 가져온다.
	// 접속된 세션(접속성공한 클라이언트소켓정보)
	// 세션 : 네트워크상의 정보를 저장하는 공간,  HTTP 세션 VS WS 세션
	private static List<Session> 접속명단 = new Vector<>();
	// static : 프로젝트내 하나의 변수를 만들때 사용되는 키워드(전역변수로 생각하면 쉬움), 프로그램이 종료될때까지 사용됨
	
	// 서버 소켓에 클라이언트 소켓들이 접속 했을때 @OnOpen 이벤트
	@OnOpen
	public void onOpen(Session session) {
		// Session : jakarta.websocket.Session로 임포트
		System.out.println(">> WebSocket 클라이언트가 서버에 접속 성공");
		System.out.println(">> session : " + session);
		// onOpen() : 클라이언트가 정상적으로 서버와 접속을 성공했을때
		// list컬렉션에 접속 성공한 session정보를 저장
		접속명단.add(session);
		System.out.println("접속명단 : " + 접속명단);
	}
	
	// 클라이언트 소켓이 나갔을때(닫았을때)
	// 클라이언트소캣(객체)이 포함된 JS가 새로고침(객채가 지워졌을때)실행되는 함수
	@OnClose
	public void onClose(Session session) {
		System.out.println(">> WebSocket 클라이언트가 나감");
		// 접속이 닫힌 클라이언트소켓을 리스트에서 제거
		접속명단.remove(session);
		System.out.println("접속명단 : " + 접속명단);
	}
	
	// 클라이언트 소켓이 서버 소켓에게 메시지를 보냈을때 @OnMessage
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println(">> 클라이언트소켓으로부터 서버소켓으로 메시지가 왔다.");
		System.out.println(">> message : " + message);
		// [1] 받은 메세지를 접속된 모든 세션(클라이언트소켓)들에게 메세지 보내기
		// 받은 메세지 = 매개변수의 message
		// 접속명단 = private static List<Session> 접속명단 = new Vector<>();
		// 반복문을 이용한 접속 명단 순회
		for(int index = 0; index < 접속명단.size(); index++) {
			// 접속된 명단 index번째 세션(접속정보)를 가져오기
			Session clientSocket = 접속명단.get(index);
			// index번째 세션에 메세지를 보내기
			try {
				// 서버가 클라이언트에게 메세지 전송
				clientSocket.getBasicRemote().sendText(message);
			} catch(IOException e) {
				System.out.println(e);
			}
		}
	}
	

}
