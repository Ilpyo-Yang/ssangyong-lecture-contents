package my.day13.a.encapsulation;

public class GujikjaMain {
	
	public static void main(String[] args) {
		
		Gujikja[] guArr = new Gujikja[5];
		Gujikja gu1 = new Gujikja();
		//The constructor Gujikja() is not visible
		//encapsulation ���������ڸ� private�� �ؼ� �� �� ������.

			//	gu1.setUserid("oeriwjflskdmnkm;lddfgh");
			//	>>> ���̵�� 5���� �̻� 10���� �����̾�� �մϴ�. <<<
			gu1.setUserid("hongkd");
			gu1.setPasswd("qwer1234/*Q");
			gu1.setName("ȫ�浿");
			gu1.setJubun("9501221");
			
			if(gu1.isUseGujikja())
				guArr[0] = gu1;
			
		Gujikja gu2 = new Gujikja();
			gu2.setUserid("eomjh");
			gu2.setPasswd("qwer1234/*V");
			gu2.setName("����ȭ");
			gu2.setJubun("9701222");
			
			if(gu2.isUseGujikja())
				guArr[1] = gu2;
			
			for (int i=0; i<guArr.length; i++) {
				if(guArr[i]!=null)
				System.out.println(guArr[i].getUserid());
			}
			/*
				my.day13.a.encapsulation.Gujikja@15db9742
				my.day13.a.encapsulation.Gujikja@6d06d69c
				null
				null
				null
				
				ȫ�浿
				����ȭ
				Exception in thread "main" java.lang.NullPointerException
					at my.day13.a.encapsulation.GujikjaMain.main(GujikjaMain.java:33)
			*/
			
			
			
		
	}//end of main ----------------------------

}
