package Bai10.tuan45;

public abstract class Person {
  private String hoten;
  private String diachi;
  public Person(String hoten, String diachi) {
	super();
	setHoten(hoten);
	setDiachi(diachi);
	
  }
  
  public String getHoten() {
	return hoten;
  }
  public void setHoten(String hoten) {
	  if(hoten == null || hoten.isEmpty()) {
		  throw new IllegalArgumentException("Ho ten khong duoc de trong");
	  }
	this.hoten = hoten;
  }
  public String getDiachi() {
	return diachi;
  }
  public void setDiachi(String diachi) {
	  if(diachi == null || diachi.isEmpty()) {
		  throw new IllegalArgumentException("Dia chi khong douc de trong");
	  }
	this.diachi = diachi;
  }
  
  @Override
	public String toString() {
		return String.format("%20s | %26s", hoten, diachi);
	}
  
}
