package my.day08.c.random;

import java.util.*;

public class GameMain {

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
		
		System.out.println("������ ���� ���߱�");
		
		Random r = new Random();
		int answer = r.nextInt(100-1+1)+1;
		
		Scanner sc = new Scanner(System.in);
		int cnt =0;
		
		for(;;) {
			
			cnt++;
			System.out.print("���ڸ� �Է��ϼ��� => ");
			int input = Integer.parseInt(sc.nextLine());
			System.out.println();			

			if(answer>input) {
				System.out.println(input+"���� Ů�ϴ�.");
				continue;
			} else if (answer<input) {
				System.out.println(input+"���� �۽��ϴ�.");
				continue;
			} else	System.out.println("����! "+cnt+"������ ������ϴ�.");
			
			sc.close();
			break;
		}
		
	}//end of main() ------------------------------------

}
