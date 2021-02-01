package my.day19.e.ENUM;

import java.text.DecimalFormat;
import java.util.*;

import my.day19.e.ENUM.EnteranceFee_2;

public class Main_3 {

	public static void main(String[] args) {

		List<Member_1> mbrList = new ArrayList<>();
		for (int i=0; i<30; i++) {
			
			Member_1 mbr1 = new Member_1();
			mbr1.setName("���"+(i+1));
			mbr1.setJubun("1910203");
			
			mbrList.add(mbr1);
			
		      Member_1 mbr2 = new Member_1();
		      mbr2.setName("û�ҳ�");
		      mbr2.setJubun("0910204");
		
		  	mbrList.add(mbr2);
		  	
		    Member_1 mbr3 = new Member_1();
		    mbr3.setName("����");
		    mbr3.setJubun("9410201");
		    
			mbrList.add(mbr3);

		    Member_1 mbr4 = new Member_1();
		    mbr4.setName("���");
		    mbr4.setJubun("4510202");
		    
			mbrList.add(mbr4);
			
		}// end of for --------------------------------------
		
		int child_cnt = 0, teenager_cnt = 0, adult_cnt = 0, old_cnt = 0;
		for(Member_1 mbr : mbrList) {
			if(mbr.getAge()<10)
				child_cnt++;
			else if(mbr.getAge()<20)
				teenager_cnt++;
			else if(mbr.getAge()<70)
				adult_cnt++;
			else
				old_cnt++;
		}// end of for -------------------------------------
		
		System.out.printf("��� ���ο��� %d��, ������� %d��\n", child_cnt, EnteranceFee_2.CHILD.getRealFee(child_cnt));
		System.out.printf("û�ҳ� ���ο��� %d��, ������� %d��\n", teenager_cnt, EnteranceFee_2.TEENAGER.getRealFee(teenager_cnt));
		System.out.printf("���� ���ο��� %d��, ������� %d��\n", adult_cnt, EnteranceFee_2.ADULT.getRealFee(adult_cnt));
		System.out.printf("��� ���ο��� %d��, ������� %d��\n", old_cnt, EnteranceFee_2.OLD.getRealFee(old_cnt));
	}

}
