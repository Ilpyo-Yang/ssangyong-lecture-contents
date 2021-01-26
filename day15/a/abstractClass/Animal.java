package my.day15.a.abstractClass;	

// abstract public class Animal {
// 또는
public abstract class Animal {	// 미완성 클래스 (== 추상클래스, abstract 클래스)
	
/*
	 미완성 메서드(== 추상메서드, abstract method)가 있는 클래스는
	 반드시 미완성 클래스(== 추상클래스, abstract class)로 만들어야 한다.
	 왜 미완성 메서드를 만들까요?
	 왜냐하면 자식클래스에서 메서드를 오버라이딩(=재정의)를 하기 때문에 
	 부모클래스에서는 메서드를 정의할 필요가 없으므로 미완성 메서드(== 추상메서드, abstract method)로 만들어 버린다.
	 
	 일반적으로 부모클래스를 미완성클래스(== 추상클래스, abstract class)로 만든다.
 */
	
	// 미완성 클래스(== 추상클래스, abstract class)을 사용하여 객체(인스턴스)를 생성할 수 없다!!!
	
	// Dog, Cat, Duck 의 공통 field (추상화)
	private String name;
	private int birthYear;
	
	
	// Dog, Cat, Duck 의 공통 method(기능)
	//package == default
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		if(name!=null && !name.trim().isEmpty())
			this.name = name;
	}
	protected int getBirthYear() {
		return birthYear;
	}
	protected void setBirthYear(int birthYear) {
		if(birthYear>0)
			this.birthYear = birthYear;
	}
	
	// === 동물들(강아지, 고양이, 오리)의 정보를 출력해주는 메서드 ===
	public void showInfo() {
		System.out.println("== 동물정보 ==\n"
				+ "1. 성명 : "+name+"\n"
				+ "2. 생년 : "+birthYear+"년\n");
	}
	
	// abstract public void cry();
	// 또는
	protected abstract void cry();   // 미완성 메서드
	// 미완성 메서드(= 추상메서드, abstract method)는 자식클래스에서 무조건 재정의(오버라이딩)을 꼭 해주어야만 된다!!!
		
}
