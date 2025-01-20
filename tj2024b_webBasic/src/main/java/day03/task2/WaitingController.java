package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet {

	/** 1. 예약신청 메소드 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waiting = mapper.readValue(req.getReader(), WaitingDto.class);
		System.out.println(waiting);
		boolean result = WaitingDao.getInstance().write(waiting);
		System.out.println("result : " + result);
	}
	
	/** 2. 예약조회 메소드 */
	
	
	/** 3. 예약수정 메소드 */
	
	
	/** 4. 예약삭제 메소드 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int code = Integer.parseInt(req.getParameter("code"));
		System.out.println("code : " + code);
		boolean result = WaitingDao.getInstance().delete(code);
		System.out.println("result :" + result);
	}
	
}
