package my.day08.c.random;

import java.util.*;

public class RandomMain {

	public static void main(String[] args) {
		
// 보안상 Math.random() 보다는 new Random(); 을 사용하는 것이 더 안전하다.
		
		// === 랜덤한 정수를 뽑아본다. ===
		
		Random rnd = new Random();
	//	int rndNum = rnd.nextInt(마지막수 - 처음수 + 1)+처음수;
		
		int random1 = rnd.nextInt(10-1+1)+1;
		System.out.println("1부터 10까지 중 랜덤하게 발생한 값 => "+random1);
		
		int random2 = rnd.nextInt(7-3+1)+1;
		System.out.println("3부터 7까지 중 랜덤하게 발생한 값 => "+random2);
		
		int random3 = rnd.nextInt(('z'-'a'+1)+'a');
		System.out.println("a부터 z까지 중 랜덤하게 발생한 값 => "+(char)(random3));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[인증키]는 랜덤한 숫자 3개와 랜덤한 소문자 4개로 만든다.
//예:> 103qdtj 251adfa

		String key="";
		for(int i=0; i<3; i++) {
			int num = rnd.nextInt(9-0+1)+0;
			key += num;
		}
		for(int i=0; i<4; i++) {
			int num = rnd.nextInt('z'-'a'+1)+'a';
			key += (char)num;
		}

		System.out.println("인증키 => "+key);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[random => 짝수인지 홀수인지 맞추기]
		
		Scanner sc = new Scanner(System.in);
		System.out.print("선택[1.홀수/0.짝수] => ");    //전제, 예외처리 생략
		String choice = sc.nextLine();
		char ch = choice.charAt(0);  
		//***0은 int로 48
		//char 타입을 숫자로 바꾸려면 '0' 빼기
		int choiceNo = ch-'0'; //0 또는 1
		
		int randNo = rnd.nextInt(10-1+1)+1;
		
		String result = "";
		if (choiceNo == randNo%2) {
			result = "맞습니다";
		} else
			result = "틀렸습니다";
		System.out.println(result+" 랜덤하게 나온 수는 "+randNo+"입니다.");	
	
	sc.close();	
	}// end of main() ----------------------------
}
