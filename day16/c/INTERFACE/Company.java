package my.day16.c.INTERFACE;

import java.text.DecimalFormat;

public class Company extends Member {

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
	   
	   
	   // == �޼ҵ��� ������(method overriding  �޼ҵ� �������̵�) == //
	   // ==> �θ�Ŭ������ ��ӹ��� �޼ҵ带 �ڽ� Ŭ�������� �޼ҵ忡 �� ���빰�� ���Ӱ� ����� ���� ���Ѵ�.!!!!! 
	   
	   	   
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
	   
	   // ==> InterMember �������̽��� ���ǵ� �߻�޼���(�̿ϼ��޼���)�� ������ �� ����.
	   @Override
	   public void setName(String name) {
	      
	      if(name != null && !name.trim().isEmpty() &&
	         2<=name.length() && name.length()<=20 ) {
	         super.saveName(name);   
	      }
	      
	   }

		@Override
		public void viewInfo() {
			// TODO Auto-generated method stub
			
		}
 
	
}
