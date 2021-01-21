package my.day08.c.random;

import java.util.*;

public class RockMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
		int userNum = 0;
		
		do {
			System.out.println("=============== �޴� ==============");
			System.out.println("1.����\t2.����\t3.��\t4.��������");
			System.out.println("==================================");
			System.out.print(">> �����ϼ��� => ");
			
			try {
				userNum = Integer.parseInt(sc.nextLine());
				
				if(!(1<=userNum&&userNum<=4)) {
					System.out.println("��  �޴��� �������� �ʴ� ��ȣ�Դϴ�.\n");
					continue;
				} 
				
				String msg = "";
				
				if (userNum!=4) {     //1~3�� �� ���
					int pcNum = rnd.nextInt(3-1+1)+1;
										
					//����ڰ� �̱� ���
					if((pcNum==1&&userNum==2) || (pcNum==2&&userNum==3) || (pcNum==3&&userNum==1)) {
					   msg = ">>> ����ڴ��� �̰���ϴ�!!\n";
					}
					//pc�� �̱� ���
					else if((pcNum==2&&userNum==1) || (pcNum==3&&userNum==2) || (pcNum==1&&userNum==3)) {
					   msg = ">>> pc�� �̰���ϴ�!!\n";
				    } 
					//����ڿ� pc�� ��� ���
					else  msg = ">>> �����ϴ�!!\n";	  
				}
				System.out.println(msg);
				
				
				
			} catch (NumberFormatException e) {
				System.out.println("��  ���ڷθ� �Է��ϼ���!!\n");
			}
			
		
		} while (!(userNum == 4)); //userNum == 0 �̸� true�̰� !�� ���� false�� �Ǿ� while�� �������� �� �ִ�. Ż������
		
		sc.close();
	}

}
