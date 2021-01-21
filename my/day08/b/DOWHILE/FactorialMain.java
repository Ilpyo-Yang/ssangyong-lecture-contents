package my.day08.b.DOWHILE;

import java.util.Scanner;

public class FactorialMain {

	public static void main(String[] args) {

//=== 입사문제 ===
/*
 	>> 알고 싶은 팩토리얼 수 입력 => 5
 	>> 5! ==> 5*4*3*2*1 = 120
 	예외처리와 경우의 수 처리하기
 	
 */
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print(">> 알고 싶은 팩토리얼 수 입력 => ");
				int num = Integer.parseInt(sc.nextLine());
				
				if(num<=0) {
					System.out.println(">> 자연수만 입력하세요!!");
					continue;
				}
				int result = 1;
				
				for(int i=5;i>0;i--) {
					result *= i;
				}
				System.out.println(result);
				
				break;
			} catch (NumberFormatException e) {
				System.out.println(">> 정수만 입력하세요!!");
			}
		} while (true);  //무한루프
		
		sc.close();
		System.out.println("\n ~~~~~~~~~ 프로그램 종료 ~~~~~~~~~~~~~");
	}

}
