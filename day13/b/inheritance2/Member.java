package my.day13.b.inheritance2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Member {

	// Gujikja Ŭ������ Company Ŭ������ �������� ������ �ϴ� field ���� 
	private String id;      // ���̵�(5���� �̻� 10���� ���ϱ����� ��밡����)
	private String passwd;  // ��ȣ 
	private String name;    // �̸�(ȸ���, ���μ���)
	
	
	// Gujikja Ŭ������ Company Ŭ������ �������� ������ �ϴ� method ����
	public String getId() {
		return id;
	}
	
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
	
	public void setName(String name) {
		
		// name ���� �ѱ۸� ����ϰڴ�.
		
		if(name == null) {
			System.out.println(">> ������ ������� �ѱ۷θ� 2���� ���� 5���ڱ����� �����մϴ�. <<");
		    return;
		}
		
		// ����ǥ����(Regular Expression)�̶�?
		// ==> Ư���� ��Ģ�� ���� ���ڿ��� ������ ǥ���ϱ� ���� ���̴� ���ľ��
		
		// == 1. ����ǥ����(Regular Expression) ������ �ۼ��Ѵ�. == //
		Pattern p = Pattern.compile("^[��-�R]{2,5}$");
		
		// == 2. ���ڿ��� �־��� ���Խ� ���ϰ� ��ġ�ϴ��� �Ǻ��ϴ� ��ü�� �����Ѵ�. == //
		Matcher m = p.matcher(name);
		
		// == 3. �Ǻ��ϵ��� �Ѵ�. == //
		// �־��� ���Խ� ���ϰ� ��ġ�ϸ�  true, ��ġ���� ������ false �� ���Ͻ����ش�.
		boolean b = m.matches();
		
		if(b) 
			this.name = name;
		
		else 
			System.out.println(">> ������ ������� �ѱ۷θ� 2���� ���� 5���ڱ����� �����մϴ�. <<");
		
	}
	
	///////////////////////////////////////////
	public void setCompanName(String name) {
		this.name = name;
	}
	
	
	
}
