package day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example2 {
	public static void main(String[] args) {
		
		// ArrayList 인스턴스 생성
		/*
		 인스턴스 : new ArrayList<String>();
		 변수명 : list
		 변수의 타입 : List<String> 
		*/
		// ArrayList타입은 List인터페이스를 구현했으므로 List에 대입가능
		List<String> list = new ArrayList<String>();
		
		// List인터페이스 메소드
		// .add(자료) : 리스트 내 지정한 자료를 마지막 요소에 추가
		list.add("유재석"); System.out.println(list);
		list.add("강호동"); System.out.println(list);
		list.add("신동엽"); System.out.println(list);
		list.add("하하"); System.out.println(list);
		// .add(인덱스, 자료) : 리스트 내 지정한 자료를 인덱스에 요소를 추가
		list.add(2, "김희철"); System.out.println(list);
		// .set(인덱스, 자료) : 리스트 내 지정한 인덱스에 지정한 자료의 요소 수정
		list.set(2, "서장훈"); System.out.println(list);
		// .get(인덱스) : 리스트 내 지정한 인덱스의 요소 값을 반환
		System.out.println(list.get(2));
		String str1 = list.get(0); System.out.println(str1);
		// .size() : 리스트 내 요소 전체 개수를 반환
		System.out.println(list.size());
		// .contains(자료) : 리스트 내 저장한 자료의 존재 여부를 반환 (true/false)
		System.out.println(list.contains("서장훈"));
		boolean result1 = list.contains("박명수");
		System.out.println(result1);
		// .indexOf(자료) : 리스트 내 지정한 자료의 인덱스 번호를 반환 없으면 -1을 반환
		System.out.println(list.indexOf("서장훈"));
		int result2 = list.indexOf("박명수");
		System.out.println(result2);
		// .remove(인덱스 또는 자료) : 리스트 내 지정한 인덱스 또는 자료의 요소를 삭제
		list.remove(0); System.out.println(list);
		// .clear() : 리스트 내 모든 요소를 삭제
		// .isEmpty() : 리스트 내 요소가 비어있으면 true 아니면 false
		System.out.println(list.isEmpty());
		// 리스트내 요소들을 순회하는 방법
		// 방법1] for문
		for(int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		// 방법2] 향상된 for문, for(타입 반복변수명 : 리스트명) { }
		for(String str : list) {
			System.out.println(str);
		}
		// 방법3] forEach() , JS : () => {} , JAVA : () -> {}
		list.forEach((str) -> { System.out.println(str); } );
		
		// 클래스들
		ArrayList<String> list1 = new ArrayList<String>();
		// 멀티스레드에서 주로 사용
		Vector<String> list2 = new Vector<>();
		// 요소가 중간 삽입/삭제에 용이하다(효율적이다)
		LinkedList<String> list3 = new LinkedList<>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new Vector<String>();
		List<String> list6 = new LinkedList<String>();
		
	}
}
