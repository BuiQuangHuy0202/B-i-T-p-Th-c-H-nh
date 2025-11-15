package bai2.chuong4;

import java.text.NumberFormat;
import java.util.Locale;

public class OrderDetail extends Products {
  private int soluong;

  public OrderDetail(String productID, String description, double price) {
		super(productID, description, price);
	}
  
  

  public OrderDetail(String productID, String description, double price, int soluong) {
	super(productID, description, price);
	setSoluong(soluong);
}



  public int getSoluong() {
	return soluong;
  }

  public void setSoluong(int soluong) {
	  if(soluong <= 0) {
		  throw new IllegalArgumentException("So lhuong phai lon hon 0");
	  }
	this.soluong = soluong;
  }

  @Override
  public String toString() {
	  NumberFormat nf = NumberFormat.getCurrencyInstance(
			  Locale.forLanguageTag("vi-VN"));
	return String.format("%s | %8d | %s", super.toString()
			      , soluong
			      , nf.format(calcToTalPrice())
			      );
  }
  
  public double calcToTalPrice() {
	  return soluong * getPrice();
  }
  
  
  
  
  
  
  
  
}
