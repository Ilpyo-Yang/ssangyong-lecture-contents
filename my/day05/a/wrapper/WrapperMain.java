package my.day05.a.wrapper;

import java.util.Scanner;

/*
	=== *** wrapper 클래스 *** ===
	
	------------------------------------------------
	  기본자료형(원시형, primitive)     wrapper 클래스
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
	 
	  기본자료형(원시형)은 데이터 저장 및 4칙연산 에서만 사용하는 것이고, 
	 wrapper 클래스는  데이터 저장 및 4칙연산 뿐만아니라 
	  아주 다양한 기능의 메소드가 제공되므로 다방면으로 사용되어진다. 
*/

public class WrapperMain {

	public static void main(String[] args) {

		char ch = 'a';
		System.out.println("cha => "+ch);   //a
		System.out.println(ch+1);  //int로 변환  97+1=98 
		//대문자와 소문자 차이가 32, A가 65
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
		
		//char 타입은 비교연산자 ( == != < > <= >= )를 만나면 자동적으로 int 타입으로 형변환된다.
		if(65 <= ch2 && ch2 <= 90) {     
			System.out.println(ch2+"는 대문자입니다.");
		} else if (97 <= ch2 && ch2 <= 122) {
			System.out.println(ch2+"는 소문자입니다.");
		} else if (48 <= ch2 && ch2 <= 57) {
			System.out.println(ch2+"는 숫자입니다.");
		} else System.out.println(ch2+"는 기타문자입니다.");

		System.out.println("=========================");
		
		if(Character.isUpperCase(ch2)) {     
			System.out.println(ch2+"는 대문자입니다.");
		} else if (Character.isLowerCase(ch2)) {
			System.out.println(ch2+"는 소문자입니다.");
		} else if (Character.isDigit(ch2)) {
			System.out.println(ch2+"는 숫자입니다.");
		} else System.out.println(ch2+"는 기타문자입니다.");
		
		System.out.println("*************************");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("한 글자만 입력하세요 => ");  //t
		
		char ch1 = sc.nextLine().charAt(0);    //시작은 무조건 0부터 index
		
		if(Character.isUpperCase(ch1)) {     
			System.out.println(ch1+"는 대문자입니다.");
		} else if (Character.isLowerCase(ch1)) {
			System.out.println(ch1+"는 소문자입니다.");
		} else if (Character.isDigit(ch1)) {
			System.out.println(ch1+"는 숫자입니다.");
		} else System.out.println(ch1+"는 기타문자입니다.");
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("=== 오토박싱, 오토언박싱에 대해서 알아봅니다. ===");
		
		// Boxing(박싱, 포장을 하는것) 이란 ?
	    // ==> 기본자료형(boolean, byte, short, int, long, char, float, double)으로 되어진 변수를 
	    //     객체타입인 Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)   
	    //     타입의 객체로 만들어주는 것을 말한다.
		
		int a1 = 10;
		Integer a2 = new Integer(a1);  // Boxing(박싱)
		System.out.println("a2 => "+a2);  //10
		
		int b1 = 10;
		Integer b2 = b1;  // Auto Boxing(오토박싱)
		System.out.println("b2 => "+b2);  //10
		
		// UnBoxing(언박싱, 포장을 푸는것) 이란?   
	    // ==> Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)로 
	    //     되어져 있는 객체를 기본자료형(boolean, byte, short, int, long, char, float, double)으로 
	    //     만들어주는 것을 말한다.
		
		Integer a3 = new Integer(20);
		int a4 = a3.intValue();           //UnBoxing(언박싱)
		System.out.println("a4 => "+a4);  //20

		int a5 = new Integer(20);           //Auto UnBoxing(오토언박싱)
		System.out.println("a5 => "+a5);  //20
		
		Double db1 = new Double(21.2345);
		double db2 = db1.doubleValue();           //UnBoxing(언박싱)
		System.out.println("db2 => "+db2);  //21.2345
		
		double db3 = new Double(21.2345);         //Auto UnBoxing(오토언박싱)
		System.out.println("db3 => "+db3);  //21.2345
		
		
		
		sc.close();
		
	}//main

}
