package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner5Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== 2���� ���ڸ� �Է¹޾Ƽ� ����� ��� �˾ƺ��� ==");
		
		String inputStr = "";
		
		try {
			
			System.out.println(">> ù��° ���� �Է�: ");
			inputStr = sc.nextLine();		
			int num1 = Integer.parseInt(inputStr);   
					
			System.out.println(">> �ι�° ���� �Է�: ");
			inputStr = sc.nextLine();		
			int num2 = Integer.parseInt(inputStr);   
			//���ڿ��� intŸ������ ����ȯ �����ִ� ��
			
			Calculator calc = new Calculator();
			
			String result = calc.plus(num1, num2);
			System.out.println(result);
			
			result = calc.minus(num1, num2);
			System.out.println(result); //10-20=-10
			
			result = calc.multiply(num1, num2);
			System.out.println(result); //10*20=200
			
			result = calc.devide(num1, num2);
			System.out.println(result); //10/20=0.5
			
			
			/*
			 	10+0=10
				10-0=10
				10*0=0
				10.0/0=Infinity
			 */
			
			
		} catch(NumberFormatException e) {
			System.out.println(">> "+inputStr+"�� ������ �ƴմϴ�. ������ �Է��ϼ���!!");
		}
				
		sc.close();		
	}

}
