package my.day14.a.accessmodifier;

public class Child1 extends Parent {

	void viewInfo() {
		super.id="leess"; 			// public		���׶��(�ʷϻ�)
		super.passwd="qwer1234$A";  // protected    ������(�����)
		super.name="�̼���";			// default		�ﰢ��(�Ķ���)
	//	super.jubun="";				// private		�簢��(������)	���ٺҰ�
	}
}
