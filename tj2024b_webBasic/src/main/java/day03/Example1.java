package day03;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example1")
public class Example1 extends HttpServlet {
	
	/**  */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP GET 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1"); System.out.println("data1 : " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2 : " + data2);
		
	}
	
	/**  */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP POST 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1"); System.out.println("data1 : " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2 : " + data2);
	}
	
	/**  */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP PUT 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1"); System.out.println("data1 : " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2 : " + data2);
	}
	
	/**  */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP DELETE 방식으로 요청이 왔어요.]");
		String data1 = req.getParameter("data1"); System.out.println("data1 : " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2 : " + data2);
	}
	
}
