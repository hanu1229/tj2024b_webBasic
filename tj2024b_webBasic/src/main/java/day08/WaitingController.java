package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {
	
	//private ArrayList<HashMap<String, Object>> dto = new ArrayList<>();
	
	/** 대기명단 등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 대기명단 등록(doPost) 실행");
		
		// {"phone" : "010-1111-1111", "people" : 3}
		int wno = 0;
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> result = mapper.readValue(req.getReader(), HashMap.class);
		//System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		ArrayList<HashMap<String, Object>> dto = null;
		if(!result.isEmpty()) {
			if(result.get("phone") != null) {
				HttpSession session = req.getSession();
				Object object = session.getAttribute("dto");
				dto = (ArrayList<HashMap<String, Object>>)object;
				result.put("wno", dto.size()+1);
				dto.add(result);
				session.setAttribute("dto", dto);
				wno = Integer.parseInt(result.get("wno").toString());
			}
		}
		System.out.println(">> dto : " + dto);	
		resp.getWriter().print(wno);
		
		System.out.println(">> WaitingController 대기명단 등록(doPost) 끝");
	}
	
	/** 대기명단 전체 출력 */
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 대기명단 천체 출력(doGet) 실행");
		
		HttpSession session = req.getSession();
		if(session.isNew()) {
			ArrayList<HashMap<String, Object>> dto = new ArrayList<>();
			session.setAttribute("dto", dto);
		}
		ObjectMapper mapper = new ObjectMapper();
		Object object = session.getAttribute("dto");
		String jsonResult = mapper.writeValueAsString(object);
		System.out.println(">> jsonResult : " + jsonResult);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		System.out.println(">> WaitingController 대기명단 천체 출력(doGet) 끝");
	}
	
	/** 특정 대기명단(인원수) 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 특정 대기명단(인원수) 수정(doPut) 실행");
		
		boolean state = false;
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> result = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		if(!result.isEmpty()) {
			HttpSession session = req.getSession();
			Object object = session.getAttribute("dto");
			ArrayList<HashMap<String, Object>> dto = (ArrayList<HashMap<String, Object>>)object;
			for(int index = 0; index < dto.size(); index++) {
				HashMap<String, Object> temp = dto.get(index);
				if(temp.get("wno").equals(result.get("wno"))) {
					temp.put("people", result.get("people"));
					session.setAttribute("dto", dto);
					state = true;
					break;
				}
			}
		}
		resp.getWriter().print(state);
		
		System.out.println(">> WaitingController 특정 대기명단(인원수) 수정(doPut) 끝");
	}
	
	/** 특정 대기명단 삭제 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 특정 대기명단 삭제(doDelete) 실행");
		
		boolean state = false;
		int wno = Integer.parseInt(req.getParameter("wno"));
		resp.setContentType("application/json");
		HttpSession session = req.getSession();
		Object object = session.getAttribute("dto");
		ArrayList<HashMap<String, Object>> dto = (ArrayList<HashMap<String, Object>>)object;
		for(int index = 0; index < dto.size(); index++) {
			HashMap<String, Object> temp = dto.get(index);
			if(Integer.parseInt(temp.get("wno").toString()) == wno) {
				dto.remove(index);
				state = true;
				break;
			}
		}
		resp.getWriter().print(state);
		
		System.out.println(">> WaitingController 특정 대기명단 삭제(doDelete) 끝");
	}

}
