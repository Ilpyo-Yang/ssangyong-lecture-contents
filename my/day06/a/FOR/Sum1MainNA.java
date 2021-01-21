package my.day06.a.FOR;

import java.util.Scanner;

public class Sum1MainNA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 정수를 입력해주세요 => ");
		String input1 = sc.nextLine();
		System.out.println("두 번째 정수를 입력해주세요 => ");
		String input2 =sc.nextLine();
		
		int a = Integer.parseInt(input1);
		int b = Integer.parseInt(input2);
		
		sc.close();
		
		int sum = 0;
		for (; a<=b; a++) {
			sum+=a;
		}
		
		System.out.println(input1+"에서 "+input2+"까지의 합은 "+sum+"입니다.");
			
	}//end of main

}
