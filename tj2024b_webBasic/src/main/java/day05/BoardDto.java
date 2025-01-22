package day05;

public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bview;
	private String bpwd;
	private String bdate;
	
	public BoardDto() {}
	public BoardDto(String btitle, String bcontent, String bwriter, int bview, String bpwd) {
		this.btitle = btitle; this.bcontent = bcontent; this.bwriter = bwriter;
		this.bview = bview; this.bpwd = bpwd;
	}
	
	// getter
	public int getBno() { return this.bno; }
	public String getBtitle() { return this.btitle; }
	public String getBcontent() { return this.bcontent; }
	public String getBwriter() { return this.bwriter; }
	public int getBview() { return this.bview; }
	public String getBpwd() { return this.bpwd; }
	public String getBdate() { return this.bdate; }
	
	// setter
	public void setBno(int bno) { this.bno = bno; }
	public void setBtitle(String btitle) { this.btitle = btitle; }
	public void setBcontent(String bcontent) { this.bcontent = bcontent; }
	public void setBwriter(String bwriter) { this.bwriter = bwriter; }
	public void setBview(int bview) { this.bview = bview; }
	public void setBpwd(String bpwd) { this.bpwd = bpwd; }
	public void setBdate(String bdate) { this.bdate = bdate; }	

	// toString
	@Override
	public String toString() {
		return "BoardDto [bno = " + bno + ", btitle = " + btitle + ", bcontent = " + bcontent + ", bwriter = " 
				+ bwriter + ", bview = " + bview + ", bpwd = " + bpwd + ", bdate = " + bdate + "]";
	}
	
}
