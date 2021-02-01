package my.day19.b.ENUM;

public class EnumMain_2 {

	public static void main(String[] args) {

	      // ��� enum(������)�� �߻� Ŭ���� Enum �� �ڼ��̴�. 
	      // ��, enum(������)�� ������ java.lang.Enum Ŭ�����̴�.
	      // �׷��Ƿ� enum(������)Ÿ���� Ŭ�����̸� java.lang.Enum Ŭ�������� ���ǵǾ��� �޼ҵ���� ����� �� �ְ� �ȴ�.

		SeasonType_1[] seasonArr = SeasonType_1.values();
		// values() �޼���� enum(������)�� ��� ����� �迭�� ��� ��ȯ���ִ� ���̴�.
		
		System.out.println("1. ~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (SeasonType_1 season :  seasonArr ) {
			String seasonName = season.name();
			// name() �޼���� enum(������) ����� ���� ���ڿ�(String)�� ��ȯ���ִ� ���̴�.
			
			System.out.println(seasonName);
		}
		
		/*
		 	��
			����
			����
			�ܿ�
		 */
		
		System.out.println("2. ~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (SeasonType_1 season :  seasonArr ) {
			int order = season.ordinal();
			// ordinal() �޼ҵ�� enum(������) ����� ���ǵ� ������ ��ȯ���ִ� ���̴�.
	        // ������ 0 ���� �����Ѵ�.
			String seasonName = season.name();
			System.out.println(order+"."+seasonName);
			/*
			 		0.��
					1.����
					2.����
					3.�ܿ�
			 */
		}

		System.out.println("3. ~~~~~~~~~~~~~~~~~~~~~~\n");
		
		try {
		SeasonType_1 season1 = SeasonType_1.valueOf("����");
		// valueOf()�޼ҵ�� ������ SeasonType_1 ���� ���ڿ� "����" �� ��ġ�ϴ� ������ ����� ��ȯ���ִ� ���̴�.
		
		System.out.println(season1);
		// ����
		
		season1 = SeasonType_1.valueOf("�ѿ���");
		System.out.println(season1);
		} catch(IllegalArgumentException e) {
			System.out.println(">> ������ ����� �����ϴ�. <<");
		}
		
		
	}// end of main() ---------------------------------

}
