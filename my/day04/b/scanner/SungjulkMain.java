package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Sungjuk sj = new Sungjuk();
		
		try {
			
			System.out.print("1. �й�: ");
			sj.hakbun = sc.nextLine();
			
			System.out.print("2. ����: ");
			sj.name = sc.nextLine();
			
			//0~100
			//byte: -128 ~ 127
			
			System.out.print("3. ����: ");
			Byte.parseByte(sc.nextLine());
			
			//	if(sj.kor < 0 || sj.kor > 100 )
			if(!(0 < sj.kor && sj.kor <= 100)) {
				System.out.println(">> ������ �Է��� 0 �̻� 100 ������ �����մϴ� <<");
				sc.close();
				return;
			}
			//Main() �޼��� �� return;�� main()�޼��忡�� �۾����� ���� �����ض�� ���̴�.
			//��, ���α׷��� �����ض�� ��
			
			System.out.print("4. ����: ");
			sj.eng = Byte.parseByte(sc.nextLine());
			
			System.out.print("5. ����: ");
			sj.math = Byte.parseByte(sc.nextLine());
			
		} catch (NumberFormatException e) {
			
			System.out.println(">> ������ �Է��� 0 �̻� 100 ������ �����մϴ� <<");
			
		}
		
		
		sc.close();
	}

}
