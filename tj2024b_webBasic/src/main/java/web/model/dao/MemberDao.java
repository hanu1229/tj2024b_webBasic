package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;


// @Getter : 클래스내 모든 멤버변수에 getter 적용
//클래스내 디폴트생성자를 private 적용 / private MemberDao() {}
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class MemberDao extends Dao {
	
	// 지정한 멤버변수에 getter 적용
	// public static MemberDao getInstance() { return instance; }
	@Getter 
	private static MemberDao instance = new MemberDao();
	
	/**
	 * 회원가입 등록 SQL 처리 메소드
	*/
	public boolean signup(MemberDto memberDto) {
		try {			
			// [1] SQL문을 작성한다.
			String sql = "insert into member(mid, mpwd, mname, mphone, mimg) values (?, ?, ?, ?, ?);";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
			ps.setString(5, memberDto.getMimg());
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환을 한다.
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(">> DB에 저장 실패");
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 로그인 SQL 처리 메소드
	*/
	public int login(MemberDto memberDto) {
		try {			
			// [1] SQL문을 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ?;";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			while(rs.next()) {
				return rs.getInt("mno");
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return 0;
	}
	
	/**
	 * 내정보 보기 SQL 처리 메소드
	*/
	public MemberDto myInfo(int loginMno) {
		try {
			// [1] SQL문을 작성한다.
			String sql = "select * from member where mno = ?;";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL문을 실행하고 결과를 받는다.
			ps.setInt(1, loginMno);
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMno(rs.getInt("mno"));
				memberDto.setMid(rs.getString("mid"));
				memberDto.setMname(rs.getString("mname"));
				memberDto.setMphone(rs.getString("mphone"));
				memberDto.setMdate(rs.getString("mdate"));
				memberDto.setMimg(rs.getString("mimg"));
				return memberDto;
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * 회원탈퇴 SQL 처리 메소드
	*/
	public boolean delete(int loginMno) {
		try {
			String sql = "delete from member where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 회원수정 SQL 처리 메소드
	*/
	public boolean update(MemberDto memberDto) {
		try {
			String sql = "update member set mpwd = ?, mname = ?, mphone = ? where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMpwd());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setInt(4, memberDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 회원가입 포인트 지급 SQL 처리 메소드 
	*/
	public boolean joinPoint(PointDto pointDto, String mname) {
		try {
			String sql = "select * from member where mname = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pointDto.setMno(rs.getInt("mno"));
			}
			sql = "insert into point_log(title, point, mno) values(?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pointDto.getTitle());
			ps.setInt(2, pointDto.getPoint());
			ps.setInt(3, pointDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 추가
	/**
	 * 포인트 지급 SQL 처리 메소드 
	*/
	public boolean awardPoint(PointDto pointDto) {
		try {
			String sql = "insert into point_log(title, point, mno) values(?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pointDto.getTitle());
			ps.setInt(2, pointDto.getPoint());
			ps.setInt(3, pointDto.getMno());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/**
	 * 포인트 지급 날짜 SQL 처리 메소드<p>
	 * 로그인한 사용자 포인트 전체 내역 조회 SQL 처리 메소드 
	*/
	public ArrayList<String> checkDate(int loginMno) {
		ArrayList<String> result = new ArrayList<>();
		try {
			String sql = "select * from point_log where mno = ? and title = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			ps.setString(2, "로그인");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String str = rs.getString("date");
				result.add(str);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/**
	 * 로그인한 사용자 포인트 전체 내역 조회 SQL 처리 메소드 
	*/
	public ArrayList<PointDto> printPointLog(int loginMno) {
		ArrayList<PointDto> result = new ArrayList<>();
		
		try {
			String sql = "select * from point_log where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PointDto pointDto = new PointDto();
				pointDto.setPno(rs.getInt("pno"));
				pointDto.setTitle(rs.getString("title"));
				pointDto.setPoint(rs.getInt("point"));
				pointDto.setDate(rs.getString("date"));
				result.add(pointDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	/**
	 * 현재 내 포인트 조회 SQL 처리 메소드 
	*/
	public int myPoint(int mno) {
		int mpoint = 0;
		try {
			String sql = "select sum(point) as mpoint from point_log where mno = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				mpoint = rs.getInt("mpoint");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return mpoint;
	}
	
}
