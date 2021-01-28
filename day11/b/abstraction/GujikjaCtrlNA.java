package my.day11.b.abstraction;

import java.util.Scanner;

import my.util.MyUtil;

//Main은 호출
//작동은 거의다 다른 클래스의 메서드를 활용하도록 작성한다
public class GujikjaCtrlNA {
	
// == 구직자(Gujikja) 신규 회원가입을 해주는 메서드 생성하기 ==
	Gujikja register(Scanner sc, Gujikja[] guArr) {
		
		String userid;
		String passwd;
		String name;
		String jubun;
		
		boolean useridflag;
		do {
			useridflag = false;
			
			System.out.print("1. 아이디 : ");
			userid = sc.nextLine();
			
			//== 중복 아이디 검사하기 ==//			
			for (int i=0; i<Gujikja.count; i++) {   //5개 배열 중 기존 회원은 2명이므로 검사는 가입된 회원수만큼 해야한다.
				if (userid.equals(guArr[i].userid)) {
					System.out.println(">> 이미 사용중인 아이디 입니다!! <<\n");
					useridflag = true;
					break;
				}
			}		
		} while (useridflag); //아이디가 겹치지 않으면 false으므로 빠져나간다.
		
		///////////////////////////////////////////////////////////////////////////////
		
		do {
			System.out.print("2. 암호 : ");
			passwd = sc.nextLine();
			if (!MyUtil.isCheckPasswd(passwd)) {
				System.out.println(">> 암호는 8글자 이상 15 이하의 대소문자 및 숫자, 특수기호가 혼합되어야 합니다!! <<\n");
			} else break;
		} while (true);
		
		///////////////////////////////////////////////////////////////////////////////
				
		System.out.print("3. 성명 : ");
		name = sc.nextLine();
		
		///////////////////////////////////////////////////////////////////////////////
				
		System.out.print("4. 주민번호 앞 7자리만 : ");
		jubun = sc.nextLine();
		
		do {
			if(!MyUtil.isCheckJubun(jubun)) {
				System.out.println(">> 주민번호 7자리를 올바르게 넣으세요!!  <<\n");
			} else break;
		} while (true);
		
		///////////////////////////////////////////////////////////////////////////////
		
		Gujikja gu = new Gujikja();
		gu.userid = userid;
		gu.passwd = passwd;
		gu.name = name;
		gu.jubun = jubun;
		
		
		return null;
	}//end of Gujikja register(Scanner sc) ----------------------------------------


	
	// == 구직자의 정보를 모두 보여주는 메소드 생성하기 == 
	   void showAll(Gujikja[] guArr) {
	      
	      System.out.println("------------------------------------------------------");
	      System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","아이디","암호","성명","현재나이","성별");
	      System.out.println("------------------------------------------------------");
	      
	      for(int i=0; i<Gujikja.count; i++) {
	         
	      //   guArr[i].showInfo();
	         guArr[i].viewInfo();
	         
	      }// end of for-----------------------
	      
	      System.out.print("\n");
	      
	   }// end of void showAll(Gujikja[] guArr)----------
	   
	   int storedAgeline;
	   Boolean flag, flag2, flag3;
	   
	// == 연령대를 입력받아 해당 연령대에 속하는 구직자 정보를 출력해주는 메서드 ==
	   void showByAgeline(Gujikja[] guArr, int gucount, int ageline) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","아이디","암호","성명","현재나이","성별");
	       System.out.println("------------------------------------------------------");

		   for (int i=0; i<gucount; i++) {
			   storedAgeline = guArr[i].getAge()/10*10;  //27/10*10 => 20	25/10*10 => 20
			   if(storedAgeline == ageline) {
				   flag = true;
				   guArr[i].viewInfo();
			   } 
		   }
		   if(!flag) {
			   System.out.println(">> 검색하신 "+ageline+"대는 없습니다. <<");
		   }
		   
		   System.out.println("\n");
	   }// end of void showByAgeline(Gujikja[] guArr, int ageline)------------
	   
	   
	   
	// == 성별를 입력받아 해당 연령대에 속하는 구직자 정보를 출력해주는 메서드 ==
	   void showBygender(Gujikja[] guArr, int gucount, String genderGroup) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","아이디","암호","성명","현재나이","성별");
	       System.out.println("------------------------------------------------------");

		   for (int i=0; i<gucount; i++) {
			   if(genderGroup.equals(guArr[i].getGender())) {
				   flag2 = true;
				   guArr[i].viewInfo();
			   }
		   }
		   if(!flag2) {
			   System.out.println(">> 검색하신 "+genderGroup+" 구직자는 없습니다. <<");
		   }
		   System.out.println("\n");
	   }// end of void showBygender(Gujikja[] guArr, int gucount, String gender)------------
	   
	   
		// == 연령대 및 성별을 입력받아 해당 연령대에 속하는 구직자 정보를 출력해주는 메서드 ==
	   
	
	   void showByboth(Gujikja[] guArr, int gucount, int ageline, String genderGroup) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","아이디","암호","성명","현재나이","성별");
	       System.out.println("------------------------------------------------------");
	       
	       showByAgeline(guArr, gucount, ageline);
	       showBygender(guArr, gucount, genderGroup);

		   for (int i=0; i<gucount; i++) {
			   if(flag==true && flag2==true) {
				   flag3 = true;
				   guArr[i].viewInfo();
			   }
		   }
		   if(!flag3) {
			   System.out.println(">> 검색하신 연령대 및 성별의 구직자는 없습니다. <<");
		   }
	   }
	   
}