package Bai10.tuan45;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee extends Person{
 private double hesoluong;
 private static double luongcoban  = 1800000;

 public Employee(String hoten, String diachi, double hesoluong) {
	super(hoten, diachi);
	setHesoluong(hesoluong);
	
 }

 public double getHesoluong() {
	return hesoluong;
 }

 public void setHesoluong(double hesoluong) {
	 if(hesoluong < 0 ) {
		 throw new IllegalArgumentException("He so luong khong hop le");
	 }
	this.hesoluong = hesoluong;
 }
 
 public double tinhluong() {
	 return hesoluong * luongcoban;
 }
 
 public DanhGia danhGia() {
	 double luong = tinhluong();
	 if(luong >= 15000000) return DanhGia.GIOI;
	 else if(luong >= 10000000) return DanhGia.KHA;
	 else if(luong >= 7000000) return DanhGia.TRUNGBINH;
	 else return DanhGia.YEU;
 }
 
 @Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(
				Locale.forLanguageTag("vi-VN"));
		return String.format("%s | %.2f | %s | %10s", 
				    super.toString(),
				    hesoluong,
				    nf.format(tinhluong()),
				    danhGia()
				    );
	}
 
}
