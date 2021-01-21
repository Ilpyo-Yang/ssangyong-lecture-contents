package my.day09.b.array;

import java.util.Random;

public class LottoMain2 {

	public static void main(String[] args) {

		int[] ballArr = new int[45];
		int[] tempArr = new int[5]; //������ �̾Ҵ� ���ȣ�� �������ִ� ����Ұ� �ʿ�

		for (int i=0; i<ballArr.length; i++) {
			ballArr[i] = i+1; //�迭�� �渶�� �����Ͱ� �Է��ϱ�
								//�����Ͱ��� 1~45
		}
		
		for (int i=0; i<tempArr.length; i++) {
			tempArr[i] = -1;
			
		}
		/*
	 		���� ������ ���� ���� ���ȣ(index ��ȣ)�� ����ϴ� ������ ���Ǵ�
	 		������ ���� ���ȣ(index ��ȣ)�� 0(�������� 1����)�� ���� �� �����Ƿ�
	 		�����Ͱ��� ���ȣ(index ��ȣ)�� ������� �ʴ� -1�� ��� �ʱ�ȭ �Ѵ�.
	     */
		
		// ���� ���ȣ(�迭�� index)�� ������ �۾��� 6�� �ݺ�
		// 0�� ����� 44�� ����� �����ϰ� 6�� �̾ƾ� �Ѵ�.
		// ��, 0~44���� ������ �߻�.
		
		Random rnd = new Random();
	    String result = "";
	    
		//***������ ��ġ�� �ʵ��� ������ �ϴ� �ٽ�for��			
		front:
		for (int i=0; i<6; i++) {
			int idx = rnd.nextInt(45);
			for (int j=0; j<tempArr.length; j++) {
				if(idx == tempArr[j]) {
					i--;
					continue front;   //������ �߻������ִ� �ٱ� for������ �����Ѵ�.
				}
			}
			if(i<5) {
				tempArr[i] = idx;				
			}
			
			String comma = (i<5)?",":"";
			result += ballArr[idx]+comma;
		}//end of for -----------------------------
		
		System.out.println("\n�ζ� 1�� ��÷��ȣ : "+result);
	}

}
