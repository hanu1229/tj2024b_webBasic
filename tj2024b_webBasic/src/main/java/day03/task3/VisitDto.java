package day03.task3;

public class VisitDto {
	private int num;
	private String content;
	private int age;
	
	public VisitDto() {}
	public VisitDto(String content, int age) {
		this.content = content; this.age = age;
	}
	
	// getter
	public int getNum() { return this.num; }
	public String getContent() { return this.content; }
	public int getAge() { return this.age; }
	
	// setter
	public void setNum(int num) { this.num = num; }
	public void setContent(String content) { this.content = content; }
	public void setAge(int age) { this.age = age; }
	
	// toString
	public String toString() {
		return "VisitDto [num = " + num + ", content = " + content + ", age = " + age + "]";
	}
	
}
