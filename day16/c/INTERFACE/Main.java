package my.day16.c.INTERFACE;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		  InterMemberCtrl ctrl = new MemberCtrl();
		  //���������� �������̽��� ��ü�� ���� �� �ִ�.
		  
		  Scanner sc = new Scanner(System.in);
		  
		  Member[] mbrArr = new Member[10];
		
		  Gujikja gu1 = new Gujikja();
	      gu1.setId("eomjh");
	      gu1.setPasswd("qwer1234$A");
	      gu1.setName("����ȭ");
	      gu1.setJubun("9501252");
	      
	      if(ctrl.isUse(gu1)) {
	         mbrArr[Member.count++] = gu1;
	      }   
	      
	      
	      Gujikja gu2 = new Gujikja();
	      gu2.setId("leess");
	      gu2.setPasswd("qwer1234$B");
	      gu2.setName("�̼���");
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
		      System.out.println("=== ���θ޴� ====\n"
	                  + "1. ������ ȸ������    2. ����ȸ�� ȸ������ \n"
	                  + "3. ������ �α���       4. ����ȸ�� �α��� \n"
	                  + "5. ��� ������ ���   6. ��� ����ȸ�� ��� \n"
	                  + "7. �α׾ƿ�              8. ������ �����ϱ� \n"
	                  + "9. ���α׷� ����\n");
		      System.out.print("�� �޴����� : ");
		      
		      switch (sc.nextLine()) {
			  
		      
		      case "1":
				if(ctrl.register(sc, mbrArr, 1));
					System.out.println("������ ȸ������ ����!!");
				
				System.out.println("������ ȸ������ ����!!");
			    break;
				
			    
			  case "2":
				if(ctrl.register(sc, mbrArr, 2));
					System.out.println("����ȸ�� ȸ������ ����!!");
				
				System.out.println("����ȸ�� ȸ������ ����!!");
				break;
				
				
			  case "3":
				if(ctrl.register(sc, mbrArr, 2));
					System.out.println("����ȸ�� ȸ������ ����!!");
				
				System.out.println("����ȸ�� ȸ������ ����!!");
				break;
					
				
			  case "5":
				ctrl.veiwInfoAll(mbrArr, 1);
				break;
				
				
			  case "6":
				ctrl.veiwInfoAll(mbrArr, 2);
				break;
					
					
			  case "9":
				  System.out.println(">> ���α׷� ���� <<");
				  sc.close(); 
				break;
			  }
		      
		     
		      
	      }while(true);
	      

	      
	      // System.out.println("Ȯ�ο� Member.count => "+Member.count);
	      //////////////////////////////////////////////////////////////
	      
	      
	/*      
	      // �����ڷ� �α��� �õ�
	      Member mbr = ctrl.login(sc, mbrArr, 1);
	      // ����ȸ��� �α��� �õ�
	      Member mbr = ctrl.login(sc, mbrArr, 2);
	     
	      if(mbr!=null)
	    	  System.out.println(">>> Ȯ�ο� "+mbr.getName()+"�� �α��� ����~~");
	      else 
	    	  System.out.println(">>> Ȯ�ο� "+mbr.getName()+"�� �α��� ����~~");
	 */	
	      
	      //boolean bool = ctrl.duplicateIdGujikja("eomjh", mbrArr);
	      //System.out.println("Ȯ�ο� bool => "+bool);
	      
	      
	}//end of public static void main(String[] args)----------------------

    
}
