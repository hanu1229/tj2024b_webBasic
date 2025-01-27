package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;


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
			String sql = "insert into member(mid, mpwd, mname, mphone) values (?, ?, ?, ?);";
			// [2] DB와 연동된 곳에 SQL문을 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMname());
			ps.setString(4, memberDto.getMphone());
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
	
}
