package my.day08.c.random;

import java.util.*;

public class GameMain {

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
		
		System.out.println("랜덤한 숫자 맞추기");
		
		Random r = new Random();
		int answer = r.nextInt(100-1+1)+1;
		
		Scanner sc = new Scanner(System.in);
		int cnt =0;
		
		for(;;) {
			
			cnt++;
			System.out.print("숫자를 입력하세요 => ");
			int input = Integer.parseInt(sc.nextLine());
			System.out.println();			

			if(answer>input) {
				System.out.println(input+"보다 큽니다.");
				continue;
			} else if (answer<input) {
				System.out.println(input+"보다 작습니다.");
				continue;
			} else	System.out.println("빙고! "+cnt+"번만에 맞췄습니다.");
			
			sc.close();
			break;
		}
		
	}//end of main() ------------------------------------

}
