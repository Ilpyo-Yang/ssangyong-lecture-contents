package my.day17.b.userDefineException;

// == �����(������)�� �����ϴ� ����(�ͼ���)�� Ŭ���� ����� == //
/*
 	1. Exception Ŭ������ ��ӹ޾ƾ� �Ѵ�.
 	2. �����ڿ��� ���ܸ޽���(�����޽���)�� ������ָ� ������.
 */

public class JangolackException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// �⺻������
	public JangolackException() {
		super(">> �ܰ��� �ֹ������� �����Ƿ� �ֹ��� �Ұ��մϴ�. <<\n");
	}
	
	// �Ķ���Ͱ� �ִ� ������
	public JangolackException(String errMsg)  {
		super(errMsg);
	}
	
	
}
