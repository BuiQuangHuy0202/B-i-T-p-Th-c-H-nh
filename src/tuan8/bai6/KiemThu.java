package tuan8.bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class KiemThu {
	
	public static void main(String[] args) {
		List<PhongHoc> ds = taoDuLieuMau();
		String headerLine = String.format("%6s | %10s | %10s | %10s | %12s | %s",
				"Mã", "Dãy nhà", "Diện tích", "Bóng đèn", "Đánh giá", "Bổ sung");
		
		System.out.println(headerLine + "\n" + "-".repeat(100));
		QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
		for (PhongHoc phongHoc : ds) {
			try {
				System.out.println(quanLyPhongHoc.them(phongHoc));
			} catch (Exception e) {
				System.out.println("Thêm không thành công");
			}
		}
		System.out.println(headerLine + "\n" + "-".repeat(100));
		System.out.println(quanLyPhongHoc);	
		
		System.out.println("Xoa phong LT101");
		quanLyPhongHoc.xoa("LT101");
		for (PhongHoc phongHoc : quanLyPhongHoc.getlist()) {
			System.out.println(phongHoc);
		}
		
		System.out.println("\nCap nhat");
		quanLyPhongHoc.capNhat("MT201", 55);
		for (PhongHoc phongHoc : quanLyPhongHoc.getlist()) {
			System.out.println(phongHoc);
		}
		
		System.out.println("\nTim Kiem Phong Hoc TN302");
		System.out.println(quanLyPhongHoc.timKiemPhongHoc("TN302"));
		
		System.out.println("\nSap Xep Tang Dan Theo Day Nha");
		quanLyPhongHoc.sapXepTangDanTheoDayNha().forEach(System.out::println);
		
		System.out.println("\nSap Xep Giam Dan Theo Dien Tich");
		quanLyPhongHoc.sapXepGiamDanTheoDienTich().forEach(System.out::println);
		
		System.out.println("Sap Xep Tang Dan Theo So Bong Den Giam Dan Theo Day Nha");
		quanLyPhongHoc.sapXepTangDanTheoSoBongDenGiamDanTheoDayNha()
		.forEach(System.out::println);
		
		System.out.println("\nLay Danh Sach Phong Dat Chuan");
		quanLyPhongHoc.layDanhSachPhongHocDatChuan().forEach(System.out::println);
		
		System.out.println("Lay Danh Sach Phong May Tinh");
		quanLyPhongHoc.layDanhSachPhongMayTinh(55).forEach(System.out::println);
		
		System.out.println("Lay Danh Sach Phong Co Dien Tich Lon Nhat");
		quanLyPhongHoc.layDanhSachPhongHocCoDienTichLonNhat(5).forEach(System.out::println);
		
		System.out.println("Gom Nhom 1");
		Map<String, List<PhongHoc>> nhomtheoloai = quanLyPhongHoc.gomNhom1();
		nhomtheoloai.forEach((loaiphong, dsachphong)->{
			System.out.println("=> Loai Phong: " + loaiphong);
			dsachphong.forEach(System.out::println);
			System.out.println("-".repeat(100));
		});
		
		System.out.println("Gom Nhom Theo Day Nha");
		Map<DayNha, Integer> nhomtheodaynha = quanLyPhongHoc.gomNhom2();
		nhomtheodaynha.forEach((daynha,sophong)->{
			System.out.println("=> Day Nha: " + 
		      daynha + " Co " + "So Phong: " + sophong);
			
		});
		
		System.out.println("Gom Nhom Theo Dien Tich");
		Map<String, List<PhongHoc>> nhomtheodientich = quanLyPhongHoc.gomNhom3();
		nhomtheodientich.forEach((loaiphong, dsachphong)->{
			System.out.println("=> Loai Phong: " + loaiphong);
			dsachphong.forEach(System.out::println);
			System.out.println("-".repeat(90));
		});
		
		System.out.println("Gom Nhom Theo Day Nha Khong Trung");
		Map<String, Set<DayNha>> nhomtheodaynhakhongtrung
		= quanLyPhongHoc.gomNhom4();
		nhomtheodaynhakhongtrung.forEach((loainha,daynha)->{
			System.out.println("=>Loai Nha: " + loainha + " Day nha:" + daynha);
		});
		
		System.out.println("\nGom Nhom Theo Dien Tich Giam Dan");
		 Map<String, PhongHoc> nhomtheodientichgiamdan
		   = quanLyPhongHoc.gomNhom5();
		 nhomtheodientichgiamdan.forEach((maphong, phong)->{
			 System.out.println("Ma Phong: " + maphong + " Dien Tich: " + phong.getDienTich());
		 });
		 
		 System.out.println("Gom Nhom Phong Co Dien Tich Giam Dan Theo Danh Sach");
		 Map<DayNha, List<PhongHoc>> nhomtheodientichgiamdantheods
		 = quanLyPhongHoc.gomNhom6();
		 nhomtheodientichgiamdantheods.forEach((daynha, dsach)->{
			 System.out.println("=>Day Nha: "+ daynha);
			 dsach.forEach(System.out::println);
			 System.out.println("-".repeat(90));
		 });
	}

	private static List<PhongHoc> taoDuLieuMau(){
		List<PhongHoc> danhSach = new ArrayList<>();
		danhSach.add(new PhongLyThuyet("LT101", DayNha.A, 75.0, 8, true));
		danhSach.add(new PhongLyThuyet("LT102", DayNha.B, 60.0, 6, false));
		danhSach.add(new PhongLyThuyet("LT103", DayNha.C, 90.5, 10, true));
		danhSach.add(new PhongLyThuyet("LT104", DayNha.D, 55.5, 5, false));
		danhSach.add(new PhongLyThuyet("LT105", DayNha.V, 100.0, 12, true));
		danhSach.add(new PhongLyThuyet("LT106", DayNha.X, 65.0, 7, true));
		danhSach.add(new PhongLyThuyet("LT107", DayNha.A, 80.0, 9, false));
		danhSach.add(new PhongMayTinh("MT201", DayNha.A, 65.0, 6, 45));
		danhSach.add(new PhongMayTinh("MT202", DayNha.B, 80.0, 8, 50));
		danhSach.add(new PhongMayTinh("MT203", DayNha.C, 100.0, 10, 60));
		danhSach.add(new PhongMayTinh("MT204", DayNha.D, 70.0, 7, 48));
		danhSach.add(new PhongMayTinh("MT205", DayNha.V, 90.0, 9, 55));
		danhSach.add(new PhongMayTinh("MT206", DayNha.X, 85.0, 8, 58));
		danhSach.add(new PhongMayTinh("MT207", DayNha.B, 95.0, 11, 62));
		danhSach.add(new PhongThiNghiem("TN301", DayNha.A, 70.0, 6, "Hóa học", 35, true));
		danhSach.add(new PhongThiNghiem("TN302", DayNha.B, 90.0, 9, "Sinh học", 40, true));
		danhSach.add(new PhongThiNghiem("TN303", DayNha.C, 85.0, 8, "Vật lý", 38, false));
		danhSach.add(new PhongThiNghiem("TN304", DayNha.D, 110.0, 12, "Công nghệ thực phẩm", 50, true));
		danhSach.add(new PhongThiNghiem("TN305", DayNha.V, 60.0, 5, "Hóa phân tích", 30, false));
		danhSach.add(new PhongThiNghiem("TN306", DayNha.X, 100.0, 10, "Môi trường", 45, true));
		danhSach.add(new PhongThiNghiem("TN307", DayNha.A, 75.0, 7, "Kỹ thuật điện", 42, false));
		return danhSach;
	}
}
