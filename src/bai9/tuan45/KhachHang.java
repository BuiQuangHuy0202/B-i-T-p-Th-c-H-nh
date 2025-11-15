package bai9.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class KhachHang {
	protected String makh;
	 protected String hoten;
	 protected LocalDate  ngayxuathoadon;
	 protected double soKWH;
	 protected double dongia;
	 protected double dinhmuc;
	 
	 public KhachHang(String makh, String hoten, LocalDate ngayxuathoadon, double soKWH, double dongia,
			double dinhmuc) {
		super();
		
		setMakh(makh);
		setHoten(hoten);
		this.ngayxuathoadon = ngayxuathoadon;
		setSoKWH(soKWH);
		setDongia(dongia);
		setDinhmuc(dinhmuc);
		
	 }

	 public String getMakh() {
		return makh;
	 }

	 public void setMakh(String makh) {
		 if(makh == null || makh.isEmpty()) {
			 throw new IllegalArgumentException("Ma khach hang khong rong");
		 }
		this.makh = makh;
	 }

	 public String getHoten() {
		return hoten;
	 }

	 public void setHoten(String hoten) {
		 if(hoten == null || hoten.isEmpty()) {
			 throw new IllegalArgumentException("Ten khong hop le");
		 }
		this.hoten = hoten;
	 }

	 public LocalDate getNgayxuathoadon() {
		return ngayxuathoadon;
	 }

	 public void setNgayxuathoadon(LocalDate ngayxuathoadon) {
		this.ngayxuathoadon = ngayxuathoadon;
	}

	 public double getSoKWH() {
		return soKWH;
	 }

	 public void setSoKWH(double soKWH) {
		 if(soKWH < 0) {
			 throw new IllegalArgumentException("So KWH phai lon hon hoac bang 0");
		 }
		this.soKWH = soKWH;
	 }

	 public double getDongia() {
		return dongia;
	 }

	 public void setDongia(double dongia) {
		 if(dongia <= 0) {
			 throw new IllegalArgumentException("Don gia phai lon hon hoac bang 0");
		 }
		this.dongia = dongia;
	 }

	 public double getDinhmuc() {
		return dinhmuc;
	 }

	 public void setDinhmuc(double dinhmuc) {
		this.dinhmuc = dinhmuc;
	 }
	 
	 @Override
		public String toString() {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			NumberFormat nf = NumberFormat.getCurrencyInstance(
					Locale.forLanguageTag("vi-VN")
					);
			
			return String.format("%5s | %20s | %18s | %.2f | %5s | %8.2f ", 
					    makh,
					    hoten,
					    df.format(ngayxuathoadon),
					    soKWH,
					    nf.format(dongia),
					    dinhmuc
					    ) ;
		}
	 

	 
	 public abstract double thanhtien();

	 @Override
	 public int hashCode() {
		return Objects.hash(makh);
	 }

	 @Override
	 public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(makh, other.makh);
	 }
	 
	 
	 
}
