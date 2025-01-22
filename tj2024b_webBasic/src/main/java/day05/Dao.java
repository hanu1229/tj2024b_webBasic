package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	private Connection conn;
	private String dburl = "jdbc:mysql://localhost:3306/boardservice11";
	private String dbuser = "root";
	private String dbpwd = "1234";
	
	// singleton start
	private static Dao instance = new Dao();
	private Dao () {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	public static Dao getInstance() { return instance; }
	//singleton end
	
	/** 게시물 등록 */
	public boolean create(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle, bcontent, bwriter, bpwd) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBwriter());
			ps.setString(4, boardDto.getBpwd());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 게시물 전체 조회 */
	public ArrayList<BoardDto> findAll() {
		ArrayList<BoardDto> result = new ArrayList<>();
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bview, bdate from board;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno")); boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent")); boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBview(rs.getInt("bview")); boardDto.setBdate(rs.getString("bdate"));
				result.add(boardDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 게시물 개별 조회 */
	public BoardDto find(int bno) {
		BoardDto result = new BoardDto();
		try {
			String sql = "select * from board where bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result.setBno(rs.getInt("bno")); result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent")); result.setBwriter(rs.getString("bwriter"));
				result.setBview(rs.getInt("bview")); result.setBcontent(rs.getString("bcontent"));
				result.setBpwd(rs.getString("bpwd")); ;result.setBdate(rs.getString("bdate"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 게시물 수정 */
	public boolean update(BoardDto boardDto) {
		try {
			String sql = "update board set btitle = ?, bcontent = ? where bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 게시물 삭제 */
	public boolean delete(int bno) {
		try {
			String sql = "delete from board where bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
}
