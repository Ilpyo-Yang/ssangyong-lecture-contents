package my.day04.a.scanner;

import java.util.*;

public class Scanner2Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� => ");
		
		try {
			int inputNum = sc.nextInt();
			sc.nextLine();
			
			System.out.println("�Է��� ����: "+inputNum);
		} catch (InputMismatchException e) {
			System.out.println(">>> ������ �Է��ϼ���!! <<");
			e.printStackTrace();
		}
		
		
		sc.close();
	}

}
