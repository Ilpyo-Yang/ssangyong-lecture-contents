package io.util;

//import java.lang.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class MyUtil {

// === ����ð��� ������ִ� static �޼ҵ� �����ϱ� === //
   public static void currentTime() {
      Date now = new Date(); // ����ð�
      
      SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String result = sdfrmt.format(now);
      System.out.println(">> ����ð� : " + result);
      // 2021-01-07 11:22:35 
   }
   
   
   
// === ��й�ȣ�� ��Ģ�� �´��� Ʋ������ �˷��ִ� static �޼ҵ� �����ϱ� === // 
   // ��й�ȣ ��Ģ�� ��й�ȣ�� ���̴� 8���� �̻� 15���� �����̾�� �ϰ�,
   // ���� ��й�ȣ�� �����빮��, �����ҹ���, ����, Ư����ȣ�� ȥ�յǾ�߸� �Ѵ�.
   // �츮�� ��Ģ�� ������ true , ��Ģ�� Ʋ����  false �� �������ֵ��� �����.
   public static boolean isCheckPasswd(String passwd) {
      
      // ���� �� 
      // "ab123cd#S".toCharArray(); �� �ϸ�
      // {'a','b','1','2','3','c','d','#','S'} ���� ��ȯ�ȴ�.
	   
	  if(passwd == null) return false;
      
      char[] chArr = passwd.toCharArray();
   /*
       -------------------------------------
       | a | b | 1 | 2 | 3 | c | d | # | S |
       -------------------------------------    
    */
      
      if( 8 <= chArr.length && chArr.length <= 15 ) {
      
         boolean flagUpper   = false; // �����빮�� ǥ���� ���� �뵵 
         boolean flagLower   = false; // �����ҹ��� ǥ���� ���� �뵵
         boolean flagNumber  = false; // ���� ǥ���� ���� �뵵
         boolean flagSpecial = false; // Ư������ ǥ���� ���� �뵵
         
      /*   
         for(int i=0; i<chArr.length; i++) {
            char ch = chArr[i];
            
            if(Character.isUpperCase(ch)) {   // �����빮���� ���
               flagUpper = true;
            }
            
            else if(Character.isLowerCase(ch)) { // �����ҹ����� ���
               flagLower = true;
            }
            
            else if(Character.isDigit(ch)) { // ������ ���
               flagNumber = true;
            }
            
            else { // Ư�������� ���
               flagSpecial = true;
            }
            
         }// end of for------------------------
      */   
         
         // === �Ǵ� ===
         for(char ch : chArr) {
            
            if(Character.isUpperCase(ch)) {   // �����빮���� ���
               flagUpper = true;
            }
            
            else if(Character.isLowerCase(ch)) { // �����ҹ����� ���
               flagLower = true;
            }
            
            else if(Character.isDigit(ch)) { // ������ ���
               flagNumber = true;
            }
            
            else { // Ư�������� ���
               flagSpecial = true;
            }
            
         }// end of for----------------------
         
         if(flagUpper && flagLower && flagNumber && flagSpecial) {
            return true;
         }
         else {
            return false;
         }
      
      }
      
      else { // ��й�ȣ�� ���̰� 8���� �̸� �̰ų� 15���� ���� ū ����̴�.
         return false;
      }
      
   }// end of public static boolean isCheckPasswd(String passwd)--------
   
   
   
   
// === , �� ����ִ� ���ڷ� �� ���ڿ��� , �����ؼ� ������ ���Ͻ����ִ� �޼��� �����ϱ� === //
   
    public static int delComma(String str) {
    	do {
    		int commaIndex = str.indexOf(",");
    		if(commaIndex==-1) break;
			str = str.substring(0, commaIndex) + str.substring(commaIndex+1);
			//"2"+"000,000" => "2000,000"
			//"2000"+"000" => "2000000"
		} while (true);
    	return Integer.parseInt(str);
    }//end of public static int delComma(String str) ---------------------
    
    
    
    
// === �ֹι�ȣ 7�ڸ��� �޾Ƽ� �ùٸ� ���������� �˻����ִ� �޼��� ���� === // 
    public static boolean isCheckJubun(String jubun) {
    	if(jubun==null)  return false;   //������ �������� �ʰ� false�� �ְ� ����
    	char[] chArr = jubun.toCharArray();
    	if(chArr.length!=7) return false;
    	for (int i=0; i<7; i++) {
			if (!Character.isDigit(chArr[i])) {
				return false;
			}
		}
    	if (!('1'<=chArr[6]&&chArr[6]<='4')) return false;
    	
    	//�� => "01" ~ "12"
    	int month = Integer.parseInt(jubun.substring(2, 4));  //1~12
    	if(!(1<=month&&month<=12)) return false;
    	int day = Integer.parseInt(jubun.substring(4, 6)); //1~31
    	if(!(1<=month&&month<=31)) return false;
    	//2���� 30�� 31���� ����.
    	if(month==2 && 30<=day&&day<=31) return false;
    	
    	return true; //�������� ��� ���ǹ��� �ش��Ѵٸ�!
    }//end of public static boolean isCheckJuban(String jubun) ------------
    
    public static boolean isCheckJubun2(String jubun) {
    	if(jubun==null) return false;
    	//jubun  => "9501151" "9501152"
    	
    	// ����ǥ����(Regular Expression)�̶�?
    	// ==> Ư���� ��Ģ�� ���� ���ڿ��� ������ ǥ���ϱ� ���� ���̴� ���ľ�� 
    	
    	// == 1. ����ǥ����(Regular Expression) ������ �ۼ��Ѵ�. ==
    	//Pattern p = Pattern.compile("^ [0-9][0-9][01][0-9]{3}[1-4] $");
    	//^ �� ������ �ǹ��Ѵ�.
    	//$ �� ���� �ǹ��Ѵ�.
    	//[] �� ���� 1���� ������ ���� �ǹ��Ѵ�.
    	//[0123456789] �� 0~9������ ���´ٴ� ���̴�.
    	//[0123456789] �� [0-9]�� ����.    	
    	//[0-9]{3} �� [0-9][0-9][0-9] �̷��� ���޾� ���� �� �� �� �ִ�.
    	Pattern p = Pattern.compile("^ \\d{2}[01]\\d{3}[1-4] $");
    	//[0-9] �� \\d �� ����.
    	    	
    	
    	// == 2. ���ڿ��� �־��� ���Խ����ϰ� ��ġ�ϴ��� �Ǻ��ϴ� ��ü�� �����Ѵ�. ==
    	Matcher m = p.matcher(jubun);
    	
    	// == 3. �Ǻ��ϵ��� �Ѵ�. ==
    	//�־��� ���Խ� ���ϰ� ��ġ�ϸ� true, ��ġ���� ������ false�� ���Ͻ����ش�.
    	Boolean b = m.matches();
    	return b;
    }//end of public static boolean isCheckJuban2(String jubun) ------------

}



