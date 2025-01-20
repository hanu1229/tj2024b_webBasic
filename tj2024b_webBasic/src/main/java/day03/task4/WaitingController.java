package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet {
	
	/** 1. 대기번호등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doPost 실행 시작");
		
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		boolean result = WaitingDao.getInstance().write(waitingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> doPost 실행 끝");
		System.out.println("\n-------------------------------------------\n");
	}
	
	/** 2. 대기전체조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doGet 실행 시작");
		
		ArrayList<WaitingDto> result = WaitingDao.getInstance().select();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> doGet 실행 끝");
		System.out.println("\n-------------------------------------------\n");
	}
	
	/** 3. 대기개별수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doPut 실행 시작");
		
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		boolean result = WaitingDao.getInstance().update(waitingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> doPut 실행 끝");
		System.out.println("\n-------------------------------------------\n");
	}
	
	/** 4. 대기번호삭제 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doDelete 실행 시작");
		
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = WaitingDao.getInstance().delete(num);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> doDelete 실행 끝");
		System.out.println("\n-------------------------------------------\n");
	}
	
}
