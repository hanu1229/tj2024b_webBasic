package day03.task1;

public class VisitDto {
	private String content;
	private int age;
	
	public VisitDto() {}
	public VisitDto(String content, int age) {
		this.content = content; this.age = age;
	}
	
	// getter
	public String getContent() { return this.content; }
	public int getAge() { return this.age; }
	
	// setter
	public void setContent(String content) { this.content = content; }
	public void setAge(int age) { this.age = age; }
	
	// toString
	public String toString() {
		return "VisitDto [content = " + content + ", age = " + age + "]";
	}
	
}
