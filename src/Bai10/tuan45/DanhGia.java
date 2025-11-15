package Bai10.tuan45;

public enum DanhGia {
  GIOI("Giỏi"),
  KHA("Khá"),
  TRUNGBINH("Trung Bình"), 
  YEU("Yếu");
	
	private String value;

	private DanhGia(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	
}
