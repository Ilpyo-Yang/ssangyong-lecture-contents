package my.day15.b.abstractClass;

import java.text.DecimalFormat;

public class Company extends Member {

//    Company Ŭ������ Member Ŭ������ �ڽ� Ŭ������ �Ǿ�����.
//  �׷��Ƿ� �ڽ� Ŭ������ Company ������ �θ� Ŭ������ Member ���� ����Ǿ��� �͵��� 
//  ��ӹ޾� ����� �� �ְ� �ȴ�.   

   // ����ȸ��
   
   // �ùٸ��� ����
   
   // field
   private String jobType;  // ȸ������Ÿ��(������, ���񽺾�, IT, ....)
   private long seedMoney;  // �ں��� 
   
      
   public String getJobType() {
      return jobType;
   }
   
   public void setJobType(String jobType) {
      
      // jobType ���� "         " �� ���� ���� ���� �� ����.
      if(jobType != null && jobType.trim().isEmpty()) 
         System.out.println(">> �������� �ùٸ��� �Է��ϼ���!! <<");
      
      else 
         this.jobType = jobType;
   }
   
   public long getSeedMoney() {
      return seedMoney;
   }
   
   public void setSeedMoney(long seedMoney) {
      // �ں����� 0 ���� Ŀ�� �Ѵ�.
      
      if(seedMoney > 0)
         this.seedMoney = seedMoney;
      else
         System.out.println(">> �ں����� 0 ���� Ŀ�� �մϴ�. <<");
   }
   
   
   @Override
   public boolean isUse() {
      if( jobType != null && seedMoney > 0 &&
         super.getId() != null && this.getPasswd() != null && getName() != null)
         return true;
      else
         return false;
   }

   // == �޼ҵ��� ������(method overriding  �޼ҵ� �������̵�) == //
   // ==> �θ�Ŭ������ ��ӹ��� �޼ҵ带 �ڽ� Ŭ�������� �޼ҵ忡 �� ���빰�� ���Ӱ� ����� ���� ���Ѵ�.!!!!! 
   @Override
   public void setName(String name) {
      
      if(name != null && !name.trim().isEmpty() &&
         2<=name.length() && name.length()<=20 ) {
         super.saveName(name);   
      }
      
   }
   
   
   @Override
   public void viewInfo() {
      System.out.printf("%-10s\t%-15s\t%-4s\t%-4s\t%-10d\n",getId(),getPasswd(),getName(),getJobType(),getSeedMoney());
   }// end of public void viewInfo()-------------------
   
   
   @Override  // �޼ҵ� �������̵�(�޼ҵ� ������)
   public String toString() {
      
      DecimalFormat df = new DecimalFormat("#,###");
      
      String info = "1. ���̵� : "+getId()+"\n"
                + "2. ��ȣ : "+getPasswd()+"\n"
                + "3. ���� : "+getName()+"\n"
                + "4. ����Ÿ�� : "+jobType+"\n"
                + "5. �ں��� : "+ df.format(seedMoney)+"��\n";
      
      return info;
   }

   //////////////////////////////////////////////////
   
   @Override
   public String showInfo() {
      
      DecimalFormat df = new DecimalFormat("#,###");
      
      String info = "1. ���̵� : "+getId()+"\n"
                + "2. ��ȣ : "+getPasswd()+"\n"
                + "3. ���� : "+getName()+"\n"
                + "4. ����Ÿ�� : "+jobType+"\n"
                + "5. �ں��� : "+ df.format(seedMoney)+"��\n";
      
      return info;   
      
   }
   
}// end of public class Company extends Member------------