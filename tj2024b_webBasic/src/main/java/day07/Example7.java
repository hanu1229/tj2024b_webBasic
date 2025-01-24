package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// [1] 톰캣 안에 있는 객체 호출 (첫HTTP 요청시 객체 생성)
		HttpSession httpSession = req.getSession();
		System.out.println(httpSession);
		// 첫번째 요청시 : org.apache.catalina.session.StandardSessionFacade@7ddd19a
		// 두번째 요청시 : org.apache.catalina.session.StandardSessionFacade@7ddd19a
		
		// [2] 세선 객체의 주요 메소드
		// 세션 객체 내 모든 속성을 반환하는 함수
		System.out.println("getAttributeNames : " + httpSession.getAttributeNames());
		// 첫번째 요청시 : java.util.Collections$3@91a3f11
		// 두번째 요청시 : java.util.Collections$3@742e99f4
		
		// 세션 객체가 만들어진 시간을 반환하는 함수
		System.out.println("getCreationTime : " + httpSession.getCreationTime());
		// 첫번째 요청시 : 1737705811631
		// 두번째 요청시 : 1737705811631
		
		// 세션 객체의 아이디(식별자)
		System.out.println("getId : " + httpSession.getId());
		// 첫번째 요청시 : 58FD9085F9FF025102C908AA170A9A47
		// 두번째 요청시 : 58FD9085F9FF025102C908AA170A9A47
		
		// 마지막으로 세션 객체를 사용한 시간을 반환하는 함수
		System.out.println("getLastAccessedTime : " + httpSession.getLastAccessedTime());
		// 첫번째 요청시 : 1737705811631
		// 두번째 요청시 : 1737705811635
		
		// 새로 만들어진 세션 인지 여부를 확인 후 반환하는 함수
		System.out.println("isNew : " + httpSession.isNew());
		// 첫번째 요청시 : true
		// 두번째 요청시 : false
		
		// [3] 세션 객체의 속성명과 속성값
		// 세션값 저장 (Key, Value)
		httpSession.setAttribute("세션속성1", "유재석");
		
		// [4] 세션 객체에 지정한 속성명의 값 호출
		Object object = httpSession.getAttribute("세션속성1");
		System.out.println("object : " + (String)object);
		
		// [5] 세션 객체에 지정한 속성 제거
		httpSession.removeAttribute("세션속성1");
		
		System.out.println("____________");
	}
	
}
