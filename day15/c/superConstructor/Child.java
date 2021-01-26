package my.day15.c.superConstructor;

public class Child extends Parent {

	// field
	String name;
	
	//기본생성자
	public Child() {
		//super(); 
		//부모클래스의 기본생성자를 말하는 것이다.
		//부모클래스의 기본생성자를 생략하더라도 무조건 호출되어진다.
		//Constructor call must be the first statement in a constructor
		
		name = "엄정화";
		System.out.println("=== 확인용 Child 클래스의 기본생성자를 호출함 ===");
	}
	
	// method
	void childInfo() {
		String info = "아이디 : "+super.id+"\n"
				    + "암호 : "+super.passwd+"\n"
				    + "성명 : "+this.name+"\n";
		System.out.println(info);
	}
	
}
