package my.day16.a.INTERFACE;

public interface Figure {

// === �������̽�(interface)��? === //
// ������ �̿ϼ��޼ҵ�(�߻�޼ҵ�)�� field�� final�����θ� �̷���� ���� ���Ѵ�.
// �׸��� �̿ϼ��޼ҵ�(�߻�޼ҵ�)�� field�� ���������ڴ� public ���θ� �Ǿ�����.
// �̿ϼ��޼ҵ�(�߻�޼ҵ�) ������ public abstract �� �����Ǿ��� �ִ�.
// field ������ public final �� �����Ǿ��� �ִ�.	
	
	//field ==> public final �� �����Ǿ��� �ִ�.
	double PI = 3.141592;
	//��, public final double PI = 3.141592; �̴�.
	
	//method
	double area(double x, double y);
	//��, public abstract double area(double x, double y); �̴�.
	//Abstract methods do not specify a body 
	//{}�� ������ ������ �ȵȴ�.
	
	double circleArea(double r);
	
}
