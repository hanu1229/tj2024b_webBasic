package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class PageDto {
	// 페이징처리된 데이터들의 이동객체(데이터베이스랑 관련없으며 자바에서만 사용하는 Dto)
	// 현재 페이지
	private int page;
	//전체 페이지수
	private int totalpage;
	// 전체 자료개수(주로 검색결과 조회시 사용)
	private int totalcount;
	// 페이징 버튼 시작번호
	private int startbtn;
	// 페이징 버튼 끝번호
	private int endbtn;
	// 페이징된 자료
	// Object타입은 자바의 최상위 클리스이므로 모든 타입들의 자료들을 저장할 수 있다.
	// data에는 List<board>, List<replyDto>등등 여러 타입들을 하나의 타입에 저장한다.
	private Object data;
	
}
