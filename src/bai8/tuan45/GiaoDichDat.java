package bai8.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class GiaoDichDat extends GiaoDich {
	
 private LoaiDat loaidat;
 private double dientich;
 
 public GiaoDichDat(String magd, LocalDate ngaygd, double dongia, LoaiDat loaidat, double dientich) {
	super(magd, ngaygd, dongia);
	
	setLoaidat(loaidat);
	setDientich(dientich);
	
 }

 public LoaiDat getLoaidat() {
	return loaidat;
 }

 public void setLoaidat(LoaiDat loaidat) {
	this.loaidat = loaidat;
 }

 public double getDientich() {
	return dientich;
 }

 public void setDientich(double dientich) {
	 if(dientich <= 0) {
		 throw new IllegalArgumentException("Dien tich phai lon hon khong");
	 }
	this.dientich = dientich;
 }
 
 NumberFormat nf = NumberFormat.getCurrencyInstance(
		      Locale.forLanguageTag("vi-VN"));
 @Override
	public String toString() {
		return String.format("%s | Loai Dat: %3s, Dien Tich: %.2f, Thanh Tien: %5s ", super.toString(),
				             loaidat,
				             dientich,
				             nf.format(thanhtien())
				             );
	}

 @Override
 public double thanhtien() {
	if(loaidat == LoaiDat.B || loaidat == LoaiDat.C) {
		return dientich * dongia;
	}
	else
		return dientich * dongia * 1.5;
 }
 
 
 
 


 
 
}
