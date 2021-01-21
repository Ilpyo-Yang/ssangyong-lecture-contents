package my.day10.c.array;

public class TwoDimensionArrayMain {

	public static void main(String[] args) {
		// === 1차원 배열 === //
		int[] subjectArr = new int[5];
		
		/*
		 * -----------
		 * |0|1|2|3|4|
		 * -----------
		 */
		
		
		// === 2차원 배열 === //
		int[][] pointArr = new int[4][3];
		
		/* 4행 3열
		 * ----------------------
		 * |[0][0]|[0][1]|[0][2]|
		 * ----------------------
		 * |[1][0]|[1][1]|[1][2]|
		 * ----------------------
		 * |[2][0]|[2][1]|[2][2]|
		 * ----------------------
		 * |[3][0]|[3][1]|[3][2]|
		 * ----------------------
		 */
		
		pointArr[0][0] = 10;
		pointArr[0][1] = 20;
		pointArr[0][2] = 30;
		
		pointArr[1][0] = 40;
		pointArr[1][1] = 50;
	//	pointArr[1][2] = 60;
		
		pointArr[2][0] = 70;
		pointArr[2][1] = 80;
		pointArr[2][2] = 90;
	/*	
		pointArr[3][0] = 100;
		pointArr[3][1] = 110;
		pointArr[3][2] = 120;
	 */
		System.out.println("pointArr.length => "+pointArr.length);   //행의 개수
		//pointArr.length => 4
		//이차원배열명.length => 행의 길이가 나온다.
		
		System.out.println("pointArr[0].length => "+pointArr[0].length);   //열의 개수
		//pointArr.length => 3
		//이차원배열명[행의인덱스].length => 그 행에 존재하는 열의 길이가 나온다.
		
		System.out.println("pointArr[3].length => "+pointArr[0].length);   //열의 개수
		//pointArr.length => 3
		//값지정 안해도 초기 값 0으로 입력되어짐
		//이차원배열명[행의인덱스].length => 그 행에 존재하는 열의 길이가 나온다.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=0; i<pointArr.length; i++) {
			for (int j=0; j<pointArr[i].length; j++) {
				String str = (j<pointArr[i].length-1)?",":"";
				System.out.printf("%02d%s",pointArr[i][j],str);  //오른쪽정렬 %02d 두자리 확보, 빈자리는 0으로 채운다
																 //printf의 활용법 알아보기
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~ 성적결과 ~~~~~~~~~~~~~~~~~\n");

		int[][] jumsuArr = {{90,80,70},{80,85,76},{85,70,90},{60,80,50}};   //4행 3열
		
		int[] totalArr = new int[jumsuArr.length];  //각 학생들의 총점을 저장시켜두는 곳이다.
		
		int[] subjectTotalArr = new int[jumsuArr[0].length];         //각 과목별 총점
		
		//1. 각 학생별로 총점을 나타내 보자.
		for (int i=0; i<jumsuArr.length; i++) {
			int sum = 0;
			for (int j=0; j<jumsuArr[i].length; j++) {
				sum += jumsuArr[i][j];
			}
			totalArr[i] = sum;
		}
		
		for(int total : totalArr) {     //for(a:b)인 경우, b 객체를 a에 차례대로 넣겠다는 의미
			System.out.println(total);
		}
		
		/*
		  	240
			241
			245
			190
		 */
		
		System.out.println("\n-----------------------------------\n");
		
		//2. 각 과목별 총점을 나타내 보자.
		for (int i=0; i<jumsuArr[0].length; i++) {
			int sum = 0;
			for (int j=0; j<jumsuArr.length; j++) {
				sum += jumsuArr[j][i];
			}
			subjectTotalArr[i] = sum;
		}
		
		
		
		for(int total : subjectTotalArr) {
			System.out.println(total);
		}
		
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
		//at my.day10.c.array.TwoDimensionArrayMain.main(TwoDimensionArrayMain.java:103)
		
		/*
		    315
			315
			286
		 */
		System.out.println("\n");
		
		System.out.printf("%25s","=== 각 과목별 및 평균 ===");
		System.out.print("\n-----------------------------------");
		System.out.print("\n국어\t영어\t수학\n");
		System.out.println("-----------------------------------");
		System.out.print(subjectTotalArr[0]/4.0f+"\t");
		System.out.print(subjectTotalArr[1]/4.0f+"\t");
		System.out.print(subjectTotalArr[2]/4.0f);
		System.out.println("\n-----------------------------------");

		String result = "";
	      for(int total : subjectTotalArr) {
	         double avg = Math.round( ((double)total/jumsuArr.length) * 10)/10.0;
	         result += avg+"\t";
	      }
	      
	      System.out.println(result);
	      
	    /*
	            		=== 각 과목별 및 평균 ===
				-----------------------------------
				국어		영어		수학
				-----------------------------------
				78.75	78.75	71.5
				-----------------------------------
				78.8	78.8	71.5	
	     */
	      
	  	System.out.println("\n###################################\n");
	  	
		int[][] numArr = new int[4][];   //4행 null열
		
	/*	
		numArr[0][0] = 10;   //열의 크기를 설정하지 않았으므로 NullPointerException 발생한다
		numArr[0][1] = 20;
		numArr[0][2] = 30;
	 */
	  	
		numArr[0] = new int[3]; //0행에는 열을 3개 쓰겠다
		numArr[1] = new int[2];
		numArr[2] = new int[4];
		numArr[3] = new int[3];
		
		numArr[0][0] = 10; 
		numArr[0][1] = 20;
		numArr[0][2] = 30;
		
		numArr[1][0] = 40; 
		numArr[1][1] = 50;
	//	numArr[1][2] = 60;  //ArrayIndexOutOfBoundsException이 발생한다.

		numArr[2][0] = 70; 
	//	numArr[2][1]        //디폴트로 0 값이 들어옴
		numArr[2][2] = 90;
		
		for (int i=0; i<numArr.length; i++) {
			for (int j=0; j<numArr[i].length; j++) {
				String str =(j<numArr[i].length-1)?",":"";
				System.out.printf("%2d%s",numArr[i][j],str);
			}
			System.out.print("\n");
		}
		
		/*
		 	10,20,30
			40,50
			70, 0,90, 0
			 0, 0, 0
		 */

	  	System.out.println("\n###################################\n");
	  	
		int[][] numArr2 = {{10,20,30},{40,50},{70,0,90,0},{0,0,0}}; 
		
		for (int i=0; i<numArr2.length; i++) {
			for (int j=0; j<numArr2[i].length; j++) {
				String str =(j<numArr2[i].length-1)?",":"";
				System.out.printf("%2d%s",numArr2[i][j],str);
			}
			System.out.print("\n");
		}
		
	}

}
