package bai6.tuan4;

import java.util.List;
import java.util.Map;

public interface IThuVien {

	// Trả về số lượng sách có trong danh sách
		int getSize();
		
		// Trả về danh sách mới (bản sao)
		List<Sach> getBooks();
		
		// Thêm sách
		void add1(Sach sach);
		boolean add2(Sach sach);
		Sach add3(Sach sach);
		
		// Xoá sách dựa vào mã
		void remove1(String code);
		boolean remove2(String code);
		Sach remove3(String code);
		
		// Cập nhật thuế mới cho sách tham khảo
		void update1(String code, double newVAT);
		boolean update2(String code, double newVAT);
		Sach update3(String code, double newVAT);
		
		// Tìm và trả về đối tượng sách khi biết mã sách
		Sach getBook(String code);
		
		// Tìm và trả về danh sách của các đối tượng sách nhập vào trong tháng month
		List<Sach> getBooksInMonth(int month);
		
		// Tìm và trả về danh sách khi sách đã nhập kho được hơn 1 tháng
		List<Sach> getImportedBooksForOverOneMonth();
		
		// Tìm và trả về danh sách khi sách có tình trạng là sách cũ
		List<Sach> getOldBooks();
		
		// Sắp xếp và trả về danh sách theo đơn giá giảm dần
		List<Sach> sortUnitPriceDesc();
		
		// Sắp xếp và trả về danh sách theo nhà xuất bản tăng dần, đơn giá giảm dần
		List<Sach> sortPublisherAscThenUnitPriceDesc();
		
		// Sắp xếp và trả về danh sách theo kiểu tăng dần (tên lớp kiểu String), đơn giá giảm dần
		List<Sach> sortTypeAscThenUnitPriceDesc();
		
		//Thống kê theo điều kiện
		int getQuantityTotal(int year);
		double getUnitPriceAverage(int year);
		
		//Gom nhóm theo kiểu và đếm số lượng trong từng nhóm
		Map<String, Integer> groupByTypeAndCounting();
		
		//Gom nhóm tuỳ chỉnh: Đơn giá trên 50_000 thuộc nhóm "Cao", còn lại thuộc nhóm "Thấp"
		//Và sắp xếp giảm dần theo tên các đối tượng trong nhóm
		Map<String, List<Sach>> groupByUnitPriceAndSorting();
}
