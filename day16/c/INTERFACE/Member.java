package my.day16.c.INTERFACE;

import my.util.MyUtil;

public abstract class Member implements InterMember {
// Member 클래스에서는 InterMember 인터페이스의 미완성메서드(추상메서드)를 재정의(메서드 오버라이딩)을 하지 않겠다는 말이므로
// Member 클래스는 미완성클래스(==추상클래스)가 되어야 한다.
//인터페이스의 내용을 부모클래스에서 재정의 안하고 자식클래스에서 재정의하겠다.

	// Gujikja 클래스와 Company 클래스가 공통으로 가져야 하는 field 생성 
	   private String id;      // 아이디(5글자 이상 10글자 이하까지만 사용가능함)
	   private String passwd;  // 암호 
	   private String name;    // 이름(회사명, 개인성명)
	   
	   static int count;  // 자식클래스인 Gujikja 객체(인스턴스) 
	                      // 또는 자식클래스인 Company 객체(인스턴스) 의 개수를 알아오려는 용도
	   
	   // Gujikja 클래스와 Company 클래스가 공통으로 가져야 하는 method 생성
	//   public String getId() {
	   public String getId() {   
	      return id;
	   }
	   
	//   public void setId(String id) {
	   public void setId(String id) {   
	      
	      if(id != null && !id.trim().isEmpty() &&
	         5 <= id.length() && id.length() <= 10 )
	         this.id = id;
	      else
	         System.out.println(">> 아이디는 공백만으로는 불가합니다. \n"
	                           + " 또한 5글자 이상 10글자 이하까지만 가능합니다.<<");
	      
	   }
	   
	   public String getPasswd() {
	      return passwd;
	   }
	   
	   public void setPasswd(String passwd) {

	      boolean bool = MyUtil.isCheckPasswd(passwd);
	      
	      if(bool) 
	         this.passwd = passwd;
	      
	      else 
	         System.out.println(">> 암호는 8글자 이상 15글자 이하의 영대,소문자 및 숫자, 특수문자가 혼합되어야 합니다. <<");
	   }
	   
	   
	   public String getName() {
	      return name;
	   }

	   
	   public void saveName(String name) {
	      this.name = name;
	   }
	   
	   /////////////////////////////////////////////////////
	   
	   // 자식클래스인 Gujikja 와 Company 에서 showInfo()를 상속받아 
	   // 사용할 것인데 보여주는 내용물이 Gujikja 와 Company 는 다를 것이다.
	   // 그러므로 부모클래스인 Member 에서는 showInfo() 메소드를 정의할 필요가 없다.
	   // 반드시 자식클래스인 Gujikja 와 Company 에서는 showInfo() 재정의를 꼭 해주어야 한다.
	   // 그러므로 부모클래스인 Member 에서는 showInfo() 메소드를 미완성(==추상)메소드로 만들어야 한다.
	  
	   
	   public abstract void viewInfo();

	
}
