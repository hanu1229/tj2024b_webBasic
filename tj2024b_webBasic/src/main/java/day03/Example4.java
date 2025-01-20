package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet {
	
	/**
	 * HTTP GET
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP GET 방식으로 요청이 왔습니다.");
		
		// 응답할 데이터 req는 웹에서 요청한 값, resp는 웹으로 응답하는 값
		boolean result = true;
		// .getWriter().print(보낼자료);
		resp.getWriter().print(result);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
		
	}
	
	/**  */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP POST 방식으로 요청이 왔습니다.");
		
		// 응답할 데이터 req는 웹에서 요청한 값, resp는 웹으로 응답하는 값
		String result = "Java";
		// .getWriter().print(보낼자료);
		resp.getWriter().print(result);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
	
	/**  */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP PUT 방식으로 요청이 왔습니다.");
		int result = 30;
		resp.getWriter().print(result);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
	
	/**  */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> HTTP DELETE 방식으로 요청이 왔습니다.");
		DataDto result = new DataDto("유재석", 40);
		resp.getWriter().print(result);
		System.out.println(">> HTTP로 자료를 응답했습니다.");
	}
}
