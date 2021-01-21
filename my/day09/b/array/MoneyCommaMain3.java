package my.day09.b.array;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MoneyCommaMain3 {

	public static void main(String[] args) {
		
		System.out.print("�� �ݾ��� �Է��ϼ���(�����θ�) => ");
		Scanner sc = new Scanner(System.in);
		long money = Long.parseLong(sc.nextLine());
		
		DecimalFormat df = new DecimalFormat("#,###");
		String smoney = df.format(money);
		System.out.println(smoney);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.print("�� �ݾ��� �Է��ϼ���(�����θ�) => ");
		String inputStr = sc.nextLine();
		int len = inputStr.length();   // �Է¹��� ���ڿ��� ����
		int commaCount = len/3;
		commaCount = (len%3==0)?commaCount-1:commaCount;
		
		/*
		 	if(len%3==0) commaCount-=1;        // ���� ǥ��
		 	
		 	-------------------      -----------------------
		 	|1|2|3|4|5|6|7|8|9|  ��   |1|2|3|,|4|5|6|,|7|8|9|
		 	-------------------      -----------------------
		 */
		
		char[] moneyArr = inputStr.toCharArray();
		char[] outputArr = new char[len+commaCount];
		
		//�ڿ��� ���� ���ڸ� ä���, �ڿ��� 4�ڸ� ������ ,
		int cnt = 0; // �ݺ�Ƚ��
		
		for (int i=outputArr.length-1,j=moneyArr.length-1; i>=0; i--,j--) {
			cnt++;
			if(cnt%4!=0) {
				outputArr[i]=moneyArr[j];
			} else {
				outputArr[i]=',';
				j++;
			}
		}
		
		System.out.println(outputArr);
		
		sc.close();
	}

}
