package my.day15.a.abstractClass;

public class Duck extends Animal {

	// Duck �� ������ field �� ���� (�߻�ȭ)
	private int price;

	// Duck �� ������ method �� ���� (�߻�ȭ)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>0)
			this.price = price;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== ���� ���� ==\n"
				+ "1. ���� : "+getName()+"\n"
				+ "2. ���� : "+getBirthYear()+"��\n"
				+ "3. ���� : "+price+"��\n");
				
	}
	
	@Override
	public void cry() {
		System.out.println("������ '�в�'�ϸ� �Ҹ��� �� �ϴ�.");
	}
	
	public void swim() {
		System.out.println(">> ������ �������� ����� Ĩ�ϴ�. <<");
	}
}
