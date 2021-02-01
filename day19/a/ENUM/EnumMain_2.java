package my.day19.a.ENUM;

import java.util.Calendar;

public class EnumMain_2 {

	public static void main(String[] args) {

		// ���� ��¥�� �ð��� ���´�.
		Calendar currentDate = Calendar.getInstance();
		int currentMonth = currentDate.get(Calendar.MONTH)+1;
		
		System.out.println(currentMonth);
		// 2
		
		String season = null;
		
		if(1<= currentMonth && currentMonth <=2 || currentMonth == 12) {
			season = Season_1.WINTER;
		} else if (3<= currentMonth && currentMonth <=5) {
			season = Season_1.SPRING;
		} else if (6<= currentMonth && currentMonth <=8) {
			season = Season_1.SUMMER;
		} else if (9<= currentMonth && currentMonth <=11) {
			season = Season_1.WINTER;
		}
			
		System.out.println(season);
		// �ܿ�
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		

		if(1<= currentMonth && currentMonth <=2 || currentMonth == 12) {
			season = "������";
		} else if (3<= currentMonth && currentMonth <=5) {
			season = "ȣȣȣ";
		} else if (6<= currentMonth && currentMonth <=8) {
			season = "������";
		} else if (9<= currentMonth && currentMonth <=11) {
			season = "������";
		}
			
		System.out.println(season);
		// ������
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	/*
        ���� ���� �츮�� ����ϴ� ���� 4������(��,����,����,�ܿ�)�� �ƴ� String Ÿ�Ը� �Ǹ� � ���̵��� 
        ���� �� �ֱ� ������ �ڹٴ� ������ �ƴ����� ����� ���鿡���� ������ �߻��� �� �ִ�.
        �̷��� ��� "���� ������ ������� ����"�� �ǹ��ϴ� enum(������)�̶�� Ÿ���� ����Ͽ� �ذ��� �� �ִ�.
     */
		
		SeasonType_3 sType = null;
		
		if(1<= currentMonth && currentMonth <=2 || currentMonth == 12) {
			sType = SeasonType_3.�ܿ�;
		} else if (3<= currentMonth && currentMonth <=5) {
			sType = SeasonType_3.��;
		} else if (6<= currentMonth && currentMonth <=8) {
			sType = SeasonType_3.����;
		} else if (9<= currentMonth && currentMonth <=11) {
			sType = SeasonType_3.����;
		}
			
		System.out.println(sType);
		// �ܿ�
	
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// sType ���� ���� enum ���� ���ŵ� 
	    // SeasonType.��  SeasonType.����  SeasonType.����  SeasonType.�ܿ�  �̿��� ���� ���� �� ���� �ȴ�.
	    // �׷��Ƿ� �Ʒ��� ���� �� �� ���� �ȴ�.
		
		/*
		if(1<= currentMonth && currentMonth <=2 || currentMonth == 12) {
			sType = "������";		// �����߻���.
		}
		*/
		
		switch (sType) {
		//	case "������":		// �����߻���
		//	case SeasonType_3.��:		// SeasonType_3.�� �̶�� �ϸ� �����߻���	
		case ��:
			System.out.println("������ ���Դϴ�.");
				break;
		case ����:
			System.out.println("���� �����Դϴ�.");
				break;
		case ����:
			System.out.println("�ÿ��� �����Դϴ�.");
				break;
		case �ܿ�:
			System.out.println("�߿� �ܿ��Դϴ�.");
				break;

		default:
			break;
		}
		
		
		
	}// end of main() ---------------------------------

}
