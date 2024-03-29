package my.day13.a.encapsulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Gujikja {

	/*
		   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스        그외의영역  
		   ----------------------------------------------------------------------------------------------------------------------- 
		   public                                    O                    O                         O                 O  
		   protected                                 O                    O                         O                 X
		   default                                   O                    O                         X                 X
		   private                                   O                    X                         X                 X
	 */	
	
		//field
		private String userid;
		private String passwd;
		private String name;
		private String jubun;   //주민번호 7자리		예:9501151 남자	9501152 여자 
						//주민번호 7자리		예:0101153 남자	0101154 여자
		
		static int count; //gujikja 객체의 개수를 알아오려는 용도
	
		Gujikja() {}      //생략되어 있는 기본생성자
		
		
		
		//method     => field를 처리하고자 할 때 사용
		//static 메서드 내에는 인스턴스 메서드가 들어올 수 없다.
		public void setUserid(String userid) {
			int len = userid.length();
			if(5<=len&&len<=10)
				this.userid = userid;     //지역변수와 인스턴스변수의 구분
			else
				System.out.println(">>> 아이디는 5글자 이상 10글자 이하이어야 합니다. <<<");
		}
		
		public void setPasswd(String passwd) {
			Boolean bool = MyUtil.isCheckPasswd(passwd);
			if (bool) 
				this.passwd = passwd;
			else
				System.out.println(">>> 암호는 8글자 이상 15글자 이하의 대소문자, 숫자, 특수문자로 혼합되어야 합니다. <<<");
		}
		
		public void setName(String name) {
			// name에는 한글만 허용하겠다.
			if(name==null) {
				System.out.println(">>> 성명은 공백없이 한글로만 2~5글자까지만 가능합니다. <<<");
				return;
			}
			
			// 정규표현식(Regular Expression)이란?
	    	// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어 
	    	
	    	// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. ==
			// 2~5 글자, 공백은 안되고 한글만
	    	Pattern p = Pattern.compile("^[가-힣]{2,5}$"); 	    	
	    	
	    	// == 2. 문자열이 주어진 정규식패턴과 일치하는지 판별하는 객체를 생성한다. ==
	    	Matcher m = p.matcher(name);
	    	
	    	// == 3. 판별하도록 한다. ==
	    	//주어진 정규식 패턴과 일치하면 true, 일치하지 않으면 false를 리턴시켜준다.
	    	boolean b = m.matches();

			if (b) 
				this.name = name;
			else
				System.out.println(">>> 성명은 공백없이 한글로만 2~5글자까지만 가능합니다. <<<");
		}
		
		public void setJubun(String jubun) {
			boolean bool = MyUtil.isCheckJubun(jubun);
			if (bool) 
				this.jubun = jubun;
			else
				System.out.println(">>> 주민번호 7자리가 올바르지 않습니다. <<<");
		
		}
		
		// userid, passwd, name, jubun field의 값이 모두 null이 아니라면 
		// true를 return 해주고, 적어도 한 개 이상이 null 이라면 false를 리턴해주는 메서드를 생성한다.
		
		public boolean isUseGujikja() {
			if(userid!=null &&
				passwd!=null &&
				name!=null &&
				jubun!=null) 
				return true;
			else return false;
		}
		
		public String getName() {
			return name;
		}



		public String getUserid() {
			return userid;
		}



		public String getPasswd() {
			return passwd;
		}



		public String getJubun() {
			return jubun;
		}
		
	
}//end of public class Gujikja ----------------------------------
