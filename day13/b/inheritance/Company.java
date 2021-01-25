package my.day13.b.inheritance;

public class Company extends Member {	//자손클래스
// Company 클래스는 Member 클래스의 자식 클래스가 되어진다.
// 그러므로 자식클래스인 Company에서는 부모 클래스인 Member 에서 선언되어진 것들을 
// 상속받아 사용할 수 있게 된다.
	
	// 구인회사
	
	// field
	private String jobType;   //직종타입(제조업, 서비스업, IT, ....)
	private long seedMoney ;	//자본금

	static int count; //Company 객체의 개수를 알아오려는 용도
	
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
	if(jobType!=null && jobType.trim().isEmpty())      //trim?
	//***null은 들어올 수 있지만, "      "는 들어올 수 없다.
		System.out.println(">> 직종명을 올바르게 입력하세요! <<");
		else
			this.jobType = jobType;
	}
	
	public long getSeedMoney() {
		return seedMoney;
	}
	
	public void setSeedMoney(long seedMoney) {
		if(0>=seedMoney) {
			System.out.println("자본금은 0 보다 커야 합니다. ");
			return;
		} else 
			this.seedMoney = seedMoney;
	}
	
	boolean isUseCompany() {
		if(super.getId()!=null && getPasswd()!=null && getName()!=null&&
		   jobType!=null && seedMoney>0)
			//부모 field를 받아왔을 때 super를 써서 받아도 되고 그냥 입력해도 사용가능하다.
			return true;
		else return false;		
	}
	

	// == 메소드의 재정의 (method overriding) @Override == //
	// ==> 부모클래스로부터 상속받은 메서드를 자식클래스에서 메서드에 들어갈 내용물만 새롭게 만드는 것을 말한다. 
	// ==> 상속받은 메서드명과 파라미터도 동일해야 오버라이딩 가능!
	
	@Override
	public void setName(String name) {
		if(name!=null && !name.trim().isEmpty() &&
		   2<=name.length() && name.length()<=20)
			super.setCompanyName(name);
	}

	String showCo() {
		return "1. 아이디: "+getId()+"\n"
			 + "2. 비밀번호 : "+getPasswd()+"\n"
			 + "3. 회사명 : "+getName()+"\n"
			 + "4. 직종 : "+getJobType()+"\n"
			 + "5. 자본금 : "+getSeedMoney();
		
	}
	
}
