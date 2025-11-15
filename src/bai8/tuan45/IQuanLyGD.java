package bai8.tuan45;

import java.util.List;
import java.util.Map;


public interface IQuanLyGD {
 GiaoDich them(GiaoDich gd) ;
 GiaoDich xoa(String magd) ;
 GiaoDich capnhat(String magd, String diachi) ;
 List<GiaoDich> loaidattangdientichgiam();
 List<GiaoDich> loainhatangdientichgiam();
 List<GiaoDich> loaigdtangdongiagiam();
 List<GiaoDich> xuatdsGDDat();
 List<GiaoDich> xuatdsGDNha();
 
 Map<String, List<GiaoDich>> dongiagiam();
 Map<String, List<GiaoDich>> matangdongiagiam();
}
