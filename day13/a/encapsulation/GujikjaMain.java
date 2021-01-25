package my.day13.a.encapsulation;

public class GujikjaMain {
	
	public static void main(String[] args) {
		
		Gujikja[] guArr = new Gujikja[5];
		Gujikja gu1 = new Gujikja();
		//The constructor Gujikja() is not visible
		//encapsulation 접근제어자를 private로 해서 볼 수 없었다.

			//	gu1.setUserid("oeriwjflskdmnkm;lddfgh");
			//	>>> 아이디는 5글자 이상 10글자 이하이어야 합니다. <<<
			gu1.setUserid("hongkd");
			gu1.setPasswd("qwer1234/*Q");
			gu1.setName("홍길동");
			gu1.setJubun("9501221");
			
			if(gu1.isUseGujikja())
				guArr[0] = gu1;
			
		Gujikja gu2 = new Gujikja();
			gu2.setUserid("eomjh");
			gu2.setPasswd("qwer1234/*V");
			gu2.setName("엄정화");
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
				
				홍길동
				엄정화
				Exception in thread "main" java.lang.NullPointerException
					at my.day13.a.encapsulation.GujikjaMain.main(GujikjaMain.java:33)
			*/
			
			
			
		
	}//end of main ----------------------------

}
