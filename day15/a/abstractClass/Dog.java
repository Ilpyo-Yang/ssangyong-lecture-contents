package my.day15.a.abstractClass;

public class Dog extends Animal {
	
	// Dog �� ������ field �� ����
	private int weight;

	
	// Dog �� ������ method �� ����
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight>0)
			this.weight = weight;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== ������ ���� ==\n"
				+ "1. ���� : "+getName()+"\n"
				+ "2. ���� : "+getBirthYear()+"��\n"
				+ "3. ������ : "+weight+"kg\n");
				
	}
	
	@Override
	protected void cry() {
	// �޼��� �������̵�(�޼��� ������)�� ���������ڴ� �θ�Ŭ�������� �����ص�
	// �̿ϼ�(�߻�޼���)�� ���������ڿ� ������ �Ǵ� ��������� �� ū ������ 
	// ���־�� �Ѵ�.
		System.out.println("�������� '�۸�'�ϸ� ¢���ϴ�.");
	}
	
	public void run() {
		System.out.println(">> �������� ������ �޸��ϴ�. <<");
	}
	
}
