package my.day05.c.IF;

public class IfMain {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2 = 20;
		
		if(n1 == n2) {
			System.out.println(n1+ "�� " + n2+ "�� �����ϴ�.");
		} else {
			System.out.println(n1+ "�� " + n2+ "�� ���� �ʽ��ϴ�.");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

// ���ڿ��� ��
		
		String name1 = "�̼���";   //Ŭ�������� ������ó�� ���, ���� ���Ǵϱ�
		String name2 = "�̼���";

		if(name1 == name2) {  //name1 == name2�� name1�� name2�� ���� ���Ѵ�.
			System.out.println(name1+ "�� " + name2+ "�� �����ϴ�.");
		} else {
			System.out.println(name1+ "�� " + name2+ "�� ���� �ʽ��ϴ�.");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		String name3 = new String("������");
		String name4 = new String("������");

		if(name3 == name4) {   //name3 == name4�� name3�� name4�� �޸� �ּ� ���� ���Ѵ�.
			System.out.println(name3+ "�� " + name4+ "�� �����ϴ�.");
		} else {
			System.out.println(name3+ "�� " + name4+ "�� ���� �ʽ��ϴ�.");
		}
//***		
		if(name3.equals(name4)) {   //name3.equals(name4)�� name3�� name4��  ���� ���Ѵ�.
			System.out.println(name3+ "�� " + name4+ "�� �����ϴ�.");
		} else {
			System.out.println(name3+ "�� " + name4+ "�� ���� �ʽ��ϴ�.");
		}
		
	}

}
