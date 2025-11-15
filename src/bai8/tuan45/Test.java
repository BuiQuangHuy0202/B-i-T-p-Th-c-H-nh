package bai8.tuan45;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
 public static void main(String[] args) {
	List<GiaoDich> ds = taodulieumau();
	QuanLyGD qly =new QuanLyGD();
	
	String headerline = String.format("%5s | %15s | %13s | %s",
			"MaGD","NgayGD", "Don Gia", "Thong Tin Bo Sung" );
	System.out.println(headerline+ "\n" + "-".repeat(147));
	for (GiaoDich giaoDich : ds) {
		System.out.println(qly.them(giaoDich));
	}
	
	System.out.println("Xóa ma DAT01");
	qly.xoa("DAT01");
	System.out.println(headerline+ "\n" + "-".repeat(147));
	for (GiaoDich giaoDich : qly.getList()) {
		System.out.println(giaoDich);
	}
	 System.out.println("Cap nhat Dia Chi NHA01");
	 qly.capnhat("NHA01", "16/15 Le Duc Tho");
	 for (GiaoDich giaoDich : qly.getList()) {
		System.out.println(giaoDich);
	}
	 
	 Map<String, List<GiaoDich>> gomnhom1 = qly.dongiagiam();
	 gomnhom1.forEach((ma, danhsach)->{
		 System.out.println("=> MaGD" + ma);
		 danhsach.forEach(System.out::println);
		 System.out.println("-".repeat(147));
	 });
	
	 System.out.println("Xuat danh sach GD dat");
	 System.out.println(headerline+ "\n" + "-".repeat(147));
	 qly.xuatdsGDDat().forEach(System.out::println);
	 
	 System.out.println("Xuat danh sach GD nha");
	 System.out.println(headerline+ "\n" + "-".repeat(147));
	 qly.xuatdsGDNha().forEach(System.out::println);
	 
	 System.out.println("Loai nha tang dien tich giam");
	 System.out.println(headerline+ "\n" + "-".repeat(147));
	 qly.loainhatangdientichgiam().forEach(System.out::println);
	 
	 System.out.println("Loai dat tang dien tich giam");
	 System.out.println(headerline+ "\n" + "-".repeat(147));
	 qly.loaidattangdientichgiam().forEach(System.out::println);
	 
	 System.out.println("Loai giao dich tang don gia giam");
	 System.out.println(headerline+ "\n" + "-".repeat(147));
	 qly.loaigdtangdongiagiam().forEach(System.out::println);
}
 
 private static List<GiaoDich> taodulieumau(){
	 List<GiaoDich> ds = new ArrayList<GiaoDich>();
	 ds.add(new GiaoDichDat("DAT01", LocalDate.of(2024, 10, 29), 13000.00, LoaiDat.A, 2000));
	 ds.add(new GiaoDichDat("DAT02", LocalDate.of(2025, 11, 4), 14000.00, LoaiDat.B, 2100));
	 ds.add(new GiaoDichDat("DAT03", LocalDate.of(2024, 12, 30), 23000.00, LoaiDat.C, 2200));
	 ds.add(new GiaoDichDat("DAT04", LocalDate.of(2020, 9, 25), 33000.00, LoaiDat.B, 3000));
	 ds.add(new GiaoDichDat("DAT05", LocalDate.of(2023, 7, 12), 93000.00, LoaiDat.A, 100000));
	 ds.add(new GiaoDichNha("NHA01", LocalDate.of(2024, 12, 29), 1300000.00, LoaiNha.caocap, 20000, "416/11 Duong Quang Ham"));
	 ds.add(new GiaoDichNha("NHA02", LocalDate.of(2024, 1, 9),233000.00, LoaiNha.thuong, 2000, "14/14 Nguyen Oanh"));
	 ds.add(new GiaoDichNha("NHA03", LocalDate.of(2024, 8, 5), 2203000.00, LoaiNha.caocap, 50000, "299/11/5 Duong Quang Ham"));
	 ds.add(new GiaoDichNha("NHA04", LocalDate.of(2024, 10, 20), 5303000.00, LoaiNha.caocap, 35000, "566/187/52 Nguyen Thai Son"));
	 
	 return ds;
 }
}
