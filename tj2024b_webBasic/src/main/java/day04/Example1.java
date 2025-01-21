package day04;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day04/example1")
public class Example1 extends HttpServlet {
	
	/** 1. 쿼리스트링 예제 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value1 = req.getParameter("value1");
		int value2 = Integer.parseInt(req.getParameter("value2"));
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		
		boolean result = true;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	/** 2. HTTP header body 예제 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ValueDto valueDto = mapper.readValue(req.getReader(), ValueDto.class);
		System.out.println(valueDto);
		
		ValueDto result = new ValueDto("강호동", 23);
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
}
