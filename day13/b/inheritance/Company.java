package my.day13.b.inheritance;

public class Company extends Member {	//�ڼ�Ŭ����
// Company Ŭ������ Member Ŭ������ �ڽ� Ŭ������ �Ǿ�����.
// �׷��Ƿ� �ڽ�Ŭ������ Company������ �θ� Ŭ������ Member ���� ����Ǿ��� �͵��� 
// ��ӹ޾� ����� �� �ְ� �ȴ�.
	
	// ����ȸ��
	
	// field
	private String jobType;   //����Ÿ��(������, ���񽺾�, IT, ....)
	private long seedMoney ;	//�ں���

	static int count; //Company ��ü�� ������ �˾ƿ����� �뵵
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
	if(jobType!=null && jobType.trim().isEmpty())      //trim?
	//***null�� ���� �� ������, "      "�� ���� �� ����.
		System.out.println(">> �������� �ùٸ��� �Է��ϼ���! <<");
		else
			this.jobType = jobType;
	}
	
	public long getSeedMoney() {
		return seedMoney;
	}
	
	public void setSeedMoney(long seedMoney) {
		if(0>=seedMoney) {
			System.out.println("�ں����� 0 ���� Ŀ�� �մϴ�. ");
			return;
		} else 
			this.seedMoney = seedMoney;
	}
	
	boolean isUseCompany() {
		if(super.getId()!=null && getPasswd()!=null && getName()!=null&&
		   jobType!=null && seedMoney>0)
			//�θ� field�� �޾ƿ��� �� super�� �Ἥ �޾Ƶ� �ǰ� �׳� �Է��ص� ��밡���ϴ�.
			return true;
		else return false;		
	}
	

	// == �޼ҵ��� ������ (method overriding) @Override == //
	// ==> �θ�Ŭ�����κ��� ��ӹ��� �޼��带 �ڽ�Ŭ�������� �޼��忡 �� ���빰�� ���Ӱ� ����� ���� ���Ѵ�. 
	// ==> ��ӹ��� �޼����� �Ķ���͵� �����ؾ� �������̵� ����!
	
	@Override
	public void setName(String name) {
		if(name!=null && !name.trim().isEmpty() &&
		   2<=name.length() && name.length()<=20)
			super.setCompanyName(name);
	}

	String showCo() {
		return "1. ���̵�: "+getId()+"\n"
			 + "2. ��й�ȣ : "+getPasswd()+"\n"
			 + "3. ȸ��� : "+getName()+"\n"
			 + "4. ���� : "+getJobType()+"\n"
			 + "5. �ں��� : "+getSeedMoney();
		
	}
	
}
