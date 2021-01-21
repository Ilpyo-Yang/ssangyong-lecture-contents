package my.day06.a.FOR;

public class Quiz1Main {

	public static void main(String[] args) {
		
		String word = "Abz3Sa0#$T";
		
		System.out.println(word+" 문자열의 길이(글자수) : "+word.length()+"\n");
		//Abz3Sa0#$T 문자열의 길이(글자수) : 10
		
		/*
		    Abz3Sa0#$T
		 	대문자 개수 : 3
		 	소문자 개수 : 3
		 	숫자 개수 : 2
		 	특수문자 개수 : 2
		 */
		
		int upperCnt = 0;
		int lowerCnt = 0;
		int digitCnt = 0;
		int simbolCnt = 0;
		
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isUpperCase(ch)) {  //대문자인지 검사
				upperCnt++;
			} else if(Character.isLowerCase(ch)) {  //소문자인지 검사
				lowerCnt++;
		    } else if(Character.isDigit(ch)) {  //숫자인지 검사
				digitCnt++;
		    } else simbolCnt++;  //특수문자인지 검사
		}
		
		System.out.println(word
				+ "\n대문자의 개수 : "+upperCnt+"\n"
				+ "소문자의 개수 : "+lowerCnt+"\n"	
				+ "숫자의 개수 : "+digitCnt+"\n"	
				+ "특수문자의 개수 : "+simbolCnt+"\n");

	}
}
