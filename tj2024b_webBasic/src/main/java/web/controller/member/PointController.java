package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.PointDto;

@WebServlet("/member/point")
public class PointController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> PointController doGet 실행");

		ArrayList<PointDto> result = null;
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().printPointLog(loginMno);
		}
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("appliction/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> PointController doGet 종료\n");
	}
}
