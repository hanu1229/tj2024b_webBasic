package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaitingDao {
	private Connection conn;
	private String dburl = "jdbc:mysql://localhost:3306/waitingdb";
	private String dbuser = "root";
	private String dbpwd = "1234";
	
	// singleton start
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao () {
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
	
	/** 1. 대기번호등록 */
	public boolean write(WaitingDto waitingDto) {
		try {
			String sql = "insert into waiting_table(phone, people) values (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhone());
			ps.setInt(2, waitingDto.getPeople());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 2. 대기전체조회 */
	public ArrayList<WaitingDto> select() {
		ArrayList<WaitingDto> result = new ArrayList<>();
		try {
			String sql = "select * from waiting_table;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum(rs.getInt("num"));
				waitingDto.setPhone(rs.getString("phone"));
				waitingDto.setPeople(rs.getInt("people"));
				result.add(waitingDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 3. 대기개별수정 */
	public boolean update(WaitingDto waitingDto) {
		try {
			String sql = "update waiting_table set phone = ?, people = ? where num = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPhone());
			ps.setInt(2, waitingDto.getPeople());
			ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 4. 대기번호삭제 */
	public boolean delete(int num) {
		try {
			String sql = "delete from waiting_table where num = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
