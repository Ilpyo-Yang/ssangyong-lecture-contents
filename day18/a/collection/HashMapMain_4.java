package my.day18.a.collection;

import java.util.*;

/*
		=== Map �迭 ===
		1. HashMap �� Hashtable �� �ִ�.
		2. Map �迭�� List �迭(Vector, ArrayList, LinkedList)ó�� index �� ���Ǿ� ����Ǵ� ���� �ƴ϶�, 
		   Map �迭�� key���� value���� ������ ����Ͽ� �����ϴµ�  
		         ������ ����� ���Ǵ� �޼ҵ�� put(String key, Object value)�޼ҵ带 ����Ѵ�.
		         �̶� key���� �ݵ�� ������ ���� ������ �ϰ�, value���� �ߺ��� ���� �͵� ������.
		3. Map �迭�� ����� key������ �����ʹ� ������� ����ȴ�.  
		4. Map �迭�� ����� value���� �����Ϸ��� key�� �̿��ؼ� �������µ� 
		   value ���� ������ get(String key) �޼ҵ带 ����Ѵ�. 
*/ 

public class HashMapMain_4 {

	public static void main(String[] args) {

		// Map<String, Member> mbrMap = new HashMap<String, Member>();
		// �Ǵ�
		Map<String, Member> mbrMap = new HashMap<>();
		// Map<K,V>
		
		mbrMap.put("youjs", new Member("youjs","qwer1234$","���缮"));
		// mbrMap �̶�� HashMap ����ҿ� new Member("youjs","qwer1234$","���缮") �� �����ϴµ�
		// ����� new Member("youjs","qwer1234$","���缮")�� ã���� �Ҷ���
		// "youjs" �� �־��ָ� new Member("youjs","qwer1234$","���缮") �� �������� �����ϰڴٴ� ���̴�.
		
		mbrMap.put("eom", new Member("eom","qwer1234$","����ȭ"));
		mbrMap.put("kanghd", new Member("kanghd","qwer1234$","��ȣ��"));
		mbrMap.put("leess", new Member("leess","qwer1234$","�̼���"));
		mbrMap.put("kimth", new Member("kimth","qwer1234$","������"));
		mbrMap.put("kangkc", new Member("kangkc","qwer1234$","������"));
	      
		
		// == mbrMap �� ����Ǿ��� Member ��ü�� �߿� key �� "leess" �� value��(������ Member) �� �����ؼ�
		//      ����� ȸ��(Member)�� ������ ����ϼ���.
	
		//	String id = "sdfawef";
		String id = "leess";
		Member mbr = mbrMap.get(id);
		if(mbr!=null)
				mbr.infoPrint();
		else
			System.out.println(">> �˻��Ͻ� "+id+"�� �ش��ϴ� ȸ���� �����ϴ�\n");
		/*
		 		== �̼��Ŵ��� ȸ������ ==
				1. ���̵� : leess
				2. ��ȣ : qwer1234$
				3. ���� : �̼���
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		mbrMap.put("leess", new Member("leess","abcd1234$","�̻��"));
		mbrMap.put("leess2", new Member("leess","abcd1234$","�̻��"));
		
		id = "leess";
		mbr = mbrMap.get(id);
		if(mbr!=null)
				mbr.infoPrint();
		else
			System.out.println(">> �˻��Ͻ� "+id+"�� �ش��ϴ� ȸ���� �����ϴ�\n");
		
		/*
		 		== �̻�Ŵ��� ȸ������ ==
				1. ���̵� : leess
				2. ��ȣ : abcd1234$
				3. ���� : �̻��
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// === mbrMap �� ����Ǿ��� ��� key���� �о���� ù��° ��� ===
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
			mbrMap.put(id, new Member(id,"abcd1234$","�̼���"));
			System.out.println("\n>>> ȸ������ ���� <<<");
		} else
			System.out.println("\n>>> "+id+" ���̵�� �̹� ������Դϴ�. ȸ������ ����!! <<<");
		
		//  >>> leess ���̵�� �̹� ������Դϴ�. ȸ������ ����!! <<<
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// === mbrMap �� ����Ǿ��� ��� key���� �о���� �ι�° ��� ===
		Set<String> keySets2 = mbrMap.keySet();
		
		Iterator<String> itra = keySets2.iterator();
		// Iterator�� ����Ұ� �ƴ϶� Collection �� ����Ǿ��� ���(Element)�� �о���� �뵵�� ���̴� ���̴�.
		
		while(itra.hasNext()) {
			/*
             	 itrator.hasNext() �� 
             	 itrator ���� ���� itrator �� ������ �ִ� ���� String ��������
                 �ϳ��� ������� �����ϴ����� �˾ƺ��� ���̴�.
                 �����ϸ� true , �������� ������ false �������ش�.
                 �׷��Ƿ� ����� Ű�� ������ 6�� �̹Ƿ� 6�� �ݺ��� �� ���̴�.
             */
			String key = itra.next();
			/*
			 	 ������ Ű���� String ���� itra ���� ������ ����.
			 	 �׷��� ������ �� String ���� �� �̻� itra ���� �������� �ʰ� �ȴ�.
			 */
			System.out.println(key);
		}
		
		System.out.println("\n~~~~~~~~~~~~ �� �� �� �� ~~~~~~~~~~~~~~~~\n");
		
		while(itra.hasNext()) {
			String key = itra.next();
			System.out.println(key);
		}
		/*
		 	itra ���� �� �̻� String �����Ͱ� �������� �����Ƿ�
		 	ó������ itra.hasNext() �� false�� �Ǿ�����.
		 	�׷��� �ƹ��͵� ����� ���� �ʴ´�.
		 */
		
		System.out.println("\n~~~~~~~~~~~~ �ٽ� ó������ �غ��� ~~~~~~~~~~~~~~~~\n");
		
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
				System.out.println(id+" ���̵� �̹� �����ϹǷ� ȸ�������� �Ұ��մϴ�.\n");
				flag = true;
				break;
			}
		}// end of while ------------------------------------------
		
		if(!flag) {
			mbrMap.put(id, new Member(id, "qwer1234$", "����õ"));
		}
		
		System.out.println("\n~~~~~~~~~ [����] mbrMap �� ����Ǿ��� ��� ȸ������ ������ ��� ~~~~~~~~~~~~~~~\n");
		
		Set<String> keyK = mbrMap.keySet();
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		
		System.out.println("\n----------------- �Ǵ� ------------------\n");
	
		Iterator<String> it = keyK.iterator();
		while(it.hasNext()) {
			String key = it.next();
			mbrMap.get(key).infoPrint();
		}
		
		System.out.println("\n------------- key ���� kangkc �� Member �� �����ϱ� --------------\n");
		mbrMap.remove("kangkc");
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		
		System.out.println("\n------------- mbrMap �� ����� ��� ��� �����ϱ� --------------\n");
		mbrMap.clear();
		for (String key : keyK) {
			mbrMap.get(key).infoPrint();	
		}
		System.out.println("mbrMap.isEmpty() => "+mbrMap.isEmpty());
		// mbrMap.isEmpty() => true
		
	}// end of main() ------------------------------------------------------------

}
