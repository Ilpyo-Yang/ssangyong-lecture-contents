package my.day06.a.FOR;

public class ForTest2Main {

	public static void main(String[] args) {

		System.out.println(">> 1. break <<");
		
		for(int i=0; i<10; i++) {
			if(i==5) break;
			System.out.println(i+1);
			
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~\n");
		
		// for (;;) {} Unreachable code �������� �� ���� ������
		int cnt = 0;
		
		for(;;) {
			System.out.println(++cnt+"��°�ݺ�");
			if(cnt==5) break;
		}
			
		System.out.println("\n>> 2. continue <<");
		
		for(int i=0; i<10; i++) {
			if((i+1)%2 == 0)  //¦����� skip�ض�.
			continue;  //continue;�� ������ ��������� ������ �������� �ʰ� ���� ����� �ݺ����� ���������� �̵������ش�.
			System.out.print(i+1+" ");  //1 3 5 7 9 
		}
		
	}//end of main()---------------------------

}
