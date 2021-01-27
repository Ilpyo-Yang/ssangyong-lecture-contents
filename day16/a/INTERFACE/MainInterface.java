package my.day16.a.INTERFACE;

public class MainInterface {

	public static void main(String[] args) {
		
		//final변수 => 상수변수라고 부른다.
		//일반 변수와 구분짓고자 일반적으로 대문자로 변수를 작성한다.
		
		final double PI = 3.141592;	//원주율
		// pi = 9.0992;
		// 더 이상 새로운 값을 넣을 수 없다.
		
		
		System.out.println("반지름이 5인 원의 원둘레 크기 => "+2*PI*5);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Triangle tri = new Triangle();
		Rectangle rt = new Rectangle();
		
		System.out.println("밑변 4, 높이 5인 삼각형의 넓이 => "+tri.area(4, 5));
		System.out.println("가로 4, 세로 5인 사각형의 넓이 => "+rt.area(4, 5));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// == 다형성(Polymorphism) == //
		// ==> 자식클래스로 생성되어진 객체를 부모클래스의 타입으로 받을 수가 있다.
		// ==> ***특정 인터페이스로 구현된 클래스의 객체를 특정 인터페이스 타입으로 받을 수가 있다.
		
		
		Figure fg1 = new Triangle();
		Figure fg2 = new Rectangle();
		Figure fg3 = new Circle();
		
		// Figure fgArr = new Figure[3]; --> 오류
		// 인터페이스인 Figure는 new Figure[3]; 와 같이 할 수 없다.
		
		System.out.println("밑변 4, 높이 5인 삼각형의 넓이 => "+fg1.area(4, 5));
		System.out.println("가로 4, 세로 5인 사각형의 넓이 => "+fg2.area(4, 5));
		System.out.println("반지름이 4인 원의 넓이 => "+fg3.circleArea(4));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
// == 입사문제 == //
//인터페이스와 추상클래스 중에 추상화가 더 많은 것? 인터페이스
//인터페이스는 오로지 추상메서드로만 되어 있다, 완성된 메서드를 쓸 수 없다.
//추상클래스는 미완성 메서드도 있지만 완성된 메서드도 있다.
		
				
		

	}// end of main -------------------------------------------------------------

}
