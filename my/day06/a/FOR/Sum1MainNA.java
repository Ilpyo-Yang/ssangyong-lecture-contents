package my.day06.a.FOR;

import java.util.Scanner;

public class Sum1MainNA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ù ��° ������ �Է����ּ��� => ");
		String input1 = sc.nextLine();
		System.out.println("�� ��° ������ �Է����ּ��� => ");
		String input2 =sc.nextLine();
		
		int a = Integer.parseInt(input1);
		int b = Integer.parseInt(input2);
		
		sc.close();
		
		int sum = 0;
		for (; a<=b; a++) {
			sum+=a;
		}
		
		System.out.println(input1+"���� "+input2+"������ ���� "+sum+"�Դϴ�.");
			
	}//end of main

}
