package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example2")
public class Example2 extends HttpServlet {
	// queryString방식이 아닌 HTTP body(본문) 활용
	// HTTP body(본문)은 post, put method에서 사용 권장
	
	/**
	 * HTTP post Body 방식 <p>
	 * Content-Type : application/json <p>
	 * body : 원하는 값
	 * 
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP POST 방식으로 요청이 왔습니다.");
		// 요청 할때 마다 객체가 바뀐다(HTTP 무상태)
		System.out.println(req.getReader());
		// HTTP 본문의 내용들을 한줄 읽어서 반환 하는 함수
		System.out.println(req.getReader().readLine()); 
	}
	
	/**
	 * HTTP put Body 방식
	*/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP PUT 방식으로 요청이 왔습니다.");
		// 요청 할때 마다 객체가 바뀐다(HTTP 무상태)
		System.out.println(req.getReader());
		// HTTP 본문의 내용들을 한줄 읽어서 반환 하는 함수
		System.out.println(req.getReader().readLine());
	}
	
}
