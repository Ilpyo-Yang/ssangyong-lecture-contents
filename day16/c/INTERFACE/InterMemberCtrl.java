package my.day16.c.INTERFACE;

import java.util.Scanner;

public interface InterMemberCtrl {
	
	// ������ �ߺ����̵� �˻�
	boolean duplicateIdGujikja(String id,  Member[] mbrArr);
	// ���̵� �̹� �����Ѵٶ�� true �� ����.
	// ���̵� �������� �ʴ´ٶ�� false �� ����.
	
	
	// ����ȸ�� �ߺ����̵� �˻�
	boolean duplicateIdCompany(String id,  Member[] mbrArr);
	// ���̵� �̹� �����Ѵٶ�� true �� ����.
	// ���̵� �������� �ʴ´ٶ�� false �� ����.
		
		
	// ȸ������(������, ����ȸ��)
	boolean register(Scanner sc, Member[] mbrArr, int n);
	
	// �α���(������, ����ȸ��) 
	Member login(Scanner sc, Member[] mbrArr, int n);
	// int n�� n���� 1�̸� �����ڷ� �α���, n���� 2�̸� ����ȸ��� �α���.

	// ��� ȸ������ ���(������, ����ȸ��)
	void veiwInfoAll(Member[] mbrArr, int n);
	// int n�� n���� 1�̸� ������, n���� 2�̸� ����ȸ��.
	
	// Ư�� ȸ�� �� ���� ȸ������ ���(������, ����ȸ��)
	String showInfo(Member mbr);
	
	// ȸ��(������, ����ȸ��)���� ��밡������ �˾ƺ��� ��
	boolean isUse(Member mbr);
	
	// ȸ������ ����(������, ����ȸ��)
	Member updateMemberInfo(Scanner sc, Member[] mbrArr);


}
