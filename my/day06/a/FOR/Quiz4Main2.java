package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main2 {

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
				int jjakSum =0;  //짝수의 누적의 합계를 저장하는 변수
				
				int holsu=0, jjaksu=0;
				
				if(firstNo%2 == 0) {   //첫번째 입력받은 값이 짝수라면						
					holsu = firstNo+1;
					jjaksu = firstNo;
				} else {               //첫번째 입력받은 값이 홀수라면
					holsu = firstNo;
					jjaksu = firstNo+1;
				}
				
				//== 홀수 및 짝수의 합을 구한다. ===
				for(;;) {
					if(holsu<=secondNo) holSum += holsu;
					if(jjaksu<=secondNo) jjakSum += jjaksu;
					
					holsu += 2;
					jjaksu += 2;
					
					if(holsu>secondNo && jjaksu>secondNo) {   // 2 10
						break;
						// 두 경우에서 모두 break가 실행되어야 하므로 &&
					}	
					
				}
					
					System.out.println("\n>>결과<<");
					System.out.println(startNo+"부터 "+endNo+"까지의 홀수의 합 : "+holSum);
					System.out.print(startNo+"부터 "+endNo+"까지의 짝수의 합 : "+jjakSum);
					
					sc.close();
					break;
				} catch (NumberFormatException e) {
				System.out.println("정수를 입력해주세요!");
			}
				
				
			
			
		}//end of for ------------------------------------------
		
	}
	
}	



