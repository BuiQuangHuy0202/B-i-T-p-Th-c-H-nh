package tuan8.bai6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QuanLyPhongHoc implements QuanLyImpl{
	
	private List<PhongHoc> danhSach;
	
	public QuanLyPhongHoc() {
		this.danhSach = new ArrayList<PhongHoc>();
	}
	
	public int getSoLuong() {
		return danhSach.size();
	}
	
	public List<PhongHoc> getlist(){
		return danhSach;
	}

	@Override
	public PhongHoc them(PhongHoc phong) {
		for (PhongHoc phongHoc : danhSach) {
			if(phongHoc.getMaPhong().equals(phong.getMaPhong())) {
				return null;
			}
		}
		danhSach.add(phong);
		return phong;
	}

	@Override
	public PhongHoc xoa(String maPhong) {
		for (PhongHoc phongHoc : danhSach) {
			if(phongHoc.getMaPhong().equals(maPhong)) {
				danhSach.remove(phongHoc);
				return phongHoc;
			}
		}
		return null;
	}

	@Override
	public PhongHoc capNhat(String maPhong, int soMayTinh) {
		for (int i = 0; i < danhSach.size(); i++) {
			if(danhSach.get(i).getMaPhong().equalsIgnoreCase(maPhong)
					&& danhSach.get(i) instanceof PhongMayTinh phong) {
				phong.setSoMayTinh(soMayTinh);
				return phong;
			}
		}
		return null;
	}

	@Override
	public PhongHoc timKiemPhongHoc(String maPhong) {
		for (PhongHoc phongHoc : danhSach) {
			if(phongHoc.getMaPhong().equals(maPhong)) {
				return phongHoc; 
			}
		}
		return null;
	}

	@Override
	public List<PhongHoc> sapXepTangDanTheoDayNha() {
		return danhSach.stream().sorted(Comparator.comparing(PhongHoc::getDayNha))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<PhongHoc> sapXepGiamDanTheoDienTich() {
		return danhSach.stream()
				.sorted(Comparator.comparing(PhongHoc::getDienTich).reversed())
				.toList();
	}

	@Override
	public List<PhongHoc> sapXepTangDanTheoSoBongDenGiamDanTheoDayNha() {
		return danhSach.stream().sorted(Comparator.comparing(PhongHoc::getSoBongDen)
				.thenComparing(PhongHoc::getDayNha).reversed())
				.collect(Collectors.toCollection(ArrayList::new))
				;
	}

	@Override
	public int soLuongPhongHoc() {
		return danhSach.size();
	}

	@Override
	public int tinhTongSoBongDen() {
		return danhSach.stream().mapToInt(PhongHoc::getSoBongDen).sum();
	}

	@Override
	public double tinhTrungBinhDienTich() {
		return danhSach.stream().mapToDouble(PhongHoc::getDienTich)
				.average().getAsDouble();
	}

	@Override
	public List<PhongHoc> layDanhSachPhongHocDatChuan() {
		return danhSach.stream().filter(phong->phong.datChuan())
				.toList();
	}

	@Override
	public List<PhongHoc> layDanhSachPhongMayTinh(int soMay) {
		return danhSach.stream().filter(phong->phong instanceof PhongMayTinh)
				.map(phong->(PhongMayTinh)phong)
				.filter(phong->phong.getSoMayTinh() == soMay)
				.collect(Collectors.toCollection(ArrayList::new));
				
				
	}

	@Override
	public List<PhongHoc> layDanhSachPhongHocCoDienTichLonNhat(int n) {
		return danhSach.stream()
				.sorted(Comparator.comparing(PhongHoc::getDienTich).reversed())
				.limit(n)
				.toList();
	}

	@Override
	public Map<String, List<PhongHoc>> gomNhom1() {
		return danhSach.stream()
				.collect(Collectors.groupingBy(phong -> phong.getClass().getSimpleName()));
	}

	@Override
	public Map<DayNha, Integer> gomNhom2() {
		return danhSach.stream()
				.collect(Collectors.groupingBy(phong -> phong.getDayNha()
						, Collectors.collectingAndThen(Collectors.counting(), 
								number -> number.intValue())
						));
	}

	@Override
	public Map<String, List<PhongHoc>> gomNhom3() {
		return danhSach.stream()
				.collect(Collectors.groupingBy(phong->{
					PhongHoc h = (PhongHoc) phong;
					if(h.getDienTich() <= 30) return "Phòng Nhỏ";
					else if(h.getDienTich() <= 70) return "Phòng Vừa";
					else return "Phòng lớn";
				}));
	}

	@Override
	public Map<String, Set<DayNha>> gomNhom4() {
		return danhSach.stream()
				.collect(Collectors.groupingBy(phong->phong.getClass().getSimpleName(),
						Collectors.mapping(PhongHoc::getDayNha, Collectors.toSet())
						))
				;
	}

	@Override
	public Map<String, PhongHoc> gomNhom5() {
		return danhSach.stream()
				.collect(Collectors.toMap(PhongHoc::getMaPhong, phong -> phong))
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(PhongHoc::getDienTich).reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
						,(e1, e2) -> e1,
						LinkedHashMap::new));
	}

	@Override
	public Map<DayNha, List<PhongHoc>> gomNhom6() {
		return danhSach.stream()
				.collect(Collectors.groupingBy(PhongHoc::getDayNha))
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, 
						entry -> entry.getValue().stream()
						.sorted(Comparator.comparing(PhongHoc::getDienTich))
						.toList()
						,(e1, e2) -> e1
						,LinkedHashMap::new
						));
	}

}
