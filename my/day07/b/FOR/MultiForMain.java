package my.day07.b.FOR;

public class MultiForMain {

	public static void main(String[] args) {

		//���� for���� ���ؼ� �˾ƺ���.
		/*
		 	abcdefg     3�� 7��
		 	hijklmn
		 	opqrstu
		 */
		
		char ch = 'a';		
		
		for(int i=0; i<3; i++) { // �ٱ� for�� ==> ��
			for(int j=0; j<7; j++) { // ���� for�� ==> ��
				System.out.print(ch++);
			}
			System.out.print("\n");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~");
		
//�̰� ���� �̻��� �ڵ��̴�		
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
		
		//���� for�� �ڵ�
		for (int i=0; i<'u'-'a'+1;i++) {  //7�� ������� �ٹٲ�
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
		//continue; => continue �� ���� ����� �ݺ����� ���������� �̵��ϴ� ��
		//continue ���̺��; => ���̺���� �ִ� �ݺ����� ���������� �̵��ϴ� ��
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
		
		System.out.println("\n�ȳ��ϼ���\t���� �� �ɰԿ�~~");
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
		 	501ȣ	502ȣ	503ȣ	505ȣ
		 	301ȣ	302ȣ	303ȣ	305ȣ
		 	201ȣ	202ȣ	203ȣ	205ȣ
		 	101ȣ	102ȣ	103ȣ	105ȣ
		 */
		
		for (i=5; i>0 ;i--) {
			if(i==4) continue;
			for (j=1; j<6; j++) { 
				if(j==4) continue;
				System.out.print(i+"0"+j+"ȣ\t");
			}
			System.out.print("\n");
		}
		
		

		
		
	}//end of main --------------------------------

}
