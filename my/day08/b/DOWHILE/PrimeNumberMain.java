package my.day08.b.DOWHILE;

import java.util.*;

public class PrimeNumberMain {

/*
		=== 소수란? === 
		소수란? 1과 자기 자신으로밖에 나누어지지 않는 1 이외의 정수 
	         예> 1 부터 10까지의 소수를 나타내면 
		    2%2 ==> 0   2 는 소수
		    3%3 ==> 0   3 는 소수
		    4%2 ==> 0   4 는 소수가 아님
		    5%5 ==> 0   5 는 소수
		    6%2 ==> 0   6 는 소수가 아님
		    7%7 ==> 0   7 는 소수
	        8%2 ==> 0   8 는 소수가 아님
		    9%3 ==> 0   9 는 소수가 아님
		    10%2 ==> 0  10 는 소수가 아님  	
*/
	public static void main(String[] args) {
		
		/*
	        ==실행결과==
		        ▷시작 자연수 : 1엔터
		        ▷끝 자연수 : 20엔터 
		     1 부터 20 까지의 소수는?
		     2,3,5,7,11,13,17,19
	
		     1부터 20 까지의 소수의 개수? 8개  
		     1부터 20 까지의 소수들의 합? 77 
		     
	       === 프로그램 종료 ===      
	   */
		Scanner sc = new Scanner(System.in);
		int startNo = 0, endNo = 0;

		
		do {
			try {
				System.out.print(" ▷시작 자연수 : ");
				startNo = sc.nextInt();
				sc.nextLine();
				
				System.out.print(" ▷끝 자연수 : ");
				endNo = sc.nextInt();
				sc.nextLine();
				
				if(startNo<1 || endNo<1) {
					System.out.println(">> 입력하시는 값은 모두 자연수이어야 합니다!! <<\n");
				} else {	
					sc.close();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println(">> 자연수만 입력하세요!! <<\n");
				sc.nextLine();    //값을 비워야 무한 반복되지 않는다.
			}
		} while (true);	//자연수를 넣을 때까지 돌린 것일 뿐
		
		//소수란? 1과 자기자신의 수로만 나누었을 때 나머지가 0인 1 이외의 정수
		
		String resultStr ="";
		int cnt = 0, sum = 0;
		
		//나누기를 했을 때 나머지가 얼마가 되는지 일일이 검사를 한다.
		for(int i=startNo; i<=endNo; i++) {			
			if(i==1) continue; //1은 소수가 아니다
			
			boolean isSosu = true;
			
			for(int j=2; j<i; j++) {
				if(i%j==0) { //검사대상인 i는 소수가 아닌 경우 검사할 필요가 없다.
					isSosu = false;
					break;
				}
			}
			
			if(isSosu) {	// 검사대상인 i가 소수라면
				cnt++;	// 소수의 개수
				sum+=i;   // 소수들의 누적합계
				
				// 2,3,5,7,11,13,17,19
				String comma = (cnt>1)?",":"";
				resultStr += comma+i; 
			}
		}
		
		System.out.println(startNo+"부터 "+endNo+"까지의 소수는? "+resultStr);
		System.out.println(startNo+"부터 "+endNo+"까지의 소수의 개수는? "+cnt);
		System.out.println(startNo+"부터 "+endNo+"까지의 소수들의 합은? "+sum);
		
		System.out.println("=== 프로그램 종료 ===");
	}

}
