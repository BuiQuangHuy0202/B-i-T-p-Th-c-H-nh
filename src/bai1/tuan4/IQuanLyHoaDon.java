package bai1.tuan4;

import java.util.List;
import java.util.Map;

public interface IQuanLyHoaDon {
  
	HoaDon them(HoaDon hd);
	HoaDon xoa(String mahd);
	HoaDon capnhat(String mahd, String tenkh);
	
	List<HoaDon> thanhtienlonnhat(int n);
	List<HoaDon> sapxeptangtheodongia();
	List<HoaDon> sapxepmaphongtangdongiagiam();
	
	Map<String, HoaDon> gomnhom1();//gom nhom theo mahd don gia giam dan
	Map<String, List<HoaDon>> gomnhom2();//gom nhom theo loai don gia giam dan bang danh sach
	Map<String, Integer> gomnhom3();//key: loai hoa don, tra ve so luong tung loai
	double trungbinhthanhtien(int month, int year);
	
}
