package my.day11.b.abstraction;

//�÷���??
//����������
//�⺻������
//printf ����ǥ�ؽ�

import java.util.Scanner;
import my.util.MyUtil;

public class GujikjaMain {
	
	public static void main(String[] args) {

		Gujikja[] guArr = new Gujikja[5];   //�÷���??
		
		Gujikja gu1 = new Gujikja();   //�⺻�������� ����
		gu1.userid="leess";
		gu1.passwd="qwer1234$A";
		gu1.name="�̼���";
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
		 
		// === �Ʒ��� ����ǥ������ ����Ͽ� �˻��� ���̴�. 
		//	 bool = MyUtil.isCheckJubun2(null);	
		//	 bool = MyUtil.isCheckJubun2("950");
		//	 bool = MyUtil.isCheckJubun2("754fea");
		//	 bool = MyUtil.isCheckJubun2("9855336");
		//	 bool = MyUtil.isCheckJubun2("9855336");
		 
		//System.out.println(bool);
		 
		//System.out.println("���� => "+gu1.getGender());
		//System.out.println("���� => "+gu1.getAge());
		
		 Gujikja gu2 = new Gujikja();   //�⺻�������� ����
			 gu2.userid="youks";
			 gu2.passwd="qwer1234$B";
			 gu2.name="������";
			 gu2.jubun="8510202";
			 
			 guArr[1] = gu2;
			 Gujikja.count++;
			 
		 Gujikja gu3 = new Gujikja();   //�⺻�������� ����
			 gu3.userid="eomjh";
			 gu3.passwd="qwer1234$B";
			 gu3.name="����ȭ";
			 gu3.jubun="9710202";
			 
			 guArr[2] = gu3;
			 Gujikja.count++;
			 
		////////////////////////////////////////////////////////////////////////////////////	 
		GujikjaCtrl ctrl = new GujikjaCtrl();
					 
		Scanner sc = new Scanner(System.in); //***��ĳ�ʴ� ���� �޼��忡�� �����.
		String smenuNo;
		
		do {
			System.out.println("\n=== ���θ޴� ===\n"
					+ "1. ������ ȸ������	2. ������ ��κ���	3.�˻�	4. ���α׷� ����");
			System.out.print("�� �޴���ȣ ���� => ");
			smenuNo = sc.nextLine();
			
			switch (smenuNo) {
			case "1":	
				Gujikja gujikja = ctrl.register(sc, guArr); //***��ĳ�ʿ� ���� �������� ������ �ѱ��.
				guArr[Gujikja.count++] = gujikja;
				System.out.println(">> ȸ������ ����! <<");
				break;
			case "2":	
				ctrl.showAll(guArr);
				break;
			case "3":   //�˻��޴��� �����ֵ��� ȣ��
				searchMenu(sc, ctrl, guArr); 
				break;
			}
		} while (!("4".equals(smenuNo)));
		
		sc.close();
		System.out.println("\n~~~~~~~ ���α׷� ���� ~~~~~~~~~");
	}
	
		static void searchMenu(Scanner sc, GujikjaCtrl ctrl, Gujikja[] guArr) {    //Main �޼��� �� �޼���
			
			String sMenuNo="";
			do {
				System.out.println("\n=== �˻��޴� ===\n"
						+ "1. ���ɴ�˻�	2. �����˻�	3.���ɴ� �� �����˻�	4. ���ư���\n");
				System.out.print("�� �˻��޴���ȣ ���� =>");
				sMenuNo = sc.nextLine();
				
				switch (sMenuNo) {
				case "1":
					System.out.print("�� ���ɴ� =>");
					String sageline = sc.nextLine();
					int ageline = Integer.parseInt(sageline);	// 20
					ctrl.showByAgeline(guArr, Gujikja.count, ageline);
					break;
				case "2":
					System.out.print("�� ����[��/��] =>");
					String genderGroup = sc.nextLine();
					ctrl.showBygender(guArr, Gujikja.count, genderGroup);
					break;
				case "3":
					System.out.print("�� ���ɴ� =>");
					sageline = sc.nextLine();
					ageline = Integer.parseInt(sageline);
					System.out.print("�� ����[��/��] =>");
					genderGroup = sc.nextLine();
					ctrl.showByAgelineGender(guArr, Gujikja.count, ageline, genderGroup);
					break;
				}// end of switch ------------------------------------------
			} while (!("4".equals(sMenuNo)));
			
		} 
		 
		 
		 
}

