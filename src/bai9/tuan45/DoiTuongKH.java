package bai9.tuan45;

public enum DoiTuongKH {
SINHHOAT("Sinh Hoạt"),
KINHDOANH("Kinh Doanh"),
SANXUAT("Sản Xuất");
	private String value;

	private DoiTuongKH(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
