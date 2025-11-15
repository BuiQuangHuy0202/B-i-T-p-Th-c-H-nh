package bai8.tuan45;

public enum LoaiNha {
 caocap("Cao Cấp"),
 thuong("Thường");
	
	private String value;

	private LoaiNha(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
