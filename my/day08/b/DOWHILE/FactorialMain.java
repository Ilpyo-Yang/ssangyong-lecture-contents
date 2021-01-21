package my.day08.b.DOWHILE;

import java.util.Scanner;

public class FactorialMain {

	public static void main(String[] args) {

//=== �Ի繮�� ===
/*
 	>> �˰� ���� ���丮�� �� �Է� => 5
 	>> 5! ==> 5*4*3*2*1 = 120
 	����ó���� ����� �� ó���ϱ�
 	
 */
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print(">> �˰� ���� ���丮�� �� �Է� => ");
				int num = Integer.parseInt(sc.nextLine());
				
				if(num<=0) {
					System.out.println(">> �ڿ����� �Է��ϼ���!!");
					continue;
				}
				int result = 1;
				
				for(int i=5;i>0;i--) {
					result *= i;
				}
				System.out.println(result);
				
				break;
			} catch (NumberFormatException e) {
				System.out.println(">> ������ �Է��ϼ���!!");
			}
		} while (true);  //���ѷ���
		
		sc.close();
		System.out.println("\n ~~~~~~~~~ ���α׷� ���� ~~~~~~~~~~~~~");
	}

}
