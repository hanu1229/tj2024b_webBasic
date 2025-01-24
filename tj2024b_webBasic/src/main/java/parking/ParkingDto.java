package parking;

public class ParkingDto {
	/* 멤버변수 */
	// 자리번호
	private int pno;
	// 입출차번호
	private int lno;
	// 차량번호
	private String car;
	// 시간
	private String time;
	// 상태
	private int state;
	// 요금
	private int price;
	
	/* 생성자 */
	public ParkingDto() {}
	public ParkingDto(int pno, int lno, String car, String time, int state, int price) {
		this.pno = pno; this.lno = lno; this.car = car;
		this.time = time; this.state = state; this.price = price;
	}
	
	/* getter */
	public int getPno() { return pno; }
	public int getLno() { return lno; }
	public String getCar() { return car; }
	public String getTime() { return time; }
	public int getState() { return state; }
	public int getPrice() { return price; }
	
	/* setter */
	public void setPno(int pno) { this.pno = pno; }
	public void setLno(int lno) { this.lno = lno; }
	public void setCar(String car) { this.car = car; }
	public void setTime(String time) { this.time = time; }
	public void setState(int state) { this.state = state; }
	public void setPrice(int price) { this.price = price; }
	
	/* toString */
	public String toString() {
		return "ParkingDto [pno = " + pno + ", lno = " + lno + ", car = " + car
				 + ", time = " + time + ", state = " + state + ", price = " + price + "]";
	}
	
}
