package day03;

public class DataDto {
	private String data1;
	private int data2;
	
	// Constructor
	public DataDto() {}
	public DataDto(String data1, int data2) {
		this.data1 = data1; this.data2 = data2;
	}
	
	// getter
	public String getData1() { return this.data1; }
	public int getData2() { return this.data2; }
	
	// setter
	public void setData1(String data1) { this.data1 = data1; }
	public void setData2(int data2) { this.data2 = data2; }
	
	// toString
	public String toString() {
		return "DataDto [data1 = " + data1 + ", data2 = " + data2 + "]";
	}
	
}
