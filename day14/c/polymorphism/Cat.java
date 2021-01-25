package my.day14.c.polymorphism;

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
	
	
}
