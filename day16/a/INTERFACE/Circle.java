package my.day16.a.INTERFACE;

public class Circle implements Figure {

	@Override
	public double circleArea(double r) {
		
		return 3.141592*r*r;
	}

	//�Ƚᵵ �������� �ȵ�, �� �Ŷ� ���־� ��
	@Override
	public double area(double x, double y) {
		
		return 0;
	}

}
