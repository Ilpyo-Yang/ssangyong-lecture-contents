package my.day07.b.FOR;

import java.util.Scanner;

public class GuguDan1Main {  //�����  �� ����� ������ �����

	public static void main(String[] args) {

		/*
		 	>> �� �� ����? => 8
		 	
		 	=== 8�� ===
		 	8*1=8
		 	8*2=16
		 	8*3=24....
		 	
		 	>> �� �Ͻðڽ��ϱ�? [Y/N] => y �Ǵ� Y����
		 	
		 	>> �� �� ����? => 1.4
		 	>>> 2�ܺ��� 9�ܱ����� �����մϴ� <<<
		 	
		 	>> �� �� ����? => 345
		 	>>> 2�ܺ��� 9�ܱ����� �����մϴ� <<<
		 	
		 	>> �� �� ����? => 3
		 	             
		 	>> �� �Ͻðڽ��ϱ�? [Y/N] => n �Ǵ� N����

		 	== ���α׷� ���� ==
		 	
		 	>> �� �Ͻðڽ��ϱ�? [Y/N] => �� ���� ����
		 	>>> Y �Ǵ� N�� �����մϴ� <<<
		 	
		 	>> �� �Ͻðڽ��ϱ�? [Y/N]
		 */
		
		Scanner sc = new Scanner(System.in);	
		
	/*
		 === ���̺��� ����Ͽ� break; �ϱ� ===
		 ���̺�� �ڿ��� : �� ���̸� �ݵ�� �ݺ��� �տ� ��� �Ѵ�.		  
	 */
		outer:  // outer: �� ���̺��̶�� �θ��µ� �� ���̺���� ������ outer�� ���̴�.
		for(;;) {
			
			try {
				System.out.print("�� �� ����? => ");
				String strDan = sc.nextLine();
				int Dan  = Integer.parseInt(strDan);
				
				if(1<Dan&&Dan<10) {
					System.out.println("=== "+Dan+"�� ===");
					for(int i=1;i<10;i++) {
						System.out.println(Dan+"*"+i+"="+Dan*i);
					}
					
					for(;;) {
						System.out.print(">> �� �Ͻðڽ��ϱ�? [Y/N] => ");
						String yn = sc.nextLine();
						
						if ("N".equalsIgnoreCase(yn)) { 	//��ҹ��� �������� �ʴ� ���
							System.out.println("== ���α׷� ���� ==");
							sc.close();
							break outer; // ���� �ٱ����� ����� for���� ���������� �ϴ� ���̴�. 
										 // outer�� ���̺���̴�. 
						} else if ("Y".equalsIgnoreCase(yn)) {
								break;
						} else System.out.println(">>> Y �Ǵ� N�� �����մϴ� <<<");
					}//end of for ------------------------------------------------
				
				} else
					System.out.println(">>> 2�ܺ��� 9�ܱ����� �����մϴ� <<<");
				
				
			} catch (NumberFormatException e) {
				System.out.println(">>> 2�ܺ��� 9�ܱ����� �����մϴ� <<<");
			}
			
		//sc.close(); break;���� �־��ֱ�
		}//end of for-------------------------------------------------

	}

}
