package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ParkingDao {
	private Connection conn;
	private String dbname = "jdbc:mysql://localhost:3306/parkingservice";
	private String dbuser = "root";
	private String dbpassword = "hanu1229";
	
	// singleton start
	private static ParkingDao instance = new ParkingDao();
	private ParkingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbname, dbuser, dbpassword);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	public static ParkingDao getInstance() { return instance; }
	// singleton end
	
	/**
	 * 주차자리 화면 구현 
	*/
	public ArrayList<ParkingDto> parkingView() {
		ArrayList<ParkingDto> result = new ArrayList<>();
		try {
			String sql = "select * from parking";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				ParkingDto parkingDto = new ParkingDto();
				parkingDto.setPno(rs.getInt("pno"));
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setTime(rs.getString("time"));
				result.add(parkingDto);
			} // w end
		}catch( SQLException e ) { System.out.println(e); }
		return result;
	} // f end
	
	/**
	 * 입차 SQL문
	*/
	public boolean inCar(ParkingDto parkingDto) {
		try {
			// 자동 commit 끄기
			conn.setAutoCommit(false);
			String sql = "insert into parking(pno, car) values (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, parkingDto.getPno());
			ps.setString(2, parkingDto.getCar());
			int count1 = ps.executeUpdate();
			sql = "insert into inout_log(car, state, price) values (?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parkingDto.getCar());
			ps.setInt(2, parkingDto.getState());
			ps.setInt(3, parkingDto.getPrice());
			int count2 = ps.executeUpdate();
			if(count1 == 1 && count2 == 1) {
				// commit
				conn.commit();
				return true;
			}
		} catch(SQLException e) {
			System.out.println(e);
			try {
				// commit전으로 돌리기
				conn.rollback();
				// 자동 commit 켜기
				conn.setAutoCommit(true);
			} catch(SQLException exception) {
				System.out.println(exception);
			}
			
		}
		return false;
	}
	
	/**
	 * 출차 SQL문
	*/
	public boolean outCar(String car) {
		ParkingDto parkingDto = new ParkingDto();
		try {
			// 자동 commit 끄기
			conn.setAutoCommit(false);
			// 주차테이블 전체를 조회
			String sql = "select * from parking where car = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, car);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				parkingDto.setPno(rs.getInt("pno"));
				parkingDto.setCar(rs.getString("car"));
				parkingDto.setTime(rs.getString("time"));
			}
			System.out.println(parkingDto);
			// 현재 시간 불러오기
			LocalDateTime ldt = LocalDateTime.now();
			System.out.println(">> LocalDateTime : " + ldt);
			// 현재 시간을 yyyy-MM-dd HH:mm:ss 형식으로 변환
			String ldtFormat = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			System.out.println(">> Formatter : " + ldtFormat);
			// 요금 계산 함수 호출
			int price = Parking.calculatePrice(parkingDto.getTime(), ldtFormat);
			// 입출차내역테이블에 레코드 추가
			sql = "insert into inout_log(car, state, time, price) values (?, ?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, car);
			ps.setInt(2, 1);
			ps.setString(3, ldtFormat);
			ps.setInt(4, price);
			int count1 = ps.executeUpdate();
			// 주차테이블에 pno가 일치하는 레코드 삭제
			sql = "delete from parking where pno = ?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, parkingDto.getPno());
			int count2 = ps.executeUpdate();
			
			if(count1 == 1 && count2 == 1) {
				// commit
				conn.commit();
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println(e);
			try {
				// commit전으로 돌리기
				conn.rollback();
				// 자동 commit 켜기
				conn.setAutoCommit(true);
			} catch(SQLException exception) {
				System.out.println(exception);
			}
		}
		return false;
	}
	
}
