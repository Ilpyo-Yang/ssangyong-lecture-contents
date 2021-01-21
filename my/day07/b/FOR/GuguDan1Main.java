package my.day07.b.FOR;

import java.util.Scanner;

public class GuguDan1Main {  //경우의  수 고려한 구구단 만들기

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
		
	/*
		 === 레이블을 사용하여 break; 하기 ===
		 레이블명 뒤에는 : 을 붙이며 반드시 반복문 앞에 써야 한다.		  
	 */
		outer:  // outer: 을 레이블이라고 부르는데 그 레이블명이 지금은 outer일 뿐이다.
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
					
					for(;;) {
						System.out.print(">> 또 하시겠습니까? [Y/N] => ");
						String yn = sc.nextLine();
						
						if ("N".equalsIgnoreCase(yn)) { 	//대소문자 구분하지 않는 경우
							System.out.println("== 프로그램 종료 ==");
							sc.close();
							break outer; // 가장 바깥에서 선언된 for문을 빠져나가야 하는 것이다. 
										 // outer가 레이블명이다. 
						} else if ("Y".equalsIgnoreCase(yn)) {
								break;
						} else System.out.println(">>> Y 또는 N만 가능합니다 <<<");
					}//end of for ------------------------------------------------
				
				} else
					System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
				
				
			} catch (NumberFormatException e) {
				System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
			}
			
		//sc.close(); break;전에 넣어주기
		}//end of for-------------------------------------------------

	}

}
