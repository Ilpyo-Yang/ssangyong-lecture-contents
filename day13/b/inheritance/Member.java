package my.day13.b.inheritance;
//getter and setter ã�ƺ���
//get�� �Ӽ����� �ѱ� ��, private�� �Ǿ��� �� ���ϴ� ������� �ѱ�?
//set�� �Ķ���� ���� ������ ������ �� �� ���?

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Member {  //�θ�Ŭ����

	//Gujikja Ŭ������ Company Ŭ������ �������� ������ �ϴ� field �� �����.
	private String id;
	private String passwd;
	private String name;
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		if(id!=null && id.trim().isEmpty()&&
				5<=id.length() && id.length()<=10) {
			System.out.println(">> ���̵�� ���鸸���� �Ұ��մϴ� \n"
					+ " ���� 5���� �̻� 10���� ���ϱ����� �����մϴ�. <<");	
		} else	{
			this.id = id;
		}
		
			
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		boolean bool = MyUtil.isCheckPasswd(passwd);
		if (bool) 
			this.passwd = passwd;
		else
			System.out.println(">>> ��ȣ�� 8���� �̻� 15���� ������ ��ҹ���, ����, Ư�����ڷ� ȥ�յǾ�� �մϴ�. <<<");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
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
	
	/////////////////////////////////////////////////////////////
	public void setCompanyName(String name) {
		this.name = name;
	} 
	
	
	
}
