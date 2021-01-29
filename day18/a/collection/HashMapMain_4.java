package my.day18.a.collection;

import java.util.*;

/*
		=== Map 계열 ===
		1. HashMap 과 Hashtable 이 있다.
		2. Map 계열은 List 계열(Vector, ArrayList, LinkedList)처럼 index 가 사용되어 저장되는 것이 아니라, 
		   Map 계열은 key값과 value값을 쌍으로 사용하여 저장하는데  
		         데이터 저장시 사용되는 메소드는 put(String key, Object value)메소드를 사용한다.
		         이때 key값은 반드시 고유한 값을 가져야 하고, value값은 중복된 값이 와도 괜찮다.
		3. Map 계열에 저장된 key값들은 순서와는 상관없이 저장된다.  
		4. Map 계열에 저장된 value값을 추출하려면 key를 이용해서 가져오는데 
		   value 값의 추출은 get(String key) 메소드를 사용한다. 
*/ 

public class HashMapMain_4 {

	public static void main(String[] args) {

		// Map<String, Member> mbrMap = new HashMap<String, Member>();
		// 또는
		Map<String, Member> mbrMap = new HashMap<>();
		// Map<K,V>
		
		mbrMap.put("youjs", new Member("youjs","qwer1234$","유재석"));
		// mbrMap 이라는 HashMap 저장소에 new Member("youjs","qwer1234$","유재석") 을 저장하는데
		// 저장된 new Member("youjs","qwer1234$","유재석")을 찾고자 할때는
		// "youjs" 만 넣어주면 new Member("youjs","qwer1234$","유재석") 이 나오도록 저장하겠다는 말이다.
		
		mbrMap.put("eom", new Member("eom","qwer1234$","엄정화"));
		mbrMap.put("kanghd", new Member("kanghd","qwer1234$","강호동"));
		mbrMap.put("leess", new Member("leess","qwer1234$","이순신"));
		mbrMap.put("kimth", new Member("kimth","qwer1234$","김태희"));
		mbrMap.put("kangkc", new Member("kangkc","qwer1234$","강감찬"));
	      
		
		// == mbrMap 에 저장되어진 Member 객체들 중에 key 가 "leess" 인 value값(지금은 Member) 을 추출해서
		//      추출된 회원(Member)의 정보를 출력하세요.
	
		//	String id = "sdfawef";
		String id = "leess";
		Member mbr = mbrMap.get(id);
		if(mbr!=null)
				mbr.infoPrint();
		else
			System.out.println(">> 검색하신 "+id+"에 해당하는 회원은 없습니다\n");
		/*
		 		== 이순신님의 회원정보 ==
				1. 아이디 : leess
				2. 암호 : qwer1234$
				3. 성명 : 이순신
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		mbrMap.put("leess", new Member("leess","abcd1234$","이삼신"));
		mbrMap.put("leess2", new Member("leess","abcd1234$","이삼신"));
		
		id = "leess";
		mbr = mbrMap.get(id);
		if(mbr!=null)
				mbr.infoPrint();
		else
			System.out.println(">> 검색하신 "+id+"에 해당하는 회원은 없습니다\n");
		
		/*
		 		== 이삼신님의 회원정보 ==
				1. 아이디 : leess
				2. 암호 : abcd1234$
				3. 성명 : 이삼신
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// === mbrMap 에 저장되어진 모든 key들을 읽어온다. ===
		Set<String> keySets = mbrMap.keySet();
		
		for(String key : keySets) {
			System.out.println(key);
		}
		
		/*
			    eom
				youjs
				kimth
				kangkc
				kanghd
				leess2
				leess
		 */
		
		id = "leess";
		boolean flag = false;
		
		for(String key : keySets) {
			if(id.equals(key)) {
				flag = true;
			    break;
			}
		}
		
		if(!flag) {
			mbrMap.put(id, new Member(id,"abcd1234$","이수성"));
			System.out.println("\n>>> 회원가입 성공 <<<");
		} else
			System.out.println("\n>>> "+id+" 아이디는 이미 사용중입니다. 회원가입 실패!! <<<");
		
		//  >>> leess 아이디는 이미 사용중입니다. 회원가입 실패!! <<<
		
	
	}// end of main() ------------------------------------------------------------

}
