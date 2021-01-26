package my.day15.a.abstractClass;

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
	
	@Override
	protected void cry() {
	// 메서드 오버라이딩(메서드 재정의)시 접근제한자는 부모클래스에서 정의해둔
	// 미완성(추상메서드)의 접근제한자와 같든지 또는 접근허용이 더 큰 것으로 
	// 해주어야 한다.
		System.out.println("강아지는 '멍멍'하며 짖습니다.");
	}
	
	public void run() {
		System.out.println(">> 강아지가 빠르게 달립니다. <<");
	}
	
}
