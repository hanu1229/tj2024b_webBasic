package web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/toast")
public class ToastSocket {
	
	private static List<Session> list = new Vector<>();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(">> 클라이언트소켓 연결 시작");
		
		System.out.println(">> session : " + session);
		list.add(session);
		System.out.println(">> 접속명단 : " + list);
		
		System.out.println(">> 클라이언트소켓 연결 완료");
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println(">> 클라이언트 소켓 끊기 시작");
		
		list.remove(session);
		System.out.println(">> 접속명단 : " + list);
		
		System.out.println(">> 클라이언트 소켓 끊기 완료");	
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println(">> 클라이언트언트 소켓의 메세지 도착");
		
		//System.out.println(">> message : " + message);
		for(int index = 0; index < list.size(); index++) {
			Session client = list.get(index);
			try {
				System.out.println("message : " + message);
				client.getBasicRemote().sendText(message);
			} catch(IOException e) {
				System.out.println(e);
			}
		}
		
		System.out.println(">> 클라이언트언트 소켓의 메세지 받음");
	}
	
}
