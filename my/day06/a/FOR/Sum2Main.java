package my.day06.a.FOR;

import java.util.Scanner;

public class Sum2Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;   //������ ���� �����ϴ� �����ν� 0���� �ʱ�ȭ
		String str =""; //�����Ǿ��� ���ڿ� +�� ���ڿ��� �����ؼ� �����ϴ� �����μ� ""���� �ʱ�ȭ	
		
		System.out.print("�����ؾ��� ���� ���� => ");
		int startNo = Integer.parseInt(sc.nextLine());
		System.out.print("�����ؾ��� ������ ���� => ");
		int endNo =Integer.parseInt(sc.nextLine());
		
		for (;;) {   //���ѹݺ���
			try {
				int cnt = endNo-startNo+1;
					
				for (int i=0, j=startNo; i<cnt; i++,j++) {
					if(j<cnt)	str += j+"+";
					else str+=j;
					
					sum+=j;
				}
				break;
				
			//����� ���� ������ ���� �����ϱ�				
			} catch (NumberFormatException e) {
				System.out.println("\n>> ������ �Է��ϼ���!! <<");
				//�ٽ� �ݺ��Է��� �� �ְ� �ϴ� ��� => ���ѹݺ���
			sc.close();	
			}	
		}
	
	//1+2+3+4+5+6+7+8+9+10=55
	
	System.out.print(str+"="+sum);
			
	sc.close();	
	System.out.println("\n>> ���α׷����� <<");	
	}//end of main

}
