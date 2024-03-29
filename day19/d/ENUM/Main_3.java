package my.day19.d.ENUM;

import my.day15.c.superConstructor.Child;
import my.day19.c.ENUM.EntranceFee_2;

public class Main_3 {

	public static void main(String[] args) {
		
		  Member_1 mbr1 = new Member_1();
	      mbr1.setName("어린이");
	      mbr1.setJubun("1910203");
	      
	      Member_1 mbr2 = new Member_1();
	      mbr2.setName("청소년");
	      mbr2.setJubun("0910204");
	      
	      Member_1 mbr3 = new Member_1();
	      mbr3.setName("성년");
	      mbr3.setJubun("9410201");

	      Member_1 mbr4 = new Member_1();
	      mbr4.setName("어르신");
	      mbr4.setJubun("4510202");
		
	      Member_1[] mbrArr = {mbr1, mbr2, mbr3, mbr4};
	      
	      // EntranceFee_2 fee = new EntranceFee_2(4567);
	      
	      for (Member_1 mbr : mbrArr) {
	      //toString()의 오버라이딩
	      //System.out.println(mbr.toString()); 또는
	        System.out.println(mbr);
	        
	        int age = mbr.getAge();
	        EntranceFee_2 fee = null;
	        
	        if(age<10) {
	        	fee = EntranceFee_2.CHILD;
	        } else if(10<=age && age<20) {
	        	fee = EntranceFee_2.TEENAGER;
	        } else if(20<=age && age<30) {
	        	fee = EntranceFee_2.ADULT;
	        } else 
	        	fee = EntranceFee_2.OLD;
		           
	        System.out.println("4. 입장료 : "+fee.getFee()+"원");
	        
			System.out.println("");
		}
	}

}
