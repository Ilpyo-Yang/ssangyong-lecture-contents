package my.day14.c.polymorphism;

public class Dog extends Animal {
	
	// Dog 만 가지는 field 를 정의
	private int weight;

	
	// Dog 만 가지는 method 를 정의
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight>0)
			this.weight = weight;
	}
	
	@Override
	public void showInfo() {
		System.out.println("== 강아지 정보 ==\n"
				+ "1. 성명 : "+getName()+"\n"
				+ "2. 생년 : "+getBirthYear()+"년\n"
				+ "3. 몸무게 : "+weight+"kg\n");
				
	}
	
	
}
