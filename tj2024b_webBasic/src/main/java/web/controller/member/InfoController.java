package web.controller.member;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dao.RealMemberDao;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;

//[1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
//[2] 데이터 유효성 검사
//[3] DAO에게 데이터 전달하고 응답 받기
//[4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
//[5] HTTP 응답의 header body로 application/json으로 응답/반환

@WebServlet("/member/info")
public class InfoController extends HttpServlet {
	
	/**
	 * 내 정보 조회 
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> InfoController doGet 실행");
		// [1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		// [2] 데이터 유효성 검사
		// [3] DAO에게 데이터 전달하고 응답 받기
		MemberDto result = null;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {			
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().myInfo(loginMno);
			// 추가
			Integer mpoint = MemberDao.getInstance().myPoint(loginMno);
			result.setMpoint(mpoint.toString());
			// 추가
		}
		System.out.println("result : " + result);
		// [4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		// [5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		System.out.println(">> InfoController doGet 종료\n");
	}
	
	/**
	 * 회원정보 탈퇴 
	*/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> InfoController doDelete 실행");
		//[1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		//[2] 데이터 유효성 검사
		//[3] DAO에게 데이터 전달하고 응답 받기
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().delete(loginMno);
			if(result == true) {
				// 만약 회원탈퇴를 성공했다면 세션객체내 속성을 제거한다(로그아웃)
				session.removeAttribute("loginMno");
			}
		}
		//[4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		//[5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		System.out.println(">> InfoController doDelete 종료\n");
	}
	
	/**
	 * 회원수정 
	*/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// {"mname" : "ung", "mpwd" : "a123456", "mphone" : "010-9999-9999"}
		//[1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		boolean result = false;
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		System.out.println(">> " + memberDto);
		//[2] 데이터 유효성 검사
		//[3] DAO에게 데이터 전달하고 응답 받기
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if(object != null) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno);
			result = RealMemberDao.getInstance().update(memberDto);
		}
		//[4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		//[5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
}
