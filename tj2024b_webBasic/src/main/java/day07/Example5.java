package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example5")
public class Example5 extends HttpServlet {
	
	//private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	// Dto를 사용하지 않는 상황 : 일회성 이동객체, Dto의 멤버변수의 정의가 명확하지 않을때 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/day07/example5 POST OK ");
//		String str = req.getReader().readLine();
//		resp.setContentType("application/json");
//		if(!str.isEmpty()) {
//			list.add(str);			
//			resp.getWriter().print(true);
//		} else {
//			resp.getWriter().print(false);
//		}
//		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		//HashMap<String, Object> hashMap = mapper.readValue(req.getReader(), new HashMap<String, Object>().getClass());
		HashMap<String, Object> hashMap = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(hashMap);
		resp.setContentType("application/json");
		if(!hashMap.isEmpty()) {
			list.add(hashMap);
			resp.getWriter().print(true);
		} else {
			resp.getWriter().print(false);
		}
		System.out.println(list);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/day07/example5 GET OK ");
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
