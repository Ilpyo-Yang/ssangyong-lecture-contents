package my.day16.c.INTERFACE;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		  InterMemberCtrl ctrl = new MemberCtrl();
		  //다형성으로 인터페이스로 객체를 받을 수 있다.
		  
		  Scanner sc = new Scanner(System.in);
		  
		  Member[] mbrArr = new Member[10];
		
		  Gujikja gu1 = new Gujikja();
	      gu1.setId("eomjh");
	      gu1.setPasswd("qwer1234$A");
	      gu1.setName("엄정화");
	      gu1.setJubun("9501252");
	      
	      if(ctrl.isUse(gu1)) {
	         mbrArr[Member.count++] = gu1;
	      }   
	      
	      
	      Gujikja gu2 = new Gujikja();
	      gu2.setId("leess");
	      gu2.setPasswd("qwer1234$B");
	      gu2.setName("이순신");
	      gu2.setJubun("9709251");
	      
	      if(ctrl.isUse(gu2)) {
	         mbrArr[Member.count++] = gu2;
	      }
	      
	      ////////////////////////////////////////////////////
	      
	      Company co1 = new Company();
	      co1.setId("skcompany");
	      co1.setPasswd("abcd1234$C");
	      co1.setName("SK");
	      co1.setJobType("IT");
	      co1.setSeedMoney(20000000);
	      
	      if(ctrl.isUse(co1)) {
	         mbrArr[Member.count++] = co1;
	      }
	      
	      
	      Company co2 = new Company();
	      co2.setId("ktcompany");
	      co2.setPasswd("abcd1234$D");
	      co2.setName("KT");
	      co2.setJobType("IT");
	      co2.setSeedMoney(30000000);
	      
	      if(ctrl.isUse(co2)) {
	         mbrArr[Member.count++] = co2;
	      }
	      
	      
	      do {
		      System.out.println("=== 메인메뉴 ====\n"
	                  + "1. 구직자 회원가입    2. 구인회사 회원가입 \n"
	                  + "3. 구직자 로그인       4. 구인회사 로그인 \n"
	                  + "5. 모든 구직자 출력   6. 모든 구인회사 출력 \n"
	                  + "7. 로그아웃              8. 내정보 변경하기 \n"
	                  + "9. 프로그램 종료\n");
		      System.out.print("▷ 메뉴선택 : ");
		      
		      switch (sc.nextLine()) {
			  
		      
		      case "1":
				if(ctrl.register(sc, mbrArr, 1));
					System.out.println("구직자 회원가입 성공!!");
				
				System.out.println("구직자 회원가입 실패!!");
			    break;
				
			    
			  case "2":
				if(ctrl.register(sc, mbrArr, 2));
					System.out.println("구인회사 회원가입 성공!!");
				
				System.out.println("구인회사 회원가입 실패!!");
				break;
				
				
			  case "3":
				if(ctrl.register(sc, mbrArr, 2));
					System.out.println("구인회사 회원가입 성공!!");
				
				System.out.println("구인회사 회원가입 실패!!");
				break;
					
				
			  case "5":
				ctrl.veiwInfoAll(mbrArr, 1);
				break;
				
				
			  case "6":
				ctrl.veiwInfoAll(mbrArr, 2);
				break;
					
					
			  case "9":
				  System.out.println(">> 프로그램 종료 <<");
				  sc.close(); 
				break;
			  }
		      
		     
		      
	      }while(true);
	      

	      
	      // System.out.println("확인용 Member.count => "+Member.count);
	      //////////////////////////////////////////////////////////////
	      
	      
	/*      
	      // 구직자로 로그인 시도
	      Member mbr = ctrl.login(sc, mbrArr, 1);
	      // 구인회사로 로그인 시도
	      Member mbr = ctrl.login(sc, mbrArr, 2);
	     
	      if(mbr!=null)
	    	  System.out.println(">>> 확인용 "+mbr.getName()+"님 로그인 성공~~");
	      else 
	    	  System.out.println(">>> 확인용 "+mbr.getName()+"님 로그인 실패~~");
	 */	
	      
	      //boolean bool = ctrl.duplicateIdGujikja("eomjh", mbrArr);
	      //System.out.println("확인용 bool => "+bool);
	      
	      
	}//end of public static void main(String[] args)----------------------

    
}
