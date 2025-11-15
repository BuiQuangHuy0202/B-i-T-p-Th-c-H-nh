package Bai10.tuan45;

import java.text.NumberFormat;
import java.util.Locale;

public class Customer extends Person {
 private String tencongty;
 private double trigiahoadon;
 private DanhGia danhgia;
 public Customer(String hoten, String diachi, String tencongty, double trigiahoadon, DanhGia danhgia) {
	super(hoten, diachi);
	setTencongty(tencongty);
	setTrigiahoadon(trigiahoadon);
	setDanhgia(danhgia);
	
 }
 
 public String getTencongty() {
	return tencongty;
 }
 public void setTencongty(String tencongty) {
	this.tencongty = tencongty;
 }
 public double getTrigiahoadon() {
	return trigiahoadon;
 }
 public void setTrigiahoadon(double trigiahoadon) {
	this.trigiahoadon = trigiahoadon;
 }
 public DanhGia getDanhgia() {
	return danhgia;
 }
 public void setDanhgia(DanhGia danhgia) {
	this.danhgia = danhgia;
 }
 
 @Override
	public String toString() {
	 NumberFormat nf = NumberFormat.getCurrencyInstance(
			 Locale.forLanguageTag("vi-VN"));
		return String.format("%s | %20s | %s | %10s |",
				super.toString(),
				tencongty,
				nf.format(trigiahoadon),
				danhgia
				);
	}
 
 
 
}
