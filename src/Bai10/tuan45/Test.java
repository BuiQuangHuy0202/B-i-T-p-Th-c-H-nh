package Bai10.tuan45;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
public static void main(String[] args) {
	List<Person> dsach = taodulieumau();
	QuanLy ds = new QuanLy(dsach);
	String headerline = String.format("%20s | %26s | %s ", "Ten", "Dia Chi", "Thong Tin Khac");
	System.out.println(headerline+"\n"+"=".repeat(60));
	for (Person person : dsach) {
		System.out.println(ds.them(person));
	}
	
	System.out.println("Xoa danh sach");
	System.out.println(headerline+"\n"+"=".repeat(60));
	ds.xoa("Bui Quang Huy");
	for (Person person : ds.getlist()) {
		System.out.println(person);
	}
	System.out.println("Sap xep danh sach");
	System.out.println(headerline+"\n"+"=".repeat(60));
	ds.Sapxeptheoten().forEach(System.out::println);
	
	
	int tongnguoi = ds.tong();
	System.out.printf("Tong nguoi : %d", tongnguoi);
}
private static List<Person> taodulieumau(){
	List<Person> ds = new ArrayList<>();
	ds.add(new Student("Bui Quang Huy", "566/187/52 nguyen thai son", 9.0, 10));
	ds.add(new Employee("Tran My Mong", "14/14 nguyen van luong", 10.0));
	ds.add(new Customer("Bui Thanh Tu", "416/11/1 DQH", "CTTNHH Xe", 10000, DanhGia.GIOI));
	return ds;
}
}
