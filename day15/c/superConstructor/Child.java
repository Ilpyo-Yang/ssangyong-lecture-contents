package my.day15.c.superConstructor;

public class Child extends Parent {

	// field
	String name;
	
	//�⺻������
	public Child() {
		//super(); 
		//�θ�Ŭ������ �⺻�����ڸ� ���ϴ� ���̴�.
		//�θ�Ŭ������ �⺻�����ڸ� �����ϴ��� ������ ȣ��Ǿ�����.
		//Constructor call must be the first statement in a constructor
		
		name = "����ȭ";
		System.out.println("=== Ȯ�ο� Child Ŭ������ �⺻�����ڸ� ȣ���� ===");
	}
	
	// method
	void childInfo() {
		String info = "���̵� : "+super.id+"\n"
				    + "��ȣ : "+super.passwd+"\n"
				    + "���� : "+this.name+"\n";
		System.out.println(info);
	}
	
}
