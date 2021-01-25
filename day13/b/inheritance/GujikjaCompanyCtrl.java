package my.day13.b.inheritance;

import java.util.Scanner;

public class GujikjaCompanyCtrl {
	
	Gujikja gu = new Gujikja();
	Company co = new Company();
	
	public void signGujikja(Scanner sc, Gujikja[] guArr) {
		System.out.println("1.아이디 : ");
		gu.setId(sc.nextLine());
		System.out.println("2.암호: ");
		gu.setPasswd(sc.nextLine());
		System.out.println("3.성명 : ");
		gu.setName(sc.nextLine());
		System.out.println("4.주민번호 7자리: ");
		gu.setJubun(sc.nextLine());
	}
	
	public void signCompany(Scanner sc, Gujikja[] guArr) {
		System.out.print("1.아이디 : ");
		co.setId(sc.nextLine());
		System.out.print("2.암호: ");
		co.setPasswd(sc.nextLine());
		System.out.print("3.회사명 : ");
		co.setCompanyName(sc.nextLine());
		System.out.print("4.직종 : ");
		co.setJobType(sc.nextLine());
		System.out.print("5.자본금 : ");
		co.setSeedMoney(Long.parseLong(sc.nextLine()));
	}
	
	void showGuInfo(Gujikja[] guArr) {
		for (int i=0; i<Gujikja.count; i++) {
			guArr[i].showGu();
		}
		System.out.print("\n");
	}
	
	void showCoInfo(Company[] coArr) {
		for (int i=0; i<Company.count; i++) {
			coArr[i].showCo();
		}
		System.out.print("\n");
	}

}
