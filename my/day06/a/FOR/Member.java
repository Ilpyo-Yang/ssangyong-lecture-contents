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
		
		int length = pwd.length();  //�Է¹��� ��й�ȣ ���ڿ��� ����
		if(8 <= length && length <=15) {
			for (int i=0; i<length; i++) {
				char ch = pwd.charAt(i);
				if (Character.isAlphabetic(ch)) {  //intŸ�Կ� charŸ�� ���� �ڵ�����ȯ �߻�
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
		else { //���� ���̰� 8���� �̻� 15���� ���ϰ� �ƴ� ���
			return false;
		}
		
	}
	
	
}
