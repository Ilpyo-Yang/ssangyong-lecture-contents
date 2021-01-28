package my.day11.b.abstraction;

import java.util.Scanner;

import my.util.MyUtil;

//Main�� ȣ��
//�۵��� ���Ǵ� �ٸ� Ŭ������ �޼��带 Ȱ���ϵ��� �ۼ��Ѵ�
public class GujikjaCtrlNA {
	
// == ������(Gujikja) �ű� ȸ�������� ���ִ� �޼��� �����ϱ� ==
	Gujikja register(Scanner sc, Gujikja[] guArr) {
		
		String userid;
		String passwd;
		String name;
		String jubun;
		
		boolean useridflag;
		do {
			useridflag = false;
			
			System.out.print("1. ���̵� : ");
			userid = sc.nextLine();
			
			//== �ߺ� ���̵� �˻��ϱ� ==//			
			for (int i=0; i<Gujikja.count; i++) {   //5�� �迭 �� ���� ȸ���� 2���̹Ƿ� �˻�� ���Ե� ȸ������ŭ �ؾ��Ѵ�.
				if (userid.equals(guArr[i].userid)) {
					System.out.println(">> �̹� ������� ���̵� �Դϴ�!! <<\n");
					useridflag = true;
					break;
				}
			}		
		} while (useridflag); //���̵� ��ġ�� ������ false���Ƿ� ����������.
		
		///////////////////////////////////////////////////////////////////////////////
		
		do {
			System.out.print("2. ��ȣ : ");
			passwd = sc.nextLine();
			if (!MyUtil.isCheckPasswd(passwd)) {
				System.out.println(">> ��ȣ�� 8���� �̻� 15 ������ ��ҹ��� �� ����, Ư����ȣ�� ȥ�յǾ�� �մϴ�!! <<\n");
			} else break;
		} while (true);
		
		///////////////////////////////////////////////////////////////////////////////
				
		System.out.print("3. ���� : ");
		name = sc.nextLine();
		
		///////////////////////////////////////////////////////////////////////////////
				
		System.out.print("4. �ֹι�ȣ �� 7�ڸ��� : ");
		jubun = sc.nextLine();
		
		do {
			if(!MyUtil.isCheckJubun(jubun)) {
				System.out.println(">> �ֹι�ȣ 7�ڸ��� �ùٸ��� ��������!!  <<\n");
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


	
	// == �������� ������ ��� �����ִ� �޼ҵ� �����ϱ� == 
	   void showAll(Gujikja[] guArr) {
	      
	      System.out.println("------------------------------------------------------");
	      System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
	      System.out.println("------------------------------------------------------");
	      
	      for(int i=0; i<Gujikja.count; i++) {
	         
	      //   guArr[i].showInfo();
	         guArr[i].viewInfo();
	         
	      }// end of for-----------------------
	      
	      System.out.print("\n");
	      
	   }// end of void showAll(Gujikja[] guArr)----------
	   
	   int storedAgeline;
	   Boolean flag, flag2, flag3;
	   
	// == ���ɴ븦 �Է¹޾� �ش� ���ɴ뿡 ���ϴ� ������ ������ ������ִ� �޼��� ==
	   void showByAgeline(Gujikja[] guArr, int gucount, int ageline) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
	       System.out.println("------------------------------------------------------");

		   for (int i=0; i<gucount; i++) {
			   storedAgeline = guArr[i].getAge()/10*10;  //27/10*10 => 20	25/10*10 => 20
			   if(storedAgeline == ageline) {
				   flag = true;
				   guArr[i].viewInfo();
			   } 
		   }
		   if(!flag) {
			   System.out.println(">> �˻��Ͻ� "+ageline+"��� �����ϴ�. <<");
		   }
		   
		   System.out.println("\n");
	   }// end of void showByAgeline(Gujikja[] guArr, int ageline)------------
	   
	   
	   
	// == ������ �Է¹޾� �ش� ���ɴ뿡 ���ϴ� ������ ������ ������ִ� �޼��� ==
	   void showBygender(Gujikja[] guArr, int gucount, String genderGroup) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
	       System.out.println("------------------------------------------------------");

		   for (int i=0; i<gucount; i++) {
			   if(genderGroup.equals(guArr[i].getGender())) {
				   flag2 = true;
				   guArr[i].viewInfo();
			   }
		   }
		   if(!flag2) {
			   System.out.println(">> �˻��Ͻ� "+genderGroup+" �����ڴ� �����ϴ�. <<");
		   }
		   System.out.println("\n");
	   }// end of void showBygender(Gujikja[] guArr, int gucount, String gender)------------
	   
	   
		// == ���ɴ� �� ������ �Է¹޾� �ش� ���ɴ뿡 ���ϴ� ������ ������ ������ִ� �޼��� ==
	   
	
	   void showByboth(Gujikja[] guArr, int gucount, int ageline, String genderGroup) {
		   System.out.println("------------------------------------------------------");
	       System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
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
			   System.out.println(">> �˻��Ͻ� ���ɴ� �� ������ �����ڴ� �����ϴ�. <<");
		   }
	   }
	   
}