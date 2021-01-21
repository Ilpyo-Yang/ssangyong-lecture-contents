package my.day08.a.WHILE;

public class WhileMain {

/*
	   === while �� ���� ===
	   
	      ������ �ʱ�ȭ;
	      
	   while(���ǽ�) {
		      ���ǽ��� ��(true)�̶�� �ݺ��ؼ� ������ ��ɹ��� �����ϰ�,
		      ���ǽ��� ����(false)�̶�� while�� { } �̺κ��� ����������. 
		      
		      �ݺ��ؼ� ������ ��ɹ�;
		      ������;
	   }
*/
	
	public static void main(String[] args) {

		int cnt=5, loop=0;
		while(loop < cnt) {
			System.out.println((loop+1)+". �ȳ� �ڹ�~~");   //�������� �����ϱ�
			loop++;
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		cnt=5; loop=0;
		while(loop++ < cnt) {
			System.out.println(loop+". Hello java~~");	//�������� �����ϱ�
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		cnt=5; loop=0;
		while(loop < cnt) {  //���������� ���ѷ���
			System.out.println(++loop+". Hi Eclipse~~");	//�������� �����ϱ�
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		loop=0;
		while(true) {  //������ �� ���ѷ���
			System.out.println(++loop+". Hi ��Ŭ����~~");	
			if(loop == 5) break;
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		//while���� ! ���� ���� ����
		//!() => while���� �������� ���ǽ��� ���ǳ�����
		loop=0;
		while(!(++loop>5)) {  
			System.out.println(loop+". �ȳ� ����Ŭ~~");	//�������� �����ϱ�
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
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
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		loop=0;
		while(true) {  
			if(++loop>10) break;   //Ż������
			if(loop%2 == 0) continue;   //�Ʒ��� �ȳ������� ()������
			System.out.println(loop +". Hi oooooOracle~~");	
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");
		
		System.out.println("=== 5�� ===");
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
		System.out.println("=== 6�� ===");
		loop=0;
		while(true) { 
			if(++loop>9) break;
			System.out.println("6*"+loop+"="+6*loop);	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=== 7�� ===");
		loop=0;
		while(!(++loop>9)) { //while���� Ż�������� ����		
			System.out.println("7*"+loop+"="+7*loop);	
		}//end of while -----------------------------
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("%35s","=== ������ ===\n"); 
		//9�� 8��
		//jul dan
		int jul=0, dan=1;
		
		while(!(++jul>9)) { //9��
			while(!(++dan>9)) { //8��
				String str = (dan<9)?"\t":"\n";   //���׿�����
				System.out.print(dan+"*"+jul+"="+jul*dan+str);	
			}
			dan=1;     //�ʱ�ȭ ���ְ� �ٹٲ�
		}//end of while -----------------------------
		
		System.out.println("=== ���α׷� ���� ===\n");

	}//end of main ----------------------------------

}
