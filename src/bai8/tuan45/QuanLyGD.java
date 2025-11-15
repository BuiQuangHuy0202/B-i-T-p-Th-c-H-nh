package bai8.tuan45;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuanLyGD implements IQuanLyGD{
	
 List<GiaoDich> danhsach;

 public QuanLyGD() {
	this.danhsach = new ArrayList<GiaoDich>();
 }
 
 public int getSoLuong() {
	 return danhsach.size();
 }
 
 public List<GiaoDich> getList(){
	 return danhsach;
			 
 }

 @Override
 public GiaoDich them(GiaoDich gd) {
	for (GiaoDich giaoDich : danhsach) {
		if(giaoDich.getMagd().equals(gd.getMagd())) {
			return null;
		}
	}
	danhsach.add(gd);
	return gd;
 }

 @Override
 public GiaoDich xoa(String magd) {
	for (GiaoDich giaoDich : danhsach) {
		if(giaoDich.getMagd().equalsIgnoreCase(magd)) {
			danhsach.remove(giaoDich);
			return giaoDich;
			
		}
	}
	return null;
 }

 @Override
 public GiaoDich capnhat(String magd, String diachi) {
	for (int i = 0; i < danhsach.size(); i++) {
		if(danhsach.get(i).getMagd().equalsIgnoreCase(magd)
				&& danhsach.get(i) instanceof GiaoDichNha gdnha) {
			gdnha.setDiachi(diachi);
			return gdnha;
		}
	}
	return null;
 }

 @Override
 public List<GiaoDich> loaidattangdientichgiam() {
	return danhsach.stream()
			.filter(gd -> gd instanceof GiaoDichDat)
			.map(gd -> (GiaoDichDat) gd)
		.sorted(Comparator.comparing(GiaoDichDat::getLoaidat)
				.thenComparing(Comparator.comparing(GiaoDichDat::getDientich).reversed()))
		.collect(Collectors.toCollection(ArrayList::new)); 
 }

 @Override
 public List<GiaoDich> loainhatangdientichgiam() {
	return danhsach.stream()
		.filter(gd -> gd instanceof GiaoDichNha)
		.map(gd -> (GiaoDichNha) gd)
		.sorted(Comparator.comparing(GiaoDichNha::getLoainha)
			.thenComparing(Comparator.comparing(GiaoDichNha::getDientich).reversed()))
		.collect(Collectors.toCollection(ArrayList::new));
 }

 @Override
 public List<GiaoDich> loaigdtangdongiagiam() {
	return danhsach.stream()
			.sorted(Comparator.comparing((GiaoDich gd)->gd.getClass().getSimpleName())
			.thenComparing(Comparator.comparing(GiaoDich::getDongia).reversed()))
			.toList();
 }

 @Override
 public List<GiaoDich> xuatdsGDDat() {
	return danhsach.stream()
			.filter(gd -> gd instanceof GiaoDichDat)
			.map(gd -> (GiaoDichDat) gd)
			.collect(Collectors.toCollection(ArrayList::new));
	    
 }

 @Override
 public List<GiaoDich> xuatdsGDNha() {
	return danhsach.stream()
		.filter(gd -> gd instanceof GiaoDichNha)
		.map(gd -> (GiaoDichNha) gd)
		.collect(Collectors.toCollection(ArrayList::new));
 }

 @Override
 public Map<String, List<GiaoDich>> dongiagiam() {
	return danhsach.stream()
			.collect(Collectors.groupingBy(gd -> gd.getMagd()))
			.entrySet()
			.stream()
			.collect(Collectors.toMap(Map.Entry::getKey,
					entry -> entry.getValue()
					.stream()
					.sorted(Comparator.comparing(GiaoDich::getDongia).reversed())
					.toList(),
					(e1, e2) -> e1, 
					LinkedHashMap::new
					));
 }

 @Override
 public Map<String, List<GiaoDich>> matangdongiagiam() {
	return danhsach.stream()
			.collect(Collectors.groupingBy(gd -> gd.getMagd()))
			.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(Map.Entry::getKey,
			entry -> entry.getValue()
			.stream().sorted(Comparator.comparing(GiaoDich::getDongia).reversed())
			.toList()
			,(e1, e2) -> e1
			, LinkedHashMap::new
			));
 }

 
 
 
 
}
