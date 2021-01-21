package my.day08.c.random;

import java.util.Scanner;

public class MathRandomMain {

	public static void main(String[] args) {
		
		// === 랜덤한 정수를 뽑아본다. ===
		
		double random = Math.random();
		System.out.println("random => "+random);
		//random => 0.5066934813478947
		//random => 0.25630541700328846
		
/*
     java.lang.Math.random() 메소드는 
     0.0 이상 1.0 미만의 실수(double)값을 랜덤하게 나타내어주는 메소드이다. 
               즉,  0.0 <= 임의의 난수(실수) < 1.0
           
     1부터 10까지 중 랜덤한 정수를 얻어와 본다.
   
             랜덤한 정수 = (int)(Math.random()*구간범위)+시작값;
     
     0.0        (int)(0.0*(10-1+1))+1         ==>  1
     0.23346438 (int)(0.23346438*(10-1+1))+1  ==>  3
     0.67835431 (int)(0.67835431*(10-1+1))+1  ==>  7
     0.99999999 (int)(0.99999999*(10-1+1))+1  ==> 10
     
     3 부터 7까지중 랜덤한 정수를 얻어와 본다.
     
     0.0        (int)(0.0*(7-3+1))+3         ==>  3
     0.23346438 (int)(0.23346438*(7-3+1))+3  ==>  4
     0.67835431 (int)(0.67835431*(7-3+1))+3  ==>  6
     0.99999999 (int)(0.99999999*(7-3+1))+3  ==>  7
     
     int random2 = (int)(Math.random()*범위값+시작값); 
           정수로의 강제형변환
 */
		
		int random1 = (int)(Math.random()*10+1);
		System.out.println("1부터 10까지 중 랜덤하게 발생한 값 => "+random1);
		
		int random2 = (int)(Math.random()*5+3);
		System.out.println("3부터 7까지 중 랜덤하게 발생한 값 => "+random2);
		
		int random3 = (int)(Math.random()*('z'-'a'+1)+'a');
		System.out.println("a부터 z까지 중 랜덤하게 발생한 값 => "+(char)(random3));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[인증키]는 랜덤한 숫자 3개와 랜덤한 소문자 4개로 만든다.
//예:> 103qdtj 251adfa
		
//1. 나의 허접한 코드
		int nb = (int)(Math.random()*900+100);
		char eb = (char)(Math.random()*26+97);
		char eb1 = (char)(Math.random()*26+97);
		char eb2 = (char)(Math.random()*26+97);
		char eb3 = (char)(Math.random()*26+97);
		System.out.println("인증키 => "+nb+eb+eb1+eb2+eb3);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

//2. 쌤 코드
		String key="";
		for(int i=0; i<3; i++) {
			int num = (int)(Math.random()*10);
			key += num;
		}
		for(int i=0; i<4; i++) {
			int num = (int)(Math.random()*('z'-'a'+1)+'a');
			key += (char)num;
		}

		System.out.println("인증키 => "+key);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[random => 짝수인지 홀수인지 맞추기]
		
		Scanner sc = new Scanner(System.in);
		System.out.println("선택[1.홀수/0.짝수] => ");    //전제, 예외처리 생략
		String choice = sc.nextLine();
		char ch = choice.charAt(0);  
		//***0은 int로 48
		//char 타입을 숫자로 바꾸려면 '0' 빼기
		int choiceNo = ch-'0'; //0 또는 1
		
		int randNo = (int)(Math.random()*10+1);
		
		String result = "";
		if (choiceNo == randNo%2) {
			result = "맞습니다";
		} else
			result = "틀렸습니다";
		System.out.println(result+" 랜덤하게 나온 수는 "+randNo+"입니다.");	
	
	sc.close();	
	}// end of main() ----------------------------
}
