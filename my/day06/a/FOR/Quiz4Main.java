package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main {

	public static void main(String[] args) {

		/*
		 * 첫번째 정수:2
		 * 두번째 정수:10
		 * >>결과<<
		 * 2부터 10까지의 홀수의 합: 24
		 * 2부터 10까지의 짝수의 합: 30
		 */
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			try {
				System.out.print("첫번째 정수 => ");
				String startNo = sc.nextLine();
				int firstNo = Integer.parseInt(startNo);
				
				System.out.print("두번째 정수 => ");
				String endNo = sc.nextLine();
				int secondNo = Integer.parseInt(endNo);
				
				int holSum = 0;  //홀수의 누적의 합계를 저장하는 변수
				int jjakSum =0;
				
				//== 홀수의 합을 구한다. ===
				for(;;) {
					//홀수의 합을 구하는데 첫번째로 입력한 값이 firstNo => 2 (짝수)라면
					//firstNo 는 1을 더한 후(즉, 3) 2씩 증가시켜주면 된다.
					
					//홀수의 합을 구하는데 첫번째로 입력한 값이 firstNo => 3 (홀수)라면
					//2씩 증가시켜주면 된다.
					
					if(firstNo%2 == 0) {   //첫번째 입력받은 값이 짝수라면						
						firstNo = firstNo+1;
					} 
					
					if(firstNo<=secondNo)					
						holSum += firstNo;
					else break;
					
					firstNo += 2;
					
									
				} //end of for ---------------------------------
				
				firstNo = Integer.parseInt(startNo);
				//== 짝수의 합을 구한다. ===
				for(;;) {
					if(firstNo%2 != 0) {   						
						firstNo = firstNo+1;
					} 
					
					if(firstNo<=secondNo)					
						jjakSum += firstNo;
					else break;
					
					firstNo += 2;
					
					System.out.println("\n>>결과<<");
					System.out.println(startNo+"부터 "+endNo+"까지의 홀수의 합 : "+holSum);
					System.out.print(startNo+"부터 "+endNo+"까지의 짝수의 합 : "+jjakSum);
					
				}} catch (NumberFormatException e) {
				System.out.println("정수를 입력해주세요!");
			}
				
				
			
			sc.close();
		}//end of for ------------------------------------------
		
	}
	
}	



