package bai1.tuan4;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuanLyHoaDon implements IQuanLyHoaDon {
  
	private List<HoaDon> danhsach;

	public QuanLyHoaDon() {
		super();
		this.danhsach = new ArrayList<HoaDon>();
	}
	
	public int getSoLuong() {
		return danhsach.size();
	}
	
	public List<HoaDon> getList() {
		return danhsach;
	}

	@Override
	public HoaDon them(HoaDon hd) {
		for (HoaDon hoaDon : danhsach) {
			if(hoaDon.getMahd().equalsIgnoreCase(hd.getMahd())) {
				return null;
			}
		}
		danhsach.add(hd);
		return hd;
	}

	@Override
	public HoaDon xoa(String mahd) {
		for (HoaDon hoaDon : danhsach) {
			if(hoaDon.getMahd().equalsIgnoreCase(mahd)) {
				danhsach.remove(hoaDon);
				return hoaDon;
			}
		}
		return null;
	}

	@Override
	public HoaDon capnhat(String mahd, String tenkh) {
		for (int i = 0; i < danhsach.size(); i++) {
			if(danhsach.get(i).getMahd().equalsIgnoreCase(mahd)) {
				danhsach.get(i).setTenkh(tenkh);
				return danhsach.get(i);
			}
		}
		return null;
	}

	@Override
	public List<HoaDon> thanhtienlonnhat(int n) {
		return danhsach.stream()
				.sorted(Comparator.comparing(HoaDon::thanhtien).reversed())
				.limit(n)
				.toList();
	}

	@Override
	public List<HoaDon> sapxeptangtheodongia() {
		return danhsach.stream()
			.sorted(Comparator.comparing(HoaDon::getDongia))
			.toList();
	}

	@Override
	public List<HoaDon> sapxepmaphongtangdongiagiam() {
		return danhsach.stream()
			.sorted(Comparator.comparing(HoaDon::getMaphong)
		          .thenComparing(Comparator.comparing(HoaDon::getDongia).reversed()))
			.toList();
	}

	@Override
	public Map<String, HoaDon> gomnhom1() {
		return danhsach.stream()
		  .collect(Collectors.toMap(hoadon -> hoadon.getMahd(),
				  hoadon -> hoadon))
		  .entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue(Comparator.comparing(HoaDon::getDongia).reversed()))
		  .collect(Collectors.toMap(Map.Entry::getKey,
				  Map.Entry::getValue,
				  (e1, e2) -> e1, 
				  LinkedHashMap::new
				  ));
	}

	@Override
	public Map<String, List<HoaDon>> gomnhom2() {
		return danhsach.stream()
			.collect(Collectors.groupingBy(phong -> phong.getClass().getSimpleName()))
			.entrySet()
			.stream()
			.collect(Collectors.toMap(Map.Entry::getKey,
			entry -> entry.getValue()
			.stream()
			.sorted(Comparator.comparing(HoaDon::getDongia).reversed())
			.toList()
			, (e1, e2) -> e1
			,LinkedHashMap::new
			));
	}

	@Override
	public Map<String, Integer> gomnhom3(){
		return danhsach.stream()
			.collect(Collectors.groupingBy(hoadon -> hoadon.getClass().getSimpleName()
					, Collectors.collectingAndThen(Collectors.counting(),
							number -> number.intValue()
							)));
	}
	@Override
	public double trungbinhthanhtien(int month, int year) {
		return danhsach.stream()
			.filter(hoadon -> hoadon.getNgayhd().getMonthValue() == month
			  && hoadon.getNgayhd().getYear() == year)
			.mapToDouble(HoaDon::thanhtien)
			.average()
			.orElse(0.0)
			;
	}
	
	
	
	
}
