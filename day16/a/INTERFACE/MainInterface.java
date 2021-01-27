package my.day16.a.INTERFACE;

public class MainInterface {

	public static void main(String[] args) {
		
		//final���� => ���������� �θ���.
		//�Ϲ� ������ ���������� �Ϲ������� �빮�ڷ� ������ �ۼ��Ѵ�.
		
		final double PI = 3.141592;	//������
		// pi = 9.0992;
		// �� �̻� ���ο� ���� ���� �� ����.
		
		
		System.out.println("�������� 5�� ���� ���ѷ� ũ�� => "+2*PI*5);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Triangle tri = new Triangle();
		Rectangle rt = new Rectangle();
		
		System.out.println("�غ� 4, ���� 5�� �ﰢ���� ���� => "+tri.area(4, 5));
		System.out.println("���� 4, ���� 5�� �簢���� ���� => "+rt.area(4, 5));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// == ������(Polymorphism) == //
		// ==> �ڽ�Ŭ������ �����Ǿ��� ��ü�� �θ�Ŭ������ Ÿ������ ���� ���� �ִ�.
		// ==> ***Ư�� �������̽��� ������ Ŭ������ ��ü�� Ư�� �������̽� Ÿ������ ���� ���� �ִ�.
		
		
		Figure fg1 = new Triangle();
		Figure fg2 = new Rectangle();
		Figure fg3 = new Circle();
		
		// Figure fgArr = new Figure[3]; --> ����
		// �������̽��� Figure�� new Figure[3]; �� ���� �� �� ����.
		
		System.out.println("�غ� 4, ���� 5�� �ﰢ���� ���� => "+fg1.area(4, 5));
		System.out.println("���� 4, ���� 5�� �簢���� ���� => "+fg2.area(4, 5));
		System.out.println("�������� 4�� ���� ���� => "+fg3.circleArea(4));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
// == �Ի繮�� == //
//�������̽��� �߻�Ŭ���� �߿� �߻�ȭ�� �� ���� ��? �������̽�
//�������̽��� ������ �߻�޼���θ� �Ǿ� �ִ�, �ϼ��� �޼��带 �� �� ����.
//�߻�Ŭ������ �̿ϼ� �޼��嵵 ������ �ϼ��� �޼��嵵 �ִ�.
		
				
		

	}// end of main -------------------------------------------------------------

}
