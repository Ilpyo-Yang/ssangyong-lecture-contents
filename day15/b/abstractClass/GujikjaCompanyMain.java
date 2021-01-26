package my.day15.b.abstractClass;

import java.util.Scanner;

public class GujikjaCompanyMain {

   public static void main(String[] args) {
      
      Member[] mbrArr = new Member[10];
      
      Gujikja gu1 = new Gujikja();
      gu1.setId("eomjh");
      gu1.setPasswd("qwer1234$A");
      gu1.setName("����ȭ");
      gu1.setJubun("9501252");
      
      if(gu1.isUse()) {
         mbrArr[Member.count++] = gu1;
      }   
      
      
      Gujikja gu2 = new Gujikja();
      gu2.setId("leess");
      gu2.setPasswd("qwer1234$B");
      gu2.setName("�̼���");
      gu2.setJubun("9709251");
      
      if(gu2.isUse()) {
         mbrArr[Member.count++] = gu2;
      }
      
      ////////////////////////////////////////////////////
      
      Company co1 = new Company();
      co1.setId("skcompany");
      co1.setPasswd("abcd1234$C");
      co1.setName("SK");
      co1.setJobType("IT");
      co1.setSeedMoney(20000000);
      
      if(co1.isUse()) {
         mbrArr[Member.count++] = co1;
      }
      
      
      Company co2 = new Company();
      co2.setId("ktcompany");
      co2.setPasswd("abcd1234$D");
      co2.setName("KT");
      co2.setJobType("IT");
      co2.setSeedMoney(30000000);
      
      if(co2.isUse()) {
         mbrArr[Member.count++] = co2;
      }
      
      //////////////////////////////////////////////////
      
      GujikjaCompanyCtrl ctrl = new GujikjaCompanyCtrl();
      
      Scanner sc = new Scanner(System.in);
       
      String smenuNo = "";
      
      Member mbr = null;
      String title = "";
      
      do {
         if(mbr == null)
            title = "======  >>  ���θ޴�  <<  ======== \n";
         
         else {
             String who = (mbr instanceof Gujikja)?"������":"����ȸ��";
            title = "======  >>  ���θ޴�["+who+" "+mbr.getName()+" �α�����..]  <<  ======== \n";   
         }
            
         System.out.println(title
                        + "1. ������ ȸ������    2. ����ȸ�� ȸ������ \n"
                        + "3. ������ �α���       4. ����ȸ�� �α��� \n"
                        + "5. ��� ������ ���   6. ��� ����ȸ�� ��� \n"
                        + "7. �α׾ƿ�              8. ������ �����ϱ� \n"
                        + "9. ���α׷� ����\n");
         
         System.out.print("�� �޴���ȣ ���� => "); 
         smenuNo = sc.nextLine();
         
         switch (smenuNo) {
            case "1": // ������ ȸ������ 
               mbr = ctrl.register(1, sc, mbrArr);
               
               mbrArr[Member.count++] = mbr;
               System.out.println(">> ������ ȸ������ ����!! \n");
               
               break;
   
            case "2": // ����ȸ�� ȸ������
               mbr = ctrl.register(2, sc, mbrArr);
               
               mbrArr[Member.count++] = mbr;
               System.out.println(">> ����ȸ�� ȸ������ ����!! \n");
               
               break;
               
            case "3": // ������ �α���
               if(mbr == null)
                  mbr = ctrl.login(3, sc, mbrArr);
               
               else if(mbr instanceof Gujikja)
                  System.out.println(">> ���� �����ڷ� �α��� �Ǿ��� ���� �Դϴ�!! << \n");
               
               else 
                  System.out.println(">> ���� ����ȸ��� �α��� �Ǿ��� ���� �Դϴ�!! << \n"); 
               
               break;
               
            case "4": // ����ȸ�� �α���
               if(mbr == null)
                  mbr = ctrl.login(4, sc, mbrArr);
               
               else if(mbr instanceof Company)
                  System.out.println(">> ���� ����ȸ��� �α��� �Ǿ��� ���� �Դϴ�!! << \n");
               
               else 
                  System.out.println(">> ���� �����ڷ� �α��� �Ǿ��� ���� �Դϴ�!! << \n");
               
               break;   
               
            case "5": // ��� ������ ���
               ctrl.showAllGujikja(mbrArr);
               break;
               
            case "6": // ��� ����ȸ�� ���
               ctrl.showAllCompany(mbrArr);
               break;
               
            case "7": // �α׾ƿ�
               mbr = null;
               System.out.println(">> �α׾ƿ� �Ǿ����ϴ�. << \n");
               break;   
            
               
            case "8": // ������ �����ϱ�
               if(mbr != null)
                  mbr = ctrl.updateMyInfo(sc, mbr); 
                   // ������ �Ǵ� ����ȸ��� �α��� �Ǿ��� ���� 
               
               else
                  System.out.println(">> ���� �α��� �ϼž� �մϴ�. << \n");
               
               break;
               
               
            default:
               break;
            }
         
      } while (!("9".equals(smenuNo)));

      sc.close();
      
      System.out.println("\n~~~~ ���α׷� ���� ~~~~");
      
   }// end of main()-----------------------------

}// end of public class GujikjaCompanyMain------------
