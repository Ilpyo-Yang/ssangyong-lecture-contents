package my.day08.c.random;

import java.util.*;

public class RandomMain {

	public static void main(String[] args) {
		
// ���Ȼ� Math.random() ���ٴ� new Random(); �� ����ϴ� ���� �� �����ϴ�.
		
		// === ������ ������ �̾ƺ���. ===
		
		Random rnd = new Random();
	//	int rndNum = rnd.nextInt(�������� - ó���� + 1)+ó����;
		
		int random1 = rnd.nextInt(10-1+1)+1;
		System.out.println("1���� 10���� �� �����ϰ� �߻��� �� => "+random1);
		
		int random2 = rnd.nextInt(7-3+1)+1;
		System.out.println("3���� 7���� �� �����ϰ� �߻��� �� => "+random2);
		
		int random3 = rnd.nextInt(('z'-'a'+1)+'a');
		System.out.println("a���� z���� �� �����ϰ� �߻��� �� => "+(char)(random3));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[����Ű]�� ������ ���� 3���� ������ �ҹ��� 4���� �����.
//��:> 103qdtj 251adfa

		String key="";
		for(int i=0; i<3; i++) {
			int num = rnd.nextInt(9-0+1)+0;
			key += num;
		}
		for(int i=0; i<4; i++) {
			int num = rnd.nextInt('z'-'a'+1)+'a';
			key += (char)num;
		}

		System.out.println("����Ű => "+key);
				
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//[random => ¦������ Ȧ������ ���߱�]
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����[1.Ȧ��/0.¦��] => ");    //����, ����ó�� ����
		String choice = sc.nextLine();
		char ch = choice.charAt(0);  
		//***0�� int�� 48
		//char Ÿ���� ���ڷ� �ٲٷ��� '0' ����
		int choiceNo = ch-'0'; //0 �Ǵ� 1
		
		int randNo = rnd.nextInt(10-1+1)+1;
		
		String result = "";
		if (choiceNo == randNo%2) {
			result = "�½��ϴ�";
		} else
			result = "Ʋ�Ƚ��ϴ�";
		System.out.println(result+" �����ϰ� ���� ���� "+randNo+"�Դϴ�.");	
	
	sc.close();	
	}// end of main() ----------------------------
}
