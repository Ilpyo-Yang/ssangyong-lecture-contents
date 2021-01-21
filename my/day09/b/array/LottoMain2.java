package my.day09.b.array;

import java.util.Random;

public class LottoMain2 {

	public static void main(String[] args) {

		int[] ballArr = new int[45];
		int[] tempArr = new int[5]; //기존에 뽑았던 방번호를 기억시켜주는 저장소가 필요

		for (int i=0; i<ballArr.length; i++) {
			ballArr[i] = i+1; //배열의 방마다 데이터값 입력하기
								//데이터값은 1~45
		}
		
		for (int i=0; i<tempArr.length; i++) {
			tempArr[i] = -1;
			
		}
		/*
	 		공을 꺼내어 오면 공의 방번호(index 번호)를 기억하는 곳으로 사용되는
	 		꺼내온 공의 방번호(index 번호)가 0(실제값은 1번볼)이 들어올 수 있으므로
	 		데이터값은 방번호(index 번호)로 사용하지 않는 -1로 모두 초기화 한다.
	     */
		
		// 공의 방번호(배열의 index)를 꺼내는 작업을 6번 반복
		// 0번 방부터 44번 방까지 랜덤하게 6번 뽑아야 한다.
		// 즉, 0~44까지 난수를 발생.
		
		Random rnd = new Random();
	    String result = "";
	    
		//***난수가 겹치지 않도록 뽑히게 하는 핵심for문			
		front:
		for (int i=0; i<6; i++) {
			int idx = rnd.nextInt(45);
			for (int j=0; j<tempArr.length; j++) {
				if(idx == tempArr[j]) {
					i--;
					continue front;   //난수를 발생시켜주는 바깥 for문으로 가야한다.
				}
			}
			if(i<5) {
				tempArr[i] = idx;				
			}
			
			String comma = (i<5)?",":"";
			result += ballArr[idx]+comma;
		}//end of for -----------------------------
		
		System.out.println("\n로또 1등 당첨번호 : "+result);
	}

}
