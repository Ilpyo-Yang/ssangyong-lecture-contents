package my.day09.a.array;

public class Member4 {

		//field
		String id;
		String passwd;
		String name;
		
		static int count;  //Member4 객체를 생성환 개수를 알려주고자 하는 용어
		
		//method
		public String showInfo() {
			return "\n1. 아이디 : "+id+"\n"
					+ "2. 비밀번호 : "+passwd+"\n"
					+ "3. 성명 : "+name+"\n";
					
		}
}
