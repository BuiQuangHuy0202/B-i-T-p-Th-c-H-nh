package bai1.tuan4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class HoaDon {
  protected final String mahd;
  protected LocalDate ngayhd;
  protected String tenkh;
  protected String maphong;
  protected double dongia;
  
  
  public HoaDon(String mahd, LocalDate ngayhd, String tenkh, String maphong, double dongia) {
	super();
	if(mahd == null || mahd.isEmpty()) {
		throw new RuntimeException("Ma hoa don khong hop le");
	}
	if(maphong == null || maphong.isEmpty()) {
		throw new RuntimeException("Ma phong khong hop le");
	}
	this.mahd = mahd;
	setNgayhd(ngayhd);
	setTenkh(tenkh);
	this.maphong = maphong;
	setDongia(dongia);
	
  }


  public LocalDate getNgayhd() {
	return ngayhd;
  }


  public void setNgayhd(LocalDate ngayhd) {
	  if(ngayhd.isAfter(LocalDate.now())) {
		  throw new IllegalArgumentException("Ngay hoa don khong hop le");
	  }
	this.ngayhd = ngayhd;
  }


  public String getTenkh() {
	return tenkh;
  }


  public void setTenkh(String tenkh) {
	  if(tenkh == null || tenkh.isEmpty()) {
		  throw new IllegalArgumentException("Ten khach hang khong duoc trong");
	  }
	this.tenkh = tenkh;
  }


  public double getDongia() {
	return dongia;
  }


  public void setDongia(double dongia) {
	  if(dongia <= 0) {
		  throw new IllegalArgumentException("Don gia phai lon hon khong");
	  }
	this.dongia = dongia;
  }


  public String getMahd() {
	return mahd;
  }


  public String getMaphong() {
	return maphong;
  }
  
  @Override
	public String toString() {
	  DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  NumberFormat nf = NumberFormat.getCurrencyInstance(
			  Locale.forLanguageTag("vi-VN"));
		return String.format("%10s | %15s | %8s | %20s | %8s | %9s ",
				     mahd,
				     df.format(ngayhd),
				     maphong,
				     tenkh,
				     nf.format(dongia),
				     nf.format(thanhtien())
				     );
	}
  
  public abstract double thanhtien();


  @Override
  public int hashCode() {
	return Objects.hash(mahd);
  }


  @Override
  public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	HoaDon other = (HoaDon) obj;
	return Objects.equals(mahd, other.mahd);
  }




  
  
  
  
}
