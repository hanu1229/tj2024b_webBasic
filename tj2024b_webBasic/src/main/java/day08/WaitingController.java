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


@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {
	
	private ArrayList<HashMap<String, Object>> dto = new ArrayList<>();
	
	/** 대기명단 등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 대기명단 등록(doPost) 실행");
		
		// {"phone" : "010-1111-1111", "people" : 3}
		boolean state = false;
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Object> result = mapper.readValue(req.getReader(), HashMap.class);
		result.put("wno", dto.size()+1);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		if(!result.isEmpty()) {
			if(result.get("phone") != null) {				
				dto.add(result);
				state = true;
			}
		}
		System.out.println(">> dto : " + dto);	
		resp.getWriter().print(state);
		
		System.out.println(">> WaitingController 대기명단 등록(doPost) 끝");
	}
	
	/** 대기명단 전체 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> WaitingController 대기명단 천체 출력(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(dto);
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
			for(int index = 0; index < dto.size(); index++) {
				HashMap<String, Object> temp = dto.get(index);
				if(temp.get("wno").equals(result.get("wno"))) {
					temp.put("people", result.get("people"));
					System.out.println(">> 변경 후 : " + temp);
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
		String phone = req.getParameter("phone");
		resp.setContentType("application/json");
		for(int index = 0; index < dto.size(); index++) {
			HashMap<String, Object> temp = dto.get(index);
			if(temp.get("phone").equals(phone)) {
				dto.remove(index);
				state = true;
				break;
			}
		}
		resp.getWriter().print(state);
		
		System.out.println(">> WaitingController 특정 대기명단 삭제(doDelete) 끝");
	}

}
