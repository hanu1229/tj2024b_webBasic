package parking;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		
		ObjectMapper mapper = new ObjectMapper();
		String car = req.getParameter("car");
		System.out.println(">> car : " + car);
		boolean result = ParkingDao.getInstance().outCar(car);
		String josnResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(josnResult);
		if(result) {
			System.out.println(">> 출차 성공");
		} else {
			System.out.println(">> 출차 실패");
		}
		
	}
	
	/**
	 * 요금계산 함수 
	*/
	public static int calculatePrice(String inTime, String ldtFormat) {
		// 현재 시간 형식을 yyyy-MM-dd HH:mm:ss 형식으로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// 문자열로된 날짜/시간을 LocalDateTime타입으로 변환
		LocalDateTime oldTime = LocalDateTime.parse(inTime, formatter);
		LocalDateTime newTime = LocalDateTime.parse(ldtFormat, formatter);
		// 두 LocalDateTime의 차이를 구하는 방법
		Duration duration = Duration.between(oldTime, newTime);
		// days : 날짜, hours : 시, minutes : 분, seconds : 초
		long days = duration.toDays();
		long hours = duration.toHours() % 24;
		long minutes = duration.toMinutes() % 60;
		//long seconds = duration.toSeconds() % 60;
		long seconds = duration.toSeconds();
		int price = (int)(100 * seconds);
		System.out.println("price : " + price);
		if(price > 10000) {
			return 10000;
		}
		return price;
	}
	
}
