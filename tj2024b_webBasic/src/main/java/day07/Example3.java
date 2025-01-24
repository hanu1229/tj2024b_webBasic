package day07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Example3 {
	public static void main(String[] args) {
		
		// HashSet 인스턴스 생성
		Set<String> set =new HashSet<>();
		// set 인터페이스의 주요 메소드들
		// .add(자료) : set 내 지정한 자료를 추가
		set.add("유재석"); System.out.println(set);
		set.add("강호동"); System.out.println(set);
		set.add("신동엽"); System.out.println(set);
		// .size() : set 내 전체 요소 개수를 반환
		System.out.println(set.size());
		// .remove(자료) : set 내 지정한 자료가 존재하면 삭제
		set.remove("강호동"); System.out.println(set);
		// .contains(자료) : set 내 지정한 자료가 존재하는지 여부를 반환
		System.out.println(set.contains("유재석"));
		// 순회 .interator() , interator : 반복자르는 뜻을 가지고 있다
		Iterator<String> rs = set.iterator();
		while(rs.hasNext()) {
			System.out.println(rs.next());
		}
		// 순회 for문은 사용불가능 : 인덱스가 존재하지 않기 때문이다
		// 향상된 for문 : 문법 자체가 Iterator 기반으로 만들었기 때문에 사용 가능
		for(String str : set) { System.out.println(str); }
		// forEach(()->{}) : Iterator 기반으로 만들었기 때문에 사용 가능
		set.forEach((str)-> {System.out.println(str); });
		// set 컬랙션은 중복을 허용하지 않는다. 중복되는 값이 있더라도 오류를 내지는 않는다.
		set.add("유재석"); System.out.println(set);
		
		// TreeSet 인스턴스 생성
		// 정렬 기능이 포함되어 자동으로 오름차순 정렬을 해준다.
		TreeSet<String> set2 = new TreeSet<String>();
		set2.add("유재석"); set2.add("강호동"); set2.add("서장훈");
		// 오름차순 정렬
		System.out.println(set2);
		// 내림차순 정렬
		System.out.println(set2.descendingSet());
		
	}
}
