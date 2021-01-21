package my.day07.b.FOR;

public class MultiForMain {

	public static void main(String[] args) {

		//다중 for문에 대해서 알아본다.
		/*
		 	abcdefg     3행 7열
		 	hijklmn
		 	opqrstu
		 */
		
		char ch = 'a';		
		
		for(int i=0; i<3; i++) { // 바깥 for문 ==> 행
			for(int j=0; j<7; j++) { // 내부 for문 ==> 열
				System.out.print(ch++);
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
		
//이건 나의 이상한 코드이다		
		ch ='a';
		
		for(int i=0; i<7; i++) {
			if(ch == 'v') break;
			System.out.print("\n"+ch++);
			System.out.print(ch++);
			System.out.print(ch++);
			System.out.print(ch++);
			System.out.print(ch++);
			System.out.print(ch++);
			System.out.print(ch++);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		ch ='a';
		
		//단일 for문 코드
		for (int i=0; i<'u'-'a'+1;i++) {  //7의 배수에서 줄바꿈
			System.out.print(ch++);
			if((i+1)%7==0) {
				System.out.print("\n");
			}
		}
	
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
		 * [0,0][0,1][0,2]
		 * [1,0][1,1][1,2]
		 * [2,0][2,1][2,2]
		 * [3,0][3,1][3,2]
		 */
		
		int i = 0;
		int j = 0;
		
		for (i=0; i<4 ;i++) {
			for (j=0; j<3; j++) { 
				System.out.print("["+i+","+j+"]");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		//continue; => continue 와 가장 가까운 반복문의 증감식으로 이동하는 것
		//continue 레이블명; => 레이블명이 있는 반복문의 증감식으로 이동하는 것
		/*
		 * [0,0][0,1][0,2]
		 * [1,0][1,1][1,2]
		 * [3,0][3,1][3,2]
		 */
		
		for (i=0; i<4 ;i++) {
			if(i==2) continue;
			for (j=0; j<3; j++) { 
				System.out.print("["+i+","+j+"]");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
	
		/*
		 * [0,0][0,2]
		 * [1,0][1,2]
		 * [2,0][2,2]
		 * [3,0][3,2]
		 */
		
		for (i=0; i<4 ;i++) {
			for (j=0; j<3; j++) { 
				if(j==1) continue;
				System.out.print("["+i+","+j+"]");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n안녕하세요\t내일 또 뵐게요~~");
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
		 	501호	502호	503호	505호
		 	301호	302호	303호	305호
		 	201호	202호	203호	205호
		 	101호	102호	103호	105호
		 */
		
		for (i=5; i>0 ;i--) {
			if(i==4) continue;
			for (j=1; j<6; j++) { 
				if(j==4) continue;
				System.out.print(i+"0"+j+"호\t");
			}
			System.out.print("\n");
		}
		
		

		
		
	}//end of main --------------------------------

}
