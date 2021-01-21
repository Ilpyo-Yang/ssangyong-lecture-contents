package my.day06.a.FOR;

import java.util.Scanner;

public class Sum2Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;   //누적의 합을 저장하는 변수로써 0으로 초기화
		String str =""; //누적되어질 숫자와 +를 문자열로 결합해서 저장하는 변수로서 ""으로 초기화	
		
		System.out.print("누적해야할 시작 숫자 => ");
		int startNo = Integer.parseInt(sc.nextLine());
		System.out.print("누적해야할 마지막 숫자 => ");
		int endNo =Integer.parseInt(sc.nextLine());
		
		for (;;) {   //무한반복문
			try {
				int cnt = endNo-startNo+1;
					
				for (int i=0, j=startNo; i<cnt; i++,j++) {
					if(j<cnt)	str += j+"+";
					else str+=j;
					
					sum+=j;
				}
				break;
				
			//경우의 수를 따져서 오류 제어하기				
			} catch (NumberFormatException e) {
				System.out.println("\n>> 정수만 입력하세요!! <<");
				//다시 반복입력할 수 있게 하는 방법 => 무한반복문
			sc.close();	
			}	
		}
	
	//1+2+3+4+5+6+7+8+9+10=55
	
	System.out.print(str+"="+sum);
			
	sc.close();	
	System.out.println("\n>> 프로그램종료 <<");	
	}//end of main

}
