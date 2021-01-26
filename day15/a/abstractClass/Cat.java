package my.day15.a.abstractClass;

public class Cat extends Animal {
	
	// Cat 만 가지는 field 를 정의
	private String color;
	
	
	// Cat 만 가지는 method 를 정의
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color!=null && !color.trim().isEmpty())
			this.color = color;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== 고양이 정보 ==\n"
				+ "1. 성명 : "+getName()+"\n"
				+ "2. 생년 : "+getBirthYear()+"년\n"
				+ "3. 색상 : "+color+"\n");
				
	}
	
	@Override
	public void cry() {
		System.out.println("고양이는 '야옹야옹'하며 웁니다.");
	}
	
	public void jump() {
		System.out.println(">> 고양이는 점프를 합니다. <<");
	}
	
}
