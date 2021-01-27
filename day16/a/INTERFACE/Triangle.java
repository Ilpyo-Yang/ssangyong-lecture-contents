package my.day16.a.INTERFACE;

public class Triangle implements Figure {
		//Triangle 이라는 클래스는 인터페이스 Figure를 구현(implements)한다는 말이다.
	
	@Override
	//재정의할 때의 접근제한자는 추상메서드 접근제한자보다 범위가 같던지 커야 한다.
	public double area(double x, double y) {
		
		return x*y/2;
	}

	@Override
	public double circleArea(double r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
