package my.day15.d.block;

public class MainBlock {

	public static void main(String[] args) {
		
		Child child1 = new Child();
		System.out.println("child1.name => "+child1.name);		
		System.out.println("Child.count => "+Child.count);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Child child2 = new Child();
		child2.name = "������";
		System.out.println("child2.name => "+child2.name);		
		System.out.println("Child.count => "+Child.count);
		
/*
 	*** Child Ŭ������ 'static �ʱ�ȭ ��' ȣ���. ***
	>> �θ� Ŭ������ Parent Ŭ������ �⺻������ ȣ��� <<
	### Child Ŭ������ �ν��Ͻ� �ʱ�ȭ �� ȣ���. ###
	>> �ڽ� Ŭ������ Child Ŭ������ �⺻������ ȣ��� <<
	child1.name => ������
	
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	>> �θ� Ŭ������ Parent Ŭ������ �⺻������ ȣ��� <<
	### Child Ŭ������ �ν��Ͻ� �ʱ�ȭ �� ȣ���. ###
	>> �ڽ� Ŭ������ Child Ŭ������ �⺻������ ȣ��� <<
 */
		

	}

}
