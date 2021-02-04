package io.day.end;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		InterMemberCtrl ctrl = new MemberCtrl();
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Member> mbrList = new ArrayList<>();

		mbrList.add(new Gujikja("eomjh","qwer1234$A","엄정화","9501252"));
		mbrList.add(new Gujikja("leess","qwer1234$B","이순신","9709251"));		
		mbrList.add(new Company("skcompany","abcd1234$C","SK","IT",20000000));
		mbrList.add(new Company("ktcompany","abcd1234$D","KT","IT",30000000));
		
		String smenuNo = "";
		
		mbrList = null;
		String title = "";
		
		do {
			if(mbrList == null)
			   title = "======  >>  메인메뉴  <<  ======== \n";
			
			else {
			    String who = (mbrList(new Gujikja))?"구직자":"구인회사";
				title = "======  >>  메인메뉴["+who+" "+mbrList.get+" 로그인중..]  <<  ======== \n";	
			}
			   
			System.out.println(title
					         + "1. 구직자 회원가입    2. 구인회사 회원가입 \n"
					         + "3. 구직자 로그인       4. 구인회사 로그인 \n"
					         + "5. 모든 구직자 출력   6. 모든 구인회사 출력 \n"
					         + "7. 로그아웃              8. 내정보 변경하기 \n"
					         + "9. 파일에 저장하기    10. 파일로부터 불러오기 \n"
					         + "11. 프로그램 종료\n");
			
			System.out.print("▷ 메뉴번호 선택 => "); 
			smenuNo = sc.nextLine();
			
			switch (smenuNo) {
				case "1": // 구직자 회원가입 
					boolean bool = ctrl.register(sc, mbrList, 1);
					
					if(bool)
						System.out.println(">> 구직자 회원가입 성공!! \n");
					else
						System.out.println(">> 정원초과로 회원가입 실패!! \n");
						
					break;
	
				case "2": // 구인회사 회원가입
					bool = ctrl.register(sc, mbrList, 2);
					
					if(bool)
						System.out.println(">> 구인회사 회원가입 성공!! \n");
					else
						System.out.println(">> 정원초과로 회원가입 실패!! \n");
						
					break;
					
				case "3": // 구직자 로그인
					if(mbrList == null) {
						mbrList = ctrl.login(sc, mbrList, 1);
						if(mbrList != null) 
							System.out.println(">> 로그인 성공!! << \n");
						else
							System.out.println(">> 로그인 실패!! << \n");
					}
					else if(mbrList instanceof Gujikja)
						System.out.println(">> 현재 구직자로 로그인 되어진 상태 입니다!! << \n");
					
					else 
						System.out.println(">> 현재 구인회사로 로그인 되어진 상태 입니다!! << \n"); 
					
					break;
					
				case "4": // 구인회사 로그인
					if(mbrList == null) {
						mbrList = ctrl.login(sc, mbrList, 2);
						if(mbrList != null) 
							System.out.println(">> 로그인 성공!! << \n");
						else
							System.out.println(">> 로그인 실패!! << \n");
					}
					else if(mbrList instanceof Company)
						System.out.println(">> 현재 구인회사로 로그인 되어진 상태 입니다!! << \n");
					
					else 
						System.out.println(">> 현재 구직자로 로그인 되어진 상태 입니다!! << \n");
					
					break;	
					
				case "5": // 모든 구직자 출력
					ctrl.viewInfoAll(mbrList, 1);
					break;
					
				case "6": // 모든 구인회사 출력
					ctrl.viewInfoAll(mbrList, 2);
					break;
					
				case "7": // 로그아웃
					mbrList = null;
					System.out.println(">> 로그아웃 되었습니다. << \n");
					break;	
				
					
				case "8": // 내정보 변경하기
					if(mbrList != null)
						mbrList = ctrl.updateMemberInfo(sc, mbrList); 
					    // 구직자 또는 구인회사로 로그인 되어진 상태 
					
					else
						System.out.println(">> 먼저 로그인 하셔야 합니다. << \n");
					
					break;
					
				case "9":
					ctrl.saveFile(mbrList);
					System.out.println(">> 파일에 저장되었습니다. << \n");
					
					break;	
				case "10": 
					ctrl.openFile(mbrList);
					System.out.println(">> 불러왔습니다. << \n");
					break;	
					
				default:
					break;
				}
			
		} while (!("11".equals(smenuNo)));

		sc.close();
		
		System.out.println("\n~~~~ 프로그램 종료 ~~~~");
		
	}// end of main()------------------------

}
