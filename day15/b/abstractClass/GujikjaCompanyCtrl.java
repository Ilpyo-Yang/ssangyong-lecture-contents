package my.day15.b.abstractClass;

import java.util.Scanner;

public class GujikjaCompanyCtrl {

   // == ������(Gujikja) �� ����ȸ��(Company) �ű� ȸ�������� ���ִ� �޼ҵ� �����ϱ� ==  
   public Member register(int n, Scanner sc, Member[] mbrArr) {
      
      Member mbr = null;
      
      if(n==1) { // ������(Gujikja) �ű� ȸ������
         
         mbr = new Gujikja();
         
         do {
            System.out.print("1. ���̵� : ");
            String id = sc.nextLine(); 
            
            mbr.setId(id);
            id = mbr.getId();
            
            if(id != null) { 
                            
               // == ��ϵǾ��� ������ �߿��� �ߺ����̵� �˻��ϱ� == //
               boolean idFlag = false;
               
               for(int i=0; i<Member.count; i++) {
                  if( mbrArr[i] instanceof Gujikja && id.equals(mbrArr[i].getId()) ) {     
                     System.out.println(">> �̹� ������� ���̵� �Դϴ�. <<\n");
                     idFlag = true;
                     break;
                  }
               }// end of for---------------------
               
               if(!idFlag)
                  break;
            }
            
         } while (true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("2. ��ȣ : ");
            String passwd = sc.nextLine();
            
            mbr.setPasswd(passwd);
            passwd = mbr.getPasswd();
            
            if(passwd != null) 
               break;
            
         } while(true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("3. ���� : ");
            String name = sc.nextLine();
            
            mbr.setName(name);
            name = mbr.getName();
            
            if(name != null)
               break;
            
         } while(true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("4. �ֹι�ȣ ���� 7�ڸ��� : ");
            String jubun = sc.nextLine();
            
            ((Gujikja) mbr).setJubun(jubun); 
            jubun = ((Gujikja) mbr).getJubun();
            
            if(jubun != null) 
               break;
            
         } while(true);   
         
      }
      
      ///////////////////////////////////////////////////
      
      else if(n==2) { // ����ȸ��(Company) �ű� ȸ������
         
         mbr = new Company();
         
         do {
            System.out.print("1. ���̵� : ");
            String id = sc.nextLine(); 
            
            mbr.setId(id);
            id = mbr.getId();
            
            if(id != null) { 
                            
               // == ��ϵǾ��� ����ȸ�� �߿��� �ߺ����̵� �˻��ϱ� == //
               boolean idFlag = false;
               
               for(int i=0; i<Member.count; i++) {
                  if( mbrArr[i] instanceof Company && id.equals(mbrArr[i].getId()) ) {     
                     System.out.println(">> �̹� ������� ���̵� �Դϴ�. <<\n");
                     idFlag = true;
                     break;
                  }
               }// end of for---------------------
               
               if(!idFlag)
                  break;
            }
            
         } while (true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("2. ��ȣ : ");
            String passwd = sc.nextLine();
            
            mbr.setPasswd(passwd);
            passwd = mbr.getPasswd();
            
            if(passwd != null) 
               break;
            
         } while(true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("3. ȸ��� : ");
            String name = sc.nextLine();
            
            mbr.setName(name);
            name = mbr.getName();
            
            if(name != null)
               break;
            
         } while(true);
         
         ////////////////////////////////////////////
         
         do {
            System.out.print("4. ȸ������Ÿ�� : ");
            String jobType = sc.nextLine();
            
            ((Company) mbr).setJobType(jobType);
            jobType = ((Company) mbr).getJobType(); 
            
            if(jobType != null) 
               break;
            
         } while(true);
         
         /////////////////////////////////////////////
         
         do {
            System.out.print("5. �ں��� : ");
            String sseedMoneny = sc.nextLine();
            
            ((Company) mbr).setSeedMoney(Long.parseLong(sseedMoneny));
            long seedMoneny = ((Company) mbr).getSeedMoney();
            
            if(seedMoneny > 0) 
               break;
            
         } while(true);
         
      }
      
      /////////////////////////////////////////////
      
      return mbr;
      
   }// end of public Member register(int n, Scanner sc, Member[] mbrArr)-------
   
   
   // == �������� ������ ��� �����ִ� �޼ҵ� �����ϱ� == 
   public void showAllGujikja(Member[] mbrArr) {
      
      System.out.println("------------------------------------------------------");
      System.out.printf("%-10s\t%-15s\t%-8s\t%-4s\t%-2s\n","���̵�","��ȣ","����","���糪��","����");
      System.out.println("------------------------------------------------------");
      
      for(int i=0; i<Member.count; i++) {
      
         if(mbrArr[i] instanceof Gujikja)
            mbrArr[i].viewInfo();
         
      }// end of for-----------------------
      
      System.out.print("\n");
      
   }// end of public void showAllGujikja(Gujikja[] guArr)----------
   
   
   // == ����ȸ���� ������ ��� �����ִ� �޼ҵ� �����ϱ� == 
   public void showAllCompany(Member[] mbrArr) {
      
      System.out.println("------------------------------------------------------");
      System.out.printf("%-10s\t%-15s\t%-4s\t%-4s\t%-10s\n","���̵�","��ȣ","ȸ���","����","�ں���");
      System.out.println("------------------------------------------------------");
      
      for(int i=0; i<Member.count; i++) {
         
         if(mbrArr[i] instanceof Company)
            mbrArr[i].viewInfo();
         
      }// end of for-----------------------
      
      System.out.print("\n");
      
   }// end of public void showAllCompany(Company[] coArr)----------
   
   
   
   // == ������ �� ����ȸ��� �α��� �ϴ� �޼ҵ� �����ϱ� == 
   public Member login(int n, Scanner sc, Member[] mbrArr) {
      
      Member mbr = null;
      
      System.out.print("\n�����̵� : ");
      String id = sc.nextLine();
      
      System.out.print("����ȣ : ");
      String passwd = sc.nextLine();
      
      for(int i=0; i<Member.count; i++) {
         
         if(n==3 && mbrArr[i] instanceof Gujikja) {
            // �����ڷ� �α���
            
            if( id.equals(mbrArr[i].getId()) && passwd.equals(mbrArr[i].getPasswd()) ) { 
               mbr = mbrArr[i];
               break;
            }

         }
         
         else if(n==4 && mbrArr[i] instanceof Company) {
            // ����ȸ��� �α���
            
            if( id.equals(mbrArr[i].getId()) && passwd.equals(mbrArr[i].getPasswd()) ) { 
               mbr = mbrArr[i];
               break;
            }
         }
         
      }// end of for-----------------------------
      
         
      if(mbr != null)
         System.out.println(">> �α��� ����!! << \n");
      else
         System.out.println(">> �α��� ����!! << \n");
      
      
      return mbr;
      
   }// end of public Member login(int n, Scanner sc, Member[] mbrArr)------------
   
   
   
   // ======= Method Overloading(�޼ҵ� �����ε�) ======== //
   // �޼ҵ��� �̸��� ������ 
   // �Ķ����(�Ű�����)�� ���� �Ǵ� �Ķ������ ���� �Ǵ� �Ķ������ ������ �ٸ���
   // �̸��� ������ ���� �ٸ� �޼ҵ�� ����� �Ѵ�. 
   // �̶� ������ ���� ����Ÿ���� ���� ���� ���谡 ���ٴ� ���̴�.
   // �̷��� ���� "�޼ҵ� �����ε�" �̶�� �θ���. 
   public int abc(int n1, int n2) {
      
      return 0;
   }
   
   public double abc(int m1, double m2) {
      
      return 0.0;
   }
   
   
   public String abc(double y, int x) {
      
      return "�ȳ��ϼ���";
   }
   
   
   // == ������ �Ǵ� ����ȸ���� ������ �����ϱ� �޼ҵ� �����ϱ� == //
   public Member updateMyInfo(Scanner sc, Member mbr) {
      
      System.out.println("\n ~~~~ ������ �����ϱ� ~~~~ \n");

      System.out.println(mbr.showInfo());
      
      if(mbr instanceof Gujikja) {
         // �����ڷ� �α��� �Ǿ��� ���
         
         do {
            System.out.print("�� ��ȣ���� => ");
            String newPasswd = sc.nextLine();  // ����� ��ȣ "12345"
                                               // ����� ��ȣ�� "super1234$A"
            
            mbr.setPasswd(newPasswd);           // ����� ��ȣ "12345"
            String passwd = mbr.getPasswd();    // ��ȣ��å�� ���� ������ 
                                                // passwd �� ������ ��ȣ�̰�, newPasswd �� ��ȣ��å�� ���� �ʴ� ��ȣ 
            
                                                // ����� ��ȣ�� "super1234$A"
                                                // ��ȣ��å�� ������ 
                                                // passwd �� ����� ����ȣ�� �ȴ�.
            if(newPasswd.equals(passwd)) 
               break;
            
         } while(true);
         
         
         do {
            System.out.print("�� ������ => ");
            String newName = sc.nextLine();
            
            mbr.setName(newName);
            String name = mbr.getName();
            
            if(newName.equals(name))
               break;
            
         } while(true);
         
         
         
         do {
            System.out.print("�� �ֹι�ȣ 7�ڸ� ���� => ");
            String newJubun = sc.nextLine();
            
            ((Gujikja) mbr).setJubun(newJubun);
            String jubun = ((Gujikja) mbr).getJubun();
            
            if(newJubun.equals(jubun)) 
               break;
            
         } while(true);
         
      }
      
      else {
         // ����ȸ��� �α��� �Ǿ��� ���
      
         do {
            System.out.print("�� ��ȣ ���� => ");
            String newPasswd = sc.nextLine();
            
            mbr.setPasswd(newPasswd);
            String passwd = mbr.getPasswd();
            
            if(newPasswd.equals(passwd)) 
               break;
            
         } while(true);
         
         
         do {
            System.out.print("�� ȸ��� ���� => ");
            String newName = sc.nextLine();
            
            mbr.setName(newName);
            String name = mbr.getName();
            
            if(newName.equals(name))
               break;
            
         } while(true);
         
         
         do {
            System.out.print("�� ȸ������Ÿ�� ���� => ");
            String newJobType = sc.nextLine();
            
            ((Company) mbr).setJobType(newJobType);
            String jobType = ((Company) mbr).getJobType();
            
            if(newJobType.equals(jobType)) 
               break;
            
         } while(true);
         
         
         do {
            System.out.print("�� �ں��� ���� => ");
            String newSseedMoneny = sc.nextLine();
            
            long newSeedMoneny = Long.parseLong(newSseedMoneny);
            
            ((Company) mbr).setSeedMoney(newSeedMoneny);
            long seedMoneny = ((Company) mbr).getSeedMoney();
            
            if(seedMoneny > 0 && newSeedMoneny == seedMoneny) 
               break;
            
         } while(true);   
         
      }
      
      System.out.println("");  // 1�� ���� 
      
      return mbr;
   }
   
}// end of public class GujikjaCompanyCtrl-----------------