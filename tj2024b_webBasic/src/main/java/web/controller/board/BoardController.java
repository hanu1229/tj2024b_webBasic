package web.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	/** 게시물쓰기(첨부파일X) */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardController 게시물쓰기(doPost) 실행");
		
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환하는 기능을 제공하는 라이브러리 객체 생성
		ObjectMapper mapper = new ObjectMapper();
		// HTTP의 request Body로 부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			//테스트용 회원번호
			//int loginMno = 1;
			int loginMno = (Integer)object;
			boardDto.setMno(loginMno);
			boolean result = BoardDao.getInstance().write(boardDto);	
			resp.setContentType("application/json");
			resp.getWriter().print(result);
			System.out.println(">> 게시물 작성 성공");
		} else {
			System.out.println(">> 게시물 작성 실패");
		}
		
		System.out.println(">> BoardController 게시물쓰기(doPost) 종료");
	}
	
	/** 게시물 전체 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardController 게시물전체조회(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> BoardController 게시물전체조회(doGet) 종료");
	}
	
	/** 게시물 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardController 게시물수정(doPut) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		boolean result = BoardDao.getInstance().update(boardDto);
		if(result) { System.out.println(">> 게시물 수정 성공"); }
		else { System.out.println(">> 게시물 수정 삭제"); }
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardController 게시물수정(doPut) 종료");
	}
	
	/** 게시물 삭제 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardController 게시물삭제(doDelete) 실행");
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		boolean result = BoardDao.getInstance().delete(bno);
		if(result) { System.out.println(">> 게시물 삭제 성공"); }
		else { System.out.println(">> 게시물 삭제 실패"); }
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardController 게시물삭제(doDelete) 종료");
	}
	
}
