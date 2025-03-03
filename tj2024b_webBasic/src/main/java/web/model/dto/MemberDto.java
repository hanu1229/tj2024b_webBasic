package web.model.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class MemberDto {
	// 회원번호 
	private int mno;
	// 아이디
	private String mid;
	// 비밀번호 
	private String mpwd;
	// 이름 
	private String mname;
	// 전화번호
	private String mphone;
	// 가입일 
	private String mdate;
	// 프로필 --> 추가
	private String mimg;
	// DB Member 테이블에는 존재하지 않지만, 자바 내부적으로 사용할 예정인 현재 포인트수량
	private String mpoint;
	
}
