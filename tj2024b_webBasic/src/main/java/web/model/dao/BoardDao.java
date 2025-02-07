package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import web.model.dto.BoardDto;

public class BoardDao extends Dao {
	// singleton start
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return instance; }
	// singleton end
	/*
	 @Getter
	 private static BoardDao instance = new BoardDao();
	 로도 작성이 가능하다.
	*/
		
	/** 게시물 쓰기 SQL */
	public boolean write(BoardDto boardDto) {
		try {
			String sql = "insert into board(btitle, bcontent, mno, cno) values (?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			ps.setInt(4, boardDto.getCno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }	
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 게시물 전체 조회 SQL */
	public ArrayList<BoardDto> findAll(int cno) {
		ArrayList<BoardDto> result = new ArrayList<>();
		try {
			// desc 내림차순 asc 오름차순 --> order by 뒤에 작성
			String sql = "select b.bno, b.btitle, b.bcontent, b.bview, b.bdate, b.cno, b.mno, m.mid from board as b "
					+ "inner join member as m on b.mno = m.mno "
					+ "where cno = ? "
					+ "order by b.bno desc;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno")); boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent")); boardDto.setBview(rs.getInt("bview"));
				boardDto.setBdate(rs.getString("bdate")); boardDto.setCno(rs.getInt("cno"));
				boardDto.setMno(rs.getInt("mno")); boardDto.setMid(rs.getString("mid"));
				// 회원테이블과 조인한 결과 회원아이디도 조회가 가능하다.
				result.add(boardDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 게시물 개별 조회 SQL */
	public BoardDto find(int bno) {
		BoardDto result = null;
		try {
			// [1] 특정 게시물 테이블의 게시물 1개 조회(작성한 회원 아이디까지 조회)
			/*
			String sql = "select b.*, m.mid from board as b "
					+ "inner join member as m on b.mno = m.mno "
					+ "where bno = ?;";
			*/
			// [1] + 카테고리 이름까지 조회
			String sql = "select b.*, m.mid, c.cname from board as b "
					+ "inner join member as m on b.mno = m.mno "
					+ "inner join category as c on b.cno = c.cno "
					+ "where bno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = new BoardDto();
				result.setBno(rs.getInt("bno")); result.setBtitle(rs.getString("btitle"));
				result.setBcontent(rs.getString("bcontent")); result.setBview(rs.getInt("bview"));
				result.setBdate(rs.getString("bdate")); result.setCno(rs.getInt("cno"));
				result.setMno(rs.getInt("mno")); result.setMid(rs.getString("mid"));
				result.setCname(rs.getString("cname"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 게시물 수정 SQL */
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
	
	/** 게시물 삭제 SQL */
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
	
	/** 댓글 쓰기 SQL */
	
	
}
