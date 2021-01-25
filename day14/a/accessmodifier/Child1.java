package my.day14.a.accessmodifier;

public class Child1 extends Parent {

	void viewInfo() {
		super.id="leess"; 			// public		동그라미(초록색)
		super.passwd="qwer1234$A";  // protected    마름모(노란색)
		super.name="이순신";			// default		삼각형(파란색)
	//	super.jubun="";				// private		사각형(빨간색)	접근불가
	}
}
