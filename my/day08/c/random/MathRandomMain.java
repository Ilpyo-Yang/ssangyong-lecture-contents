package my.day08.c.random;

import java.util.Scanner;

public class MathRandomMain {

	public static void main(String[] args) {
		
		// === ������ ������ �̾ƺ���. ===
		
		double random = Math.random();
		System.out.println("random => "+random);
		//random => 0.5066934813478947
		//random => 0.25630541700328846
		
/*
     java.lang.Math.random() �޼ҵ�� 
     0.0 �̻� 1.0 �̸��� �Ǽ�(double)���� �����ϰ� ��Ÿ�����ִ� �޼ҵ��̴�. 
               ��,  0.0 <= ������ ����(�Ǽ�) < 1.0
           
     1���� 10���� �� ������ ������ ���� ����.
   
             ������ ���� = (int)(Math.random()*��������)+���۰�;
     
     0.0        (int)(0.0*(10-1+1))+1         ==>  1
     0.23346438 (int)(0.23346438*(10-1+1))+1  ==>  3
     0.67835431 (int)(0.67835431*(10-1+1))+1  ==>  7
     0.99999999 (int)(0.99999999*(10-1+1))+1  ==> 10
     
     3 ���� 7������ ������ ������ ���� ����.
     
     0.0        (int)(0.0*(7-3+1))+3         ==>  3
     0.23346438 (int)(0.23346438*(7-3+1))+3  ==>  4
     0.67835431 (int)(0.67835431*(7-3+1))+3  ==>  6
     0.99999999 (int)(0.99999999*(7-3+1))+3  ==>  7
     
     int random2 = (int)(Math.random()*������+���۰�); 
           �������� ��������ȯ
 */
		
		int random1 = (int)(Math.random()*10+1);
		System.out.println("1���� 10���� �� �����ϰ� �߻��� �� => "+random1);
		
		int random2 = (int)(Math.random()*5+3);
		System.out.println("3���� 7���� �� �����ϰ� �߻��� �� => "+random2);
		
		int random3 = (int)(Math.random()*('z'-'a'+1)+'a');
		System.out.println("a���� z���� �� �����ϰ� �߻��� �� => "+(char)(random3));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[����Ű]�� ������ ���� 3���� ������ �ҹ��� 4���� �����.
//��:> 103qdtj 251adfa
		
//1. ���� ������ �ڵ�
		int nb = (int)(Math.random()*900+100);
		char eb = (char)(Math.random()*26+97);
		char eb1 = (char)(Math.random()*26+97);
		char eb2 = (char)(Math.random()*26+97);
		char eb3 = (char)(Math.random()*26+97);
		System.out.println("����Ű => "+nb+eb+eb1+eb2+eb3);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

//2. �� �ڵ�
		String key="";
		for(int i=0; i<3; i++) {
			int num = (int)(Math.random()*10);
			key += num;
		}
		for(int i=0; i<4; i++) {
			int num = (int)(Math.random()*('z'-'a'+1)+'a');
			key += (char)num;
		}

		System.out.println("����Ű => "+key);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[random => ¦������ Ȧ������ ���߱�]
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����[1.Ȧ��/0.¦��] => ");    //����, ����ó�� ����
		String choice = sc.nextLine();
		char ch = choice.charAt(0);  
		//***0�� int�� 48
		//char Ÿ���� ���ڷ� �ٲٷ��� '0' ����
		int choiceNo = ch-'0'; //0 �Ǵ� 1
		
		int randNo = (int)(Math.random()*10+1);
		
		String result = "";
		if (choiceNo == randNo%2) {
			result = "�½��ϴ�";
		} else
			result = "Ʋ�Ƚ��ϴ�";
		System.out.println(result+" �����ϰ� ���� ���� "+randNo+"�Դϴ�.");	
	
	sc.close();	
	}// end of main() ----------------------------
}
