package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Sungjuk sj = new Sungjuk();
		
		try {
			
			System.out.print("1. 학번: ");
			sj.hakbun = sc.nextLine();
			
			System.out.print("2. 성명: ");
			sj.name = sc.nextLine();
			
			//0~100
			//byte: -128 ~ 127
			
			//Integer.parseInt(String str)
			//Short.parseShort(String str)
				
			System.out.print("3. 국어: ");
			byte kor = Byte.parseByte(sc.nextLine());
			                         // "똘똘이" "2000" "-50" "90"
			
		/*	
			boolean bool = sj.cheakJumsu(kor);
			if (!bool) {  //false라면,
				sc.close();
				return;
			} else {
				sj.kor = kor;
			}
			// kor 값이 0 ~ 100 이라면 true
			// kor 값이 0 미만 또는 100보다 크다라면 false
			//Main() 메서드 내 return;은 main()메서드에서 작업중인 것을 종료해라는 말이다.
			//즉, 프로그램을 종료해라는 말
			  
			 ▼ 코드 줄이기
		*/
			
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
			
		} catch (NumberFormatException e) {
			
			System.out.println("## 점수는 입력은 0 이상 100 까지만 가능합니다 ##");
			e.printStackTrace();
			
		}
		
		
		sc.close();
	}

}
