package my.day14.b.accessmodifier;

import my.day14.a.accessmodifier.Parent;

public class Child2 extends Parent {

	void viewInfo() {
		super.id="leess"; 			// public		���׶��(�ʷϻ�)
		super.passwd="qwer1234$A";  // protected    ������(�����)
	//	super.name="�̼���";			// default		�ﰢ��(�Ķ���)	���ٺҰ�
	//	super.jubun="";				// private		�簢��(������)	���ٺҰ�
	}
}