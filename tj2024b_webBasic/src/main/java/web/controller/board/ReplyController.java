package web.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet {

	/** 댓글쓰기 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ReplyController 댓글쓰기(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		// Dto 대신에 HashMap<> 컬렉션을 사용하여 데이터를 관리
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object == null) {
			// 비로그인 상태
			result = false;
		} else {
			// 로그인 상태
			int loginMno = (Integer)object;
			map.put("mno", loginMno+"");
			result =  BoardDao.getInstance().replyWrite(map);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> ReplyController 댓글쓰기(doPost) 종료\n");
	}
	
	/** 특정 게시물의 댓글 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ReplyController 특정 게시물의 댓글 조회(doGet) 실행");
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		List<Map<String, String>> result = BoardDao.getInstance().replyFindAll(bno);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> ReplyController 특정 게시물의 댓글 조회(doGet) 종료\n"); 
	}
	
}
