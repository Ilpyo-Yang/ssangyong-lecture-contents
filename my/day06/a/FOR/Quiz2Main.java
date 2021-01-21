package my.day06.a.FOR;
//***
public class Quiz2Main {

	public static void main(String[] args) {
//[Quiz1]
		//최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => super
		//최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => 5
		
//***방법1.		
		String word = "sup3er007Man";
		String result = "";
		int i=0;
		
		//배열 풀이 고려해볼 것!
		for (; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isDigit(ch)) {
				break;    //i => 5, 문자열이 길이와 동일
			} else {
				result += ch;
				//하나씩 출력하는 것이 아니라 글자를 result 값에 하나씩 축적해서 출력
			}
			
		} 
		
		System.out.print("\n1.최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => "+result);
		System.out.println("\n1.최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => "+i);

		//System.out.println("최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => "+);
		//System.out.println("최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => "+);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//방법2.
		int index = 0;
		result = "";
		
		for(;;) {
			char ch = word.charAt(index++);
				//word.charAt(0);
				//index => 0+1
			
			if(Character.isDigit(ch)) break;    //word.charAt(5)
		    else result += ch;
		}
		
		System.out.print("\n2.최초로 숫자가 나오는 곳의 앞까지 문자열 출력 => "+result);
		System.out.println("\n2.최초로 숫자가 나오는 곳의 앞까지 문자열 길이 => "+(index-1));
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//[Quiz2]
		/*
		       알파벳 소문자를 출력하는데 아래처럼 나타내도록 하세요.
		   a,c,e,g,i,k,m,o,q,s,u,w,y
		 */
//방법1.
		int len = 'z'-'a'+1;  //122-97+1 = 26
		
		for (i=0; i<len; i++) {
			char ch = (char)('a'+i);
			if((ch+0)%2 == 0) continue;  //아래 문장을 출력하지 않고 증감식으로
			//아직 삼항연산자에 대해 잘 모르고 있는 것 같은데
			//맨 뒤에 , 가 찍힐 가능성을 배제할 것
			String str = (i<len-2) ? "," : "";
			System.out.print(ch+str);
	    }
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//방법2.
		for(i='a';i<'z'+1;i++) {	
			if(i%2==0) continue;
			String str = (i<'z'-1)?",":"";
			System.out.print((char)i+str);
		}
		
	}//end of main()
}

