package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/signup")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> SignUpController doPost 실행");
		// {"mid" : "test1", "mpwd" : "q123456", "mname" : "han", "mphone" : "010-1111-1111"}
		// [1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(">> memberDto : " + memberDto);
		// [2] 데이터 유효성 검사	
		
		// [3] DAO에게 데이터 전달하고 응답 받기
		boolean result = MemberDao.getInstance().signup(memberDto);
		// [4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		// boolean은 안해도됨
		// [5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	
		
	}
	
}
