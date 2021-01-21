package my.day05.a.wrapper;

import java.util.Scanner;

/*
	=== *** wrapper Ŭ���� *** ===
	
	------------------------------------------------
	  �⺻�ڷ���(������, primitive)     wrapper Ŭ����
	------------------------------------------------
	 byte                           Byte 
	 short                          Short
	 int                            Integer  
	 long                           Long
	 char                           Character
	 float                          Float
	 double                         Double
	 boolean                        Boolean 
	 ------------------------------------------------
	 
	  �⺻�ڷ���(������)�� ������ ���� �� 4Ģ���� ������ ����ϴ� ���̰�, 
	 wrapper Ŭ������  ������ ���� �� 4Ģ���� �Ӹ��ƴ϶� 
	  ���� �پ��� ����� �޼ҵ尡 �����ǹǷ� �ٹ������ ���Ǿ�����. 
*/

public class WrapperMain {

	public static void main(String[] args) {

		char ch = 'a';
		System.out.println("cha => "+ch);   //a
		System.out.println(ch+1);  //int�� ��ȯ  97+1=98 
		//�빮�ڿ� �ҹ��� ���̰� 32, A�� 65
		System.out.println((char)(ch-32));  //A
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Character chr = new Character('a');
		System.out.println("cha => "+chr); 
		System.out.println(chr+1); 
		System.out.println((char)(chr-32));  //'A'
		System.out.println((char)('a'-32));  //'A'
		System.out.println(Character.toUpperCase('a'));  
		System.out.println(Character.toLowerCase('A'));
		System.out.println(Character.toUpperCase(97));
		System.out.println(Character.toLowerCase(65));

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		char ch2 = '+';
		
		//char Ÿ���� �񱳿����� ( == != < > <= >= )�� ������ �ڵ������� int Ÿ������ ����ȯ�ȴ�.
		if(65 <= ch2 && ch2 <= 90) {     
			System.out.println(ch2+"�� �빮���Դϴ�.");
		} else if (97 <= ch2 && ch2 <= 122) {
			System.out.println(ch2+"�� �ҹ����Դϴ�.");
		} else if (48 <= ch2 && ch2 <= 57) {
			System.out.println(ch2+"�� �����Դϴ�.");
		} else System.out.println(ch2+"�� ��Ÿ�����Դϴ�.");

		System.out.println("=========================");
		
		if(Character.isUpperCase(ch2)) {     
			System.out.println(ch2+"�� �빮���Դϴ�.");
		} else if (Character.isLowerCase(ch2)) {
			System.out.println(ch2+"�� �ҹ����Դϴ�.");
		} else if (Character.isDigit(ch2)) {
			System.out.println(ch2+"�� �����Դϴ�.");
		} else System.out.println(ch2+"�� ��Ÿ�����Դϴ�.");
		
		System.out.println("*************************");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���ڸ� �Է��ϼ��� => ");  //t
		
		char ch1 = sc.nextLine().charAt(0);    //������ ������ 0���� index
		
		if(Character.isUpperCase(ch1)) {     
			System.out.println(ch1+"�� �빮���Դϴ�.");
		} else if (Character.isLowerCase(ch1)) {
			System.out.println(ch1+"�� �ҹ����Դϴ�.");
		} else if (Character.isDigit(ch1)) {
			System.out.println(ch1+"�� �����Դϴ�.");
		} else System.out.println(ch1+"�� ��Ÿ�����Դϴ�.");
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("=== ����ڽ�, �����ڽ̿� ���ؼ� �˾ƺ��ϴ�. ===");
		
		// Boxing(�ڽ�, ������ �ϴ°�) �̶� ?
	    // ==> �⺻�ڷ���(boolean, byte, short, int, long, char, float, double)���� �Ǿ��� ������ 
	    //     ��üŸ���� Wrapper Ŭ����(Boolean, Byte, Short, Integer, Long, Character, Float, Double)   
	    //     Ÿ���� ��ü�� ������ִ� ���� ���Ѵ�.
		
		int a1 = 10;
		Integer a2 = new Integer(a1);  // Boxing(�ڽ�)
		System.out.println("a2 => "+a2);  //10
		
		int b1 = 10;
		Integer b2 = b1;  // Auto Boxing(����ڽ�)
		System.out.println("b2 => "+b2);  //10
		
		// UnBoxing(��ڽ�, ������ Ǫ�°�) �̶�?   
	    // ==> Wrapper Ŭ����(Boolean, Byte, Short, Integer, Long, Character, Float, Double)�� 
	    //     �Ǿ��� �ִ� ��ü�� �⺻�ڷ���(boolean, byte, short, int, long, char, float, double)���� 
	    //     ������ִ� ���� ���Ѵ�.
		
		Integer a3 = new Integer(20);
		int a4 = a3.intValue();           //UnBoxing(��ڽ�)
		System.out.println("a4 => "+a4);  //20

		int a5 = new Integer(20);           //Auto UnBoxing(�����ڽ�)
		System.out.println("a5 => "+a5);  //20
		
		Double db1 = new Double(21.2345);
		double db2 = db1.doubleValue();           //UnBoxing(��ڽ�)
		System.out.println("db2 => "+db2);  //21.2345
		
		double db3 = new Double(21.2345);         //Auto UnBoxing(�����ڽ�)
		System.out.println("db3 => "+db3);  //21.2345
		
		
		
		sc.close();
		
	}//main

}
