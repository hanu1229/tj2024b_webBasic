package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ");
		// 응답할 데이터를 준비
		boolean result = true;
		// HTTP를 이용한 응답 헤더 정보를 추가(Content-Type)
		resp.setContentType("application/json");
		// HTTP를 이용해 준비한 데이터를 응답
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "Java";
		// 문자열 1개는 application/json으로 타입변환이 불가능
		resp.setContentType("text/plain");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석", 40);
		System.out.println(result);
		// DTO ----> JSON으로 변환
		// ObjectMapper 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper();
		// .writeValueAsString(변환할객체) : 지정한 객체를 JSON형식으로 변환하는 함수
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
}
