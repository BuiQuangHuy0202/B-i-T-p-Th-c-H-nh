package bai6.tuan4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class SachThamKhao extends Sach {

	private double thue = 2;
	
	public SachThamKhao(String masach, LocalDate ngaynhap, double dongia, int soluong, String nhasanxuat,
			String tensach) {
		this(masach, ngaynhap, dongia, soluong, nhasanxuat, tensach,2.5);
	
	}

	public SachThamKhao(String masach, LocalDate ngaynhap, double dongia, int soluong, String nhasanxuat,
			String tensach, double thue) {
		super(masach, ngaynhap, dongia, soluong, nhasanxuat, tensach);
		this.thue = thue;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if(thue <= 0) {
			throw new IllegalArgumentException("Thue phai lon hon 0");
		}
		this.thue = thue;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		return String.format("%s | %s", super.toString(), nf.format(thue));
	}

	@Override
	public double thanhtien() {
		return soluong * dongia + thue;
	}
	
	
	
	
}
