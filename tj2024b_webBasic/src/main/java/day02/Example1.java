package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
	자바의 클래스를 서블릿 클래스로 만들기
	1. 클래스명 extends HttpServlet
	2. 클래스 선언부 위에 @WebServlet("http주소체계정의")
		※ 주소는 아무거나 하되 프로젝트내 중복은 불가능하다
		- @WebServlet("http://localhost:8080/tj2024b_webBasic/day02/example1") : 절대경로
		- @WebServlet("(프로잭트명 이하생략 가능)/day02/example1") : 상대경로
	3. 요청을 받는 방법(함수/기능/메소드/행위) 정의
		- doGet
		- doPost
		- doPut
		- doDelete
		- HttpServlet 클래스에서 이미 http method와 매핑하는 자바 메소드를 상속한다.
 */

@WebServlet("/day02/example1")
public class Example1 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1] HTTP 프로토콜 통신이 POST 방법으로 요청이 왔습니다.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2] HTTP 프로토콜 통신이 GET 방법으로 요청이 왔습니다.");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] HTTP 프로토콜 통신이 Put 방법으로 요청이 왔습니다.");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4] HTTP 프로토콜 통신이 Delete 방법으로 요청이 왔습니다.");
	}
	
}
