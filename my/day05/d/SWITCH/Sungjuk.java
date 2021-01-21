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
		
		//if문과 달리 범위는 쓸 수가 없고, switch()와 case 뒤에 값이 똑같아야 한다.
		//switch() 속에는 String, byte, int, short, char 타입만 가능
		//avg() ==100.0  91.6
		
		String grade = "";
		
		switch ((int)avg()/10) {                      
		  case 10 :
		  case 9 :   //또는 표기에 유의
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
	
	// 상품은
	// 학점이 "A"이라면 "놀이공원이용권, 치킨, 피자, 아이스크림"
	// 학점이 "B"이라면 "치킨, 피자, 아이스크림"
	// 학점이 "C"이라면 "피자, 아이스크림"
	// 학점이 "D"이라면 "아이스크림"
	// 학점이 "F"이라면 "꿀밤3대"
	
	String gift() {
		
		String gift = "";
		
		switch (grade()) {	//switch() 속에는 String, byte, int, short, char 타입만 가능
			case "A":
				gift += "놀이공원이용권, ";		
	
			case "B":
				gift += "치킨, ";		//할당연산자
				
			case "C":
				gift += "피자, ";			
				
			case "D":
				gift += "아이스크림";		
				break;
				
			default:
				gift = "꿀밤3대";
				break;
		}		
		return gift;
	}
	
}
