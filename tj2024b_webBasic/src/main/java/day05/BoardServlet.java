package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import day04.ValueDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardServlet extends HttpServlet {

	/** 게시물 등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardServlet doPost 시작");
		
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		boolean result = Dao.getInstance().create(boardDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardServlet doPost 끝\n");
	}
	
	/** 게시물 전체 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardServlet doGet 시작");
		
		ArrayList<BoardDto> result = Dao.getInstance().findAll();
		System.out.println(">> result : " + result);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		System.out.println("jsonResult : " + jsonResult);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> BoardServlet doGet 끝\n");
	}
	
	/** 게시물 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardServlet doPut 시작");
		
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		boolean result = Dao.getInstance().update(boardDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardServlet doPut 끝\n");
	}
	
	/** 게시물 삭제 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardServlet doDelete 시작");
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		boolean result = Dao.getInstance().delete(bno);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardServlet doDelete 끝\n");
	}
	
}
