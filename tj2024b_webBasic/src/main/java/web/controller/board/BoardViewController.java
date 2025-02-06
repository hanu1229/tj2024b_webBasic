package web.controller.board;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	
	/** 게시물 개별 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardViewController 게시물개별조회(doGet) 실행");
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		BoardDto result = BoardDao.getInstance().find(bno);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		if(result != null) { System.out.println(">> 게시물 개별 조회 성공"); }
		else { System.out.println(">> 게시물 개별 조회 실패"); }
		
		System.out.println(">> BoardViewController 게시물개별조회(doGet) 종료");
	}
	
}
