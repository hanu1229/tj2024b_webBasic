package day03.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public boolean write(VisitDto visitDto) {
		try {			
			String sql = "insert into visit(content, age) values (?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getContent()); ps.setInt(2, visitDto.getAge());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 2. 방문록 조회 SQL */
	public ArrayList<VisitDto> select() {
		ArrayList<VisitDto> result = new ArrayList<>();
		try {
			String sql = "select* from visit;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VisitDto dto = new VisitDto();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setAge(rs.getInt("age"));
				result.add(dto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 3. 방문록 수정 SQL */
	public boolean update(VisitDto visitDto) {
		try {
			String sql = "update visit set content = ?, age = ? where num = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getContent());
			ps.setInt(2, visitDto.getAge());
			ps.setInt(3, visitDto.getNum());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
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
