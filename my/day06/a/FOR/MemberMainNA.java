package my.day06.a.FOR;

import java.util.Scanner;

public class MemberMainNA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MemberNA mbr = new MemberNA();
		
		System.out.println(">>> ȸ������ <<<");
		System.out.println("1. ���̵� : ");
		String id = sc.nextLine();
		System.out.println("2. ��й�ȣ(8���� �̻� 15���� ���Ͽ��� ������, ����, Ư����ȣ�� ȥ�յǾ�� ��) : ");
		String pwd = sc.nextLine();
		System.out.println("3. ȸ���� : ");
		String name = sc.nextLine();
		
		mbr.id = id;
		
		if(mbr.checkPwd(pwd)) {
			mbr.pwd = pwd;
		} else {
			System.out.println(">> ��й�ȣ�� 8���� �̻� 15���� ���Ͽ��� ������, ����, Ư����ȣ�� ȥ�յǾ�� �մϴ�. <<");
		}
		
		mbr.name = name;
		
		if (mbr.checkPwd(pwd) && mbr.checkOther(pwd) == false) {
			System.out.println("== ȸ������ ����!! ==");
		} else {
			System.out.println("== ȸ������ ����!! ==");
		}
		
		sc.close();

	}//end of main

}
