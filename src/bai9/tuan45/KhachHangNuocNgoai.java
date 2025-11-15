package bai9.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class KhachHangNuocNgoai extends KhachHang {
	
 private String quoctich;

 public KhachHangNuocNgoai(String makh, String hoten, LocalDate ngayxuathoadon, double soKWH, double dongia,
		double dinhmuc, String quoctich) {
	super(makh, hoten, ngayxuathoadon, soKWH, dongia, dinhmuc);
	setQuoctich(quoctich);
 }

 public String getQuoctich() {
	return quoctich;
 }

 public void setQuoctich(String quoctich) {
	 if(quoctich == null || quoctich.isEmpty()) {
		 throw new IllegalArgumentException("Quoc tich khong duoc rong");
	 }
	this.quoctich = quoctich;
 }

 @Override
 public double thanhtien() {
	return soKWH * dongia;
 }
 
 NumberFormat nf = NumberFormat.getCurrencyInstance(
			Locale.forLanguageTag("vi-VN")
			);

@Override

public String toString() {
	return String.format("%s| %s", super.toString(), nf.format(thanhtien())
			      );
}
 
 
 
 
 
 
}
