package bai1.tuan4;

import java.time.LocalDate;

public class HoaDonTheoGio extends HoaDon {
  

	private int sogiothue;
	
	public HoaDonTheoGio(String mahd, LocalDate ngayhd, String tenkh, String maphong, double dongia) {
		super(mahd, ngayhd, tenkh, maphong, dongia);
	}

	public HoaDonTheoGio(String mahd, LocalDate ngayhd, String tenkh, String maphong, double dongia, int sogiothue) {
		super(mahd, ngayhd, tenkh, maphong, dongia);
	setSogiothue(sogiothue);
	}

	public int getSogiothue() {
		return sogiothue;
	}

	public void setSogiothue(int sogiothue) {
		if(sogiothue > 30) {
			throw new IllegalArgumentException("Khong dung duoc loai hoa don thue theo gio");
		}
		this.sogiothue = sogiothue;
	}
	
	@Override
	public String toString() {

		return String.format("%s | So gio thue: %sh", super.toString(), sogiothue);
	}

	@Override
	public double thanhtien() {
       
		if(sogiothue > 24 && sogiothue < 30) {
			return 24 * dongia;
		}
		return sogiothue * dongia;
	}
	
	
	
	
}
