package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : view와 dao사이의 가교 역할, (서블릿을 이용한) 매핑/연결 역할

@WebServlet("/day02/visit")
public class VisitController extends HttpServlet {
	
	/** 1. 방문록 등록 (쿼리스트링) <p> Create [C] */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL상의 쿼리스트링 매개변수를 가져온다(내용, 나이)
		String content = req.getParameter("content");
		int age = Integer.parseInt(req.getParameter("age"));
		boolean result = VisitDao.getInstance().write(content, age);
		System.out.println(result);
		return;
	}
	
	/** 2. 방문록 조회 X <p> Read [R] */
	
	
	/** 3. 방문록 수정 X <p> Update [U] */
	
	
	/** 3. 방문록 삭제 (쿼리스트링) <p> Delete [D] */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL상의 쿼리스트링 매개변수를 가져온다(삭제할번호PK)
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
		return;
	}
	
	
}
