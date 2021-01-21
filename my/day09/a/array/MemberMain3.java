package my.day09.a.array;

import java.util.Scanner;

import my.util.MyUtil;

public class MemberMain3 {

	public static void main(String[] args) {
		
		Member2[] mbrArr = new Member2[3];
		
	/*	
		for(int i=0; i<mbrArr.length; i++) {
			System.out.println(mbrArr[i]);
		}

			null
			null
			null
	*/	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">>> 회원가입");
		
		int menuNo = 0;
		
		do {
			System.out.println("\n=========== >> 메뉴 << ==========");
			System.out.println("1. 회원가입 2.모든회원조회 3.프로그램종료");
			System.out.print("▷ 선택하세요 => ");
			try {
				menuNo = Integer.parseInt(sc.nextLine());
				if(!(1<= menuNo && menuNo <=3)) {
					System.out.println(">> 메뉴에 없는 번호입니다 \n");
					continue;
				}
				
				switch (menuNo) {
				case 1:  //회원가입
					Member2 mbr = new Member2();
					
					System.out.print("\n1. 아이디 : ");
					mbr.id = sc.nextLine();
					
					boolean bool = false;
					do {
						System.out.print("2. 비밀번호 : ");
						String passwd = sc.nextLine();
						bool = MyUtil.isCheckPasswd(passwd);
						if(bool) {
							mbr.passwd = passwd;
						} else {
							System.out.println(">> 비밀번호는 8~15 자리 정수로 입력해야 하며, 대소문자, 숫자, 특수문자가 혼합되어야 합니다!!\n");
						}
					} while(!(bool==true));
										
					System.out.print("3. 성명 : ");
					mbr.name = sc.nextLine();
					
					for (int i=0; i<mbrArr.length; i++) {
						if (mbrArr[i] == null) {
							mbrArr[i] = mbr;  //한 번 index에 대입해야 한다. 계속 새로운 값으로 바뀌면 안됨.
							break;
						}
					}
										
					break;
					
				case 2:  //모든회원조회
					
					int nullCount = 0;
					
					for(int i=0; i<mbrArr.length; i++) {
						if(mbrArr[i]!=null) {        //null 여부 꼭 확인하기
							System.out.println(mbrArr[i].showInfo());
						} else nullCount++;
					} 
					if(nullCount==mbrArr.length)
						System.out.println("\n가입된 회원이  0명 입니다.");
					break;

				default:
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println(">> 정수만 입력하세요! <<\n");
			}
			
		} while (!(menuNo==3));
				
		sc.close();	
		System.out.println(">> 프로그램 종료 <<");


	}

}
