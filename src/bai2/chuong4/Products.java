package bai2.chuong4;

import java.text.NumberFormat;
import java.util.Locale;

public class Products {
 private final String productID;
 private String description;
 private double price;
 
 public Products(String productID, String description, double price) {
	super();
	if(productID == null || productID.isEmpty()) {
		throw new RuntimeException("Ma khong hop le");
	}
	this.productID = productID;
	setDescription(description);
	setPrice(price);
 }
 public String getDescription() {
	return description;
 }
 public void setDescription(String description) {
	if(description == null || description.isEmpty()) {
		throw new IllegalArgumentException("Mo ta khong duoc de trong");
	}
	 this.description = description;
 }
 public double getPrice() {
	return price;
 }
 public void setPrice(double price) {
	 if(price <= 0) {
		 price = 0.0;
	 }
	this.price = price;
 }
 public String getProductID() {
	return productID;
 }
 
 NumberFormat nf = NumberFormat.getCurrencyInstance(
		 Locale.forLanguageTag("vi-VN"));
 
 @Override
	public String toString() {
		return String.format("%4s | %12s | %10s ",
				    productID,
				    description,
				    nf.format(price)
				    );
	}
 
}
