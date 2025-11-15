package bai1.tuan4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
 public static void main(String[] args) {
	List<HoaDon> ds = taodulieumau();
	QuanLyHoaDon qly = new QuanLyHoaDon();
	String headerline = String.format("%10s | %15s | %5s | %20s | %8s | %8s | %s",
			"MaHD", "NgayHD", "Ma Phong","TenKH" , "Don Gia", "Thanh Tien", "Thong Tin Khac");
	System.out.println(headerline + "\n" +"-".repeat(106));
	for (HoaDon hoaDon : ds) {
		try {
			System.out.println(qly.them(hoaDon));
		} catch (Exception e) {
			System.out.println("Khong Thanh Cong");
		}
	}
	
	System.out.println("\nXoa ma HDTG03");
	qly.xoa("HDTG03");
	System.out.println(headerline + "\n" +"-".repeat(106));
	for (HoaDon hoaDon : qly.getList()) {
		System.out.println(hoaDon);
	}
	
	System.out.println("\nCap nhat ten khach hang cho ma hoa don HDTN04");
	System.out.println(headerline + "\n" +"-".repeat(106));
	System.out.println(qly.capnhat("HDTN04", "Lee Min Hoo"));
	
	System.out.println("\n5 Thanh tien lon nhat");
	qly.thanhtienlonnhat(5).forEach(System.out::println);
	
	System.out.println("\n Sap xep tang dan theo don gia");
	qly.sapxeptangtheodongia().forEach(System.out::println);
	
	System.out.println("\nMa phong tang don gia giam");
	qly.sapxepmaphongtangdongiagiam().forEach(System.out::println);
	
	System.out.println("Gom nhom theo ma hoa don don gia giam dan");
	Map<String, HoaDon> gomnhom1 = qly.gomnhom1();
	gomnhom1.forEach((loai, dongia)->{
		System.out.println("=> Ma Hoa Don: " + loai + " Don Gia: " + dongia.getDongia());
	});
	
	System.out.println("Gom nhom theo loai don gia giam dan");
	Map<String, List<HoaDon>> gomnhom2 = qly.gomnhom2();
	gomnhom2.forEach((loai, danhsach)->{
		System.out.println("=> Loai: "+ loai);
		danhsach.forEach(System.out::println);
	});
	
	System.out.println("Gom nhom theo loai hoa don tra ve so luong tung loai");
	Map<String, Integer> gomnhom3 = qly.gomnhom3();
	gomnhom3.forEach((loai, soluong)->{
		System.out.println("=> Loai Hd: "+ loai + " So luong: " + soluong);
	});
	
	System.out.println("\nTinh trung binh thanh tien thue phong thang 9/2013");
	double tb = qly.trungbinhthanhtien(9, 2013);
	System.out.printf("Trung binh thanh tien la: %.2f",tb);
	
	
}
 
 private static List<HoaDon> taodulieumau(){
	 List<HoaDon> ds = new ArrayList<HoaDon>();
	 
	 ds.add(new HoaDonTheoGio("HDTG01", LocalDate.of(2025, 10, 20), "Tran My Mong", "A101", 20000, 3));
	 ds.add(new HoaDonTheoGio("HDTG02", LocalDate.of(2025, 11, 2), "Bui Thanh Tu", "A102", 26000, 7));
	 ds.add(new HoaDonTheoGio("HDTG03", LocalDate.of(2013, 9, 28), "Bui Quang Tuan", "A104", 21000, 9));
	 ds.add(new HoaDonTheoGio("HDTG04", LocalDate.of(2025, 1, 30), "Huynh Thi Ngoc Lieu", "A104", 20000, 26));
	 ds.add(new HoaDonTheoNgay("HDTN01", LocalDate.of(2022, 12, 3), "Bui Quang Huy", "A106", 19000, 2));
	 ds.add(new HoaDonTheoNgay("HDTN02", LocalDate.of(2013, 9, 13), "Ngo Kien Huy", "A107", 19000, 3));
	 ds.add(new HoaDonTheoNgay("HDTN03", LocalDate.of(2022, 9, 3), "Tran Minh Hieu", "A116", 19000, 5));
	 ds.add(new HoaDonTheoNgay("HDTN04", LocalDate.of(2022, 4, 23), "Le Duong Bao Lam", "A108", 19000, 8));
	 ds.add(new HoaDonTheoNgay("HDTN05", LocalDate.of(2022, 6, 23), "Vo Vu Truong Giang", "A106", 19000, 6));
	 return ds;
 }
 
}
