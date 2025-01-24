package parking;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day06/parking")
public class Parking extends HttpServlet {
	
	/**
	 * 입차 함수
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 입차 시작");
		
		String str = req.getReader().readLine();
		System.out.println(str);
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(str, ParkingDto.class);
		boolean result = ParkingDao.getInstance().inCar(parkingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		if(result) {			
			System.out.println(">> 입차 성공");
		} else {
			System.out.println(">> 입차 실패");
		}
	}
	
	/**
	 * 출차 함수
	*/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> 출차 시작");
		// 이곳부터 구현하면 됨
	}
	
}
