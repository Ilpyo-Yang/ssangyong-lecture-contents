package my.day05.d.SWITCH;

public class Test {

   public static void main(String[] args) {
      
      int n = 10; // n�� ���� 10
      String strn = Integer.toString(n); // strn �� ���ڿ� "10" 
      String strn2 = String.valueOf(n); // strn2 �� ���ڿ� "10"
      
      if( n > 5 ) {
         String name = "�̼���";
      }
      else {
         String name = "����ȭ";
      }
      
      String irum = (n > 5)?"�̼���":"����ȭ";
      
       

   }

}