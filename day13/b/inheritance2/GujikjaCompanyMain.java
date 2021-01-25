package my.day13.b.inheritance2;

import java.util.Scanner;

public class GujikjaCompanyMain {

	public static void main(String[] args) {
		
		Gujikja[] guArr = new Gujikja[5];
		Company[] coArr = new Company[5];
		
		Gujikja gu1 = new Gujikja();
		gu1.setId("eomjh");
		gu1.setPasswd("qwer1234$A");
		gu1.setName("����ȭ");
		gu1.setJubun("9501252");
		
		if(gu1.isUseGujikja()) {
			guArr[Gujikja.count++] = gu1;
		}	
		
	//	System.out.println(gu1.getName());
	//	System.out.println("gu1.isUseGujikja() => " + gu1.isUseGujikja());
		
		Gujikja gu2 = new Gujikja();
		gu2.setId("leess");
		gu2.setPasswd("qwer1234$B");
		gu2.setName("�̼���");
		gu2.setJubun("9709251");
		
		if(gu2.isUseGujikja()) {
			guArr[Gujikja.count++] = gu2;
		}
		
		////////////////////////////////////////////////////
		
		Company co1 = new Company();
		co1.setId("skcompany");
		co1.setPasswd("abcd1234$C");
		co1.setName("SK");
		co1.setJobType("IT");
		co1.setSeedMoney(20000000);
		
		if(co1.isUseCompany()) {
			coArr[Company.count++] = co1;
		}
		
	//	System.out.println(co1.getName());
	//	System.out.println("co1.isUseCompany() => " + co1.isUseCompany());
		
		Company co2 = new Company();
		co2.setId("ktcompany");
		co2.setPasswd("abcd1234$D");
		co2.setName("KT");
		co2.setJobType("IT");
		co2.setSeedMoney(30000000);
		
		if(co2.isUseCompany()) {
			coArr[Company.count++] = co2;
		}
		
		//////////////////////////////////////////////////
		
		GujikjaCompanyCtrl ctrl = new GujikjaCompanyCtrl();
		
		Scanner sc = new Scanner(System.in);
	    
		String smenuNo = "";
		
		Gujikja gu = null;
		Company co = null;
		String title = "";
		
		do {
			
			if (gu==null && co==null)
				title = "======  >>  ���θ޴�  <<  ======== \n";
			else if (co==null && gu!=null)
				title = "======  >>  ���θ޴� [������ "+gu.getName()+"�α��� ��..] <<  ========\n";
			else if (gu==null && co!=null)
				title = "======  >>  ���θ޴� [����ȸ�� "+co.getName()+"�α��� ��..] <<  ========\n";
			
			System.out.println(title
					         + "1. ������ ȸ������    2. ����ȸ�� ȸ������ \n"
					         + "3. ������ �α���       4. ����ȸ�� �α��� \n"
					         + "5. ��� ������ ���   6. ��� ����ȸ�� ��� \n"
					         + "7. �α׾ƿ�              8. ������ �����ϱ�\n"
					         + "9. ���α׷� ����\n");
			
			System.out.print("�� �޴���ȣ ���� => "); 
			smenuNo = sc.nextLine();
			
			switch (smenuNo) {
				case "1": // ������ ȸ������ 
					Gujikja gujikja = ctrl.registerGujikja(sc, guArr);
					guArr[Gujikja.count++] = gujikja;
					System.out.println(">> ������ ȸ������ ����!! \n");
					
					break;
	
				case "2": // ����ȸ�� ȸ������
					Company company = ctrl.registerCompany(sc, coArr);
					coArr[Company.count++] = company;
					System.out.println(">> ����ȸ�� ȸ������ ����!! \n");
					
					break;
					
				case "3": // ������ �α���
					if (co==null && gu!=null)
						System.out.println("\n���� ������ "+gu.getName()+"�� �α��εǾ� �ֽ��ϴ�. �α׾ƿ� �� ������ �ּ���!");
					else if (co!=null && gu!=null)
						System.out.println("\n���� ����ȸ�� "+co.getName()+"�� �α��εǾ� �ֽ��ϴ�. �α׾ƿ� �� ������ �ּ���!");
					else 
						gu = ctrl.loginByGujikja(sc, guArr);
					break;
					
				case "4": // ����ȸ�� �α���
					if (co!=null && gu==null)
						System.out.println("\n���� ����ȸ�� "+co.getName()+"�� �α��εǾ� �ֽ��ϴ�. �α׾ƿ� �� ������ �ּ���!");
					else if (co==null && gu!=null)
						System.out.println("\n���� ������ "+gu.getName()+"�� �α��εǾ� �ֽ��ϴ�. �α׾ƿ� �� ������ �ּ���!");
					else 
						co = ctrl.loginByCompany(sc, coArr);
					break;	
					
				case "5": // ��� ������ ���
					ctrl.showAllGujikja(guArr);
					break;
					
				case "6": // ��� ����ȸ�� ���
					ctrl.showAllCompany(coArr);
					break;
					
				case "7": // �α׾ƿ�
					gu = null;
					co = null;
					System.out.println(">> �α׾ƿ� �Ǿ����ϴ�. <<\n");
					break;	
					
				case "8": // ������ �����ϱ�
					if(gu!=null && co==null)
						gu = ctrl.updateMyInfo(sc, gu); // �����ڷ� �α��εǾ��� ����
					else if(co!=null && gu==null)
						co = ctrl.updateMyInfo(sc, co); // ����ȸ��� �α��εǾ��� ����
					else
						System.out.println("\n>> ���� �α��� �ϼž� �մϴ�. <<\n");
					break;	
					
				default:
					break;
				}
			
		} while (!("9".equals(smenuNo)));

		sc.close();
		
		System.out.println("\n~~~~ ���α׷� ���� ~~~~");
		
	}// end of main()-----------------------------

}
