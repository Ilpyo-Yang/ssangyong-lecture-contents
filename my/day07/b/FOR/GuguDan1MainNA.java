package my.day07.b.FOR;

import java.util.Scanner;

public class GuguDan1MainNA {  //경우의  수 고려한 구구단 만들기

	public static void main(String[] args) {

		/*
		 	>> 몇 단 볼래? => 8
		 	
		 	=== 8단 ===
		 	8*1=8
		 	8*2=16
		 	8*3=24....
		 	
		 	>> 또 하시겠습니까? [Y/N] => y 또는 Y엔터
		 	
		 	>> 몇 단 볼래? => 1.4
		 	>>> 2단부터 9단까지만 가능합니다 <<<
		 	
		 	>> 몇 단 볼래? => 345
		 	>>> 2단부터 9단까지만 가능합니다 <<<
		 	
		 	>> 몇 단 볼래? => 3
		 	             
		 	>> 또 하시겠습니까? [Y/N] => n 또는 N엔터

		 	== 프로그램 종료 ==
		 	
		 	>> 또 하시겠습니까? [Y/N] => 그 외의 문자
		 	>>> Y 또는 N만 가능합니다 <<<
		 	
		 	>> 또 하시겠습니까? [Y/N]
		 */
		
	Scanner sc = new Scanner(System.in);			
	
		for(;;) {
			
			try {
				System.out.print("몇 단 볼래? => ");
				String strDan = sc.nextLine();
				int Dan  = Integer.parseInt(strDan);
				
				if(1<Dan&&Dan<10) {
					System.out.println("=== "+Dan+"단 ===");
					for(int i=1;i<10;i++) {
						System.out.println(Dan+"*"+i+"="+Dan*i);
					}
					
					System.out.print(">> 또 하시겠습니까? [Y/N] => ");
					String yn = sc.nextLine();
					
					if ("Y".equalsIgnoreCase(yn)) continue;  //대소문자 구분하지 않는 경우
				    else if ("N".equalsIgnoreCase(yn)) {
						System.out.println("== 프로그램 종료 ==");
						sc.close();
						break;
					} else System.out.println(">>> Y 또는 N만 가능합니다 <<<");
					
				} else
					System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
				
				
			} catch (NumberFormatException e) {
				System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
			}
			
		//sc.close(); break;전에 넣어주기
		}//end of for-------------------------------------------------

	}

}
