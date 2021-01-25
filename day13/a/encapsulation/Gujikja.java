package my.day13.a.encapsulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja {

	/*
		   ����������(����������, accessmodifier)   �ڱ��ڽ�Ŭ��������      ������Ű�����ִ´ٸ�Ŭ����      �ٸ���Ű�����ִ�����(�ڽ�)Ŭ����        �׿��ǿ���  
		   ----------------------------------------------------------------------------------------------------------------------- 
		   public                                    O                    O                         O                 O  
		   protected                                 O                    O                         O                 X
		   default                                   O                    O                         X                 X
		   private                                   O                    X                         X                 X
	 */	
	
		//field
		private String userid;
		private String passwd;
		private String name;
		private String jubun;   //�ֹι�ȣ 7�ڸ�		��:9501151 ����	9501152 ���� 
						//�ֹι�ȣ 7�ڸ�		��:0101153 ����	0101154 ����
		
		static int count; //gujikja ��ü�� ������ �˾ƿ����� �뵵
	
		Gujikja() {}      //�����Ǿ� �ִ� �⺻������
		
		
		
		//method     => field�� ó���ϰ��� �� �� ���
		//static �޼��� ������ �ν��Ͻ� �޼��尡 ���� �� ����.
		public void setUserid(String userid) {
			int len = userid.length();
			if(5<=len&&len<=10)
				this.userid = userid;     //���������� �ν��Ͻ������� ����
			else
				System.out.println(">>> ���̵�� 5���� �̻� 10���� �����̾�� �մϴ�. <<<");
		}
		
		public void setPasswd(String passwd) {
			Boolean bool = MyUtil.isCheckPasswd(passwd);
			if (bool) 
				this.passwd = passwd;
			else
				System.out.println(">>> ��ȣ�� 8���� �̻� 15���� ������ ��ҹ���, ����, Ư�����ڷ� ȥ�յǾ�� �մϴ�. <<<");
		}
		
		public void setName(String name) {
			// name���� �ѱ۸� ����ϰڴ�.
			if(name==null) {
				System.out.println(">>> ������ ������� �ѱ۷θ� 2~5���ڱ����� �����մϴ�. <<<");
				return;
			}
			
			// ����ǥ����(Regular Expression)�̶�?
	    	// ==> Ư���� ��Ģ�� ���� ���ڿ��� ������ ǥ���ϱ� ���� ���̴� ���ľ�� 
	    	
	    	// == 1. ����ǥ����(Regular Expression) ������ �ۼ��Ѵ�. ==
			// 2~5 ����, ������ �ȵǰ� �ѱ۸�
	    	Pattern p = Pattern.compile("^[��-�R]{2,5}$"); 	    	
	    	
	    	// == 2. ���ڿ��� �־��� ���Խ����ϰ� ��ġ�ϴ��� �Ǻ��ϴ� ��ü�� �����Ѵ�. ==
	    	Matcher m = p.matcher(name);
	    	
	    	// == 3. �Ǻ��ϵ��� �Ѵ�. ==
	    	//�־��� ���Խ� ���ϰ� ��ġ�ϸ� true, ��ġ���� ������ false�� ���Ͻ����ش�.
	    	boolean b = m.matches();

			if (b) 
				this.name = name;
			else
				System.out.println(">>> ������ ������� �ѱ۷θ� 2~5���ڱ����� �����մϴ�. <<<");
		}
		
		public void setJubun(String jubun) {
			boolean bool = MyUtil.isCheckJubun(jubun);
			if (bool) 
				this.jubun = jubun;
			else
				System.out.println(">>> �ֹι�ȣ 7�ڸ��� �ùٸ��� �ʽ��ϴ�. <<<");
		
		}
		
		// userid, passwd, name, jubun field�� ���� ��� null�� �ƴ϶�� 
		// true�� return ���ְ�, ��� �� �� �̻��� null �̶�� false�� �������ִ� �޼��带 �����Ѵ�.
		
		public boolean isUseGujikja() {
			if(userid!=null &&
				passwd!=null &&
				name!=null &&
				jubun!=null) 
				return true;
			else return false;
		}
		
		public String getName() {
			return name;
		}



		public String getUserid() {
			return userid;
		}



		public String getPasswd() {
			return passwd;
		}



		public String getJubun() {
			return jubun;
		}
		
	
}//end of public class Gujikja ----------------------------------
