package bai9.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class KhachHangVN extends KhachHang {
	 private DoiTuongKH doituong;

	 public KhachHangVN(String makh, String hoten, LocalDate ngayxuathoadon, double soKWH, double dongia, double dinhmuc,
			DoiTuongKH doituong) {
		super(makh, hoten, ngayxuathoadon, soKWH, dongia, dinhmuc);
		setDoituong(doituong);
	 }

	 public DoiTuongKH getDoituong() {
		 return doituong;
	 }

	 public void setDoituong(DoiTuongKH doituong) {
		 this.doituong = doituong;
	 }

	 @Override
	 public double thanhtien() {
		if(soKWH <= dinhmuc) {
			return soKWH * dongia;
		}
		else {
			
	        double tienTrongDinhMuc = dinhmuc * dongia;
	        
	     
	        double soKWHvuotdinhmuc = soKWH - dinhmuc;
	        
	        
	        double donGiaVuot = dongia * 2.5;
	        
	      
	        double tienVuotDinhMuc = soKWHvuotdinhmuc * donGiaVuot;
	        
	        
	        return tienTrongDinhMuc + tienVuotDinhMuc;
		}
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
