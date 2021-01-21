package my.day06.a.FOR;
//***
public class Quiz2MainNA {

	public static void main(String[] args) {
//[Quiz1]
		//최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => super
		//최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => 5
		
	
		String word = "super007Man";
		
		int cnt = 0;
		
		System.out.print("\n최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => ");
		
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isAlphabetic(ch)) {
				cnt++;
				System.out.print(ch);
			} else break;
			
		} 
			System.out.println("\n최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => "+cnt);

		//System.out.println("최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => "+);
		//System.out.println("최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => "+);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//[Quiz2]
		/*
		       알파벳 소문자를 출력하는데 아래처럼 나타내도록 하세요.
		   a,c,e,g,i,k,m,o,q,s,u,w,y
		 */
				
		for (char i=97; i<122; i+=2) {
			if(i<122-2) {
			System.out.print(Character.toString(i)+',');
			}
			else System.out.print(i);
	    }
		
	}//end of main()
}

