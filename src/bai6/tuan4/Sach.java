package bai6.tuan4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

//Mã sách, ngày nhập (ngày, tháng, năm), đơn giá, số lượng, nhà xuất bản
public abstract class Sach {
	
 protected final String masach;
 protected LocalDate ngaynhap;
 protected double dongia;
 protected int soluong;
 protected String nhasanxuat;
 protected String tensach;
 
 public Sach(String masach, LocalDate ngaynhap, double dongia, int soluong, String nhasanxuat, String tensach) {
	super();
	if(masach == null || masach.isEmpty()) {
		throw new RuntimeException("Ma khong hop le");
	}
	this.masach = masach;
	setNgaynhap(ngaynhap);
	setDongia(dongia);
	setSoluong(soluong);
	setNhasanxuat(nhasanxuat);
	setTensach(tensach);
 }

 public LocalDate getNgaynhap() {
	return ngaynhap;
 }

 public void setNgaynhap(LocalDate ngaynhap) {
	 if(ngaynhap.isAfter(LocalDate.now())) {
		 ngaynhap = LocalDate.now();
	 }
	this.ngaynhap = ngaynhap;
 }

 public double getDongia() {
	return dongia;
 }

 public void setDongia(double dongia) {
	 if(dongia <= 0) {
		 throw new IllegalArgumentException("Don gia phai lon hon 0");
	 }
	this.dongia = dongia;
 }

 public int getSoluong() {
	return soluong;
 }

 public void setSoluong(int soluong) {
	 if(soluong <= 0) {
		 throw new IllegalArgumentException("So luong phai lon hon 0");
	 }
	this.soluong = soluong;
 }

 public String getNhasanxuat() {
	return nhasanxuat;
 }

 public void setNhasanxuat(String nhasanxuat) {
	 if(nhasanxuat == null || nhasanxuat.isEmpty()) {
		 throw new IllegalArgumentException("Nha san xuat khong duoc de trong");
	 }
	this.nhasanxuat = nhasanxuat;
 }

 public String getTensach() {
	return tensach;
 }

 public void setTensach(String tensach) {
	 if(tensach == null || tensach.isEmpty()) {
		 throw new IllegalArgumentException("Ten khong duoc de trong");
	 }
	this.tensach = tensach;
 }

 public String getMasach() {
	return masach;
 }
 
 public abstract double thanhtien();
 
 @Override
	public String toString() {
	 
	 DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
	 
		return String.format("%7s | %20s | %10s | %15s | %25s | %20s | %10s ", 
				           masach,
				           df.format(ngaynhap),
				           nf.format(dongia),
				           soluong,
				           tensach,
				           nhasanxuat,
				           nf.format(thanhtien())
				        );
	
 
 }

 @Override
 public int hashCode() {
	return Objects.hash(masach);
 }

 @Override
 public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	Sach other = (Sach) obj;
	return Objects.equals(masach, other.masach);
 }
 
 
 
 
 
 
 
 
 
}
