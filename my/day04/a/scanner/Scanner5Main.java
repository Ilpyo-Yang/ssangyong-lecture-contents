package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner5Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== 2개의 숫자를 입력받아서 계산한 결과 알아보기 ==");
		
		String inputStr = "";
		
		try {
			
			System.out.println(">> 첫번째 정수 입력: ");
			inputStr = sc.nextLine();		
			int num1 = Integer.parseInt(inputStr);   
					
			System.out.println(">> 두번째 정수 입력: ");
			inputStr = sc.nextLine();		
			int num2 = Integer.parseInt(inputStr);   
			//문자열을 int타입으로 형변환 시켜주는 것
			
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
			System.out.println(">> "+inputStr+"는 정수가 아닙니다. 정수만 입력하세요!!");
		}
				
		sc.close();		
	}

}
