package my.day06.a.FOR;

import java.util.Scanner;

public class MemberMainNA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberNA mbr = new MemberNA();
		
		System.out.println(">>> 회원가입 <<<");
		System.out.println("1. 아이디 : ");
		String id = sc.nextLine();
		System.out.println("2. 비밀번호(8글자 이상 15글자 이하에서 영문자, 숫자, 특수기호가 혼합되어야 함) : ");
		String pwd = sc.nextLine();
		System.out.println("3. 회원명 : ");
		String name = sc.nextLine();
		
		mbr.id = id;
		
		if(mbr.checkPwd(pwd)) {
			mbr.pwd = pwd;
		} else {
			System.out.println(">> 비밀번호는 8글자 이상 15글자 이하에서 영문자, 숫자, 특수기호가 혼합되어야 합니다. <<");
		}
		
		mbr.name = name;
		
		if (mbr.checkPwd(pwd) && mbr.checkOther(pwd) == false) {
			System.out.println("== 회원가입 실패!! ==");
		} else {
			System.out.println("== 회원가입 성공!! ==");
		}
		
		sc.close();

	}//end of main

}
