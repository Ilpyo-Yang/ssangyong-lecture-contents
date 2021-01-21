package my.day04.a.scanner;

import java.util.Scanner;

public class Scanner4Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== 2개의 숫자를 입력받아서 더한 결과 알아보기 ==");
		
		String inputStr = "";
		
		try {
			System.out.print("1. 첫번째 정수: ");
			inputStr = sc.nextLine();
			int num1 = Integer.parseInt(inputStr);      //여기서 오류가 나면, catch문으로 넘어간다
		
			System.out.print("2. 두번째 정수: ");
			inputStr = sc.nextLine();
			int num2 = Integer.parseInt(inputStr);
			
			System.out.println(">> 더한 결과 : " +num1+ "+" +num2+ "=" +(num1+num2));
			
		} catch (NumberFormatException e) {
			System.out.println(inputStr+"은(는) 정수가 아니므로 정수로 입력하세요!!");			
		}
		
		sc.close();		
	}

}
