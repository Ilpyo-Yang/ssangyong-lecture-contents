package my.day17.c.exceptionThrows;

public class MainMember {

	public static void main(String[] args) {

		try {
		
			Member mbr = new Member();
			
			mbr.name = "이순신";
			mbr.kor = "90";
			mbr.eng = "80";
			mbr.math = "70";
			
			mbr.info();
	
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			Member mbr2 = new Member();
			
			mbr2.name = "이순신";
			mbr2.kor = "90";
			mbr2.eng = "80";
			mbr2.math = "70";
			
			mbr2.info();
		
		} catch (Exception e) {
			System.out.println(">> 오류 메시지 내용 : "+e.getMessage());
		}

	}

}
