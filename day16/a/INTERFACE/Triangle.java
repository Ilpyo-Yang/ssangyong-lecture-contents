package my.day16.a.INTERFACE;

public class Triangle implements Figure {
		//Triangle �̶�� Ŭ������ �������̽� Figure�� ����(implements)�Ѵٴ� ���̴�.
	
	@Override
	//�������� ���� ���������ڴ� �߻�޼��� ���������ں��� ������ ������ Ŀ�� �Ѵ�.
	public double area(double x, double y) {
		
		return x*y/2;
	}

	@Override
	public double circleArea(double r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
