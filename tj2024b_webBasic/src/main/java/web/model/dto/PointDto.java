package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class PointDto {
	// 식별키
	private int pno;
	// 포인트 지급 내용
	private String title;
	// 수량
	private int point;
	// 날짜
	private String date;
	// 외래키
	private int mno;
}
