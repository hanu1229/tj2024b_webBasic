package day02.task2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet {

	/** 1. 예약신청 메소드 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		int people = Integer.parseInt(req.getParameter("people"));
		boolean result = WaitingDao.getInstance().write(phone, people);
		System.out.println("doPost 결과값 : " + result);
	}
	
	/** 2. 예약조회 메소드 */
	
	
	/** 3. 예약수정 메소드 */
	
	
	/** 4. 예약삭제 메소드 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int code = Integer.parseInt(req.getParameter("code"));
		boolean result = WaitingDao.getInstance().delete(code);
		System.out.println("doDelete 결과값 : " + result);
	}
	
}
