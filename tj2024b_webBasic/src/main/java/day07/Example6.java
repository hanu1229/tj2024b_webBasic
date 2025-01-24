package day07;

import java.io.IOException;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example6")
public class Example6 extends HttpServlet {
	
	private TreeSet<Object> set = new TreeSet<Object>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/day07/example6 POST OK ");
		ObjectMapper mapper = new ObjectMapper();
		//set = mapper.readValue(req.getReader(), new TreeSet<Object>().getClass());
		set = mapper.readValue(req.getReader(), TreeSet.class);
		System.out.println(set);
		resp.setContentType("application/json");
		if(!set.isEmpty()) {
			resp.getWriter().print(true);
		} else {
			resp.getWriter().print(false);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/day07/example6 POST OK ");
		resp.setContentType("application/json");
		resp.getWriter().print(set);
	}
	
}
