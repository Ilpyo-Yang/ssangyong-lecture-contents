package my.day04.b.scanner;

public class Sungjuk {

	String hakbun;
	String name;
	byte kor;     // -128 ~ 128      0 ~ 100
	byte eng;
	byte math;
	short age;    //-32768 ~ 32768      20 ~ 50
		
	// �⺻������ ���� public Sungjuk() {}
	
	boolean cheakJumsu(byte jumsu) {
		if( 0 <= jumsu && jumsu <= 100 ) 
			return true;
		else {
			System.out.println(">> ������ �Է��� 0 �̻� 100 ������ �����մϴ� <<");
			return false;
		}
	}
			
	boolean cheakAge(short age) {
		if( 20 <= age && age <= 50 ) 
			return true;
		else {
			System.out.println("== ���̴� �Է��� 20 �̻� 50 ������ �����մϴ� ==");
			return false;
        }
			
	}
	
	
	void showInfo() {
		
		int total = (kor+eng+math);
		float avg = Math.round(total/3.0f*10)/10.0f;
		          // Math.round()�� my.day05.b.math�� MathMain.java ������ ����

		String grade= "";
		if(avg >= 90)       grade = "A";
		else if (avg >= 80) grade = "B";
		else if (avg >= 70) grade = "C";
		else if (avg >= 60) grade = "D";
		else 	            grade = "F";
		
		System.out.println("\n=== "+name+"�� ������� ===\n"
				+ "1. �й� : "+hakbun+"\n"
				+ "2. ���� : "+name+"\n"
				+ "3. ���� : "+kor+"\n"
				+ "4. ���� : "+eng+"\n"
				+ "5. ���� : "+math+"\n"
				+ "6. ���� : "+total+"\n"
				+ "7. ��� : "+avg+"\n"
				+ "8. ���� : "+grade+"\n"
				+ "9. ���� : "+age+"\n");
			
	}
	
}
