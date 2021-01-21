package my.day11.b.abstraction;

//플랙션??
//접근제어자
//기본생성자
//printf 정규표준식

import java.util.Scanner;
import my.util.MyUtil;

public class GujikjaMain {
	
	public static void main(String[] args) {

		Gujikja[] guArr = new Gujikja[5];   //플랙션??
		
		Gujikja gu1 = new Gujikja();   //기본생성자의 생략
		gu1.userid="leess";
		gu1.passwd="qwer1234$A";
		gu1.name="이순신";
		gu1.jubun="9501151";
		//NullPointerException
		
		//	 bool = MyUtil.isCheckJubun(null);	
		//	 bool = MyUtil.isCheckJubun("950");
		//	 bool = MyUtil.isCheckJubun("754fea");
		//	 bool = MyUtil.isCheckJubun("9855336");
		//	 bool = MyUtil.isCheckJubun("9855336");
		
		String jubun = "9501211";
		Boolean bool = MyUtil.isCheckJubun(jubun);
		
		 if(bool) {
			 gu1.jubun = jubun;
			 guArr[0] = gu1;
			 Gujikja.count++;
		 }
		 
		// === 아래는 정규표현식을 사용하여 검사한 것이다. 
		//	 bool = MyUtil.isCheckJubun2(null);	
		//	 bool = MyUtil.isCheckJubun2("950");
		//	 bool = MyUtil.isCheckJubun2("754fea");
		//	 bool = MyUtil.isCheckJubun2("9855336");
		//	 bool = MyUtil.isCheckJubun2("9855336");
		 
		//System.out.println(bool);
		 
		//System.out.println("성별 => "+gu1.getGender());
		//System.out.println("나이 => "+gu1.getAge());
		
		 Gujikja gu2 = new Gujikja();   //기본생성자의 생략
			 gu2.userid="youks";
			 gu2.passwd="qwer1234$B";
			 gu2.name="유관순";
			 gu2.jubun="8510202";
			 
			 guArr[1] = gu2;
			 Gujikja.count++;
			 
		 Gujikja gu3 = new Gujikja();   //기본생성자의 생략
			 gu3.userid="eomjh";
			 gu3.passwd="qwer1234$B";
			 gu3.name="엄정화";
			 gu3.jubun="9710202";
			 
			 guArr[2] = gu3;
			 Gujikja.count++;
			 
		////////////////////////////////////////////////////////////////////////////////////	 
		GujikjaCtrl ctrl = new GujikjaCtrl();
					 
		Scanner sc = new Scanner(System.in); //***스캐너는 메인 메서드에서 만든다.
		String smenuNo;
		
		do {
			System.out.println("\n=== 메인메뉴 ===\n"
					+ "1. 구직자 회원가입	2. 구직자 모두보기	3.검색	4. 프로그램 종료");
			System.out.print("▷ 메뉴번호 선택 => ");
			smenuNo = sc.nextLine();
			
			switch (smenuNo) {
			case "1":	
				Gujikja gujikja = ctrl.register(sc, guArr); //***스캐너와 기존 구직자의 정보를 넘긴다.
				guArr[Gujikja.count++] = gujikja;
				System.out.println(">> 회원가입 성공! <<");
				break;
			case "2":	
				ctrl.showAll(guArr);
				break;
			case "3":   //검색메뉴를 보여주도록 호출
				searchMenu(sc, ctrl, guArr); 
				break;
			}
		} while (!("4".equals(smenuNo)));
		
		sc.close();
		System.out.println("\n~~~~~~~ 프로그램 종료 ~~~~~~~~~");
	}
	
		static void searchMenu(Scanner sc, GujikjaCtrl ctrl, Gujikja[] guArr) {    //Main 메서드 외 메서드
			
			String sMenuNo="";
			do {
				System.out.println("\n=== 검색메뉴 ===\n"
						+ "1. 연령대검색	2. 성별검색	3.연령대 및 성별검색	4. 돌아가기\n");
				System.out.print("▷ 검색메뉴번호 선택 =>");
				sMenuNo = sc.nextLine();
				
				switch (sMenuNo) {
				case "1":
					System.out.print("▷ 연령대 =>");
					String sageline = sc.nextLine();
					int ageline = Integer.parseInt(sageline);	// 20
					ctrl.showByAgeline(guArr, Gujikja.count, ageline);
					break;
				case "2":
					System.out.print("▷ 성별[남/여] =>");
					String genderGroup = sc.nextLine();
					ctrl.showBygender(guArr, Gujikja.count, genderGroup);
					break;
				case "3":
					System.out.print("▷ 연령대 =>");
					sageline = sc.nextLine();
					ageline = Integer.parseInt(sageline);
					System.out.print("▷ 성별[남/여] =>");
					genderGroup = sc.nextLine();
					ctrl.showByAgelineGender(guArr, Gujikja.count, ageline, genderGroup);
					break;
				}// end of switch ------------------------------------------
			} while (!("4".equals(sMenuNo)));
			
		} 
		 
		 
		 
}

