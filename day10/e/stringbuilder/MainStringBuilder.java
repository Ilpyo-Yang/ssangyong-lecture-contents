package my.day10.e.stringbuilder;

public class MainStringBuilder {

	public static void main(String[] args) {

		String name = "�ϼ���";			//�޸� �� 1�� ����
					name += ",�̼���";		//�޸� �� 1�� ����
					name += ",�����";		//�޸� �� 1�� ����	
					name += ",�����";		//�޸� �� 1�� ����
					name += ",������";		//�޸� �� 1�� ����
					name += ",������";		//�޸� �� 1�� ����
					name += ",ĥ����";		//�޸� �� 1�� ����
					name += ",�ȼ���";		//�޸� �� 1�� ����
					name += ",������";		//�޸� �� 1�� ����
					
													//������ �޸𸮻��� name�� �� 9�� ����
															
		System.out.println(name);
		
		name = "��";
		System.out.println(name);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		StringBuilder sb = new StringBuilder();
		sb.append("�ϼ���");
		sb.append(",�̼���");
		sb.append(",�����");
		sb.append(",�����");
		sb.append(",������");
		sb.append(",������");
		sb.append(",ĥ����");
		sb.append(",�ȼ���");
		sb.append(",������");
		
		System.out.println(sb.toString());
		
		// StringBuilder �� �ʱ�ȭ
		sb.setLength(0);

		sb.append("��");
		System.out.println(sb.toString());
		
	}

}
