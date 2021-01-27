package my.day16.a.INTERFACE;

public class Circle implements Figure {

	@Override
	public double circleArea(double r) {
		
		return 3.141592*r*r;
	}

	//¾È½áµµ »©¹ö¸®¸é ¾ÈµÊ, ºó °Å¶óµµ ³ªµÖ¾ß ÇÔ
	@Override
	public double area(double x, double y) {
		
		return 0;
	}

}
