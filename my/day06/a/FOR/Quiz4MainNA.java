//total���� ����
package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4MainNA {

	public static void main(String[] args) {

		/*
		 * ù��° ����:2
		 * �ι�° ����:10
		 * >>���<<
		 * 2���� 10������ Ȧ���� ��: 24
		 * 2���� 10������ ¦���� ��: 30
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int startNo = 0;
		int endNo = 0;
		int sum = 0;
		int total = 0;
		
		try {
			System.out.print("ù��° ���� => ");
			startNo = sc.nextInt();
			sc.nextLine();
			
			System.out.print("�ι�° ���� => ");
			endNo = sc.nextInt();
			sc.nextLine();
			
			for(int i=startNo;i<=endNo;i++) {
				total += i;
				
				if(i%2!=0) { 
					sum += i;  				
				}
			
						
			}} catch (NumberFormatException e) {      //***�̰� ��ȣ �̻���
				System.out.println("������ �Է����ּ���!");
			}
			
			System.out.println("\n>>���<<");
			System.out.println(startNo+"���� "+endNo+"������ Ȧ���� �� : "+sum);   //��� ���� ����
			System.out.print(startNo+"���� "+endNo+"������ ¦���� �� : "+(total-sum));
			
			sc.close();
				
		
	}//end of main ----------------------------------
		
}


