package day03.task4;

public class WaitingDto {
	// Value
	private int num;
	private String phone;
	private int people;
	
	// Constructor
	public WaitingDto() {}
	public WaitingDto(int num, String phone, int people) { 
		this.num = num; this.phone = phone; this.people = people;
	}
	
	// getter
	public int getNum() { return this.num; }
	public String getPhone() { return this.phone; }
	public int getPeople() { return this.people; }
	
	// setter
	public void setNum(int num) { this.num = num; }
	public void setPhone(String phone) { this.phone = phone; }
	public void setPeople(int people) { this.people = people; }
	
	// toString
	public String toString() {
		return "WaitingDto [num = " + num + ", phone = " + phone + ", people = " + people + "]";
	}
	
}
