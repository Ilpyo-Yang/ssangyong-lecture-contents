package my.day16.a.INTERFACE;

public interface Figure {

// === 인터페이스(interface)란? === //
// 오로지 미완성메소드(추상메소드)와 field는 final변수로만 이루어진 것을 말한다.
// 그리고 미완성메소드(추상메소드)와 field의 접근제한자는 public 으로만 되어진다.
// 미완성메소드(추상메소드) 생성시 public abstract 이 생략되어져 있다.
// field 생성시 public final 이 생략되어져 있다.	
	
	//field ==> public final 이 생략되어져 있다.
	double PI = 3.141592;
	//즉, public final double PI = 3.141592; 이다.
	
	//method
	double area(double x, double y);
	//즉, public abstract double area(double x, double y); 이다.
	//Abstract methods do not specify a body 
	//{}를 가지고 있으면 안된다.
	
	double circleArea(double r);
	
}
