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
import web.model.dto.PageDto;

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
		boolean result = false;
		if(object != null) {
			//테스트용 회원번호
			//int loginMno = 1;
			int loginMno = (Integer)object;
			boardDto.setMno(loginMno);
			result = BoardDao.getInstance().write(boardDto);	
			System.out.println(">> 게시물 작성 성공");
		} else {
			System.out.println(">> 게시물 작성 실패");
		}
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BoardController 게시물쓰기(doPost) 종료\n");
	}
	
	/** 게시물 전체 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BoardController 게시물전체조회(doGet) 실행");
		
		int cno = Integer.parseInt(req.getParameter("cno"));
		// 페이지 처리를 위한 변수 : page
		int page = Integer.parseInt(req.getParameter("page"));
		
		// 페이징 처리에 필요한 자료를 준비
		// [1] 페이지당 출력할 게시물 수
		int display = 5;
		// [2] 페이지당 조회할 게시물의 시작 번호
		// 게시물이 10개 존재한다고 가정 : 0번, 1번, 2번, 3번, 4번, 5번, 6번, 7번, 8번, 9번
		// 1페이지 시작번호 : 0번, 2페이지 시작번호 : 5번
		int startRow = (page - 1) * display;
		// [3] 특정 게시물의 전체 게시물수 구하기
		int totalSize = BoardDao.getInstance().getTotalSize(cno);
		// [4] 전체 페이지
		int totalPage = 0;
		if(totalSize % display == 0) {
			// 전체 게시물수 / 페이지당 게시물 수를 했을때 나머지가 없을 경우
			totalPage = totalSize / display;
		} else {
			// 전체 게시물수 / 페이지당 게시물 수를 했을때 나머지가 있을 경우
			totalPage = totalSize / display + 1;
		}
		// [5] 페이지당 버튼 수
		int btnSize = 5;
		// [6] 시작버튼 번호 구하기
		int startBtn = ((page - 1) / btnSize) * btnSize + 1;
		// [7] 끝버튼 번호 구하기
		int endBtn = startBtn + (btnSize - 1);
		// 만약에 끝번호가 전체 페이지 수보다 커지면 안되므로 끝번호가 전체 페이지수보다 커지면 전체 페이지수로 고정
		if(endBtn > totalPage) { endBtn = totalPage; }
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno, startRow, display);
		// [8] PageDto객체 만들기
		PageDto pageDto = new PageDto();
		// 조회된 전체 게시물수
		pageDto.setTotalcount(totalSize);
		// 현재 페이지
		pageDto.setPage(page);
		// 전체 페이지수
		pageDto.setTotalpage(totalPage);
		// 페이징 버튼 시작 번호
		pageDto.setStartbtn(startBtn);
		// 페이징 버튼 끝 번호
		pageDto.setEndbtn(endBtn);
		// 페이징 결과값
		pageDto.setData(result);
		// result 대신 pageDto를 json으로 변환
		String jsonResult = mapper.writeValueAsString(pageDto);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> BoardController 게시물전체조회(doGet) 종료\n");
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
		
		System.out.println(">> BoardController 게시물수정(doPut) 종료\n");
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
		
		System.out.println(">> BoardController 게시물삭제(doDelete) 종료\n");
	}
	
}
