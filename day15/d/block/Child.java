package my.day15.d.block;

public class Child extends Parent {

	// field (ù��°)
	String name = "ȫ�浿"; 	//��������� �ʱ�ȭ
	static int count; 		//��������� �ʱ�ȭ
	
	// == static �ʱ�ȭ �� (�ι�°) == //
	static {
		// static �ʱ�ȭ ���� �ν��Ͻ�(��ü)�� �����ϱ� ���� ���� ȣ��Ǿ�����
		//*** �߿��� ���� ������ 1���� ȣ��ȴٴ� ���̴�.
		// �ַ� static �ʱ�ȭ ���� ȯ�漳���� ���ȴ�.
		//*** �ڹٿ� �����ͺ��̽� ��ĥ �� ���ȴ�.
		System.out.println("*** Child Ŭ������ 'static �ʱ�ȭ ��' ȣ���. ***");
		count++;
	}
	
	// == instance �ʱ�ȭ �� (�׹�°) == //
	{
		System.out.println("### Child Ŭ������ �ν��Ͻ� �ʱ�ȭ �� ȣ���. ###");	
		name = "������"; 
	}
	
	// == ������ == //
	public Child() {
		super();  //(����°)
		
		// (�ټ���°)
		System.out.println(">> �ڽ� Ŭ������ Child Ŭ������ �⺻������ ȣ��� <<");
		name = "������";
	}
}
