package my.day06.a.FOR;

public class Quiz1Main {

	public static void main(String[] args) {
		
		String word = "Abz3Sa0#$T";
		
		System.out.println(word+" ���ڿ��� ����(���ڼ�) : "+word.length()+"\n");
		//Abz3Sa0#$T ���ڿ��� ����(���ڼ�) : 10
		
		/*
		    Abz3Sa0#$T
		 	�빮�� ���� : 3
		 	�ҹ��� ���� : 3
		 	���� ���� : 2
		 	Ư������ ���� : 2
		 */
		
		int upperCnt = 0;
		int lowerCnt = 0;
		int digitCnt = 0;
		int simbolCnt = 0;
		
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isUpperCase(ch)) {  //�빮������ �˻�
				upperCnt++;
			} else if(Character.isLowerCase(ch)) {  //�ҹ������� �˻�
				lowerCnt++;
		    } else if(Character.isDigit(ch)) {  //�������� �˻�
				digitCnt++;
		    } else simbolCnt++;  //Ư���������� �˻�
		}
		
		System.out.println(word
				+ "\n�빮���� ���� : "+upperCnt+"\n"
				+ "�ҹ����� ���� : "+lowerCnt+"\n"	
				+ "������ ���� : "+digitCnt+"\n"	
				+ "Ư�������� ���� : "+simbolCnt+"\n");

	}
}
