package my.day13.b.inheritance;

import java.util.Scanner;

public class GujikjaCompanyMain {
	
	public static void main(String[] args) {
		
		GujikjaCompanyCtrl ctrl = new GujikjaCompanyCtrl();
		
		Gujikja[] guArr = new Gujikja[5];
		Company[] coArr = new Company[5];

		Gujikja gu1 = new Gujikja();
		gu1.setId("eomjh");
		gu1.setPasswd("qwer1234$A");
		gu1.setName("����ȭ");
		gu1.setJubun("9501252");
		
		guArr[0] = gu1;
		Gujikja.count++;
		
		Gujikja gu2 = new Gujikja();
		gu2.setId("leess");
		gu2.setPasswd("qwer1514$A");
		gu2.setName("�̼���");
		gu2.setJubun("9501251");
		
		guArr[1] = gu2;
		Gujikja.count++;
		
		//System.out.println(gu1.getName());
		//System.out.println("gu1.isUseGujikja() => "+gu1.isUseGujikja());
		
		Company co1 = new Company();
		co1.setId("mycompany");
		co1.setPasswd("qwer1234$B");
		co1.setName("SK");
		co1.setJobType("IT");
		co1.setSeedMoney(200000000);
		
		coArr[0] = co1; 
		Company.count++;
		
		Company co2 = new Company();
		co2.setId("yourcompany");
		co2.setPasswd("qaer1234$B");
		co2.setName("CJ");
		co2.setJobType("������");
		co2.setSeedMoney(200000000);
		
		coArr[1] = co2; 
		Company.count++;
		
		//System.out.println(co1.getName()); //***��ȿ�� �˻�
		//System.out.println("co1.isUseCompany() => "+co1.isUseCompany());
		
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("=== >> ���θ޴� << ===\n"
					+ "1.������ ȸ������ 		2.����ȸ�� ȸ������ \n"
					+ "3.������ �α��� 		4.����ȸ�� �α��� \n"
					+ "5.��� ������ ��� 		6.��� ����ȸ�� ���\n"
					+ "7.�α׾ƿ� 		8.���α׷�����");
			System.out.print("�� �޴���ȣ ���� ==> ");
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				ctrl.signGujikja(sc,guArr);
				break;

			case "2":
				//coCtrl.signGujikja(sc,guArr);
				break;

			case "5":
				ctrl.showGuInfo(guArr);
				break;
			case "6":
				ctrl.showCoInfo(coArr);
				break;
			}

		
		} while(true);
		
		
	}//end of main ----------------------------

}
