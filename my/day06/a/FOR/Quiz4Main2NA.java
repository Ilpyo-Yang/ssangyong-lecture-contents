package my.day06.a.FOR;

import java.util.Scanner;

public class Quiz4Main2NA {

	public static void main(String[] args) {

		/*
		 * ù��° ����:2
		 * �ι�° ����:10
		 * >>���<<
		 * 2���� 10������ Ȧ���� ��: 24
		 * 2���� 10������ ¦���� ��: 30
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� => ");
		String startNo = sc.nextLine();
		System.out.print("�ι�° ���� => ");
		String endNo = sc.nextLine();
		
		int holSum = 0;  //Ȧ���� ������ �հ踦 �����ϴ� ����
		int jjakSum =0;
		
		try {
			int firstNo = Integer.parseInt(startNo);
			int secondNo = Integer.parseInt(endNo);			
			
			for(int i=firstNo;i<=secondNo;i++) {
				if(i%2 == 0) {   //ù��° �Է¹��� ���� ¦�����						
					holSum += i;
					continue;
				} else jjakSum += i;;
			}
			
	    }  catch (NumberFormatException e) {
			System.out.println("������ �Է����ּ���!");
		}
			
			System.out.println(startNo+"���� "+endNo+"������ Ȧ���� �� : "+holSum);
			System.out.print(startNo+"���� "+endNo+"������ ¦���� �� : "+jjakSum);	
			
			sc.close();
		}
		
	
}
	
	



