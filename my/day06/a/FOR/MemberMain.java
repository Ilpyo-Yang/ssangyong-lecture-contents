package my.day06.a.FOR;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberNA mbr = new MemberNA();
		
		//System.out.println("mbr.id => "+mbr.id);
		//System.out.println("mbr.id 의 문자열 길이 => "+mbr.id.length());
		//null과 "" 는 다름, null은 존재하지 않는 것

		/*
		 	Exception in thread "main" java.lang.NullPointerException
		 	at my.day06.a.FOR.MemberMain2.main(MemberMain2.java:14)
		 */
		
		System.out.println(">>> 회원가입 <<<");
		System.out.println("1. 아이디 : ");
		String id = sc.nextLine();
		System.out.println("2. 비밀번호(8글자 이상 15글자 이하에서 영문자, 숫자, 특수기호가 혼합되어야 함) : ");
		String pwd = sc.nextLine();
		System.out.println("3. 회원명 : ");
		String name = sc.nextLine();
		
		mbr.id = id;
		
		//System.out.println("mbr.id => "+mbr.id);
		//System.out.println("mbr.id => "+mbr.id.length());
		
		if(mbr.checkPwd(pwd)) {
			mbr.pwd = pwd;
		} else {
			System.out.println(">> 비밀번호는 8글자 이상 15글자 이하에서 영문자, 숫자, 특수기호가 혼합되어야 합니다. <<");
			//pwd는 null 값을 가지고 있다
		}
		
		mbr.name = name;

//***NullPointerException 이 발생하지 않게 하기 위해서는 != null 을 고려해야 한다.
//***경우의 수를 고려하여 프로그램 짜기
		if (mbr.id != null && mbr.id.length()>0 && 
			mbr.pwd != null && 
			mbr.name != null && mbr.name.length()>0) {
			System.out.println("== 회원가입 성공!! ==");
		} else System.out.println("== 회원가입 실패!! ==");
	
		sc.close();

	}//end of main

}
