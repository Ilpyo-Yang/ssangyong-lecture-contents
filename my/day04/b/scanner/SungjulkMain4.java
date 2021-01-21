package my.day04.b.scanner;

import java.util.Scanner;

public class SungjulkMain4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Sungjuk sj = new Sungjuk();
		
		int inputType = 0;
		
		try {
			
			System.out.print("1. �й�: ");
			sj.hakbun = sc.nextLine();
			
			System.out.print("2. ����: ");
			sj.name = sc.nextLine();
			
			//0~100
			//byte: -128 ~ 127
			
// === *** ��ȿ�� �˻��ϱ� (�ùٸ� ���������� Ʋ�� ���������� �˻��ϴ� ��) *** ===
			//Integer.parseInt(String str)
			//Short.parseShort(String str)
			
		    inputType = 1; //inputTye ���� 1�̶��, �������� �Է��ϴ� ���̴� ��� ����.
			
			System.out.print("3. ����: ");
			byte kor = Byte.parseByte(sc.nextLine());
			                         // "�ʶ���" "2000" "-50" "90"
			
			if (!sj.cheakJumsu(kor)) {  
				sc.close();
				return;
			} else {
				sj.kor = kor;
			}
			
			System.out.print("4. ����: ");
			byte eng = Byte.parseByte(sc.nextLine());
			if (!sj.cheakJumsu(eng)) {  
				sc.close();
				return;
			} else {
				sj.eng = eng;
			}
			
			
			System.out.print("5. ����: ");
			byte math = Byte.parseByte(sc.nextLine());
			if (!sj.cheakJumsu(math)) { 
				sc.close();
				return;
			} else {
				sj.math = math;
			}
			
			inputType = 2; //inputTye ���� 2�̶��, ���̸� �Է��ϴ� ���̴� ��� ����.
			
			System.out.print("6. ����: ");
			short age = Short.parseShort(sc.nextLine());
			if (!sj.cheakAge(age)) {         //if(false) {} ==> dead code
				sc.close();
				return;
			} else {
				sj.age = age;
			}
			
		   sj.showInfo();
		    
		    /*
		     * === �̼��� ���� ������� ===
		     * 1. �й�: 091234
		     * 2. ����: �̼���
		     * 3. ����: 90
		     * 4. ����: 80
		     * 5. ����: 78
		     * 6. ����: 248
		     * 7. ���: 82.666666667
		     * 8. ����: B
		     * 9. ���� : 20
		     */
			
			
		} catch (NumberFormatException e) {
			if(inputType == 1) 
				System.out.println("## ������ �Է��� 0 �̻� 100 ������ �����մϴ� ##");
			else if (inputType == 2) 
				System.out.println("## ���� �Է��� 20 �̻� 50 ������ �����մϴ� ##");
			
			e.printStackTrace();
		}
		
		/*
		 java.lang.NumberFormatException: Value out of range. Value:"88888888" Radix:10
			at java.lang.Short.parseShort(Unknown Source)
			at java.lang.Short.parseShort(Unknown Source)
			at my.day04.b.scanner.SungjulkMain4.main(SungjulkMain4.java:59)
		 */
				
		sc.close();
	}

}
