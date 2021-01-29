package my.day17.e.lambda;

public class MainLambda_2 {
	
/*
		 ����(Lambda) �Լ��� ���α׷��� ���� ���Ǵ� �������� �͸� �Լ�(Anonymous functions)�� ��Ī�ϴ� ����̴�.
		 ���� ���ǰ� �ִ� ������ �ٰ��� ���а� ���� ��ǻ�Ͱ��� �о߿����� ���� ����̴�. 
		 ���� ����� ������ �����ڸ� ���п��� ����ϴ� �Լ��� ���� �ܼ��ϰ� ǥ���ϴ� ����̴�.
		
		 ���� ����� �̸��� ���� �ʿ䰡 ����. ��, �͸� �Լ� (Anonymous functions)�̴�.
		 ���ٽ�(Lambda)�� �͸��Լ�(anonymous function)�� �����ϱ� ���� �����μ� ��ü ���� ���� �Լ� ���� �� ������.
		
		 �ڹٿ��� ���ٽ��� ��� ������ �������̽��� ���ǵ� �޼ҵ带 ������ �ڵ����� Ȯ �ٿ��� �����ϰ� ����ϴ� ���� �����̴�.  
          
         �ڹٿ����� �Լ� �ܵ����δ� ����� �� ���� ��ü�� ���ؼ��� ����� ������ �����̹Ƿ� 
         �ڹٿ��� ���ٸ� �����Ϸ��� ������������ ���� FunctionalInterface(�Լ��� �������̽�)�� ������ �͸�(����)Ŭ���� ��ü�� �����Ǿ��� �־�߸� �Ѵ�. 
         ���ٴ� FunctionalInterface(�Լ��� �������̽�)�� ������ �͸�(����)Ŭ���� ��ü�� �޼ҵ�� �����ϰ� �ȴ�.  
         
         ���⼭ ������ ���� FunctionalInterface(�Լ��� �������̽�)�� ������ �� �Ѱ����� �߻�޼ҵ�� �̷������ �Ѵٴ� ���̴�. 
         ���࿡ FunctionalInterface(�Լ��� �������̽�)�� �� �� �̻��� �޼ҵ尡 ����Ǹ� �ڹ� �����Ϸ��� ������ �߻���Ų��.  
         �Լ��� �������̽��� �������  @FunctionalInterface ������̼��� ����ϸ� �ȴ�.
 */
	
	public static void main(String[] args) {

		System.out.println("=== ���ٽ�(Lambda)�� ������� ���� �� ===");
		
		InterAreaFuctional_1 obj1 = new InterAreaFuctional_1( ) {
				    @Override
					public double area(double x, double y) {	
				    	return x*y;
					}
		};
		
		double areaSize1 = obj1.area(10.5, 5.5);
	 	System.out.println("���� 10.5, ���� 5.5 �� ������ : "+areaSize1);
		// ���� 10.5, ���� 5.5 �� ������ : 57.75
		
		System.out.println("=== ���ٽ�(Lambda)�� ����� �� ===");
		
		InterAreaFuctional_1 obj2 = (x,y) -> {return x*y;};
		double areaSize2 = obj2.area(10.5, 5.5);
		
		System.out.println("���� 10.5, ���� 5.5 �� ������ : "+areaSize2);
		// ���� 10.5, ���� 5.5 �� ������ : 57.75
		
		System.out.println("\n~~~~~~~ ���ٽ�(Lambda) ǥ�� ��� ~~~~~~~~~~~\n");

		InterAreaFuctional_3 obj = new InterAreaFuctional_3() {
			@Override
			public void smile(String state) {
			System.out.println("�����Ҹ� : "+state);
			}
		};
		obj.smile("ȣȣȣ ������");
		// �����Ҹ� : ȣȣȣ ������
		
		// 1. ���ٽ�(Lambda) ǥ�� �⺻���
		InterAreaFuctional_3 objA = (String state) -> {	System.out.println("�����Ҹ�1 : "+state);};
		objA.smile("����~~~~~~~~~~~~");
			// �����Ҹ� : ����~~~~~~~~~~~~
		
		// 2. �����ɹ��� 1����� { } �� ������ �� �ִ�.
		InterAreaFuctional_3 objB = (String state) -> System.out.println("�����Ҹ�2 : "+state);
		objB.smile("������");
			// �����Ҹ�2 : ������
		
		// 3. �Ķ���� Ÿ���� ������ �� �ִ�.
		InterAreaFuctional_3 objC = (state) -> System.out.println("�����Ҹ�3 : "+state);
		objC.smile("ȣȣȣ");
			// �����Ҹ�3 : ȣȣȣ
		
		// 4. �Ķ���� ������ 1���� ���� �Ķ���͸� ���δ� ��ȣ ( )�� ������ �� �ִ�.
		InterAreaFuctional_3 objD = state -> System.out.println("�����Ҹ�4 : "+state);
		objD.smile("������");
			// �����Ҹ�4 : ������
				
		// 5. �Ķ���Ͱ� ���� ���ٽ��� ������ ��ȣ�� �����ؾ� �Ѵ�.
		InterAreaFuctional_4 objE = ( ) -> System.out.println("�ȳ��ϼ���~~~");
		objE.write( );
			// �ȳ��ϼ���~~~
		
		// 6. �Ķ���Ͱ� 2�� �̻� �϶��� ������ ( ) ��ȣ�� �����ؾ� �Ѵ�.
		InterAreaFuctional_1 objF = (x, y) -> {return x+y;};
		double db1 = objF.area(10.5, 20.5);
		System.out.println(db1);
			// 31.0
		
		// 7. return �� ���� ��쿡�� { } �� ������ �� ����.
		//InterAreaFuctional_1 objG = (x, y) -> return x-y;  //����
		InterAreaFuctional_1 objG = (x, y) -> {return x-y;};  
		double db2 = objG.area(20.5, 10.5);
		System.out.println(db2);
			// 10.0
		
		// 8. return ���� �ִ� ���� �ڵ��� ��쿡�� { } �� return�� ������ �� �ִ�.
		InterAreaFuctional_1 objH = (x, y) -> x+y;  
		double db3 = objH.area(10.5, 20.5);
		System.out.println(db3);
			// 31.0

	}// end of main( ) --------------------------------------------

}
