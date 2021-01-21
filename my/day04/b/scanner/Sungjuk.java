package my.day04.b.scanner;

public class Sungjuk {

	String hakbun;
	String name;
	byte kor;     // -128 ~ 128      0 ~ 100
	byte eng;
	byte math;
	short age;    //-32768 ~ 32768      20 ~ 50
		
	// 기본생성자 생략 public Sungjuk() {}
	
	boolean cheakJumsu(byte jumsu) {
		if( 0 <= jumsu && jumsu <= 100 ) 
			return true;
		else {
			System.out.println(">> 점수는 입력은 0 이상 100 까지만 가능합니다 <<");
			return false;
		}
	}
			
	boolean cheakAge(short age) {
		if( 20 <= age && age <= 50 ) 
			return true;
		else {
			System.out.println("== 나이는 입력은 20 이상 50 까지만 가능합니다 ==");
			return false;
        }
			
	}
	
	
	void showInfo() {
		
		int total = (kor+eng+math);
		float avg = Math.round(total/3.0f*10)/10.0f;
		          // Math.round()는 my.day05.b.math의 MathMain.java 파일을 참조

		String grade= "";
		if(avg >= 90)       grade = "A";
		else if (avg >= 80) grade = "B";
		else if (avg >= 70) grade = "C";
		else if (avg >= 60) grade = "D";
		else 	            grade = "F";
		
		System.out.println("\n=== "+name+"의 성적결과 ===\n"
				+ "1. 학번 : "+hakbun+"\n"
				+ "2. 성명 : "+name+"\n"
				+ "3. 국어 : "+kor+"\n"
				+ "4. 영어 : "+eng+"\n"
				+ "5. 수학 : "+math+"\n"
				+ "6. 총점 : "+total+"\n"
				+ "7. 평균 : "+avg+"\n"
				+ "8. 학점 : "+grade+"\n"
				+ "9. 나이 : "+age+"\n");
			
	}
	
}
