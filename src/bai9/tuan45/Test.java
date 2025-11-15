package bai9.tuan45;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Test {
public static void main(String[] args) {
	List<KhachHang> danhsach = taodulieumau();
	QuanLyKH ds = new QuanLyKH(danhsach);
	
	String headerline = String.format("%5s | %20s | %18s | %s | %s | %s | %s", 
			"MaKH", "Ho va Ten", "Ngay Xuat Hoa Don","So KWH","Don Gia", "Dinh Muc", "Thanh Tien");
	
	System.out.println(headerline+ "\n" + "=".repeat(93));
	for (KhachHang khachHang : danhsach) {
		System.out.println(ds.them(khachHang));
	}
	
	
}

private static List<KhachHang> taodulieumau(){
	List<KhachHang> ds = new ArrayList<>();
	ds.add(new KhachHangVN("2222", "Bui Quang Huy", LocalDate.of(2025, 3, 10),120.0,1800.0, 150.0, DoiTuongKH.SINHHOAT));
	ds.add(new KhachHangNuocNgoai("3333", "Anthony", LocalDate.of(2013, 9, 20), 125.0, 1800.0, 150.0, "Cali"));
	ds.add(new KhachHangVN("1312", "Tran My Mong", LocalDate.of(2025, 9, 16),160.0,1800.0, 150.0, DoiTuongKH.KINHDOANH));
	return ds;
}
}


