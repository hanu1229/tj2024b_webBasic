package day07;

import java.util.ArrayList;

// 서블릿 X
public class Example1 {
	public static void main(String[] args) {
		
		// [1] Box1 인스턴스 생성
		Box1 box1 = new Box1();
		// 인스턴스 내 멤버변수의 값 대입
		box1.content = "안녕하세요";
		// 특정 인스턴스 내 멤버변수의 값을 호출
		String content1 = box1.content;
		
		// [2] Box2 인스턴스 생성
		Box2 box2 = new Box2();
		box2.content = 100;
		int content2 = box2.content;
		
		// [3] 특정 인스턴스의 하나의 멤버변수가 여러 타입을 가질 수 있는지?
		
		// 방법1] 다형성 : 다양한 타입으로 변환이 가능한 성질 최상위 클래스 = Object
		Box3 box3 = new Box3();
		// 자동 형변환(타입변환) / 업캐스팅 / 자식(String) --> 부모(Object)
		box3.content = "안녕하세요";
		// 강제 현변환(타입변환) / 다운캐스팅 / 부모(Object) --> 자식(String)
		String content3 = (String)box3.content;
		box3.content = 100;
		int content4 = (Integer)box3.content;
		
		// 방법2] 제네릭타입 : 클래스 내 멤버변수 타입을 인스턴스가 생성될 때 정하기
		Box4<String> box4 = new Box4<String>();
		box4.content = "안녕하세요";
		String content5 = box4.content;
		Box4<Integer> box5 = new Box4<Integer>();
		box5.content = 100;
		int content6 = box5.content;
		
		// [4] 제네릭 대표적인 사용처
		// String 타입 인스턴스들을 여러개 저장하는 ArrayList 인스턴스
		ArrayList<String> sList = new ArrayList<>();
		// Dto 타입 인스턴스들을 여러개 저장하는 ArrayList 인스턴스
		ArrayList<Dto> dtoList = new ArrayList<>();
		// * 게시물 1개 조회시 Dto, 게시물 여러개 조회시 ArrayList<Dto>
		
		// [5] 제네릭타입 여러개
		Point<String, Integer> point = new Point<>();
		// 제네릭타입에 String 타입을 대입했으므로 가능
		point.value1 = "안녕하세요";
		// 제네릭타입에 Integer 타입을 대입했으므로 가능
		point.value2 = 100;
		Point<Double, Dto> point2 = new Point<>();
		// 제네릭타입에 Double 타입을 대입했으므로 가능
		point2.value1 = 100.0;
		// 제네릭 타입에 Dto 타입을 대입했으므로 가능
		point2.value2 = new Dto();

		
	}
}

class Box1 { String content; }

class Box2 { int content; }

class Box3 { Object content; }
// 클래스명<제네릭타입> { }
class Box4<T> { T content; }

class Dto { }
class Point<T, V> {
	T value1;
	V value2;
}