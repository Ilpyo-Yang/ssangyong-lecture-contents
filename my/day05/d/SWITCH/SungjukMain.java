package my.day05.d.SWITCH;

public class SungjukMain {

	public static void main(String[] args) {
		
		Sungjuk sj = new Sungjuk();
		sj.hakbun = "091234";
		sj.name = "�̼���";
		sj.kor = 0;
		sj.eng = 0;
		sj.math = 88;
		
		System.out.println("���� : "+sj.total());
		System.out.println("��� : "+sj.avg());      //�ݿø�
		System.out.println("���� : "+sj.grade());
		System.out.println("��ǰ : "+sj.gift());		
		// ������ "A"�̶�� "���̰����̿��, ġŲ, ����, ���̽�ũ��"
		// ������ "B"�̶�� "ġŲ, ����, ���̽�ũ��"
		// ������ "C"�̶�� "����, ���̽�ũ��"
		// ������ "D"�̶�� "���̽�ũ��"
		// ������ "F"�̶�� "�ܹ�3��"
	}

}
