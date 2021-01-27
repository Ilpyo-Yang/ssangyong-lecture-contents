package my.day16.c.INTERFACE;

import my.util.MyUtil;

public abstract class Member implements InterMember {
// Member Ŭ���������� InterMember �������̽��� �̿ϼ��޼���(�߻�޼���)�� ������(�޼��� �������̵�)�� ���� �ʰڴٴ� ���̹Ƿ�
// Member Ŭ������ �̿ϼ�Ŭ����(==�߻�Ŭ����)�� �Ǿ�� �Ѵ�.
//�������̽��� ������ �θ�Ŭ�������� ������ ���ϰ� �ڽ�Ŭ�������� �������ϰڴ�.

	// Gujikja Ŭ������ Company Ŭ������ �������� ������ �ϴ� field ���� 
	   private String id;      // ���̵�(5���� �̻� 10���� ���ϱ����� ��밡����)
	   private String passwd;  // ��ȣ 
	   private String name;    // �̸�(ȸ���, ���μ���)
	   
	   static int count;  // �ڽ�Ŭ������ Gujikja ��ü(�ν��Ͻ�) 
	                      // �Ǵ� �ڽ�Ŭ������ Company ��ü(�ν��Ͻ�) �� ������ �˾ƿ����� �뵵
	   
	   // Gujikja Ŭ������ Company Ŭ������ �������� ������ �ϴ� method ����
	//   public String getId() {
	   public String getId() {   
	      return id;
	   }
	   
	//   public void setId(String id) {
	   public void setId(String id) {   
	      
	      if(id != null && !id.trim().isEmpty() &&
	         5 <= id.length() && id.length() <= 10 )
	         this.id = id;
	      else
	         System.out.println(">> ���̵�� ���鸸���δ� �Ұ��մϴ�. \n"
	                           + " ���� 5���� �̻� 10���� ���ϱ����� �����մϴ�.<<");
	      
	   }
	   
	   public String getPasswd() {
	      return passwd;
	   }
	   
	   public void setPasswd(String passwd) {

	      boolean bool = MyUtil.isCheckPasswd(passwd);
	      
	      if(bool) 
	         this.passwd = passwd;
	      
	      else 
	         System.out.println(">> ��ȣ�� 8���� �̻� 15���� ������ ����,�ҹ��� �� ����, Ư�����ڰ� ȥ�յǾ�� �մϴ�. <<");
	   }
	   
	   
	   public String getName() {
	      return name;
	   }

	   
	   public void saveName(String name) {
	      this.name = name;
	   }
	   
	   /////////////////////////////////////////////////////
	   
	   // �ڽ�Ŭ������ Gujikja �� Company ���� showInfo()�� ��ӹ޾� 
	   // ����� ���ε� �����ִ� ���빰�� Gujikja �� Company �� �ٸ� ���̴�.
	   // �׷��Ƿ� �θ�Ŭ������ Member ������ showInfo() �޼ҵ带 ������ �ʿ䰡 ����.
	   // �ݵ�� �ڽ�Ŭ������ Gujikja �� Company ������ showInfo() �����Ǹ� �� ���־�� �Ѵ�.
	   // �׷��Ƿ� �θ�Ŭ������ Member ������ showInfo() �޼ҵ带 �̿ϼ�(==�߻�)�޼ҵ�� ������ �Ѵ�.
	  
	   
	   public abstract void viewInfo();

	
}
