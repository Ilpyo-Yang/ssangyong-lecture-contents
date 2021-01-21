package my.day08.b.DOWHILE;

import java.util.*;

public class PrimeNumberMain {

/*
		=== �Ҽ���? === 
		�Ҽ���? 1�� �ڱ� �ڽ����ιۿ� ���������� �ʴ� 1 �̿��� ���� 
	         ��> 1 ���� 10������ �Ҽ��� ��Ÿ���� 
		    2%2 ==> 0   2 �� �Ҽ�
		    3%3 ==> 0   3 �� �Ҽ�
		    4%2 ==> 0   4 �� �Ҽ��� �ƴ�
		    5%5 ==> 0   5 �� �Ҽ�
		    6%2 ==> 0   6 �� �Ҽ��� �ƴ�
		    7%7 ==> 0   7 �� �Ҽ�
	        8%2 ==> 0   8 �� �Ҽ��� �ƴ�
		    9%3 ==> 0   9 �� �Ҽ��� �ƴ�
		    10%2 ==> 0  10 �� �Ҽ��� �ƴ�  	
*/
	public static void main(String[] args) {
		
		/*
	        ==������==
		        ������ �ڿ��� : 1����
		        ���� �ڿ��� : 20���� 
		     1 ���� 20 ������ �Ҽ���?
		     2,3,5,7,11,13,17,19
	
		     1���� 20 ������ �Ҽ��� ����? 8��  
		     1���� 20 ������ �Ҽ����� ��? 77 
		     
	       === ���α׷� ���� ===      
	   */
		Scanner sc = new Scanner(System.in);
		int startNo = 0, endNo = 0;

		
		do {
			try {
				System.out.print(" ������ �ڿ��� : ");
				startNo = sc.nextInt();
				sc.nextLine();
				
				System.out.print(" ���� �ڿ��� : ");
				endNo = sc.nextInt();
				sc.nextLine();
				
				if(startNo<1 || endNo<1) {
					System.out.println(">> �Է��Ͻô� ���� ��� �ڿ����̾�� �մϴ�!! <<\n");
				} else {	
					sc.close();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println(">> �ڿ����� �Է��ϼ���!! <<\n");
				sc.nextLine();    //���� ����� ���� �ݺ����� �ʴ´�.
			}
		} while (true);	//�ڿ����� ���� ������ ���� ���� ��
		
		//�Ҽ���? 1�� �ڱ��ڽ��� ���θ� �������� �� �������� 0�� 1 �̿��� ����
		
		String resultStr ="";
		int cnt = 0, sum = 0;
		
		//�����⸦ ���� �� �������� �󸶰� �Ǵ��� ������ �˻縦 �Ѵ�.
		for(int i=startNo; i<=endNo; i++) {			
			if(i==1) continue; //1�� �Ҽ��� �ƴϴ�
			
			boolean isSosu = true;
			
			for(int j=2; j<i; j++) {
				if(i%j==0) { //�˻����� i�� �Ҽ��� �ƴ� ��� �˻��� �ʿ䰡 ����.
					isSosu = false;
					break;
				}
			}
			
			if(isSosu) {	// �˻����� i�� �Ҽ����
				cnt++;	// �Ҽ��� ����
				sum+=i;   // �Ҽ����� �����հ�
				
				// 2,3,5,7,11,13,17,19
				String comma = (cnt>1)?",":"";
				resultStr += comma+i; 
			}
		}
		
		System.out.println(startNo+"���� "+endNo+"������ �Ҽ���? "+resultStr);
		System.out.println(startNo+"���� "+endNo+"������ �Ҽ��� ������? "+cnt);
		System.out.println(startNo+"���� "+endNo+"������ �Ҽ����� ����? "+sum);
		
		System.out.println("=== ���α׷� ���� ===");
	}

}
