package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main {

	public static void main(String[] args) {

		/*
		 * ù��° ����:2
		 * �ι�° ����:10
		 * >>���<<
		 * 2���� 10������ Ȧ���� ��: 24
		 * 2���� 10������ ¦���� ��: 30
		 */
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			try {
				System.out.print("ù��° ���� => ");
				String startNo = sc.nextLine();
				int firstNo = Integer.parseInt(startNo);
				
				System.out.print("�ι�° ���� => ");
				String endNo = sc.nextLine();
				int secondNo = Integer.parseInt(endNo);
				
				int holSum = 0;  //Ȧ���� ������ �հ踦 �����ϴ� ����
				int jjakSum =0;
				
				//== Ȧ���� ���� ���Ѵ�. ===
				for(;;) {
					//Ȧ���� ���� ���ϴµ� ù��°�� �Է��� ���� firstNo => 2 (¦��)���
					//firstNo �� 1�� ���� ��(��, 3) 2�� ���������ָ� �ȴ�.
					
					//Ȧ���� ���� ���ϴµ� ù��°�� �Է��� ���� firstNo => 3 (Ȧ��)���
					//2�� ���������ָ� �ȴ�.
					
					if(firstNo%2 == 0) {   //ù��° �Է¹��� ���� ¦�����						
						firstNo = firstNo+1;
					} 
					
					if(firstNo<=secondNo)					
						holSum += firstNo;
					else break;
					
					firstNo += 2;
					
									
				} //end of for ---------------------------------
				
				firstNo = Integer.parseInt(startNo);
				//== ¦���� ���� ���Ѵ�. ===
				for(;;) {
					if(firstNo%2 != 0) {   						
						firstNo = firstNo+1;
					} 
					
					if(firstNo<=secondNo)					
						jjakSum += firstNo;
					else break;
					
					firstNo += 2;
					
					System.out.println("\n>>���<<");
					System.out.println(startNo+"���� "+endNo+"������ Ȧ���� �� : "+holSum);
					System.out.print(startNo+"���� "+endNo+"������ ¦���� �� : "+jjakSum);
					
				}} catch (NumberFormatException e) {
				System.out.println("������ �Է����ּ���!");
			}
				
				
			
			sc.close();
		}//end of for ------------------------------------------
		
	}
	
}	



