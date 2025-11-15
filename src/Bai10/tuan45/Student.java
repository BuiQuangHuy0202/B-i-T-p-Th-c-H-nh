package Bai10.tuan45;

public class Student extends Person{
 private double diemmon1;
 private double diemmon2;
 
 public Student(String hoten, String diachi, double diemmon1, double diemmon2) {
	super(hoten, diachi);
	setDiemmon1(diemmon1);
	setDiemmon2(diemmon2);
	
 }

 public double getDiemmon1() {
	return diemmon1;
 }

 public void setDiemmon1(double diemmon1) {
	 if(diemmon1 < 0) {
		 throw new IllegalArgumentException("Diem khong hop le");
	 }
	this.diemmon1 = diemmon1;
 }

 public double getDiemmon2() {
	return diemmon2;
 }

 public void setDiemmon2(double diemmon2) {
	 if(diemmon2 < 0) {
		 throw new IllegalArgumentException("Diem khong hop le");
	 }
	this.diemmon2 = diemmon2;
 }
 
 public double tinhtb() {
	 return (diemmon1 + diemmon2)/2;
 }
 
public DanhGia danhgia() {
	double dtb  = tinhtb();
	if(dtb > 8) return DanhGia.GIOI;
	else if(dtb >= 6.5) return DanhGia.KHA;
	else if(dtb >= 5) return DanhGia.TRUNGBINH;
	else return DanhGia.YEU;
}
 @Override
	public String toString() {
		return String.format("%s | %.2f | %.2f | %.2f | %10s",
				super.toString(),
				       diemmon1,
				       diemmon2,
				       tinhtb(),
				       danhgia()
				       );
	}
}
