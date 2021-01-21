package my.day11.a.calendar;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarMain {

	public static void main(String[] args) {

		// �ڹٿ��� ��¥�� ��Ÿ�� ���� Date, Calendar�� ����Ѵ�.
		
		// === 1. Date Ŭ������ ����Ͽ� ����ð� ��Ÿ���� ===
		Date now = new Date(); //����ð�
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("��  ����ð� 1 => "+now);
		// ��  ����ð� 1 => Wed Jan 20 15:45:44 KST 2021
		System.out.println("��  ����ð� 2 => "+sdformat.format(now));
		// ��  ����ð� 2 => 2021-01-20 15:45:44
		
		String currentTime = String.format("%tF %tT %tA %tZ", now, now, now, now);
		System.out.println("��  ����ð� 3 => "+currentTime);
		// ��  ����ð� 3 => 2021-01-20 15:45:44 ������ KST
		
		/*
		    <����>
		      ��¥ Ÿ�� format         ����
		     --------------------------------------------------
		      %tF              ��¥�� yyyy-mm-dd �������� �������ִ� ��
		      %tT              ��¥�� �ð��� HH:MM:SS �������� �������ִ� ��  
		      %tp              ����, ���ĸ� ���
		      %tA              ���ϸ� ���
		      %tY              4�ڸ� �⵵�� ���
		      %tB              ���� �̸�(January, February ...)���
		      %tm              ���� 01,02,03 ~~ 10,11,12 �� ���
		      %td              �ϼ��� 1~31 �� ���
		      %te              %td�� ������
		      %tk              �ð��� 0~23 ���� ���
		      %tl              �ð��� 1~12 ���� ���
		      %tM              ���� 00~59 ���� ���
		      %tS              �ʸ� 00~59 ���� ���
		      %tZ              Ÿ������ ���(�ѱ��� KST�� ����).
	   */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		  /* 
		        Date Ŭ���� ���� ���ݴ� �����Ѽ� ���� ���� Calendar Ŭ�����̴�.
			        ������ ��¥ǥ������ Date Ŭ������ ����ϴ� ���� �� ���� �� ������,
			        �ΰ� ��¥������ ��¥������ �� ��쿡�� �޼ҵ����� �� ���� �߰��� 
			    Calendar Ŭ������ ����ϴ� ���� ���� �� �ִ�.
		   */  
		
		   Calendar currentDate = Calendar.getInstance(); // ���糯¥�� �ð��� ���´�.
		   
		   int year = currentDate.get(Calendar.YEAR);
		   int month = currentDate.get(Calendar.MONTH);
		   // 0~11 ���� �����Ƿ� �����ؾ� �Ѵ�.
		   System.out.println("month => "+month);
		   // month => 0
		   
		   String strMonth = month<10?"0"+month:String.valueOf(month);
		   							//���ڿ����� 00 01 02 03 04 ...
		   /* 
			         �����ؾ��� ���� get(Calendar.MONTH)�� ������ ���� ������ 1~12�� �ƴ�, 0~11 �̶�� ���̴�. 
			         �׷��� get(Calendar.MONTH)�� ������ ���� 0�̸� 1���� �ǹ��ϰ� 11�̸� 12���� �ǹ��Ѵ�.
			         �׷��Ƿ� ������� ǥ���Ϸ��� ( currentDate.get(Calendar.MONTH) + 1 ) ���� �ؾ��Ѵ�. 
			         ��ȣ���� currentDate.get(Calendar.MONTH) + 1�� �ϸ� �̻��� ���� ���´�. (��ȣ��������!!) 
		   */
		   
		   int month2 = currentDate.get(Calendar.MONTH)+1;
		   System.out.println("month2 => "+month2);
		   //month2 => 1
		   String strMonth2 = month2<10?"0"+month2:String.valueOf(month);
		                                   //01���� �����ϰ� ó���� month2�� 1�� ������� �Ѵ�.
		   
		   System.out.println("�� ���� �⵵ : " + year);
		    System.out.println("��(0~11, 0:1��): " + strMonth);
		    System.out.println("��(1~12, 1:1��): " + strMonth2);
		
		    System.out.println("�� ���� �� ° ��: " + currentDate.get(Calendar.WEEK_OF_YEAR));
		    System.out.println("�� ���� �� ° ��: " + currentDate.get(Calendar.WEEK_OF_MONTH));
		
		    // �Ʒ��� Calendar.DATE �� Calendar.DAY_OF_MONTH �� ���� ���̴�.
		    int day = currentDate.get(Calendar.DATE);
		    String strDay = day<10?"0"+day:String.valueOf(day);
		    
		    System.out.println("�� ���� �� ��: " + currentDate.get(Calendar.DATE));
		    System.out.println("�� ���� �� ��: " + currentDate.get(Calendar.DAY_OF_MONTH));
		    System.out.println("�� ���� �� ��: " + strDay);
		    System.out.println("�� ���� �� ��: " + currentDate.get(Calendar.DAY_OF_YEAR));
		    
		    // 1:�Ͽ���, 2:������, 3:ȭ����, 4:������, 5:�����, 6:�ݿ���, 7:�����
		    System.out.println("����(1~7, 1:�Ͽ���): " + currentDate.get(Calendar.DAY_OF_WEEK)); 
		    System.out.println("�� ���� �� ° ����: " + currentDate.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		    
		    String dayname = "";
		    switch (currentDate.get(Calendar.DAY_OF_WEEK)) {
		         case 1:
		            dayname = "��";
		            break;
		   
		         case 2:
		            dayname = "��";
		            break;
		            
		         case 3:
		            dayname = "ȭ";
		            break;   
		            
		         case 4:
		            dayname = "��";
		            break;   
		            
		         case 5:
		            dayname = "��";
		            break;   
		            
		         case 6:
		            dayname = "��";
		            break;
		            
		         case 7:
		            dayname = "��";
		            break;   
		      }
		    
		    System.out.println("������ " + dayname + "���� �Դϴ�.");
		    // ������ ������ �Դϴ�.
		    
		    System.out.println("����_����(0:����, 1:����): " + currentDate.get(Calendar.AM_PM));
		    System.out.println("�ð�(0~11): " + currentDate.get(Calendar.HOUR));
		    System.out.println("�ð�(0~23): " + currentDate.get(Calendar.HOUR_OF_DAY));
		    System.out.println("��(0~59): " + currentDate.get(Calendar.MINUTE));
		    System.out.println("��(0~59): " + currentDate.get(Calendar.SECOND));
		    System.out.println("1000���� 1��(0~999): " + currentDate.get(Calendar.MILLISECOND));
		    
		    // õ���� 1�ʸ� �ð����� ǥ���ϱ� ���� 3600000���� ��������.(1�ð� = 60 * 60��)
		    System.out.println("TimeZone(-12~+12): " + (currentDate.get(Calendar.ZONE_OFFSET)/(60*60*1000))); 
		    
		    // �� ���� ������ ���� ã�´�.
		    System.out.println("�� ���� ������ ��: " + currentDate.getActualMaximum(Calendar.DATE) ); 
		   
		    System.out.println("");
		      
		    String today = year+"-"+strMonth2+"-"+strDay;
		    today += " " + currentDate.get(Calendar.HOUR_OF_DAY) +":"+ ( currentDate.get(Calendar.MINUTE)<10?"0"+currentDate.get(Calendar.MINUTE):currentDate.get(Calendar.MINUTE) ) +":"+ ( currentDate.get(Calendar.SECOND)<10?"0"+currentDate.get(Calendar.SECOND):currentDate.get(Calendar.SECOND) );         
		    
		    switch (currentDate.get(Calendar.DAY_OF_WEEK)) {
		         case 1:
		            today += " �Ͽ���";
		            break;
		         case 2:
		            today += " ������";
		            break;   
		         case 3:
		            today += " ȭ����";
		            break;
		         case 4:
		            today += " ������";
		            break;
		         case 5:
		            today += " �����";
		            break;
		         case 6:
		            today += " �ݿ���";
		            break;   
		         case 7:
		            today += " �����";
		            break;
		      }
		    
		    System.out.println("����� " + today + " �Դϴ�.");
		    
		    // === ����ð� ��Ÿ���� === //
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    System.out.println("����ð� => " + dateFormat.format(currentDate.getTime()));
		         
		    // === ���Ͻð� ��Ÿ���� === //
		    currentDate.add(Calendar.DATE, 1); 
		    System.out.println("���Ͻð� => " + dateFormat.format(currentDate.getTime()));
			}

}
