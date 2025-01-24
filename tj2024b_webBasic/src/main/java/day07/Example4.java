package day07;

import java.util.HashMap;
import java.util.Map;

public class Example4 {
	public static void main(String[] args) {
		
		// [1] HashMap 인스턴스 생성
		Map<String, Integer> map = new HashMap<>();
		
		// [2] Map 인터페이스 주요 메소드
		// .put("key", value) : map 내 key와 value를 한쌍으로 저장
		map.put("유재석", 85); System.out.println(map);
		map.put("홍길동", 90); System.out.println(map);
		map.put("강호동", 100); System.out.println(map);
		map.put("신동엽", 100); System.out.println(map);
		map.put("유재석" , 72); System.out.println(map);
		// .get("key") : map 내 지정한 key의 value값을 반환
		System.out.println(map.get("유재석"));
		int value1 = map.get("신동엽"); System.out.println(value1);
		// .size() : map 내 전체 entry의 개수를 반환
		System.out.println(map.size());
		// .remove("key") : map 내 지정한 key의 엔트리값 삭제
		map.remove("신동엽"); System.out.println(map);
		// map.containsKey("key"), map.containsValue(value) : map 내 지정한 key 또는 value의 존재여부를 반환
		// .entry() : map 내 모든 entry를 반환하는 함수
		System.out.println(map.entrySet());
		// .keySet() : map 내 모든 key를 반환하는 함수
		System.out.println(map.keySet());
		// .values() : map 내 모든 value를 반환하는 함수
		System.out.println(map.values());
		// for문으로 순회 불가능(가능할지도?)
		// 향상된 for문으로 가능
		for(String key : map.keySet()) { System.out.println(map.get(key)); }
		// forEach문
		map.keySet().forEach((key) -> { System.out.println(map.get(key)); });
		
	}
}
