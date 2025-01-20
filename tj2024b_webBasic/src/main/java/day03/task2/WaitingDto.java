package day03.task2;

public class WaitingDto {
	private String phone;
	private int people;
	
	public WaitingDto() {}
	public WaitingDto(String phone, int people) { this.phone = phone; this.people = people; }
	
	// getter
	public String getPhone() { return this.phone; }
	public int getPeople() { return this.people; }
	
	// setter
	public void setPhone(String phone) { this.phone = phone; }
	public void setPeople(int people) { this.people = people; }
	
	// toString
	public String toString() {
		return "WaitingDto [phone = " + phone + ", people = " + people + "]";
	}
	
}
