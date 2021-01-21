package my.day08.c.random;

import java.util.*;

public class GameMainNA {

	public static void main(String[] args) {
		
/*
  1 ~ 100

  59    50  1번시도
         50보다 큰값입니다.

         71  2번시도
         71보다 적은값입니다. 

         60  3번시도
         60보다 적은값입니다.

         58  4번시도
         58보다 큰값입니다.

         59  5번시도 
         빙고!!  5번만에 맞추었습니다.
 */
//	int rndNum = rnd.nextInt(마지막수 - 처음수 + 1)+처음수;		
		
		System.out.println("== 빙고게임 ==\n");
		
		Random rnd = new Random();
		int rndNum = rnd.nextInt(100-1+1)+1;
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		do {
			System.out.print("숫자입력(1~100) => ");
			int inputNum = Integer.parseInt(sc.nextLine());
			cnt++;
			
			if(inputNum<rndNum) {
				System.out.println(">> "+inputNum+"보다 큰 수 입니다.");
			} else if(inputNum>rndNum) {
				System.out.println(">> "+inputNum+"보다 작은 수 입니다.");
			} else {
				System.out.println("\n>> 빙고!! "+cnt+"번만에 맞췄습니다.");
				sc.close();
				break;
			}
			
		} while (true);

	}//end of main() ------------------------------------

}
