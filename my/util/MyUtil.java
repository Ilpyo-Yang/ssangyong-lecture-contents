package my.util;

//import java.lang.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class MyUtil {

// === 현재시각을 출력해주는 static 메소드 생성하기 === //
   public static void currentTime() {
      Date now = new Date(); // 현재시각
      
      SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String result = sdfrmt.format(now);
      System.out.println(">> 현재시각 : " + result);
      // 2021-01-07 11:22:35 
   }
   
   
   
// === 비밀번호가 규칙에 맞는지 틀리는지 알려주는 static 메소드 생성하기 === // 
   // 비밀번호 규칙은 비밀번호의 길이는 8글자 이상 15글자 이하이어야 하고,
   // 또한 비밀번호는 영문대문자, 영문소문자, 숫자, 특수기호가 혼합되어야만 한다.
   // 우리는 규칙에 맞으면 true , 규칙에 틀리면  false 를 리턴해주도록 만든다.
   public static boolean isCheckPasswd(String passwd) {
      
      // 예를 들어서 
      // "ab123cd#S".toCharArray(); 을 하면
      // {'a','b','1','2','3','c','d','#','S'} 으로 변환된다.
      
      char[] chArr = passwd.toCharArray();
   /*
       -------------------------------------
       | a | b | 1 | 2 | 3 | c | d | # | S |
       -------------------------------------    
    */
      
      if( 8 <= chArr.length && chArr.length <= 15 ) {
      
         boolean flagUpper   = false; // 영문대문자 표식을 위한 용도 
         boolean flagLower   = false; // 영문소문자 표식을 위한 용도
         boolean flagNumber  = false; // 숫자 표식을 위한 용도
         boolean flagSpecial = false; // 특수문자 표식을 위한 용도
         
      /*   
         for(int i=0; i<chArr.length; i++) {
            char ch = chArr[i];
            
            if(Character.isUpperCase(ch)) {   // 영문대문자인 경우
               flagUpper = true;
            }
            
            else if(Character.isLowerCase(ch)) { // 영문소문자인 경우
               flagLower = true;
            }
            
            else if(Character.isDigit(ch)) { // 숫자인 경우
               flagNumber = true;
            }
            
            else { // 특수문자인 경우
               flagSpecial = true;
            }
            
         }// end of for------------------------
      */   
         
         // === 또는 ===
         for(char ch : chArr) {
            
            if(Character.isUpperCase(ch)) {   // 영문대문자인 경우
               flagUpper = true;
            }
            
            else if(Character.isLowerCase(ch)) { // 영문소문자인 경우
               flagLower = true;
            }
            
            else if(Character.isDigit(ch)) { // 숫자인 경우
               flagNumber = true;
            }
            
            else { // 특수문자인 경우
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
      
      else { // 비밀번호의 길이가 8글자 미만 이거나 15글자 보다 큰 경우이다.
         return false;
      }
      
   }// end of public static boolean isCheckPasswd(String passwd)--------
   
   
   
   
// === , 가 들어있는 숫자로 된 문자열을 , 제거해서 정수로 리턴시켜주는 메서드 생성하기 === //
   
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
    
    
    
    
// === 주민번호 7자리를 받아서 올바른 데이터인지 검사해주는 메서드 생성 === // 
    public static boolean isCheckJubun(String jubun) {
    	if(jubun==null)  return false;   //밑으로 내려가지 않고 false를 주고 끝남
    	char[] chArr = jubun.toCharArray();
    	if(chArr.length!=7) return false;
    	for (int i=0; i<7; i++) {
			if (!Character.isDigit(chArr[i])) {
				return false;
			}
		}
    	if (!('1'<=chArr[6]&&chArr[6]<='4')) return false;
    	
    	//월 => "01" ~ "12"
    	int month = Integer.parseInt(jubun.substring(2, 4));  //1~12
    	if(!(1<=month&&month<=12)) return false;
    	int day = Integer.parseInt(jubun.substring(4, 6)); //1~31
    	if(!(1<=month&&month<=31)) return false;
    	//2월은 30일 31일은 없다.
    	if(month==2 && 30<=day&&day<=31) return false;
    	
    	return true; //마지막에 모든 조건문에 해당한다면!
    }//end of public static boolean isCheckJuban(String jubun) ------------
    
    public static boolean isCheckJubun2(String jubun) {
    	if(jubun==null) return false;
    	//jubun  => "9501151" "9501152"
    	
    	// 정규표현식(Regular Expression)이란?
    	// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어 
    	
    	// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. ==
    	//Pattern p = Pattern.compile("^ [0-9][0-9][01][0-9]{3}[1-4] $");
    	//^ 은 시작을 의미한다.
    	//$ 는 끝을 의미한다.
    	//[] 는 글자 1개가 들어오는 것을 의미한다.
    	//[0123456789] 은 0~9까지만 들어온다는 뜻이다.
    	//[0123456789] 은 [0-9]와 같다.    	
    	//[0-9]{3} 는 [0-9][0-9][0-9] 이렇게 연달아 나올 때 쓸 수 있다.
    	Pattern p = Pattern.compile("^ \\d{2}[01]\\d{3}[1-4] $");
    	//[0-9] 와 \\d 은 같다.
    	    	
    	
    	// == 2. 문자열이 주어진 정규식패턴과 일치하는지 판별하는 객체를 생성한다. ==
    	Matcher m = p.matcher(jubun);
    	
    	// == 3. 판별하도록 한다. ==
    	//주어진 정규식 패턴과 일치하면 true, 일치하지 않으면 false를 리턴시켜준다.
    	Boolean b = m.matches();
    	return b;
    }//end of public static boolean isCheckJuban2(String jubun) ------------

}



