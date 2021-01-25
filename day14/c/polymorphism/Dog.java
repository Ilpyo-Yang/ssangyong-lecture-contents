package my.day14.c.polymorphism;

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
	
	
}
