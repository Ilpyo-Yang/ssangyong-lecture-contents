package my.day05.d.SWITCH;

public class Sungjuk {

	//field
	String hakbun;
	String name;
	int kor;
	int eng;
	int math;
		
	//method
	
	int total() {
		return kor+eng+math;
	}
	
	float avg() {
		return Math.round(total()/3.0f*10)/10.0f;
	}
	
	String grade() {
		
		//if���� �޸� ������ �� ���� ����, switch()�� case �ڿ� ���� �Ȱ��ƾ� �Ѵ�.
		//switch() �ӿ��� String, byte, int, short, char Ÿ�Ը� ����
		//avg() ==100.0  91.6
		
		String grade = "";
		
		switch ((int)avg()/10) {                      
		  case 10 :
		  case 9 :   //�Ǵ� ǥ�⿡ ����
			  grade = "A";
			  break;
			  
		  case 8 :
			  grade = "B";
			  break;
			  
		  case 7 :
			  grade = "C";
			  break;
			  
		  case 6 :
			  grade = "D";
			  break;
			  
		default:
			grade = "F";
			break;
		}//end of switch()
		
		return grade;
	}
	
	// ��ǰ��
	// ������ "A"�̶�� "���̰����̿��, ġŲ, ����, ���̽�ũ��"
	// ������ "B"�̶�� "ġŲ, ����, ���̽�ũ��"
	// ������ "C"�̶�� "����, ���̽�ũ��"
	// ������ "D"�̶�� "���̽�ũ��"
	// ������ "F"�̶�� "�ܹ�3��"
	
	String gift() {
		
		String gift = "";
		
		switch (grade()) {	//switch() �ӿ��� String, byte, int, short, char Ÿ�Ը� ����
			case "A":
				gift += "���̰����̿��, ";		
	
			case "B":
				gift += "ġŲ, ";		//�Ҵ翬����
				
			case "C":
				gift += "����, ";			
				
			case "D":
				gift += "���̽�ũ��";		
				break;
				
			default:
				gift = "�ܹ�3��";
				break;
		}		
		return gift;
	}
	
}
