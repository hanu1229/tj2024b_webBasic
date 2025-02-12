package web.controller;

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
import web.model.dto.MemberDto;
import web.model.dto.PointDto;

// [1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
// [2] 데이터 유효성 검사
// [3] DAO에게 데이터 전달하고 응답 받기
// [4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
// [5] HTTP 응답의 header body로 application/json으로 응답/반환

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	/**
	 * 로그인 함수 
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> LoginController doPost 실행");
		// [1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue(req.getReader(), MemberDto.class);
		// [2] 데이터 유효성 검사
		// [3] DAO에게 데이터 전달하고 응답 받기
		// 0이면 로그인 실패, 0초과이면 로그인 성공한 회원번호
		int loginMno = MemberDao.getInstance().login(memberDto);
		// 만약 로그인을 성공 했다면 세션 처리
		if(loginMno > 0) {
			// 톰캣 서버의 저장소/메모리
			HttpSession session = req.getSession();
			// 세션에 속성 추가 : 톰캣 서버에 데이터 저장
			// 현재 로그인 성공한 회원번호를 세선 속성에 등록
			// 추후에 로그인 인증에서 사용될 예정
			session.setAttribute("loginMno", loginMno);
			
			// 추가
			boolean state = checkDate(loginMno);
			if(!state) {				
				PointDto pointDto = new PointDto();
				pointDto.setMno(loginMno);
				pointDto.setTitle("로그인");
				pointDto.setPoint(1);
				boolean result = MemberDao.getInstance().awardPoint(pointDto);
				if(result) {
					session.setAttribute("loginPoint", true);
				}
			} else {
				session.setAttribute("loginPoint", false);
			}
			
			// 세션 객체의 최대 활성화 유지시간/생명주기
			session.setMaxInactiveInterval(60*10);
		}
		// [4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		// [5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(loginMno);
		
		System.out.println(">> LoginController doPost 종료\n");
	}
	
	/**
	 * 날짜 확인 메소드 
	*/
	public boolean checkDate(int loginMno) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		boolean state = false;
		int year = currentTime.getYear();
		int month = currentTime.getMonthValue();
		int day = currentTime.getDayOfMonth();
		String smonth = month < 10 ? "0" + month : "" + month;
		String sday = day < 10 ? "0" + day : "" + day;
		String date = year + "-" + smonth + "-" + sday;
		System.out.println("date : " + date);
		ArrayList<String> result = MemberDao.getInstance().checkDate(loginMno);
		for(int index = 0; index < result.size(); index ++) {
			String str = result.get(index);
			String[] temp = str.split(" ");
			if(temp[0].equals(date)) {
				state = true;
				break;
			}
		}
		return state;
	}
	
	/**
	 * 로그아웃 함수 
	*/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> LoginController doDelete 실행");
		// [1] HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.
		// [2] 데이터 유효성 검사
		// [3] DAO에게 데이터 전달하고 응답 받기
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		// 불러온 세션 값을 불러오기
		Object object = session.getAttribute("loginMno");
		boolean logOut = false;
		// 속성값이 존재하면 속성값을 제거한다 --> 로그아웃
		if(object != null) {
			session.removeAttribute("loginMno");
			logOut = true;
		}
		// [4] 자료(DTO/자바)타입을 JS(JSON)타입으로 변환
		// [5] HTTP 응답의 header body로 application/json으로 응답/반환
		resp.setContentType("application/json");
		resp.getWriter().print(logOut);
		
		System.out.println(">> LoginController doDelete 종료\n");
	}
}
