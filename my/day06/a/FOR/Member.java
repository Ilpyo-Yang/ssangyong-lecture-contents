package my.day06.a.FOR;

public class Member {

	//field
	String id;
	String pwd;
	String name;
		
	//method
	//sample pwd ==> "Ab123$"  ==> false
	//sample pwd ==> "Ab123cdef"  ==> false
	
	Boolean checkPwd(String pwd) {

		boolean alphabetFlag = false, numFlag = false, sepcialFlag = false;
		
		int length = pwd.length();  //입력받은 비밀번호 문자열의 길이
		if(8 <= length && length <=15) {
			for (int i=0; i<length; i++) {
				char ch = pwd.charAt(i);
				if (Character.isAlphabetic(ch)) {  //int타입에 char타입 쓰면 자동형변환 발생
					alphabetFlag = true;					
				} else if (Character.isDigit(ch)) {  
					numFlag = true;	
				} else
					sepcialFlag = true;					
			}//end of for--------------------------------------------
			
			if(alphabetFlag && numFlag && sepcialFlag) {
				return true;
			} else return false;
		}
		else { //글자 길이가 8글자 이상 15글자 이하가 아닌 경우
			return false;
		}
		
	}
	
	
}
