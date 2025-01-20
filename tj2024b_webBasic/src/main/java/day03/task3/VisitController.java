package day03.task3;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet {
	
	/**
	 * 1. 방문록 등록 <p>
	 * POST 방식 <p> 매개변수 : Body <p> 예시 : {"content" : "안녕", "age" : 30} <p> 
	 * 반환타입 : application/json <p> 예시 : true
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doPost 실행 시작");
		
		// HTTP로부터 요청 받은 HTTP Body를 DTO로 변환/파싱해서 가져오기
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		// Dao에 값 보내서 처리하기'
		boolean result = VisitDao.getInstance().write(visitDto);
		// Dao 결과를 HTTP Header Body로 응답 보내기
		// 1. 응답할 자료의 타입을 명시
		resp.setContentType("application/json");
		// 2. 응답 자료 보내기
		resp.getWriter().print(result);
		
		System.out.println(">> doPost 실행 끝");
	}
	
	/**
	 * 2. 방문록 전체조회 <p>
	 * GET 방식 <p> 매개변수 : X <p> 
	 * 반환타입: application/json <p> 예시 : [{"num" : 1, "content" : "안녕1", "age" : 30}, {"num" : 2, "content" : "안녕2", "age" : 40}]
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doGet 실행 시작");
		
		ArrayList<VisitDto> result = VisitDao.getInstance().select();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> doGet 실행 끝");
	}	
	
	/**
	 * 3. 방문록 수정 <p>
	 * PUT 방식 <p> 매개변수 : Body <p> 예시 : {"num" : 3, "content" : "수정안녕", "age" : 40} <p> 
	 * 반환타입 : application/json <p> 예시 : true
	*/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doPut 실행 시작");
		
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		boolean result = VisitDao.getInstance().update(visitDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> doPut 실행 끝");
	}
	
	/**
	 * 4. 방문록 삭제 <p>
	 * DELETE 방식 <p> 매개변수 : QueryString <p> 예시 : URL?num=3 <p> 
	 * 반환타입 : application/json <p> 예시 : true
	*/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> doDelete 실행 시작");
		
		// HTTP로부터 요청 받은 HTTP QueryString의 매개변수 가져오기
		int num = Integer.parseInt(req.getParameter("num"));
		// Dao에 값 보내서 처리하기
		boolean result = VisitDao.getInstance().delete(num);
		// Dao 결과를 HTTP Header Body로 응답 보내기
		// 1. 응답할 자료의 타입을 명시
		resp.setContentType("application/json");
		// 2. 응답 자료 보내기
		resp.getWriter().print(result);

		System.out.println(">> doDelete 실행 끝");
	}
	
}
