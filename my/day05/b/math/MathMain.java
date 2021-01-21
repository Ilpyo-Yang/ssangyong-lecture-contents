package my.day05.b.math;

public class MathMain {

	public static void main(String[] args) {
		
		//Math Ŭ������ ���ؼ� �˾ƺ��ϴ�.
		
//1. �ݿø��� ���ؼ� �˾ƺ���.
		
		double db1 = 93.45678, db2 = 86.87654;
		
		System.out.println("=== �ݿø� �ϱ� �� ===");
		System.out.println("db1 => "+db1+ ", db2 => " +db2);
		//db1 => 93.45678, db2 => 86.87654

		System.out.println("\n === �ݿø� �� �� ===");
		System.out.println("db1 => "+Math.round(db1)+ ", db2 => " +Math.round(db2));
		//db1 => 93, db2 => 87
		
		// Math.round(�Ǽ�) ==> �Է��� �Ǽ��� ���� �����ڸ������� �����ְ� ������ �Ҽ��δ� �ݿø��ϸ鼭 �����ȴ�. 
        //                 ==> 93.45678    �Ҽ��� ù��° �ڸ��� 4�̹Ƿ� �ݿø��� �ȵȴ�. ��, 93 �� �ȴ�.
        //                 ==> 86.87654    �Ҽ��� ù��° �ڸ��� 8�̹Ƿ� �ݿø��� �ȴ�. ��, 87 �� �ȴ�.
		
		// == Ư�� �Ҽ��� �ڸ����� �ݿø��� �ϰ��� �Ѵ�. ==
	    // db1 => 93.45678  ==> 93.5
	    // db2 => 86.87654  ==> 86.88
		
		//93.45678 * 10
		
		System.out.println("\n === �Ҽ� ù° �ڸ����� ��Ÿ���鼭 �ݿø� �� �� ===");
		System.out.println("db1 => "+Math.round(db1*10)/10.0+ ", db2 => " +Math.round(db2*10)/10.0);
		//db1 => 93.5, db2 => 86.9
		
		System.out.println("\n === �Ҽ� ��°�ڸ����� ��Ÿ���鼭 �ݿø� �� �� ===");
		System.out.println("db1 => "+Math.round(db1*100)/100.0+ ", db2 => " +Math.round(db2*100)/100.0);
		//db1 => 93.46, db2 => 86.88
		
//2. �ø��� ���ؼ� �˾ƺ���.
		//54.1 ==> 55.0
		
		double db3 = 54.0, db4 = 54.1, db5 = 54.9;
		System.out.println("\n=== �ø� �� �� ===");
		System.out.println("db3 => "+Math.ceil(db3)+ ", db4 => " +Math.ceil(db4)+ ", db5 => " +Math.ceil(db5));
		//db3 => 54.0, db4 => 55.0, db5 => 55.0
		System.out.println("db3 => "+(int)(Math.ceil(db3))+ ", db4 => " +(int)(Math.ceil(db4))+ ", db5 => " +(int)(Math.ceil(db5)));
		//db3 => 54, db4 => 55, db5 => 55
		
//3. ������ ���ؼ� �˾ƺ���.
		//54.1 ==> 54.0
		
		System.out.println("\n=== ���� �� �� ===");
		System.out.println("db3 => "+Math.floor(db3)+ ", db4 => " +Math.floor(db4)+ ", db5 => " +Math.floor(db5));
		//db3 => 54.0, db4 => 54.0, db5 => 54.0
		System.out.println("db3 => "+(int)(Math.floor(db3))+ ", db4 => " +(int)(Math.floor(db4))+ ", db5 => " +(int)(Math.floor(db5)));
		//db3 => 54, db4 => 54, db5 => 54
		
//4. ���밪�� ���ؼ� �˾ƺ���.

		int a =20, b = -30;
		
		System.out.println("a => "+a+ ", b => " +b);
		System.out.println("a => "+Math.abs(a)+ ", b => " +Math.abs(b));
        //a => 20, b => 30	
		
	}//end of main

}
