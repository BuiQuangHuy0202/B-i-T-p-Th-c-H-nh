package bai2.chuong4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;


public class Test {
	public static void main(String[] args) {
	
		
		Order or = new Order(1, LocalDate.of(2025, 9, 10));
		Order orl = new Order();
		
		Products p1 =  new Products("sp1", "Nước tương", 8000);
		Products p2 = new Products("sp2", "Gạo", 18000);
		Products p3 = new Products("sp3", "Đường", 10000);
		Products p4 = new Products("sp5", "Gạo", 18000);
	     
		System.out.println(or);
		String headerline = String.format("%4s | %12s | %11s | %4s | %s", 
				"MaHD", "TenSP", "Don Gia", "So Luong", "Thanh Tien");
		System.out.println(headerline +"\n" +"-".repeat(90));

     
		orl.addLineItems(p1, 10);
		orl.addLineItems(p2, 5);
		orl.addLineItems(p3, 1);
		orl.addLineItems(p4, 1);
		
		for (OrderDetail orderDetail : orl.getList()) {
		 System.out.println(orderDetail);	
		}
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(
		     Locale.forLanguageTag("vi-VN"));
		double t = orl.calcTotalCharge();
		System.out.printf("\n"+"Tong Thanh Tien: %s", nf.format(t));
		
		
	}
	
}
