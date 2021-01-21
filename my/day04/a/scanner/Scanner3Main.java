package my.day04.a.scanner;

import java.util.*;

public class Scanner3Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 => ");
		
		try {
			String inputStr = sc.nextLine();      //버퍼를 항상 비울 필요가 없다
			
			int n = Integer.parseInt(inputStr);
			// 문자열(String)을 int타입으로 형변환 시켜주는 메서드가 있다.
			
			System.out.println("입력한 정수에 10을 더한 값: "+n);
		} catch (NumberFormatException e) {
			System.out.println(">>> 정수만 입력하세요!! <<");
			e.printStackTrace();
		}
		
		
		sc.close();
	}

}
