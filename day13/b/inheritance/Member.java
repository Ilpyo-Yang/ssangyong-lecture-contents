package my.day13.b.inheritance;
//getter and setter 찾아보기
//get은 속성값을 넘길 때, private로 되었을 때 원하는 방식으로 넘김?
//set은 파라미터 값을 가지고 연산을 할 때 사용?

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class Member {  //부모클래스

	//Gujikja 클래스와 Company 클래스가 공통으로 가져야 하는 field 를 만든다.
	private String id;
	private String passwd;
	private String name;
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		if(id!=null && id.trim().isEmpty()&&
				5<=id.length() && id.length()<=10) {
			System.out.println(">> 아이디는 공백만으로 불가합니다 \n"
					+ " 또한 5글자 이상 10글자 이하까지만 가능합니다. <<");	
		} else	{
			this.id = id;
		}
		
			
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		boolean bool = MyUtil.isCheckPasswd(passwd);
		if (bool) 
			this.passwd = passwd;
		else
			System.out.println(">>> 암호는 8글자 이상 15글자 이하의 대소문자, 숫자, 특수문자로 혼합되어야 합니다. <<<");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
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
	
	/////////////////////////////////////////////////////////////
	public void setCompanyName(String name) {
		this.name = name;
	} 
	
	
	
}
