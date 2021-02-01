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
		
		// === mbrMap 에 저장되어진 모든 key들을 읽어오는 첫번째 방법 ===
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
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// === mbrMap 에 저장되어진 모든 key들을 읽어오는 두번째 방법 ===
		Set<String> keySets2 = mbrMap.keySet();
		
		Iterator<String> itra = keySets2.iterator();
		// Iterator는 저장소가 아니라 Collection 에 저장되어진 요소(Element)를 읽어오는 용도로 쓰이는 것이다.
		
		while(itra.hasNext()) {
			/*
             	 itrator.hasNext() 은 
             	 itrator 에서 현재 itrator 가 가지고 있는 여러 String 데이터중
                 하나를 끄집어내서 존재하는지를 알아보는 것이다.
                 존재하면 true , 존재하지 않으면 false 리턴해준다.
                 그러므로 현재는 키의 갯수가 6개 이므로 6번 반복을 할 것이다.
             */
			String key = itra.next();
			/*
			 	 실제로 키값인 String 값을 itra 에서 끄집어 낸다.
			 	 그러면 끄집어 낸 String 값은 더 이상 itra 에는 남아있지 않게 된다.
			 */
			System.out.println(key);
		}
		
		System.out.println("\n~~~~~~~~~~~~ 또 한 번 더 ~~~~~~~~~~~~~~~~\n");
		
		while(itra.hasNext()) {
			String key = itra.next();
			System.out.println(key);
		}
		/*
		 	itra 에는 더 이상 String 데이터가 존재하지 않으므로
		 	처음부터 itra.hasNext() 은 false가 되어진다.
		 	그래서 아무것도 출력이 되지 않는다.
		 */
		
		System.out.println("\n~~~~~~~~~~~~ 다시 처음부터 해본다 ~~~~~~~~~~~~~~~~\n");
		
		Iterator<String> itra2 = keySets2.iterator();
		
		while(itra2.hasNext()) {
			String key = itra2.next();
			System.out.println(key);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Iterator<String> itra3 = keySets2.iterator();
		
		id = "kangkc";
	    flag = false;
	    
		while(itra3.hasNext()) {
			String existsId = itra3.next();
			if(existsId.equals(existsId)) {
				System.out.println(id+" 아이디가 이미 존재하므로 회원가입이 불가합니다.\n");
				flag = true;
				break;
			}
		}// end of while ------------------------------------------
		
		if(!flag) {
			mbrMap.put(id, new Member(id, "qwer1234$", "강군천"));
		}
		
		System.out.println("\n~~~~~~~~~ [퀴즈] mbrMap 에 저장되어진 모든 회원들의 정보를 출력 ~~~~~~~~~~~~~~~\n");
		
		Set<String> keyK = mbrMap.keySet();
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		
		System.out.println("\n----------------- 또는 ------------------\n");
	
		Iterator<String> it = keyK.iterator();
		while(it.hasNext()) {
			String key = it.next();
			mbrMap.get(key).infoPrint();
		}
		
		System.out.println("\n------------- key 값이 kangkc 인 Member 를 삭제하기 --------------\n");
		mbrMap.remove("kangkc");
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		
		System.out.println("\n------------- mbrMap 에 저장된 모든 멤버 삭제하기 --------------\n");
		mbrMap.clear();
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		System.out.println("mbrMap.isEmpty() => "+mbrMap.isEmpty());
		// mbrMap.isEmpty() => true
		
	}// end of main() ------------------------------------------------------------

}
