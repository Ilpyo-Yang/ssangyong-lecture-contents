package my.day13.b.inheritance;

import my.util.MyUtil;

public class Gujikja extends Member {	//자손클래스
// Gujikja 클래스는 Member 클래스의 자식 클래스가 되어진다.
// 그러므로 자식클래스인 Gujikja에서는 부모 클래스인 Member 에서 선언되어진 것들을 
// 상속받아 사용할 수 있게 된다.
	
		//구직자
	
		//field
		private String jubun;   //주민번호 7자리		예:9501151 남자	9501152 여자 
								//주민번호 7자리		예:0101153 남자	0101154 여자
		
		static int count; //gujikja 객체의 개수를 알아오려는 용도
	
		Gujikja() {}      //생략되어 있는 기본생성자
		
		
		//method     => field를 처리하고자 할 때 사용
		//static 메서드 내에는 인스턴스 메서드가 들어올 수 없다.

		
		public void setJubun(String jubun) {
			boolean bool = MyUtil.isCheckJubun(jubun);
			if (bool) 
				this.jubun = jubun;
			else
				System.out.println(">>> 주민번호 7자리가 올바르지 않습니다. <<<");
		
		}
		
		public String getJubun() {
			return jubun;
		}
		
		// userid, passwd, name, jubun field의 값이 모두 null이 아니라면 
		// true를 return 해주고, 적어도 한 개 이상이 null 이라면 false를 리턴해주는 메서드를 생성한다.
		
		public boolean isUseGujikja() {
			if(super.getId()!=null &&
			   this.getPasswd()!=null &&
			   getName()!=null &&
			   jubun!=null) 
			   return true;
			else return false;
		}
		
		String showGu() {
			return "1. 아이디: "+getId()+"\n"
				 + "2. 비밀번호 : "+getPasswd()+"\n"
				 + "3. 이름 : "+getName()+"\n"
				 + "4. 주민번호 : "+getJubun();
			
		}
		
}//end of public class Gujikja ----------------------------------
