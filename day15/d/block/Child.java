package my.day15.d.block;

public class Child extends Parent {

	// field (첫번째)
	String name = "홍길동"; 	//멤버변수의 초기화
	static int count; 		//멤버변수의 초기화
	
	// == static 초기화 블럭 (두번째) == //
	static {
		// static 초기화 블럭은 인스턴스(객체)를 생성하기 전에 먼저 호출되어지며
		//*** 중요한 것은 오로지 1번만 호출된다는 뜻이다.
		// 주로 static 초기화 블럭은 환경설정시 사용된다.
		//*** 자바와 데이터베이스 합칠 때 사용된다.
		System.out.println("*** Child 클래스의 'static 초기화 블럭' 호출됨. ***");
		count++;
	}
	
	// == instance 초기화 블럭 (네번째) == //
	{
		System.out.println("### Child 클래스의 인스턴스 초기화 블럭 호출됨. ###");	
		name = "서강준"; 
	}
	
	// == 생성자 == //
	public Child() {
		super();  //(세번째)
		
		// (다섯번째)
		System.out.println(">> 자식 클래스인 Child 클래스의 기본생성자 호출됨 <<");
		name = "한지민";
	}
}
