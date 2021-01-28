package my.day10.d.string;

import java.text.DecimalFormat;

import my.util.MyUtil;

public class StringMain {

	public static void main(String[] args) {

// === 1. "문자열".charAt(int index) ===
		// "안녕하세요".charAt(2) ==> '하'
		// index => 01234
		
		char ch = "안녕하세요".charAt(2);
		System.out.println("ch => "+ch);
		// ch => 하

		String str = "안녕하세요";
		// index =>   01234
		String result = "";
		
		for (int i=str.length()-1; i>=0; i--) {
			result += str.charAt(i);
		}
		System.out.println(result);
		//요세하녕안
		
		
// === 2. "문자열".tocCharArray(int index) ===		
		// "안녕하세요".tocCharArray() ==> char 타입의 배열로 만들어준다
		//-----------------------
		//|'안'|'녕'|'하'|'세'|'요'|
		//-----------------------
		
		char[] chArr = "안녕하세요".toCharArray();
		result = "";
		
		for (int i=chArr.length-1; i>=0; i--) {
			result+=chArr[i];
		}
		System.out.println(result);
		//요세하녕안
		
		
// === 3. "문자열".substring(int 시작인덱스, int 끝인덱스) ===		
		// "안녕하세요".substring(1,4) ==> 1번 인덱스인 "녕"부터 4번 인덱스 앞까지인 "세"까지 일부 데이터를 추출해준다
		
		str = "안녕하세요".substring(1,4);
		System.out.println(str);    //녕하세
		
		int len = "안녕하세요".length();  //5
		str = "안녕하세요".substring(2,len);
		System.out.println(str);    //하세요
		
		
// === 4. "문자열".substring(int 시작인덱스) ===		
		// "안녕하세요".substring(2) ==> 2번 인덱스인 "하"부터 끝까지 뽑아온다.
		
		str = "안녕하세요".substring(2);
		System.out.println(str);    //하세요

		
// === 5. "문자열".indexOf("찾을문자열") ===		
		// "문자열"에서 최초로 나오는 "찾을문자열"의 인덱스값(int)을 알려준다.
		int index = "시작하라 안녕하세요 건강하세요".indexOf("하");
		System.out.println(index); //2
		
		index = "시작하라 안녕하세요 건강하세요".indexOf("하세요");
		System.out.println(index); //7
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
//==== [퀴즈] ==== //
		String [] pathFileNameArr = {"C:/mydocument/resume/나의이력서.hwp",   //자바는  \ 인식을 못한다.
								  "D:/mymusic.mp3",
								  "C:/photo/내얼굴.jpg"};  
		for(int i=0; i<pathFileNameArr.length; i++) {
			System.out.println(pathFileNameArr[i]);
		}
		/*
		    C:/mydocument/resume/나의이력서.hwp
			D:/mymusic.mp3
			C:/photo/내얼굴.jpg

		 */
		
		/*
		       나의이력서.hwp
			mymusic.mp3
			내얼굴.jpg
	
		 */
		
//선생님 답		
		System.out.println("\n=== 파일명만 뽑아온 결과물 ===");
	      //꺼꾸로 읽어보자
	      for(int i=0; i<pathFileNameArr.length; i++) {
	         String pathFileName = pathFileNameArr[i];   //***String[] => String => char[]
	         char[] chrArr = pathFileName.toCharArray();
	         
	         String strReverse = "";
	         for(int j=chrArr.length-1; j>=0; j--) {
	            strReverse += chrArr[j];     //꺼꾸로 차곡차곡 쌓기
	         }
	         
	      //   System.out.println(strReverse);
	         
	         int idxSlash = strReverse.indexOf("/");
	         
	         strReverse = strReverse.substring(0, idxSlash);
	         //최초로 /가 나오는 인덱스 값
	      //   System.out.println(strReverse);
	         
	         chrArr = strReverse.toCharArray();
	         
	         String fileName = "";
	         for(int j=chrArr.length-1; j>=0; j--) {
	            fileName += chrArr[j]; 
	         }
	         
	         System.out.println(fileName);
	      }
	      
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		      
		
// === 6. "문자열".lastIndexOf("찾을문자열") ===		
		// "문자열"에서 마지막으로 나오는 "찾을문자열"의 인덱스값(int)을 알려준다.
		index = "시작하라 안녕하세요 건강하세요".lastIndexOf("하");
		System.out.println(index); //13
		
		index = "시작하라 안녕하세요 건강하세요".lastIndexOf("하세요");
		System.out.println(index); //13
		
//나의 정답		
		System.out.println("\n=== 파일명만 뽑아온 결과물 ===");
	
		for (int i=0; i<pathFileNameArr.length; i++) {
			for (int j=0; j<pathFileNameArr[i].length(); j++) {
				if(j==pathFileNameArr[i].lastIndexOf("/")) {
					System.out.print(pathFileNameArr[i].substring(j+1));
				}
			}
			System.out.print("\n");		
		}
		
//선생님 정답		
		System.out.println("\n=== 파일명만 뽑아온 결과물 ===");
	
		for (int i=0; i<pathFileNameArr.length; i++) {
			int idx = pathFileNameArr[i].lastIndexOf("/");
			System.out.println(pathFileNameArr[i].substring(idx+1));
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
//==== [퀴즈] ==== //
		//String money1 = "1,000,000";  //컴마를 다 빼고 int로 바꾼다음에 더하기
		//String money2 = "5,000";
		//1000000 + 5000;
		//1005000
		
//선생님 정답			
		String money = "2,000,000";
		int commaIndex = money.indexOf(",");
		System.out.println(commaIndex);   //1

		System.out.println(money.substring(0,commaIndex));  //2
		System.out.println(money.substring(commaIndex+1));  //000,000
		
		money = money.substring(0,commaIndex)+money.substring(commaIndex+1);
		// "2"+"000,000"
		System.out.println(money);  //2000,000

		commaIndex = money.indexOf(",");  //4
		
		System.out.println(money.substring(0,commaIndex));  //2000
		System.out.println(money.substring(commaIndex+1));  //000
		
		money = money.substring(0,commaIndex)+money.substring(commaIndex+1);
		// "2000"+"000"
		System.out.println(money);  //2000000
		
		commaIndex = money.indexOf(",");  //-1
		System.out.println("commaIndex");
		
		
//선생님 정답	
		//MyUtil클래스의 delComma 메서드 만들어서 사용하기
		int sum = MyUtil.delComma("1,000,000")+MyUtil.delComma("5,000");   
		System.out.println(sum);   //1005000
		
		DecimalFormat df = new DecimalFormat("#,###");    //문자열 형태로 나옴
		System.out.println(df.format(sum));  //1,005,000
	
// === 7. "문자열".split("구분자") ===
		//"문자열"을 "구분자"로 잘라서 String 타입의 배열로 돌려주는 것이다.
		System.out.println("\n 1. ======================\n");
		
		String food = "파스타,국밥,볶음밥,고구마,계란말이";
		String[] foodArr = food.split(",");
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */		
		System.out.println("\n 2. ======================\n");
		
		food = "파스타	국밥	볶음밥	고구마	계란말이";
		foodArr = food.split("\t");
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */	
		System.out.println("\n 3. ======= split 사용시 구분자로 .| / 등 특수문자를 사용하려고 하는 경우 =======\n");
		
		food = "파스타.국밥.볶음밥.고구마.계란말이";
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		foodArr = food.split(".");       
		System.out.println(foodArr.length);  
		// ==> 0 이 나옴. 즉 . 단독만으로는 구분자로 인식을 못함.
       // split 사용시 구분자로 . | / 등 특수문자를 사용하려고 할 경우에는 구분자로 인식을 못할 경우가 많으므로
       //*** 구분자 앞에 \\ 를 붙이거나 구분자를 [] 로 씌워주면 된다. 즉, [구분자] 이렇게 말이다.
		
		foodArr = food.split("[.]");   
		System.out.println(foodArr.length); //5
		foodArr = food.split("\\.");  
		System.out.println(foodArr.length); //5
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */
		System.out.println("\n 4. ======================\n");
		
		food = "파스타|국밥|볶음밥|고구마|계란말이";
		foodArr = food.split("[|]");
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */		
		System.out.println("\n 5. ======================\n");
		
		food = "파스타,국밥,볶음밥,고구마,계란말이";
		foodArr = food.split("[,]");
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */		
		
		System.out.println("\n 6. ======================\n");
		
		food = "파스타,국밥.볶음밥	고구마,계란말이";   
		//구분자가 여러 개 일 때, | 으로 여러개 입력 가능, []는 묶어서 입력가능
		foodArr = food.split("[,.\t]");
		foodArr = food.split("\\,|\\t|\\.");
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */		
		System.out.println("\n 7. ======================\n");
		
		food = "파스타1국밥2볶음밥3고구마4계란말이";   
		foodArr = food.split("\\d");    
		// \\d에서 d는 정규표현식의 하나로써 숫자를 의미한다.
		// 즉, 숫자가 구분자가 되는 것이다.
		//{"파스타","국밥","볶음밥","고구마","계란말이"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        파스타
			국밥
			볶음밥
			고구마
			계란말이
		 */		

		System.out.println("\n 8. ======================\n");
		
		food = "파스타1국밥2볶음밥3고구마4계란말이";   
		foodArr = food.split("\\D");    
		// \\D에서 D는 정규표현식의 하나로써 숫자가 아닌 것을 의미한다.
		// 즉, 숫자가 구분자가 되는 것이다.
		//{"1","2","3","4"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        1
		        2
		        3
		        4
		 */		
		
		//=== 참고: \ 를 escape 문자라고 부른다.
		System.out.println("나의 이름은 \"이순신\"입니다.");
		//나의 이름은 "이순신"입니다.
		System.out.println("나의 이름은 '엄정화'입니다.");
		//나의 이름은 '엄정화'입니다.
		System.out.println("C:\\movie\\koremovie\\경이로운소문.mp4");
		//C:\movie\koremovie\경이로운소문.mp4

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		
		
// === 8. String.join("구분자", 문자열배열명) ===
		//문자열배열을 "구분자"로 합쳐서 String 타입으로 돌려주는 것이다.		
		String[] nameArr = {"한석규","두석규","세석규","네석규","오석규"};
		String names = String.join("-",nameArr);
		System.out.println(names);
		// 한석규-두석규-세석규-네석규-오석규
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		
		
// === 9. "문자열".replaceAll("변경대상문자열", "새로이변경될문자열") ===
		//"문자열"에서 "변경대상문자열"을 모두"새로이변경될문자열"로 교체해서 반환해주는 것이다.		
		names = names.replaceAll("석규", "SK");
		System.out.println(names);
		// 한SK-두SK-세SK-네SK-오SK
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 10. "문자열".replaceFirst("변경대상문자열", "새로이변경될문자열") ===
		//"문자열"에서 "변경대상문자열"을 첫번째만 "새로이변경될문자열"로 교체해서 반환해주는 것이다.		
		names = names.replaceFirst("SK", "석규 ");
		System.out.println(names);
		// 한석규-두SK-세SK-네SK-오SK
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
		// === 퀴즈 === //
		// replaceFirst를 사용하여 첫번째, 두번째, 세번째 "SK"를 "석규" 변환하세요.
		names = "한SK-두SK-세SK-네SK-오SK";
		
		for (int i=0; i<3; i++) {
			names = names.replaceFirst("SK", "석규 ");
		}
		
		System.out.println(names);
		//한석규-두석규-세석규-네SK-오SK
//선생님 답
		names = "한SK-두SK-세SK-네SK-오SK";
	      
		String[] namesArr = names.split("SK");
		      
		for(int i=0; i<namesArr.length; i++) {
		    if(i==1 || i==2) {
		        namesArr[i] += "석규";
		    }
		    
		    else {
		   namesArr[i] += "SK";
		    }
		} // end of for-----------------------
		      
		names = String.join("", namesArr);
		      
		System.out.println(names);
		// "한SK-두석규-세석규-네SK-오SK"
//다른 사람 답
		names = "한SK-두SK-세SK-네SK-다SK";
	    String [] nameRArr = names.split("\\-");
	       
	    for(int i=1; i<3; i++) {
	        nameRArr[i] = nameRArr[i].replace("SK", "석규");
	    }
	      
	    String renames = String.join("-", nameRArr);
	    System.out.println(renames);
	      
//나의 답		
		names = "한SK-두SK-세SK-네SK-오SK";
		names = names.replace("두SK-세SK",  "두석규-세석규");
		System.out.println(names);
		//한SK-두석규-세석규-네SK-오SK
		
		System.out.println("\n === 퀴즈 === \n");	
		String[] contents = {"호호안녕하세요","건강하세요","행복하세요 또봐요","즐겁고 건강한 하루되세요"}; 

// [Quiz1] "건강" 이라는 단어가 포함된것을 출력하세요.
		//나의 답
		for (int i=0; i<contents.length; i++) {
			if(contents[i].contains("건강")) {
				System.out.println(contents[i]);
			}
		}
		//선생님 답
		for(int i=0; i<contents.length; i++) {
	          int idx = contents[i].indexOf("건강");
	          if(idx != -1)
	             System.out.println(contents[i]);
	       }
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	

// [Quiz2] "건강" 이라는 단어로 시작하는 것만 출력하세요.	

		for (int i=0; i<contents.length; i++) {
			if(contents[i].indexOf("건강")==0) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
			
		// 또는 아래와 같이 할수도 있습니다.
// === 11. "문자열".startsWith("찾고자하는문자열")  ===
	    //       "문자열" 에서 "찾고자하는문자열"이 맨첫번째에 나오면 true 를 반환.
	    //      "문자열" 에서 "찾고자하는문자열"이 맨첫번째에 나오지 않으면 false 를 반환.
	     
		// "건강" 이라는 단어로 시작하는 것만 출력하세요.		
		for (int i=0; i<contents.length; i++) {
			if(contents[i].startsWith("건강")) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 12. "문자열".endsWith("찾고자하는문자열")  ===
	    //       "문자열" 에서 "찾고자하는문자열"이 맨 마지막에 나오면 true 를 반환.
	    //      "문자열" 에서 "찾고자하는문자열"이 맨 마지막에 나오지 않으면 false 를 반환.
	     
		// "하세요" 라는 단어로 끝나는 것만 출력하세요.		
		for (int i=0; i<contents.length; i++) {
			if(contents[i].endsWith("하세요")) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 13. "문자열".trim()  ===
	    //       "문자열".trim() 은 "문자열"의 좌,우에 공백이 있으면 공백을 제거한다.
	     
		String insa = "     수고    많으셧습니다   ";	
		System.out.println("하하하"+insa+"내일 뵐게요~~");
		System.out.println("하하하"+insa.trim()+"내일 뵐게요~~");
		//하하하     수고    많으셧습니다   내일 뵐게요~~
		//하하하수고    많으셧습니다내일 뵐게요~~
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 14. "문자열".isEmpty()  ===
	    //       "문자열"이 아무것도 없으면 true를 반환해주고,
		//       "문자열"이 뭔가 있으면 false를 반환해준다.
	    String str1="", str2="abc", str3="      ";	
		System.out.println(str1.isEmpty());   //true
		System.out.println(str2.isEmpty());   //false
		System.out.println(str3.isEmpty());   //false
		System.out.println(str3.trim().isEmpty());   //true

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
	
// === 15. "문자열".toUpperCase()  ===
	    //       "문자열"에서 소문자가 있으면 모두 대문자로 변환해준다.
	    String words="My Name is Tom 입니다.";	
		System.out.println(words.toUpperCase());   
		//MY NAME IS TOM 입니다.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 16. "문자열".toLowerCase()  ===
			    //       "문자열"에서 소문자가 있으면 모두 대문자로 변환해준다.
			    words="My Name is Tom 입니다.";	
				System.out.println(words.toLowerCase());   
				//my name is tom 입니다.
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
				
// === 17. "문자열".equals("비교대상문자열")  ===
				//        대문자와 소문자를 구분하면서
			    //       "문자열"과 "비교대상문자열"의 값이 일치하면 true를 반환
			    //       "문자열"과 "비교대상문자열"의 값이 일치하지 않으면 false를 반환
				
// === 18. "문자열".equalsIgnoreCase("비교대상문자열")  ===
				//        대문자와 소문자를 구분하지 않고
			    //       "문자열"과 "비교대상문자열"의 값이 대,소문자와 관계없이 일치하면 true를 반환
			    //       "문자열"과 "비교대상문자열"의 값이 대,소문자와 관계없이 일치하지 않으면 false를 반환
			    
				String[] strArr = {"korea","seoul","Korea 대한민국","서울 kOrEA 만세",null};
				
				for (String s :strArr) {  //배열의 길이 많큼 반복
					if("korea".equals(s))  
						//NullPointerException 주의!
						//문자열 비교시 상수값이 앞에 오고 변수는 뒤에, 변수에는 null이 올 수 있다.
						System.out.println(s);
				}
				//korea
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				//검색어를 "korea","KOREA","kOrEA" 와 같이 아무거나 입력하면,
				//"korea"," korea seoul","Korea 대한민국","서울 kOrEA 만세"이 출력되도록 하자
				
				String search = "kOrEA";
				for (String s :strArr) {  //배열의 길이 많큼 반복
					search = search.toLowerCase();
					if (s!=null && s.toLowerCase().indexOf(search)!=-1) { //***null 조건을 빼는 것에 유의
						System.out.println(s);
					}
			    }
				/*
				 	korea
					Korea 대한민국
					서울 kOrEA 만세
				 */
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				

	}//end of main------------------------------------------------------------
	
}
