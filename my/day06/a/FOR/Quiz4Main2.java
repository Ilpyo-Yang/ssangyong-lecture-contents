package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main2 {

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
				int jjakSum =0;  //¦���� ������ �հ踦 �����ϴ� ����
				
				int holsu=0, jjaksu=0;
				
				if(firstNo%2 == 0) {   //ù��° �Է¹��� ���� ¦�����						
					holsu = firstNo+1;
					jjaksu = firstNo;
				} else {               //ù��° �Է¹��� ���� Ȧ�����
					holsu = firstNo;
					jjaksu = firstNo+1;
				}
				
				//== Ȧ�� �� ¦���� ���� ���Ѵ�. ===
				for(;;) {
					if(holsu<=secondNo) holSum += holsu;
					if(jjaksu<=secondNo) jjakSum += jjaksu;
					
					holsu += 2;
					jjaksu += 2;
					
					if(holsu>secondNo && jjaksu>secondNo) {   // 2 10
						break;
						// �� ��쿡�� ��� break�� ����Ǿ�� �ϹǷ� &&
					}	
					
				}
					
					System.out.println("\n>>���<<");
					System.out.println(startNo+"���� "+endNo+"������ Ȧ���� �� : "+holSum);
					System.out.print(startNo+"���� "+endNo+"������ ¦���� �� : "+jjakSum);
					
					sc.close();
					break;
				} catch (NumberFormatException e) {
				System.out.println("������ �Է����ּ���!");
			}
				
				
			
			
		}//end of for ------------------------------------------
		
	}
	
}	



