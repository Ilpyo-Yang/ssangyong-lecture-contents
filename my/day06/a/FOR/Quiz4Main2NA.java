package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main2NA {

	public static void main(String[] args) {

		/*
		 * 첫번째 정수:2
		 * 두번째 정수:10
		 * >>결과<<
		 * 2부터 10까지의 홀수의 합: 24
		 * 2부터 10까지의 짝수의 합: 30
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 => ");
		String startNo = sc.nextLine();
		System.out.print("두번째 정수 => ");
		String endNo = sc.nextLine();
		
		int holSum = 0;  //홀수의 누적의 합계를 저장하는 변수
		int jjakSum =0;
		
		try {
			int firstNo = Integer.parseInt(startNo);
			int secondNo = Integer.parseInt(endNo);			
			
			for(int i=firstNo;i<=secondNo;i++) {
				if(i%2 == 0) {   //첫번째 입력받은 값이 짝수라면						
					holSum += i;
					continue;
				} else jjakSum += i;;
			}
			
	    }  catch (NumberFormatException e) {
			System.out.println("정수를 입력해주세요!");
		}
			
			System.out.println(startNo+"부터 "+endNo+"까지의 홀수의 합 : "+holSum);
			System.out.print(startNo+"부터 "+endNo+"까지의 짝수의 합 : "+jjakSum);	
			
			sc.close();
		}
		
	
}
	
	



