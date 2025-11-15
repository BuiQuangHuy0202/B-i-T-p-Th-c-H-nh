package bai8.tuan45;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class GiaoDichNha extends GiaoDich{
 
	private LoaiNha loainha;
	private double dientich;
	private String diachi;
	
	public GiaoDichNha(String magd, LocalDate ngaygd, double dongia, LoaiNha loainha, double dientich, String diachi) {
		super(magd, ngaygd, dongia);
		setLoainha(loainha);
		setDientich(dientich);
		setDiachi(diachi);
	}

	public LoaiNha getLoainha() {
		return loainha;
	}

	public void setLoainha(LoaiNha loainha) {
		this.loainha = loainha;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		if(diachi == null || diachi.isEmpty()) {
			throw new IllegalArgumentException("Dia chi khong duoc de trong");
		}
		this.diachi = diachi;
	}
	
	NumberFormat nf = NumberFormat.getCurrencyInstance(
			       Locale.forLanguageTag("vi-VN"));
	@Override
	public String toString() {
		
		return String.format("%s | Loai Nha: %8s, Dien Tich: %.2f, Dia Chi: %20s, Thanh Tien: %5s", super.toString(),
				           loainha,
				           dientich,
				           diachi,
				           nf.format(thanhtien())
				           );
	}

	@Override
	public double thanhtien() {
		if(loainha == LoaiNha.caocap) {
			return dientich * dongia;
		}
		else 
		   return dientich * dongia * 0.9;
	}
	
	
	
	
}
