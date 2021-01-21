//total에서 제거
package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4MainNA {

	public static void main(String[] args) {

		/*
		 * 첫번째 정수:2
		 * 두번째 정수:10
		 * >>결과<<
		 * 2부터 10까지의 홀수의 합: 24
		 * 2부터 10까지의 짝수의 합: 30
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int startNo = 0;
		int endNo = 0;
		int sum = 0;
		int total = 0;
		
		try {
			System.out.print("첫번째 정수 => ");
			startNo = sc.nextInt();
			sc.nextLine();
			
			System.out.print("두번째 정수 => ");
			endNo = sc.nextInt();
			sc.nextLine();
			
			for(int i=startNo;i<=endNo;i++) {
				total += i;
				
				if(i%2!=0) { 
					sum += i;  				
				}
			
						
			}} catch (NumberFormatException e) {      //***이거 괄호 이상함
				System.out.println("정수를 입력해주세요!");
			}
			
			System.out.println("\n>>결과<<");
			System.out.println(startNo+"부터 "+endNo+"까지의 홀수의 합 : "+sum);   //출력 띄어쓰기 조심
			System.out.print(startNo+"부터 "+endNo+"까지의 짝수의 합 : "+(total-sum));
			
			sc.close();
				
		
	}//end of main ----------------------------------
		
}


