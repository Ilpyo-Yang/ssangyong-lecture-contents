package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain {

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
			
			System.out.print("3. 국어: ");
			Byte.parseByte(sc.nextLine());
			
			//	if(sj.kor < 0 || sj.kor > 100 )
			if(!(0 < sj.kor && sj.kor <= 100)) {
				System.out.println(">> 점수는 입력은 0 이상 100 까지만 가능합니다 <<");
				sc.close();
				return;
			}
			//Main() 메서드 내 return;은 main()메서드에서 작업중인 것을 종료해라는 말이다.
			//즉, 프로그램을 종료해라는 말
			
			System.out.print("4. 영어: ");
			sj.eng = Byte.parseByte(sc.nextLine());
			
			System.out.print("5. 수학: ");
			sj.math = Byte.parseByte(sc.nextLine());
			
		} catch (NumberFormatException e) {
			
			System.out.println(">> 점수는 입력은 0 이상 100 까지만 가능합니다 <<");
			
		}
		
		
		sc.close();
	}

}
