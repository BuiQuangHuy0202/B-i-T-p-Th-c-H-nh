package bai1.tuan4;

import java.time.LocalDate;

public class HoaDonTheoNgay extends HoaDon {

	private int songaythue;
	
	public HoaDonTheoNgay(String mahd, LocalDate ngayhd, String tenkh, String maphong, double dongia) {
		super(mahd, ngayhd, tenkh, maphong, dongia);
	}

	public HoaDonTheoNgay(String mahd, LocalDate ngayhd, String tenkh, String maphong, double dongia, int songaythue) {
		super(mahd, ngayhd, tenkh, maphong, dongia);
		this.songaythue = songaythue;
	}

	public int getSongaythue() {
		return songaythue;
	}

	public void setSongaythue(int songaythue) {
		if(songaythue <= 0) {
			throw new IllegalArgumentException("So ngay thue phai lon hon 0");
		}
		this.songaythue = songaythue;
	}
	
	@Override
	public String toString() {
		return String.format("%s | So ngay thue: %s", super.toString(), songaythue);
	}

	@Override
	public double thanhtien() {
		int songayconlai = songaythue - 7;
		if(songaythue > 7) {
			return 0.8 * songayconlai * dongia + 7 * dongia;
		}
		return songaythue * dongia;
	}
	
	
}
