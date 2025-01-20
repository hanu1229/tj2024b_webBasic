package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	private Connection conn;
	private String dburl = "jdbc:mysql://localhost:3306/waitingdb";
	private String dbuser = "root"; private String dbpwd = "1234";
	
	// singleton start
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	public static WaitingDao getInstance() { return instance; }
	// singleton end
	
	/** 1. 예약신청 SQL */
	public boolean write(WaitingDto waiting) {
		try {
			String sql = "insert into waiting_table(phone, people) values (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waiting.getPhone());
			ps.setInt(2, waiting.getPeople());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 2. 예약조회 SQL */
	
	
	/** 3. 예약수정 SQL */
	
	
	/** 4. 예약삭제 SQL */
	public boolean delete(int code) {
		try {
			String sql = "delete from waiting_table where code = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, code);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
