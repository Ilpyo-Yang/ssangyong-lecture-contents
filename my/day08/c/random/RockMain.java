package my.day08.c.random;

import java.util.*;

public class RockMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
		int userNum = 0;
		
		do {
			System.out.println("=============== 메뉴 ==============");
			System.out.println("1.가위\t2.바위\t3.보\t4.게임종료");
			System.out.println("==================================");
			System.out.print(">> 선택하세요 => ");
			
			try {
				userNum = Integer.parseInt(sc.nextLine());
				
				if(!(1<=userNum&&userNum<=4)) {
					System.out.println("▷  메뉴에 존재하지 않는 번호입니다.\n");
					continue;
				} 
				
				String msg = "";
				
				if (userNum!=4) {     //1~3을 낸 경우
					int pcNum = rnd.nextInt(3-1+1)+1;
										
					//사용자가 이긴 경우
					if((pcNum==1&&userNum==2) || (pcNum==2&&userNum==3) || (pcNum==3&&userNum==1)) {
					   msg = ">>> 사용자님이 이겼습니다!!\n";
					}
					//pc가 이긴 경우
					else if((pcNum==2&&userNum==1) || (pcNum==3&&userNum==2) || (pcNum==1&&userNum==3)) {
					   msg = ">>> pc가 이겼습니다!!\n";
				    } 
					//사용자와 pc가 비긴 경우
					else  msg = ">>> 비겼습니다!!\n";	  
				}
				System.out.println(msg);
				
				
				
			} catch (NumberFormatException e) {
				System.out.println("▷  숫자로만 입력하세요!!\n");
			}
			
		
		} while (!(userNum == 4)); //userNum == 0 이면 true이고 !와 만나 false가 되어 while을 빠져나갈 수 있다. 탈출조건
		
		sc.close();
	}

}
