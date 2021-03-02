package jdbc.day03;

import java.util.Scanner;

public class MemberCtrl {

	// **** 시작메뉴 **** //
	public void menu_Start(Scanner sc) {
		
		String s_Choice = "";
		do {
			System.out.println("\n >>> --------- 시작메뉴 --------- <<< \n"
							 + "1. 회원가입 	2. 로그인       3. 프로그램 종료");
			System.out.print("▶ 메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
			case "1":	// 회원가입
				memberRegister(sc);
				break;
			case "2":	// 로그인 또는 로그아웃
				
				break;
			case "3":	// 프로그램 종료
				
				break;
			default:
				System.out.println(">>> 메뉴에 없는 번호입니다. 다시 선택하세요! <<<");
			}// end of switch(s_Choice) -------------------------------------------
			
		} while (!("3".equals(s_Choice)));
		
	}// end of public void menu_Start(Scanner sc) ---------------------------------

	
	private void memberRegister(Scanner sc) {
		System.out.println("\n >>> ----- 회원가입 ----- <<< \n");
		System.out.println("1. 아이디 : ");
		String userid = sc.nextLine();
		System.out.println("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		System.out.println("3. 회원명 : ");
		String name = sc.nextLine();
		System.out.println("4. 연락처(휴대폰) : ");
		String tel = sc.nextLine();
		
		
	}// private void memberRegister(Scanner sc) -----------------------------------
	
	
	// **** 회원가입 **** //
	
	

}
