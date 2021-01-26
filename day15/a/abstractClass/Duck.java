package my.day15.a.abstractClass;

public class Duck extends Animal {

	// Duck 만 가지는 field 를 정의 (추상화)
	private int price;

	// Duck 만 가지는 method 를 정의 (추상화)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>0)
			this.price = price;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== 오리 정보 ==\n"
				+ "1. 성명 : "+getName()+"\n"
				+ "2. 생년 : "+getBirthYear()+"년\n"
				+ "3. 가격 : "+price+"원\n");
				
	}
	
	@Override
	public void cry() {
		System.out.println("오리는 '꽥꽥'하며 소리를 냅 니다.");
	}
	
	public void swim() {
		System.out.println(">> 오리는 물가에서 헤엄을 칩니다. <<");
	}
}
