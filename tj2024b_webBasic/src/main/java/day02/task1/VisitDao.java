package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDao {
	private Connection conn;
	private String dburl = "jdbc:mysql://localhost:3306/mydb0116";
	private String dbuser = "root";
	private String dbpwd = "1234";
	
	// singleton start
	private static VisitDao instance = new VisitDao();
	private VisitDao() {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(SQLException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
	public static VisitDao getInstance() { return instance; }
	// singleton end
	
	/** 1. 방문록 등록 SQL */
	public boolean write(String content, int age) {
		try {			
			String sql = "insert into visit(content, age) values (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, content); ps.setInt(2, age);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 2. 방문록 조회 SQL */
	
	
	/** 3. 방문록 수정 SQL */
	
	
	/** 4. 방문록 삭제 SQL */
	public boolean delete(int num) {
		try {			
			String sql = "delete from visit where num = ?;";
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
