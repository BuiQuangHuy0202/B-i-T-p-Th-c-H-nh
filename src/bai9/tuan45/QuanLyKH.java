package bai9.tuan45;

import java.util.ArrayList;
import java.util.List;

public class QuanLyKH implements IQuanLyKH {
	
 private List<KhachHang> dsKhachHang;

 public QuanLyKH(List<KhachHang> dsKhachHang) {
	
	this.dsKhachHang = new ArrayList<KhachHang>();
 }
 
 public int getSoLuong() {
	 return dsKhachHang.size();
 }
 
 public List<KhachHang> getlist(){
	 return dsKhachHang;
 }

 @Override
 public KhachHang them(KhachHang kh) {
	for (KhachHang khachHang : dsKhachHang) {
		if(khachHang.getMakh().equals(kh.getMakh())) {
		return null;
		}
	}
	dsKhachHang.add(kh);
	return kh;
 }

 @Override
 public double tongsoluong() {
	return dsKhachHang.stream().mapToDouble(KhachHang::getSoKWH)
			      .sum();
 }

 @Override
 public double tbthanhtien() {
    return dsKhachHang.stream().filter(kh->kh instanceof KhachHangNuocNgoai)
    		.mapToDouble(KhachHang::thanhtien)
    		.average().getAsDouble();
 }
 
 
}
