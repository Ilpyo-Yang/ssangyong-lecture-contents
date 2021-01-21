package my.day04.a.scanner;

import java.util.*;

public class Scanner3Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� => ");
		
		try {
			String inputStr = sc.nextLine();      //���۸� �׻� ��� �ʿ䰡 ����
			
			int n = Integer.parseInt(inputStr);
			// ���ڿ�(String)�� intŸ������ ����ȯ �����ִ� �޼��尡 �ִ�.
			
			System.out.println("�Է��� ������ 10�� ���� ��: "+n);
		} catch (NumberFormatException e) {
			System.out.println(">>> ������ �Է��ϼ���!! <<");
			e.printStackTrace();
		}
		
		
		sc.close();
	}

}
