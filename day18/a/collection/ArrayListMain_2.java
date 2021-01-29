package my.day18.a.collection;

import java.util.*;


/*
		   == ArrayList == 
		   1. ��½� ����� ������� ���´�.
		   2. �ߺ��� �����͸� ������ �� �ִ�.
		   3. �����͸� �о���� �ӵ��� ArrayList �� LinkedList ���� ��������� ������.
		   4. ���������� �����͸� �߰�/�����ϴ� ��쿡�� ArrayList �� LinkedList ���� ��������� ������.
		   5. �Ϲ����� ������ �߰�/������ ������ �߰� �߰����� �߻��ϹǷ� �̷��� ��쿡�� ArrayList �� LinkedList ���� ��������� ������.
		   6. ������� ArrayList �� ����ϵ��� LinkedList �� ����ϵ��� ������ ������� ������.
		   7. LinkedList ���ٴ� ArrayList �� ����ϵ��� ����.
*/

public class ArrayListMain_2 {

   public static void main(String[] args) {
      
      // 1. Member Ŭ������ ��ü���� ������ �� �ִ� ArrayList ��ü mbrList �� �����Ͻÿ�.
      List<Member> mbrList = new ArrayList<>();
      
      // 2. Member Ŭ������ ��ü 6���� �����Ͽ� mbrList �� �����ϼ���.
      mbrList.add(new Member("youjs","qwer1234$","���缮"));
      mbrList.add(new Member("eom","qwer1234$","����ȭ"));
      mbrList.add(new Member("kanghd","qwer1234$","��ȣ��"));
      mbrList.add(new Member("leess","qwer1234$","�̼���"));
      mbrList.add(new Member("kimth","qwer1234$","������"));
      mbrList.add(new Member("kangkc","qwer1234$","������"));
      
      mbrList.add(new Member());
      mbrList.add(new Member("leess","qwer1234$","�̼���"));
      // ArrayList �� �����Ͱ��� ������ ��ü�� ������ �� �ִ�.
      
      mbrList.add(new Member("leemh","qwer1234$","�̹�ȣ"));
      
      // 3. mbrList �� ����Ǿ��� ��� ȸ������ ������ ����ϵ���  
      //    Member Ŭ������ ���ǵ� mbrInfo() �޼ҵ带 �����ϼ���.
      
      // ArrayList mbrList �� ����Ǿ��� �������� ������ mbrList.size() �� �˾ƿ´�. 
      System.out.println(mbrList.size()); // 9
      
      for(int i=0; i<mbrList.size(); i++) {
         mbrList.get(i).infoPrint();
      }
      
      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
      
      for(Member mbr : mbrList) { // mbrList.size() ��ŭ �ݺ��Ѵ�.
         mbr.infoPrint();
      }
      
      System.out.println("\n~~~~~~~~ [����1] ~~~~~~~~~~~~\n");
      /*
        [����1]
        mbrList �� ����Ǿ��� Member ��ü�� �߿���
        id ���� "leess" �� ȸ���� �� ȸ���� ������ ����ϼ���.   
      */
       for(int i=0; i<mbrList.size(); i++) {
          if( "leess".equals(mbrList.get(i).id) )
             mbrList.get(i).infoPrint();
       }
       
       System.out.println("\n---------------------\n");
       
       // �Ǵ�
       for(Member mbr : mbrList) {
          if("leess".equals(mbr.id))
             mbr.infoPrint();
       }
      
      /*
          == �̼��Ŵ��� ȸ������ == 
         1.���̵� : leess
         2.��ȣ : qwer1234$
         3.���� : �̼��� 
      */
      
       System.out.println("\n~~~~~~~~ [����2] ~~~~~~~~~~~~\n");
      /*
        [����2]
        mbrList �� ����Ǿ��� Member ��ü�� �߿���
        name ��  "��" ���� ȸ���� �� ȸ���� ������ ����ϼ���.
        
        name ��  "��" ���� ȸ���� �� ȸ���� ������ ����ϼ���.
        >> ȸ���� "��"���� �����ϴ�. <<   
      */
       
       boolean flag = false;
       
       String firstName = "��";
   //    String firstName = "��";
   
   /*    
       for(int i=0; i<mbrList.size(); i++) { 
          String name = mbrList.get(i).name;
          if( name != null && name.startsWith(firstName) ) {
             flag = true;
             mbrList.get(i).infoPrint();
          }
       }// end of for-------------------------
   */
   // �Ǵ�    
       for(Member mbr : mbrList) { 
          String name = mbr.name;
          if( name != null && name.startsWith(firstName) ) {
             flag = true;
             mbr.infoPrint();
          }
       }// end of for-------------------------
       
       if(!flag) {
          System.out.println("ȸ���� \""+firstName+"\"���� �����ϴ�.");
       }
       

   // *** ArrayList Ÿ���� mbrList �� ���ο� Member ��ü �߰��� 
   //     Ư��  index(��ġ)�� ������ �� �� �ִ�.
      System.out.println("\n ~~~ mbrList �� ���ο� Member ��ü �߰��ϱ� ~~~ ");
      
      mbrList.add(new Member("seolh","qwer1234$","����"));
      // index ���� ������ mbrList �� �� �ڿ� �߰��ȴ�.
      
      mbrList.add(3, new Member("chaew","qwer1234$","������"));
      //         3 �� Ư�� �ε��� �̴�.
      // ���缮(0) ����ȭ(1)  ��ȣ��(2)  �̼���(3) ���� �Ǿ��ִµ�
      // ���缮(0) ����ȭ(1)  ��ȣ��(2)  ������(3)  �̼���(4) ���� �ȴ�.
      
      for(Member mbr : mbrList) {
         mbr.infoPrint();
      }
      
      
      // *** ArrayList Ÿ���� mbrList �� ����Ǿ��� Member ��ü �����ϱ� *** 
      System.out.println("\n ~~~ ArrayList Ÿ���� mbrList �� ����Ǿ��� Member ��ü �����ϱ� ~~~ ");
      
      System.out.println(">> �����ϱ� �� mbrList.size() => " + mbrList.size());
      // >> �����ϱ� �� mbrList.size() => 11
      
      mbrList.remove(3);   // mbrList.remove(������ Member ��ü�� �ε�����ȣ);
      
      System.out.println(">> ������ �� mbrList.size() => " + mbrList.size());
      // >> ������ �� mbrList.size() => 10
      
      for(Member mbr : mbrList) {
         mbr.infoPrint();
      }
      
      
      System.out.println("\n~~~~~~~~ [����3] ~~~~~~~~~~~~\n");
      /*
        [����3]
        mbrList �� ����Ǿ��� Member ��ü�� �߿���
        name ��  "��" ���� ȸ������ �����ϰ�
          ������ �� mbrList �� ����Ǿ��� Member ��ü���� ������ ����ϼ���
      */
      
      firstName = "��";
      
    // >>> �Ʒ��� ���� Ʋ�� Ǯ��!!!! <<<   
    /*
      for(int i=0; i<mbrList.size(); i++) {
         String name = mbrList.get(i).name;
         
         if(name != null && name.startsWith(firstName) ) {
            System.out.println("i => " + i); // 0 1 2 3(�̼���) 4(������) 5 6 7(�̼���) 8(�̹�ȣ)  
                                                   // i => 3
            mbrList.remove(i);  // index ��ȣ 3�� �����ϸ�  
	                                // 0 1 2 3(������) 4 5 6(�̼���) 7(�̹�ȣ) ���� �ε�����ȣ�� ����ȴ�.
	                                
	            
	                                // i => 6
	                                // index ��ȣ 6�� �����ϸ�  
	                                // 0 1 2 3(������) 4 5 6(�̹�ȣ) ���� �ε�����ȣ�� ����ȴ�.
	                                
	                                // �������� for ����  ������ i++ �� ���� i�� 6���� 1������ 7�� �Ǵµ�   
	                                // i �� 7 �� ������ �� �������δ� "��"�� �� �����Ƿ� remove()�ϴ� ������ ���� �ȴ�.
	                                // �׷��� �ε��� ��ȣ 6������ ���� �̹�ȣ�� �������� �ʰ� �״�� �����ְ� �Ǵ� ���̴�.                    
         }
      }
    */   
      
      for(int i=mbrList.size()-1; i>=0; i--) {
         String name = mbrList.get(i).name;
         
         if(name != null && name.startsWith(firstName) ) {
            System.out.println("i => " + i);  // 8(�̹�ȣ) 7(�̼���) 6 5 4(������) 3(�̼���) 2 1 0 
            mbrList.remove(i);                  // 8(�̹�ȣ) �� �����ϸ� 
	                                                // 0 1 2 3(�̼���) 4(������) 5 6 7(�̼���) ���� �Ǿ���.
	                                              
	                                                // 7(�̼���) �� �����ϸ� 
	                                                // 0 1 2 3(�̼���) 4(������) 5 6 ���� �Ǿ���. 
	            
	                                                // 3(�̼���) �� �����ϸ�
	                                                // 0 1 2 3(������) 4 5 6 ���� �Ǿ���.
         }
      }
      
      for(Member mbr : mbrList) {
         mbr.infoPrint();
      }
       
      
      System.out.println("\n~~~~~~~~ [����4] ~~~~~~~~~~~~\n");
      
      /*
        [����4]
        mbrList �� ����Ǿ��� Member ��ü�� �߿���
        Ư���� ����(id �� null �� ��)�� �����ϴ� Member ��ü �ϳ��� �����ϰ�
        �����Ǿ��� �� �ε���(��ġ) �ڸ��� ���ο� Member ��ü�� �־��ֱ�
        �׷��� ���࿡ id �� null �� ���� ���ٶ�� ���ο� Member ��ü�� �� �ڿ� �־��ֱ�
      */
 
      flag = false;
      
      for(int i=mbrList.size()-1; i>=0; i--) {
    	  String id = mbrList.get(i).id;
    	  if(id==null) {				// 6 5(id �� null) 4 3 2 1 0
    		  mbrList.remove(i);    // 5(id �� null) �����ϸ� 
    		                            // 0 1 2 3 4 5(����) ���� �ȴ�.
    		  mbrList.add(i, new Member("seokj","qwer1234$","������"));   // 0 1 2 3 4 5(������) 6(����) ���� �ȴ�.
    	      flag = true;
    	      break;
    	  }
      }
      
      if(!flag)
    	  mbrList.add(new Member("seokj","qwer1234$","������")); 
      
      for(Member mbr : mbrList) {
          mbr.infoPrint();
       }
      
      System.out.println("\n=== mbrList �� ����� ��� ��ü �����ϱ� ===\n");
      mbrList.clear();
      
      System.out.println(">> ������ �� mbrList.size() => " + mbrList.size()); 	// 0
      
       
   }// end of main()----------------------------

}