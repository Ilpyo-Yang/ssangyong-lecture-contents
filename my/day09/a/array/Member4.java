package my.day09.a.array;

public class Member4 {

		//field
		String id;
		String passwd;
		String name;
		
		static int count;  //Member4 ��ü�� ����ȯ ������ �˷��ְ��� �ϴ� ���
		
		//method
		public String showInfo() {
			return "\n1. ���̵� : "+id+"\n"
					+ "2. ��й�ȣ : "+passwd+"\n"
					+ "3. ���� : "+name+"\n";
					
		}
}
