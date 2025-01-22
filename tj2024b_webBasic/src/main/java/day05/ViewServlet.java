package day05;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board/view")
public class ViewServlet extends HttpServlet {

	/** 게시물 개별 조회 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ViewServlet doGet 시작");
		
		int bno = Integer.parseInt(req.getParameter("bno"));
		BoardDto boardDto = Dao.getInstance().find(bno);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(boardDto);
		System.out.println("result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> ViewServlet doGet 끝\n");
	}
	
}
