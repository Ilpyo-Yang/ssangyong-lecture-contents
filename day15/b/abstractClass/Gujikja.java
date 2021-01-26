package my.day15.b.abstractClass;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja extends Member {

// 	Gujikja Ŭ������ Member Ŭ������ �ڽ� Ŭ������ �Ǿ�����.
//  �׷��Ƿ� �ڽ� Ŭ������ Gujikja ������ �θ� Ŭ������ Member ���� ����Ǿ��� �͵��� 
//  ��ӹ޾� ����� �� �ְ� �ȴ�.	
	
	// ������ 
	
	// field 
	private String jubun;   // �ֹι�ȣ ���� 7�ڸ� ������   
	                        // ��: "9501151"  ����   "0105103"  ����
	                        // ��: "9501152"  ����   "0105104"  ����
	
	
	
	// method 
	@Override
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
			super.saveName(name);
		
		else 
			System.out.println(">> ������ ������� �ѱ۷θ� 2���� ���� 5���ڱ����� �����մϴ�. <<");
		
	}
	
	public void setJubun(String jubun) {
		
	   boolean bool = MyUtil.isCheckJubun(jubun);
	   
	   if(bool)
		   this.jubun = jubun;
		
	   else 
		   System.out.println(">> �ֹι�ȣ ���� 7�ڸ��� �ùٸ��� �ʽ��ϴ�. <<");
	}
	
	public String getJubun() {
		return jubun;
	}
	
	// == �������� ������ �˾ƿ��� �޼ҵ� ���� == 
	public String getGender() {
		
		String gender = ""; 
		
		switch (jubun.substring(6)) {
			case "1":
			case "3":	
				gender = "��";
				break;
	
			case "2":
			case "4":	
				gender = "��";
				break;
		}// end of switch-------------------
		
		return gender;
		
	}// end of String getGender()-------------
		
		
	// == �������� ���糪�� �˾ƿ��� �޼ҵ� ���� == 
	public int getAge() {
		//  "9501151"   "0105104"
		
		// ���糪�� = ����⵵ - �¾�⵵ + 1 
		
		Calendar currentDate = Calendar.getInstance(); 
		// ���糯¥�� �ð��� ���´�.
		
		int currentYear = currentDate.get(Calendar.YEAR);
		
		String sgenderNum = jubun.substring(6);  
		// "1" �Ǵ� "2" �Ǵ� "3" �Ǵ� "4" 
		
		String sbirthYear = jubun.substring(0, 2); 
		// "95" �Ǵ� "01"
		
		int nbirthYear = Integer.parseInt(sbirthYear); 
		// 95 �Ǵ� 1
		
		if("1".equals(sgenderNum) || "2".equals(sgenderNum)) {
			// �����ڰ� 1900��� ��
			return currentYear - (1900 + nbirthYear) + 1;
		}
		else {
			// �����ڰ� 2000��� ��
			return currentYear - (2000 + nbirthYear) + 1;
		}
		
	}// end of int getAge()------------------- 
	
	
	// (userid, passwd, name, jubun) field ��  ���� ��� null �ƴ϶�� 
	// true �� �������ְ�, ��� 1�� �̻��� null �̶�� false �� �������ִ�
	// �޼ҵ带 �����Ѵ�.
	
	@Override
	public void viewInfo() {
		System.out.printf("%-10s\t%-15s\t%-8s\t%3d\t%-2s\n",getId(),getPasswd(),getName(),getAge(),getGender());
	}// end of public void viewInfo()-------------------
	
	@Override
	public String toString() {
		String info = "1. ���̵� : "+getId()+"\n"
				+"2. ��ȣ : "+getPasswd()+"\n"
				+"3. ���� : "+getName()+"\n"
				+"4. �ֹι�ȣ 7�ڸ� : "+getJubun()+"\n";
								
		return info; 
	}

	// The type Gujikja must implement the inherited abstract method Member.showInfo()
	@Override
	public String showInfo() {
		
		//����
		String gender = "";
		if(jubun.substring(6)=="1"||jubun.substring(6)=="3")
			gender = "����";
		else  gender = "����";
		
		//���糪�� = ����⵵ - (�¾�⵵) + 1
		int age = 0;
		Calendar currentDate = Calendar.getInstance();	// ���糯¥�� �ð��� �˷��ִ� ���̴�.
		int currentYear = currentDate.get(Calendar.YEAR);
		
		//�¾ �⵵
		int birthYear = 0; 
		switch (jubun.substring(6)) {
		case "1":
		case "2":
			birthYear = 1900 + Integer.parseInt(jubun.substring(0, 2));
			// �ֹι�ȣ ���� 2�ڸ��� �о���� �� 
			break;

		default:
			birthYear = 2000 + Integer.parseInt(jubun.substring(0, 2));
			break;
		}
		age = currentYear-birthYear+1;

		
		
		String info = "1. ���̵� : "+getId()+"\n"
				+"2. ��ȣ : "+getPasswd()+"\n"
				+"3. ���� : "+getName()+"\n"
				+"4. �ֹι�ȣ 7�ڸ� : "+getJubun()+"\n"
				+"5. ���� : "+gender+"\n"	
				+"6. ���� : "+age+"��\n";
		return info; 
	}

	@Override
	public boolean isUse() {
		
		if(super.getId() != null &&
		   this.getPasswd() != null &&
		   getName() != null &&
		   jubun != null) 
			return true;
		
		else 
			return false;
	
	}// end of public boolean isUseGujikja()------------------
	

	
} // end of public class Gujikja-----------------





