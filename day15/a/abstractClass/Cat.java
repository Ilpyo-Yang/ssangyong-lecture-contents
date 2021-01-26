package my.day15.a.abstractClass;

public class Cat extends Animal {
	
	// Cat �� ������ field �� ����
	private String color;
	
	
	// Cat �� ������ method �� ����
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color!=null && !color.trim().isEmpty())
			this.color = color;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== ����� ���� ==\n"
				+ "1. ���� : "+getName()+"\n"
				+ "2. ���� : "+getBirthYear()+"��\n"
				+ "3. ���� : "+color+"\n");
				
	}
	
	@Override
	public void cry() {
		System.out.println("����̴� '�߿˾߿�'�ϸ� ��ϴ�.");
	}
	
	public void jump() {
		System.out.println(">> ����̴� ������ �մϴ�. <<");
	}
	
}
