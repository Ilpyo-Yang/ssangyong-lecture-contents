package my.day18.a.collection;

public class Member {

	String id;
	String passwd;
	String name;
	
	public Member() { }
	
	public Member(String id, String passwd, String name) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	
	public void infoPrint() {
		System.out.println("== "+name+"���� ȸ������ ==\n"
							+ "1. ���̵� : "+id+"\n"
							+ "2. ��ȣ : "+passwd+"\n"
							+ "3. ���� : "+name+"\n");
	}
	
}
