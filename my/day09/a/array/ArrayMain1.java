package my.day09.a.array;

public class ArrayMain1 {

	public static void main(String[] args) {

/*
 	=== �迭(array)�̶�? ===
 	������ ������Ÿ���� ������ ���� ���� �����͸� ������ �� �ִ� ������ Ÿ���� ���Ѵ�.
 	�׸��� �迭 �Ǵ� ��ü��� ����� �� ����ϵ��� ����!!
 */
		
		//1. == �迭�� ���� ===
		//int subjectArr[]; �� �����ϳ� �ַ� ���Ǵ� ���� �Ʒ� ���
			int[] subjectArr;
		
		//2. == ����Ǿ��� �迭�� �޸𸮿� �Ҵ��� ���ش�. ==
			subjectArr = new int[7];
		
		/*
		 	---------------
		 	|0|1|2|3|4|5|6|
		 	---------------
		 	���� ���ڴ� �迭�� �ε����� ����Ű�� ��ȣ�ν� 0���� �����Ͽ� 1�� �����Ѵ�. 
		 	�迭�� �ε����� "�迭�� ���ȣ"��� ���� �θ���.
		 	
		 	�迭�� ����� �����͸� ǥ���� ���� �Ʒ��� ���� �迭��[�ε�����ȣ]�� ��Ÿ����.
		 	subjectArr[0]
		 	subjectArr[1]
		 	subjectArr[2]
		 	subjectArr[3]
		 	subjectArr[4]
		 	subjectArr[5]
		 	subjectArr[6]
		 	subjectArr[7] ==> �������� �����Ƿ� ����!!
		 	
		 	�迭�� ����� �������� �ڵ������� �ʱⰪ�� ����.
		 	������ 0, �Ǽ��� 0.0, char�� ' ', String�� ������ ��ü�� null �� ���´�. 
		 */
		
		// === �迭�� ũ��(����)�� �迭��.length �� �˾ƿ´�. ===
		System.out.println("�迭 subjectArr �� ���� : "+subjectArr.length);
		// �迭 subjectArr �� ���� : 7
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<subjectArr.length; i++) {
			int val = subjectArr[i];
			System.out.println("subjectArr["+i+"] => " +val);
		}
		
		// 3. == �����Ͱ��� �־��ֱ� ==
		subjectArr[0] = 100;
		subjectArr[1] = 90;
		subjectArr[2] = 95;
		subjectArr[3] = 70;
		subjectArr[4] = 60;
		subjectArr[5] = 100;
		subjectArr[6] = 98;
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<subjectArr.length; i++) {
			int val = subjectArr[i];
			System.out.println("subjectArr["+i+"] => " +val);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		int sum = 0;
		for(int i=0; i<subjectArr.length; i++) {
			sum += subjectArr[i];
		}
		System.out.println("���� : " +sum);
		//���� : 613
		
		double avg = Math.round((double)sum/subjectArr.length*10)/10.0;   //***���Ŀ� ����!!!
		System.out.println("��� : " +avg);
		//��� : 87.6
		
		System.out.println("\n=========================\n");
		
/*
 	���� 1. == �迭�� ���� === �� 2. == ����Ǿ��� �迭�� �޸𸮿� �Ҵ��� ���ش�. == ��
 	���� ���� ���� �ʰ� �Ʒ��� ���� ���ÿ� �� �� �ִ�.		 	
 */
		
			int[] subjectArr2 = new int[7];
			
			// 3. == �����Ͱ��� �־��ֱ� ==
			subjectArr2[0] = 100;
			subjectArr2[1] = 90;
			subjectArr2[2] = 95;
			subjectArr2[3] = 70;
			subjectArr2[4] = 60;
			subjectArr2[5] = 100;
			subjectArr2[6] = 98;
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			for(int i=0; i<subjectArr2.length; i++) {
				int val = subjectArr2[i];
				System.out.println("subjectArr2["+i+"] => " +val);
			}
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			sum = 0;
			for(int i=0; i<subjectArr2.length; i++) {
				sum += subjectArr2[i];
			}
			System.out.println("���� : " +sum);
			//���� : 613
			
			avg = Math.round((double)sum/subjectArr2.length*10)/10.0;   //***���Ŀ� ����!!!
			System.out.println("��� : " +avg);
			//��� : 87.6
			
			System.out.println("\n=========================\n");
			
			
/*
 	���� 1. == �迭�� ���� === �� 2. == ����Ǿ��� �迭�� �޸𸮿� �Ҵ��� ���ش�. == ��
 	3. == �����Ͱ��� �־��ֱ� == �� �Ʒ��� ���� ���ÿ� �� �� �ִ�.		 	
 */
			
				int[] subjectArr3 = new int[] {100,90,95,70,60,100,98};
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				for(int i=0; i<subjectArr3.length; i++) {
					int val = subjectArr3[i];
					System.out.println("subjectArr3["+i+"] => " +val);
				}
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				sum = 0;
				for(int i=0; i<subjectArr3.length; i++) {
					sum += subjectArr3[i];
				}
				System.out.println("���� : " +sum);
				//���� : 613
				
				avg = Math.round((double)sum/subjectArr3.length*10)/10.0;   //***���Ŀ� ����!!!
				System.out.println("��� : " +avg);
				//��� : 87.6

				System.out.println("\n=========================\n");
				
				
/*
 	����  1. == �迭�� ���� === �� 
 		2. == ����Ǿ��� �迭�� �޸𸮿� �Ҵ��� ���ش�. == ��
 		3. == �����Ͱ��� �־��ֱ� == �� �Ʒ��� ���� ���ÿ� �� �� �ִ�.	
 		new int[]�� ���� �����ϴ�!
 */
			
				int[] subjectArr4 = {100,90,95,70,60,100,98};
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				for(int i=0; i<subjectArr4.length; i++) {
					int val = subjectArr4[i];
					System.out.println("subjectArr4["+i+"] => " +val);
				}
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				sum = 0;
				for(int i=0; i<subjectArr4.length; i++) {
					sum += subjectArr4[i];
				}
				System.out.println("���� : " +sum);
				//���� : 613
				
				avg = Math.round((double)sum/subjectArr4.length*10)/10.0;   //***���Ŀ� ����!!!
				System.out.println("��� : " +avg);
				//��� : 87.6
				
				System.out.println("\n=========================\n");
				
				//>>> Ȯ��� for��(== ������ for��, == for each��) <<<
				int total = 0;
				for(int subject : subjectArr4) {
					// subjectArr4 �迭�� ���̸�ŭ �ݺ��Ѵ�.
					// �ݺ��ϸ鼭 �迭�濡 ����ִ� ���� �������� int subject ���� �ӿ� �־��ش�.
					System.out.println(subject);
					total += subject;
				}
				System.out.println("���� : " +total);
	}

}
