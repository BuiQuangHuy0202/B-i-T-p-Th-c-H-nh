package bai6.tuan4;


import java.time.LocalDate;


public class SachGiaoKhoa extends Sach {

	private TinhTrang tinhtrang;
	
	public SachGiaoKhoa(String masach, LocalDate ngaynhap, double dongia, int soluong, String nhasanxuat,
			String tensach) {
		this(masach, ngaynhap, dongia, soluong, nhasanxuat, tensach, TinhTrang.NEW);
	}

	public SachGiaoKhoa(String masach, LocalDate ngaynhap, double dongia, int soluong, String nhasanxuat,
			String tensach, TinhTrang tinhtrang) {
		super(masach, ngaynhap, dongia, soluong, nhasanxuat, tensach);
		setTinhtrang(tinhtrang);
	}

	public TinhTrang getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(TinhTrang tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s", super.toString(), tinhtrang);
	}

	@Override
	public double thanhtien() {
		if(tinhtrang == TinhTrang.NEW) {
			return soluong * dongia;
		}
		return soluong * dongia * 0.5;
	}
	
	
	
	
	
}
