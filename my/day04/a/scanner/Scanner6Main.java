package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner6Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== ������ ���ڿ��� ����ȯ ��Ű�� ==");
		
		System.out.print("1. ù��° ����: ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("2. �ι�° ����: ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println(num1 + num2);
		
		//������ ���ڿ��� �ٲٴ� ù��° ���
		String str1 = Integer.toString(num1);  //"10"
		
		//������ ���ڿ��� �ٲٴ� �ι�° ���
		String str2 = String.valueOf(num2);    //"20"
		System.out.println(str1+str2);         //"1020"
		
		sc.close();		
	}

}
