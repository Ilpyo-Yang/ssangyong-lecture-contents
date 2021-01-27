package my.day16.c.INTERFACE;

import java.text.DecimalFormat;

public class Company extends Member {

	// field
	   private String jobType;  // 회사직종타입(제조업, 서비스업, IT, ....)
	   private long seedMoney;  // 자본금 
	   
	      
	   public String getJobType() {
	      return jobType;
	   }
	   
	   public void setJobType(String jobType) {
	      
	      // jobType 에는 "         " 와 같은 것이 들어올 수 없다.
	      if(jobType != null && jobType.trim().isEmpty()) 
	         System.out.println(">> 직종명을 올바르게 입력하세요!! <<");
	      
	      else 
	         this.jobType = jobType;
	   }
	   
	   public long getSeedMoney() {
	      return seedMoney;
	   }
	   
	   public void setSeedMoney(long seedMoney) {
	      // 자본금은 0 보다 커야 한다.
	      
	      if(seedMoney > 0)
	         this.seedMoney = seedMoney;
	      else
	         System.out.println(">> 자본금은 0 보다 커야 합니다. <<");
	   }
	   
	   
	   // == 메소드의 재정의(method overriding  메소드 오버라이딩) == //
	   // ==> 부모클래스로 상속받은 메소드를 자식 클래스에서 메소드에 들어갈 내용물만 새롭게 만드는 것을 말한다.!!!!! 
	   
	   	   
	   @Override  // 메소드 오버라이딩(메소드 재정의)
	   public String toString() {
	      
	      DecimalFormat df = new DecimalFormat("#,###");
	      
	      String info = "1. 아이디 : "+getId()+"\n"
	                + "2. 암호 : "+getPasswd()+"\n"
	                + "3. 성명 : "+getName()+"\n"
	                + "4. 업종타입 : "+jobType+"\n"
	                + "5. 자본금 : "+ df.format(seedMoney)+"원\n";
	      
	      return info;
	   }
	   
	   // ==> InterMember 인터페이스에 정의된 추상메서드(미완성메서드)를 재정의 한 것임.
	   @Override
	   public void setName(String name) {
	      
	      if(name != null && !name.trim().isEmpty() &&
	         2<=name.length() && name.length()<=20 ) {
	         super.saveName(name);   
	      }
	      
	   }

		@Override
		public void viewInfo() {
			// TODO Auto-generated method stub
			
		}
 
	
}
