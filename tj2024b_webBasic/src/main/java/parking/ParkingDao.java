package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingDao {
	private Connection conn;
	private String dbname = "jdbc:mysql://localhost:3306/parkingservice";
	private String dbuser = "root";
	private String dbpassword = "1234";
	
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
	 * 입차 SQL문
	*/
	public boolean inCar(ParkingDto parkingDto) {
		try {
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
				conn.commit();
				return true;
			}
		} catch(SQLException e) {
			System.out.println(e);
			try {
				conn.rollback();
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
	public void outCar(String car) {
		
	}
}
