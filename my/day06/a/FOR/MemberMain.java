package my.day06.a.FOR;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberNA mbr = new MemberNA();
		
		//System.out.println("mbr.id => "+mbr.id);
		//System.out.println("mbr.id �� ���ڿ� ���� => "+mbr.id.length());
		//null�� "" �� �ٸ�, null�� �������� �ʴ� ��

		/*
		 	Exception in thread "main" java.lang.NullPointerException
		 	at my.day06.a.FOR.MemberMain2.main(MemberMain2.java:14)
		 */
		
		System.out.println(">>> ȸ������ <<<");
		System.out.println("1. ���̵� : ");
		String id = sc.nextLine();
		System.out.println("2. ��й�ȣ(8���� �̻� 15���� ���Ͽ��� ������, ����, Ư����ȣ�� ȥ�յǾ�� ��) : ");
		String pwd = sc.nextLine();
		System.out.println("3. ȸ���� : ");
		String name = sc.nextLine();
		
		mbr.id = id;
		
		//System.out.println("mbr.id => "+mbr.id);
		//System.out.println("mbr.id => "+mbr.id.length());
		
		if(mbr.checkPwd(pwd)) {
			mbr.pwd = pwd;
		} else {
			System.out.println(">> ��й�ȣ�� 8���� �̻� 15���� ���Ͽ��� ������, ����, Ư����ȣ�� ȥ�յǾ�� �մϴ�. <<");
			//pwd�� null ���� ������ �ִ�
		}
		
		mbr.name = name;

//***NullPointerException �� �߻����� �ʰ� �ϱ� ���ؼ��� != null �� ����ؾ� �Ѵ�.
//***����� ���� ����Ͽ� ���α׷� ¥��
		if (mbr.id != null && mbr.id.length()>0 && 
			mbr.pwd != null && 
			mbr.name != null && mbr.name.length()>0) {
			System.out.println("== ȸ������ ����!! ==");
		} else System.out.println("== ȸ������ ����!! ==");
	
		sc.close();

	}//end of main

}
