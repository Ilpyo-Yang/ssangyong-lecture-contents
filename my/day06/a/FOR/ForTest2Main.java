package my.day06.a.FOR;

public class ForTest2Main {

	public static void main(String[] args) {

		System.out.println(">> 1. break <<");
		
		for(int i=0; i<10; i++) {
			if(i==5) break;
			System.out.println(i+1);
			
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~\n");
		
		// for (;;) {} Unreachable code 빠져나갈 수 없는 뺑뺑이
		int cnt = 0;
		
		for(;;) {
			System.out.println(++cnt+"번째반복");
			if(cnt==5) break;
		}
			
		System.out.println("\n>> 2. continue <<");
		
		for(int i=0; i<10; i++) {
			if((i+1)%2 == 0)  //짝수라면 skip해라.
			continue;  //continue;를 만나면 실행순서가 밑으로 내려가지 않고 가장 가까운 반복문의 증감식으로 이동시켜준다.
			System.out.print(i+1+" ");  //1 3 5 7 9 
		}
		
	}//end of main()---------------------------

}
