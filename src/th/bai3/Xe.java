package th.bai3;

public class Xe {
  private String ten;
  private String loaixe;
  private int dungtich;
  private double trigia;
  
  public Xe() {
	this("","",0,0.0);
  }
  
  public Xe(String ten, String loaixe, int dungtich, double trigia) {
	super();
	this.ten = ten;
	this.loaixe = loaixe;
	this.dungtich = dungtich;
	this.trigia = trigia;
  }

  public String getTen() {
	return ten;
  }

  public void setTen(String ten) {
	this.ten = ten;
  }

  public String getLoaixe() {
	return loaixe;
  }

  public void setLoaixe(String loaixe) {
	this.loaixe = loaixe;
  }

  public int getDungtich() {
	return dungtich;
  }

  public void setDungtich(int dungtich) {
	this.dungtich = dungtich;
  }

  public double getTrigia() {
	return trigia;
  }

  public void setTrigia(double trigia) {
	this.trigia = trigia;
  }

  public double thue() {
	  if(dungtich < 100) {
		  return  trigia * 1/100;
	  }
	  if(dungtich >= 100 && dungtich <= 200) {
		  return trigia * 3/100;
	  }
		  return trigia *5/100;
	  
  }

  @Override
  public String toString() {
	return String.format("%-20s %-20s %-20s %-20s %-20s",
			              ten,
			              loaixe,
			              dungtich,
			              trigia,
			              thue()
			              );
  }
  
  
  
  
  
  
  


  
  
  
  
  
  
}
