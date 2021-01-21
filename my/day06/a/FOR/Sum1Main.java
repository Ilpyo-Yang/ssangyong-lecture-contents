package my.day06.a.FOR;

public class Sum1Main {

	public static void main(String[] args) {
		
		// 1+2+3+4+5+6+7+8+9+10 => 55
		int sum = 0;
				
		for (int i=0; i<10; i++) {
			sum+=(i+1);
		}
		System.out.println(sum);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~\n");
		
		//[Quiz] 1+2+3+4+5+6+7+8+9+10+=55
		
		sum = 0;
		
		String str = "";
		for (int i=1; i<=10; i++) {
			
			if(i<10) str+=i+"+";  //문자열의 결합
			else str+=i;

			sum+=i;
		}
		System.out.println(str+"="+sum);

	}

}
