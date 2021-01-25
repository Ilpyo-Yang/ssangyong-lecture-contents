package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain2 {

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
			byte kor = Byte.parseByte(sc.nextLine());
			// "�ʶ���" "2000" "-50" "90"
			// 0~100
			// byte: -128 ~ 127
			
			boolean bool = sj.cheakJumsu(kor);
			if (!bool) {  //false���,
				sc.close();
				return;
			} else {
				sj.kor = kor;
			}
			// kor ���� 0 ~ 100 �̶�� true
			// kor ���� 0 �̸� �Ǵ� 100���� ũ�ٶ�� false
			//Main() �޼��� �� return;�� main()�޼��忡�� �۾����� ���� �����ض�� ���̴�.
			//��, ���α׷��� �����ض�� ��
			
			System.out.print("4. ����: ");
			byte eng = Byte.parseByte(sc.nextLine());
			bool = sj.cheakJumsu(eng);
			if (!bool) {  //false���,
				sc.close();
				return;
			} else {
				sj.eng = eng;
			}
			
			
			System.out.print("5. ����: ");
			byte math = Byte.parseByte(sc.nextLine());
			bool = sj.cheakJumsu(math);
			if (!bool) {  //false���,
				sc.close();
				return;
			} else {
				sj.math = math;
			}
			
		} catch (NumberFormatException e) {
			
			System.out.println("## ������ �Է��� 0 �̻� 100 ������ �����մϴ� ##");
			
		}
		
		
		sc.close();
	}

}