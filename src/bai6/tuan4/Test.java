package bai6.tuan4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class Test {
public static void main(String[] args) {
	
	List<Sach> ds = taodulieumau();
	ThuVien thuvien = new ThuVien();
	String headerline = String.format("%6s | %20s | %10s | %15s | %25s | %20s | %11s | %s ",
			      "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng", "Tên Sách","Nhà Sản Xuất" ,"Thành Tiền", "Thông Tin Bổ Sung");
	System.out.println("Add1");
	System.out.println(headerline + "\n" + "-".repeat(150));
	for (Sach sach : ds) {
		thuvien.add1(sach);
	}
	
	for (Sach s : thuvien.getBooks()) {
		System.out.println(s);
	}
	
	System.out.println("Add2");
	System.out.println(headerline + "\n" + "-".repeat(150));
	for (Sach sach : ds) {
		thuvien.add2(sach);
	}
	for (Sach sach : thuvien.getBooks()) {
		System.out.println(sach);
	}
	
	thuvien.getBooks().clear();
	
	System.out.println("Add3");
	System.out.println(headerline + "\n" + "-".repeat(150));
	for (Sach sach : ds) {
		System.out.println(thuvien.add3(sach));
	}
	
	System.out.println("Update 1");
	thuvien.update1("STK04", 3);
	for (Sach sach : thuvien.getBooks()) {
		System.out.println(sach);
	}
	
	System.out.println("Gom nhom theo loai");
	Map<String, Integer> nhomtheoloai = thuvien.groupByTypeAndCounting();
	nhomtheoloai.forEach((loaisach, soluong)->{
		System.out.println("=> Loai Sach: " + loaisach + "  So Luong: " + soluong);
	});
	
	System.out.println("Gom nhom tuy chinh theo don gia");
	Map<String,List<Sach>> nhomtheodongia = thuvien.groupByUnitPriceAndSorting();
	nhomtheodongia.forEach((dongia, danhsach)->{
		System.out.println("=> Don Gia: " + dongia);
		danhsach.forEach(System.out::println);
		System.out.println("-".repeat(150));
	});
	
	System.out.println("Lấy các danh sách có tháng 12");
	thuvien.getBooksInMonth(12).forEach(System.out::println);
	
	System.out.println("Lấy các danh sách nhập cách đây hơn 1 tháng");
	thuvien.getImportedBooksForOverOneMonth().forEach(System.out::println);
	
	System.out.println("Sắp xếp danh sách nhà sản xuất tăng dần đơn giá giảm dần");
	thuvien.sortPublisherAscThenUnitPriceDesc().forEach(System.out::println);
	
	System.out.println("Sắp xếp theo loại sách giảm dần đơn giá tăng dần");
	thuvien.sortTypeAscThenUnitPriceDesc().forEach(System.out::println);
	
	System.out.println("Số lượng sách năm 2006");
	int soluong = thuvien.getQuantityTotal(2006);
	System.out.printf("Tổng só lượng sách năm 2006 là: %d",soluong);
	
	System.out.println("\n\nTính trung bình đơn giá năm 2007");
	double tb = thuvien.getUnitPriceAverage(2007);
	System.out.printf("Trung bình đơn giá là: %.2f", tb);
	
	
}
 private static List<Sach> taodulieumau(){
	 List<Sach> ds = new ArrayList<>();
	 ds.add(new SachGiaoKhoa("SGK01", LocalDate.of(2006, 05, 02), 50, 20, "Bùi Quang Huy", "Toán Cao Cấp", TinhTrang.NEW));
	 ds.add(new SachGiaoKhoa("SGK02", LocalDate.of(2009, 8, 05), 60, 10, "Lý Tiểu Long", "Thể Dục", TinhTrang.OLD));
	 ds.add(new SachGiaoKhoa("SGK03", LocalDate.of(2007, 11, 12), 70, 7, "Bùi Quang Huy", "Cấu Trúc Rời Rạc", TinhTrang.NEW));
	 ds.add(new SachGiaoKhoa("SGK04", LocalDate.of(2007, 12, 15), 80, 40, "Bùi Thanh Tú", "Xác Suất Thống Kê", TinhTrang.OLD));
	 ds.add(new SachGiaoKhoa("SGK05", LocalDate.of(2006, 03, 8), 100, 30, "Trần Mỹ Mộng", "Kỹ Năng Hoạt Náo", TinhTrang.NEW));
	 ds.add(new SachThamKhao("STK01", LocalDate.of(2010, 12, 18), 150, 50, "Trần Mỹ Mộng", "Lập Trình C cơ Bản", 2));
	 ds.add(new SachThamKhao("STK02", LocalDate.of(2012, 9, 28), 250, 70, "Bùi Quang Tuấn", "Cơ Khí", 2));
	 ds.add(new SachThamKhao("STK03", LocalDate.of(2022, 7, 30), 90, 80, "Trần Văn Vinh", "Cấu Trúc Dữ Liệu", 2));
	 ds.add(new SachThamKhao("STK04", LocalDate.of(2016, 3, 15), 60, 90, "Phạm Hồng Tín", "Logic Học", 2));
	 ds.add(new SachThamKhao("STK05", LocalDate.of(2005, 12, 4), 50, 30, "Huỳnh Thị Ngọc Liểu", "Lập trình Hướng Đối Tượng", 2));
	 
	 return ds;
	 
 }
}
