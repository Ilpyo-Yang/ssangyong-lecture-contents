package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Sungjuk sj = new Sungjuk();
		
		int inputType = 0;
		
		try {
			
			System.out.print("1. 학번: ");
			sj.hakbun = sc.nextLine();
			
			System.out.print("2. 성명: ");
			sj.name = sc.nextLine();
			
			//0~100
			//byte: -128 ~ 127
			
// === *** 유효성 검사하기 (올바른 데이터인지 틀린 데이터인지 검사하는 것) *** ===
			//Integer.parseInt(String str)
			//Short.parseShort(String str)
			
		    inputType = 1; //inputTye 값이 1이라면, 국영수를 입력하는 중이다 라고 본다.
			
			System.out.print("3. 국어: ");
			byte kor = Byte.parseByte(sc.nextLine());
			                         // "똘똘이" "2000" "-50" "90"
			
			if (!sj.cheakJumsu(kor)) {  
				sc.close();
				return;
			} else {
				sj.kor = kor;
			}
			
			System.out.print("4. 영어: ");
			byte eng = Byte.parseByte(sc.nextLine());
			if (!sj.cheakJumsu(eng)) {  
				sc.close();
				return;
			} else {
				sj.eng = eng;
			}
			
			
			System.out.print("5. 수학: ");
			byte math = Byte.parseByte(sc.nextLine());
			if (!sj.cheakJumsu(math)) { 
				sc.close();
				return;
			} else {
				sj.math = math;
			}
			
			inputType = 2; //inputTye 값이 2이라면, 나이를 입력하는 중이다 라고 본다.
			
			System.out.print("6. 나이: ");
			short age = Short.parseShort(sc.nextLine());
			if (!sj.cheakAge(age)) {         //if(false) {} ==> dead code
				sc.close();
				return;
			} else {
				sj.age = age;
			}
			
		   sj.showInfo();
		    
		    /*
		     * === 이순신 님의 성적결과 ===
		     * 1. 학번: 091234
		     * 2. 성명: 이순신
		     * 3. 국어: 90
		     * 4. 영어: 80
		     * 5. 수학: 78
		     * 6. 총점: 248
		     * 7. 평균: 82.666666667
		     * 8. 학점: B
		     * 9. 나이 : 20
		     */
			
			
		} catch (NumberFormatException e) {
			if(inputType == 1) 
				System.out.println("## 점수는 입력은 0 이상 100 까지만 가능합니다 ##");
			else if (inputType == 2) 
				System.out.println("## 나이 입력은 20 이상 50 까지만 가능합니다 ##");
			
			e.printStackTrace();
		}
		
		/*
		 java.lang.NumberFormatException: Value out of range. Value:"88888888" Radix:10
			at java.lang.Short.parseShort(Unknown Source)
			at java.lang.Short.parseShort(Unknown Source)
			at my.day04.b.scanner.SungjulkMain4.main(SungjulkMain4.java:59)
		 */
				
		sc.close();
	}

}
