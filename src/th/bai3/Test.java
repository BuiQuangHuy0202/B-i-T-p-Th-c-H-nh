package th.bai3;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
		System.out.println("1/ Nhập thông tin");
		System.out.println("2/ Xuất bảng kê khai tiền thuế trước bạ của các xe");
		System.out.println("3/ Thoát");
		Xe xe1= null;
		Xe xe2= null;
		Xe xe3= null;
		int chon = 0;
		do {
		    System.out.println("\nChọn chức năng: ");
		    chon = sc.nextInt();
		    sc.nextLine();
		switch(chon) {
		case 1:
		    System.out.println("Nhập tên chủ xe1");
		    String ten1 = sc.nextLine();
		    System.out.println("Nhập loại xe1");
		    String loaixe1 = sc.nextLine(); 
		    System.out.println("Nhập dung tích xe1");
		    int dungtich1= sc.nextInt();
		    System.out.println("Nhập trị giá xe1");
		    double trigia1 = sc.nextDouble();
		    xe1 = new Xe(ten1, loaixe1, dungtich1, trigia1);
		   sc.nextLine();
		   
		   
		    System.out.println("Nhập tên chủ xe2");
		    String ten2 = sc.nextLine();
		    System.out.println("Nhập loại xe2");
		    String loaixe2 = sc.nextLine(); 
		    System.out.println("Nhập dung tích xe2");
		    int dungtich2 = sc.nextInt();
		    System.out.println("Nhập trị giá xe2");
		    double trigia2 = sc.nextDouble();
		    xe2 = new Xe(ten2, loaixe2, dungtich2, trigia2);
		    sc.nextLine();
		    
		    System.out.println("Nhập tên chủ xe3");
		    String ten3 = sc.nextLine();
		    System.out.println("Nhập loại xe3");
		    String loaixe3 = sc.nextLine(); 
		    System.out.println("Nhập dung tích xe3");
		    int dungtich3 = sc.nextInt();
		    System.out.println("Nhập trị giá xe3");
		    double trigia3 = sc.nextDouble();
		    xe3 = new Xe(ten3, loaixe3, dungtich3, trigia3);
		    break;
		    
		case 2: String headerline = String.format("%-20s %-20s %-20s %-20s %-20s",
				                                   "Tên chủ xe", "Loại Xe","Dung tích","Tri giá", "Thuế phải nộp");
		 System.out.println(headerline + "\n" + "=".repeat(90));
		 System.out.println(xe1);
		 System.out.println(xe2);
		 System.out.println(xe3);
		 break;
   
}
		} while(chon!=3);
	}
    System.out.println("Đã Thoát!");
}
}
