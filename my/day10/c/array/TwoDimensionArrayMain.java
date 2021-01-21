package my.day10.c.array;

public class TwoDimensionArrayMain {

	public static void main(String[] args) {
		// === 1���� �迭 === //
		int[] subjectArr = new int[5];
		
		/*
		 * -----------
		 * |0|1|2|3|4|
		 * -----------
		 */
		
		
		// === 2���� �迭 === //
		int[][] pointArr = new int[4][3];
		
		/* 4�� 3��
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
		System.out.println("pointArr.length => "+pointArr.length);   //���� ����
		//pointArr.length => 4
		//�������迭��.length => ���� ���̰� ���´�.
		
		System.out.println("pointArr[0].length => "+pointArr[0].length);   //���� ����
		//pointArr.length => 3
		//�������迭��[�����ε���].length => �� �࿡ �����ϴ� ���� ���̰� ���´�.
		
		System.out.println("pointArr[3].length => "+pointArr[0].length);   //���� ����
		//pointArr.length => 3
		//������ ���ص� �ʱ� �� 0���� �ԷµǾ���
		//�������迭��[�����ε���].length => �� �࿡ �����ϴ� ���� ���̰� ���´�.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=0; i<pointArr.length; i++) {
			for (int j=0; j<pointArr[i].length; j++) {
				String str = (j<pointArr[i].length-1)?",":"";
				System.out.printf("%02d%s",pointArr[i][j],str);  //���������� %02d ���ڸ� Ȯ��, ���ڸ��� 0���� ä���
																 //printf�� Ȱ��� �˾ƺ���
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~ ������� ~~~~~~~~~~~~~~~~~\n");

		int[][] jumsuArr = {{90,80,70},{80,85,76},{85,70,90},{60,80,50}};   //4�� 3��
		
		int[] totalArr = new int[jumsuArr.length];  //�� �л����� ������ ������ѵδ� ���̴�.
		
		int[] subjectTotalArr = new int[jumsuArr[0].length];         //�� ���� ����
		
		//1. �� �л����� ������ ��Ÿ�� ����.
		for (int i=0; i<jumsuArr.length; i++) {
			int sum = 0;
			for (int j=0; j<jumsuArr[i].length; j++) {
				sum += jumsuArr[i][j];
			}
			totalArr[i] = sum;
		}
		
		for(int total : totalArr) {     //for(a:b)�� ���, b ��ü�� a�� ���ʴ�� �ְڴٴ� �ǹ�
			System.out.println(total);
		}
		
		/*
		  	240
			241
			245
			190
		 */
		
		System.out.println("\n-----------------------------------\n");
		
		//2. �� ���� ������ ��Ÿ�� ����.
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
		
		System.out.printf("%25s","=== �� ���� �� ��� ===");
		System.out.print("\n-----------------------------------");
		System.out.print("\n����\t����\t����\n");
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
	            		=== �� ���� �� ��� ===
				-----------------------------------
				����		����		����
				-----------------------------------
				78.75	78.75	71.5
				-----------------------------------
				78.8	78.8	71.5	
	     */
	      
	  	System.out.println("\n###################################\n");
	  	
		int[][] numArr = new int[4][];   //4�� null��
		
	/*	
		numArr[0][0] = 10;   //���� ũ�⸦ �������� �ʾ����Ƿ� NullPointerException �߻��Ѵ�
		numArr[0][1] = 20;
		numArr[0][2] = 30;
	 */
	  	
		numArr[0] = new int[3]; //0�࿡�� ���� 3�� ���ڴ�
		numArr[1] = new int[2];
		numArr[2] = new int[4];
		numArr[3] = new int[3];
		
		numArr[0][0] = 10; 
		numArr[0][1] = 20;
		numArr[0][2] = 30;
		
		numArr[1][0] = 40; 
		numArr[1][1] = 50;
	//	numArr[1][2] = 60;  //ArrayIndexOutOfBoundsException�� �߻��Ѵ�.

		numArr[2][0] = 70; 
	//	numArr[2][1]        //����Ʈ�� 0 ���� ����
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
