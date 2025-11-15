package bai6.tuan4;

public enum TinhTrang {
 NEW("Mới"),
 OLD("Cũ");
	private String value;

	private TinhTrang(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
