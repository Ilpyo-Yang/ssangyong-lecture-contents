package jdbc.day04;

import java.util.*;

import jdbc.day04.singleton.dbconnection.MyDBConnection;

public class TotalController {

	
	// attribute, property, 속성
		interMemberDAO mdao = new MemberDAO();
		interBoardDAO bdao = new BoardDAO();
	
	
	// *** 시작메뉴 *** //
	public void menu_Start(Scanner sc) {
		
		MemberDTO member = null;
		
		String s_Choice = "";
		do {
			
			String loginName = (member!=null)?"["+member.getName()+" 로그인 중 ..]":"";
			String login_logout = (member!=null)?"로그아웃":"로그인";
			
			System.out.println("\n >>> --------- 시작메뉴 "+loginName+"--------- <<< \n"
							 + "1. 회원가입     2. "+login_logout+"     3. 프로그램 종료\n");
			System.out.print("▶ 메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
			case "1":	// 회원가입
				memberRegister(sc);
				break;
				
			case "2":	// 로그인 또는 로그아웃
			
			  	if("로그인".equals(login_logout))	 member = login(sc);	// 로그인
			 
				else {
					member = null;	// 로그아웃
					System.out.println(">> 로그아웃되었습니다. <<");
				}
			
				
				
				
				break;
				
			case "3":	// 프로그램 종료
				// Connection 객체 자원반납.
				MyDBConnection.closeConnection(); 		
				break;
				
			default:
				System.out.println(">>> 메뉴에 없는 번호입니다. 다시 선택하세요! <<<");
			}// end of switch(s_Choice) -------------------------------------------
			
		} while (!("3".equals(s_Choice)));
		
	}// end of public void menu_Start(Scanner sc) --------------------------




	// **** 회원가입 **** //
	private void memberRegister(Scanner sc) {
		System.out.println("\n >>> ----- 회원가입 ----- <<< \n");
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		System.out.print("3. 회원명 : ");
		String name = sc.nextLine();
		System.out.print("4. 연락처(휴대폰) : ");
		String mobile = sc.nextLine();
		
		MemberDTO member = new MemberDTO();
		member.setUserid(userid);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMobile(mobile);
		
		int n = mdao.memberRegister(member, sc);
		// 0 => 회원가입을 취소한 것임.
		// 1 => 정상적으로 회원가입한 것임.
		// -1 => 사용자 아이디에 중복이 발생한 것임.
		// -2 => SQL 구문에 오류발생한 것임.
		
		if(n==0) {
			System.out.println("\n >>> 회원가입을 취소했습니다. <<< \n");
		} else if(n==1) {
			System.out.println("\n >>> 회원가입을 축하드립니다. <<< \n");
		} else if(n==-1) {
			System.out.println("\n >>> 아이디가 이미 사용중이므로 다른 아이디를 입력하세요. <<< \n");
		} else if(n==-2) {
			System.out.println("\n >>> SQL 구문에 오류가 발생함!! <<< \n");
		}
		
	}
	
	
	// **** 로그인하기 **** //
	private MemberDTO login(Scanner sc) {
		MemberDTO member = null;
		
		System.out.println("\n >>> ----- 로그인하기 ----- <<< \n");
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("passwd", passwd);
		
		member = mdao.login(paraMap);
		
		
		return member;
	}
}
