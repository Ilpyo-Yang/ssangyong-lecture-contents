package my.day08.c.random;

import java.util.*;

public class GameMainNA {

	public static void main(String[] args) {
		
/*
  1 ~ 100

  59    50  1���õ�
         50���� ū���Դϴ�.

         71  2���õ�
         71���� �������Դϴ�. 

         60  3���õ�
         60���� �������Դϴ�.

         58  4���õ�
         58���� ū���Դϴ�.

         59  5���õ� 
         ����!!  5������ ���߾����ϴ�.
 */
//	int rndNum = rnd.nextInt(�������� - ó���� + 1)+ó����;		
		
		System.out.println("== ������� ==\n");
		
		Random rnd = new Random();
		int rndNum = rnd.nextInt(100-1+1)+1;
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		do {
			System.out.print("�����Է�(1~100) => ");
			int inputNum = Integer.parseInt(sc.nextLine());
			cnt++;
			
			if(inputNum<rndNum) {
				System.out.println(">> "+inputNum+"���� ū �� �Դϴ�.");
			} else if(inputNum>rndNum) {
				System.out.println(">> "+inputNum+"���� ���� �� �Դϴ�.");
			} else {
				System.out.println("\n>> ����!! "+cnt+"������ ������ϴ�.");
				sc.close();
				break;
			}
			
		} while (true);

	}//end of main() ------------------------------------

}
