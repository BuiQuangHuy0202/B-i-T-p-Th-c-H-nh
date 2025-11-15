package bai8.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class GiaoDich {
	
 protected final String magd;
 protected LocalDate ngaygd;
 protected double dongia;
 public GiaoDich(String magd, LocalDate ngaygd, double dongia) {
	super();
	if(magd == null || magd.isEmpty()) {
		throw new IllegalArgumentException("Ma giao dich khong hop le");
	}
	this.magd = magd;
	setNgaygd(ngaygd);
	setDongia(dongia);
 }
 public LocalDate getNgaygd() {
	return ngaygd;
 }
 public void setNgaygd(LocalDate ngaygd) {
	this.ngaygd = ngaygd;
 }
 public double getDongia() {
	return dongia;
 }
 public void setDongia(double dongia) {
	 if(dongia <= 0) {
		 throw new IllegalArgumentException("Don gia phai lon hon hoac bang khong");
	 }
	this.dongia = dongia;
 }
 public String getMagd() {
	return magd;
 }
 
 DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 NumberFormat nf = NumberFormat.getCurrencyInstance(
		      Locale.forLanguageTag("vi-VN"));
 @Override
	public String toString() {
		return String.format("%5s | %15s | %12s ",
				       magd,
				       df.format(ngaygd),
				       nf.format(dongia)
				       );
	}
 
 public abstract double thanhtien();
 @Override
 public int hashCode() {
	return Objects.hash(magd);
 }
 @Override
 public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	GiaoDich other = (GiaoDich) obj;
	return Objects.equals(magd, other.magd);
 }
 
 
 
 
 
 
}
