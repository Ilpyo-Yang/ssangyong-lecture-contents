package my.day13.b.inheritance;

import my.util.MyUtil;

public class Gujikja extends Member {	//�ڼ�Ŭ����
// Gujikja Ŭ������ Member Ŭ������ �ڽ� Ŭ������ �Ǿ�����.
// �׷��Ƿ� �ڽ�Ŭ������ Gujikja������ �θ� Ŭ������ Member ���� ����Ǿ��� �͵��� 
// ��ӹ޾� ����� �� �ְ� �ȴ�.
	
		//������
	
		//field
		private String jubun;   //�ֹι�ȣ 7�ڸ�		��:9501151 ����	9501152 ���� 
								//�ֹι�ȣ 7�ڸ�		��:0101153 ����	0101154 ����
		
		static int count; //gujikja ��ü�� ������ �˾ƿ����� �뵵
	
		Gujikja() {}      //�����Ǿ� �ִ� �⺻������
		
		
		//method     => field�� ó���ϰ��� �� �� ���
		//static �޼��� ������ �ν��Ͻ� �޼��尡 ���� �� ����.

		
		public void setJubun(String jubun) {
			boolean bool = MyUtil.isCheckJubun(jubun);
			if (bool) 
				this.jubun = jubun;
			else
				System.out.println(">>> �ֹι�ȣ 7�ڸ��� �ùٸ��� �ʽ��ϴ�. <<<");
		
		}
		
		public String getJubun() {
			return jubun;
		}
		
		// userid, passwd, name, jubun field�� ���� ��� null�� �ƴ϶�� 
		// true�� return ���ְ�, ��� �� �� �̻��� null �̶�� false�� �������ִ� �޼��带 �����Ѵ�.
		
		public boolean isUseGujikja() {
			if(super.getId()!=null &&
			   this.getPasswd()!=null &&
			   getName()!=null &&
			   jubun!=null) 
			   return true;
			else return false;
		}
		
		String showGu() {
			return "1. ���̵�: "+getId()+"\n"
				 + "2. ��й�ȣ : "+getPasswd()+"\n"
				 + "3. �̸� : "+getName()+"\n"
				 + "4. �ֹι�ȣ : "+getJubun();
			
		}
		
}//end of public class Gujikja ----------------------------------
