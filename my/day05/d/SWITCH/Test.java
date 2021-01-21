package my.day05.d.SWITCH;

public class Test {

   public static void main(String[] args) {
      
      int n = 10; // n은 숫자 10
      String strn = Integer.toString(n); // strn 은 문자열 "10" 
      String strn2 = String.valueOf(n); // strn2 도 문자열 "10"
      
      if( n > 5 ) {
         String name = "이순신";
      }
      else {
         String name = "엄정화";
      }
      
      String irum = (n > 5)?"이순신":"엄정화";
      
       

   }

}