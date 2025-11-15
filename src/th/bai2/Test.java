package th.bai2;

public class Test {
	public static void main(String[] args) {
		QLSV sv1 = new QLSV(24666311, "Bùi Quang Huy", 9.5f, 8.5f);
		QLSV sv2 = new QLSV(24676691, "TRần Mỹ Mộng", 9.5f, 10.0f);
		QLSV sv3 = new QLSV();
		String headerline = String.format("%s | %-30s | %5s | %5s | %5s ", 
                                           "Mã số sinh viên", 
                                           "Họ và tên",
                                           "Điểm lý thuyết",
                                           "Điểm thực hành",
                                           "Điểm trung bình"
                                           );
		System.out.println(headerline + "\n" + "=".repeat(100));
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}

}
