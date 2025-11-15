package bai2.chuong4;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Order {

  private  int orderID;
  private LocalDate orderDate;
  private List<OrderDetail> lineItems;
 
  


  public Order(int orderID, LocalDate orderDate) {
	setOrderID(orderID);
	setOrderDate(orderDate);
	this.lineItems = new ArrayList<OrderDetail>();
}
  
  

  public Order() {
	this.lineItems  = new ArrayList<OrderDetail>();
}



  public int getsoluong() {
	  return lineItems.size();
  }
  
  public List<OrderDetail> getList(){
	  return lineItems;
  }
  
  public int getOrderID() {
	return orderID;
  }

  public void setOrderID(int orderID) {
	  if(orderID <= 0) {
		  throw new IllegalArgumentException("orderID phai lon hon 0");
	  }
	this.orderID = orderID;
  }

  public LocalDate getOrderDate() {
	return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
	  if(orderDate.isAfter(LocalDate.now())) {
		  orderDate = LocalDate.now();
	  }
	this.orderDate = orderDate;
  }
  
  public void addLineItems(Products p, int q) {
	    
	    if (lineItems == null) {
	        lineItems = new ArrayList<>();
	    }

	   
	    for (OrderDetail od : lineItems) {
	        if (od.getProductID().equalsIgnoreCase(p.getProductID())) {
	            od.setSoluong(od.getSoluong() + q);
	            return;
	        }
	    }

	    
	    OrderDetail newItem = new OrderDetail(p.getProductID(), p.getDescription(), p.getPrice(), q);
	    lineItems.add(newItem);
	}



  public double calcTotalCharge() {
	    double sum = 0;

	    for (int i = 0; i < lineItems.size(); i++) {
	        sum += lineItems.get(i).calcToTalPrice();
	    }

	    return sum;
	}
  
  @Override
	public String toString() {
	  DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("Mã HD: %s\nNgày lập hóa đơn: %s\n", 
				  orderID,
				  df.format(orderDate)
				 );
	}
 
  
  
  
  
  
}
