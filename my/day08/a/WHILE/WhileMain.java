package my.day08.a.WHILE;

public class WhileMain {

/*
	   === while 문 형식 ===
	   
	      변수의 초기화;
	      
	   while(조건식) {
		      조건식이 참(true)이라면 반복해서 실행할 명령문을 실행하고,
		      조건식이 거짓(false)이라면 while의 { } 이부분을 빠져나간다. 
		      
		      반복해서 실행할 명령문;
		      증감식;
	   }
*/
	
	public static void main(String[] args) {

		int cnt=5, loop=0;
		while(loop < cnt) {
			System.out.println((loop+1)+". 안녕 자바~~");   //증가값에 유의하기
			loop++;
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		cnt=5; loop=0;
		while(loop++ < cnt) {
			System.out.println(loop+". Hello java~~");	//증가값에 유의하기
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		cnt=5; loop=0;
		while(loop < cnt) {  //증감없으면 무한루프
			System.out.println(++loop+". Hi Eclipse~~");	//증가값에 유의하기
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		loop=0;
		while(true) {  //무조건 참 무한루프
			System.out.println(++loop+". Hi 이클립스~~");	
			if(loop == 5) break;
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		//while문에 ! 많이 쓰는 형태
		//!() => while문을 빠져나갈 조건식을 정의내리기
		loop=0;
		while(!(++loop>5)) {  
			System.out.println(loop+". 안녕 오라클~~");	//증가값에 유의하기
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
/*
 	1.Hi Oracle~~
 	3.Hi Oracle~~
 	5.Hi Oracle~~
 	7.Hi Oracle~~
 	9.Hi Oracle~~		 	
 */
		
		loop=0;
		while(true) {  
			if(++loop>10) break;
			System.out.println(loop++ +". Hi Oracle~~");	
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		loop=0;
		while(true) {  
			if(++loop>10) break;   //탈출조건
			if(loop%2 == 0) continue;   //아래로 안내려가고 ()속으로
			System.out.println(loop +". Hi oooooOracle~~");	
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");
		
		System.out.println("=== 5단 ===");
		cnt=5; loop=1;
		while(++loop<10) {  
			System.out.println(cnt+"*"+loop+"="+(cnt*loop));	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		loop=0;
		while(++loop<10) {  
			System.out.println("5*"+loop+"="+5*loop);	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=== 6단 ===");
		loop=0;
		while(true) { 
			if(++loop>9) break;
			System.out.println("6*"+loop+"="+6*loop);	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=== 7단 ===");
		loop=0;
		while(!(++loop>9)) { //while문의 탈출조건을 쓴다		
			System.out.println("7*"+loop+"="+7*loop);	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%35s","=== 구구단 ===\n"); 
		//9행 8열
		//jul dan
		int jul=0, dan=1;
		
		while(!(++jul>9)) { //9행
			while(!(++dan>9)) { //8열
				String str = (dan<9)?"\t":"\n";   //삼항연산자
				System.out.print(dan+"*"+jul+"="+jul*dan+str);	
			}
			dan=1;     //초기화 해주고 줄바꿈
		}//end of while -----------------------------
		
		System.out.println("=== 프로그램 종료 ===\n");

	}//end of main ----------------------------------

}
