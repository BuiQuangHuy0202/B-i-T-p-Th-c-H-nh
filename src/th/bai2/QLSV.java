package th.bai2;

public class QLSV {
	private int masv;
	private String hoten;
	private float diemlt;
	private float diemth;
	
	public QLSV() {
		this(0,"",0.0f,0.0f);
	}

	public QLSV(int masv, String hoten, float diemlt, float diemth) {
		this.masv = masv;
		this.hoten = hoten;
		this.diemlt = diemlt;
		this.diemth = diemth;
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public float getDiemlt() {
		return diemlt;
	}

	public void setDiemlt(float diemlt) {
		this.diemlt = diemlt;
	}

	public float getDiemth() {
		return diemth;
	}

	public void setDiemth(float diemth) {
		this.diemth = diemth;
	}
	
	public double dtb() {
		return (diemlt + diemth)/2;
	}

	@Override
	public String toString() {
		return String.format("%-15d | %-30s | %14.2f | %14.2f | %5.2f ", 
				masv,
				hoten,
				diemlt,
				diemth,
				dtb()
				);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
