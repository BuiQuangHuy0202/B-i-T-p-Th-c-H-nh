package bai6.tuan4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThuVien implements IThuVien {
 
	private List<Sach> danhsach;

	public ThuVien() {
		this.danhsach = new ArrayList<Sach>();
	}

	@Override
	public int getSize() {
		return danhsach.size();
	}

	@Override
	public List<Sach> getBooks() {
		return danhsach;
	}

	@Override
	public void add1(Sach sach) {
		for (Sach sach1 : danhsach) {
			if(sach1.getMasach().equalsIgnoreCase(sach.getMasach())) {
				throw new RuntimeException("Loi");
			}
		}
		danhsach.add(sach);
		
	}

	@Override
	public boolean add2(Sach sach) {
		for (Sach sach2 : danhsach) {
			if(sach2.getMasach().equalsIgnoreCase(sach.getMasach())) {
				return false;
			}
		}
		danhsach.add(sach);
		return true;
	}

	@Override
	public Sach add3(Sach sach) {
		for (Sach sach3 : danhsach) {
			if(sach3.getMasach().equalsIgnoreCase(sach.getMasach())) {
				return null;
			}
		}
		danhsach.add(sach);
		return sach;
	}

	@Override
	public void remove1(String code) {
		for (Sach sach : danhsach) {
			if(sach.getMasach().equalsIgnoreCase(code)) {
				danhsach.remove(sach);
			}
		}
		
	}

	@Override
	public boolean remove2(String code) {
		for (Sach sach : danhsach) {
			if(sach.getMasach().equalsIgnoreCase(code)) {
				danhsach.remove(sach);
				return true;
			}
		}
		return false;
	}

	@Override
	public Sach remove3(String code) {
		for (Sach sach : danhsach) {
			if(sach.getMasach().equalsIgnoreCase(code)) {
				danhsach.remove(sach);
				return sach;
			}
		}
		return null;
	}

	@Override
	public void update1(String code, double newVAT) {
		for (int i = 0; i < danhsach.size(); i++) {
			if(danhsach.get(i).getMasach().equalsIgnoreCase(code)
				&& danhsach.get(i) instanceof SachThamKhao	stk) {
				
				stk.setThue(newVAT);
				
			}
		}
		
	}

	@Override
	public boolean update2(String code, double newVAT) {
		for (int i = 0; i < danhsach.size(); i++) {
			if(danhsach.get(i).getMasach().equalsIgnoreCase(code)
				&& danhsach.get(i) instanceof SachThamKhao	stk) {
				
				stk.setThue(newVAT);
				return true;
				
			}
		}
		return false;
	}

	@Override
	public Sach update3(String code, double newVAT) {
		for (int i = 0; i < danhsach.size(); i++) {
			if(danhsach.get(i).getMasach().equalsIgnoreCase(code)
				&& danhsach.get(i) instanceof SachThamKhao	stk) {
				
				stk.setThue(newVAT);
				return stk;
				
			}
		}
		return null;
	}

	@Override
	public Sach getBook(String code) {
		for (int i = 0; i < danhsach.size(); i++) {
			if(danhsach.get(i).getMasach().equalsIgnoreCase(code)) {
				return danhsach.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Sach> getBooksInMonth(int month) {
		return danhsach.stream()
				.filter(sach -> sach.getNgaynhap().getMonthValue() == month)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<Sach> getImportedBooksForOverOneMonth() {

		return danhsach.stream()
				.filter(sach -> sach.getNgaynhap().isBefore(LocalDate.now().minusMonths(1)))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<Sach> getOldBooks() {
		return danhsach.stream()
			.filter(sach->sach instanceof SachGiaoKhoa)
			.map(sach->(SachGiaoKhoa) sach)
			.filter(sach->sach.getTinhtrang() == TinhTrang.OLD)
			.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public List<Sach> sortUnitPriceDesc() {
		return danhsach.stream().sorted(Comparator.comparing(Sach::getDongia))
				.toList();
	}

	@Override
	public List<Sach> sortPublisherAscThenUnitPriceDesc() {
		return danhsach.stream()
				.sorted(Comparator.comparing(Sach::getNhasanxuat)
						.thenComparing(Comparator.comparing(Sach::getNhasanxuat).reversed()))
				.toList()
				;
	}

	@Override
	public List<Sach> sortTypeAscThenUnitPriceDesc() {
		return danhsach.stream()
			.sorted(Comparator.comparing((Sach sach) -> sach.getClass().getSimpleName())
					.thenComparing(Comparator.comparing(Sach::getDongia).reversed()))
			.toList();
	}

	@Override
	public int getQuantityTotal(int year) {
		return danhsach.stream()
			.filter(sach -> sach.getNgaynhap().getYear() == year)
			.mapToInt(Sach::getSoluong)
			.sum()
			;
	}

	@Override
	public double getUnitPriceAverage(int year) {
		return danhsach.stream()
			.filter(sach -> sach.getNgaynhap().getYear() == year)
			.mapToDouble(Sach::getDongia)
			.average().orElse(0.0);
	}

	@Override
	public Map<String, Integer> groupByTypeAndCounting() {
		return danhsach.stream()
				.collect(Collectors.groupingBy(sach->sach.getClass().getSimpleName(),
						Collectors.collectingAndThen(Collectors.counting(), number->number.intValue())
						));
	}

	@Override
	public Map<String, List<Sach>> groupByUnitPriceAndSorting() {
		return danhsach.stream()
		.collect(Collectors.groupingBy(sach ->{
			
		Sach s = (Sach) sach;
		
		if(s.getDongia() > 50) return "Cao";
		else return "Thấp";
			
		}))
		.entrySet()
		.stream()
		.collect(Collectors.toMap(Map.Entry::getKey, 
           entry->entry.getValue().stream().sorted(Comparator.comparing(Sach::getTensach))
           .toList()
           ,(e1, e2)->e1
           ,LinkedHashMap::new));
	}
	
	
	
}
