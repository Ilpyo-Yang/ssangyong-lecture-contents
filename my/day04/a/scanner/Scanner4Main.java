package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner4Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== 2���� ���ڸ� �Է¹޾Ƽ� ���� ��� �˾ƺ��� ==");
		
		String inputStr = "";
		
		try {
			System.out.print("1. ù��° ����: ");
			inputStr = sc.nextLine();
			int num1 = Integer.parseInt(inputStr);      //���⼭ ������ ����, catch������ �Ѿ��
		
			System.out.print("2. �ι�° ����: ");
			inputStr = sc.nextLine();
			int num2 = Integer.parseInt(inputStr);
			
			System.out.println(">> ���� ��� : " +num1+ "+" +num2+ "=" +(num1+num2));
			
		} catch (NumberFormatException e) {
			System.out.println(inputStr+"��(��) ������ �ƴϹǷ� ������ �Է��ϼ���!!");			
		}
		
		sc.close();		
	}

}
