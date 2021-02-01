package my.day18.a.collection;

import java.util.*;

public class SetMain_5 {

	/*
	     == HashSet == 
	     1. ��½� ����� ������ �������� �ʴ´�.
	     2. �ߺ��� �����͸� ������ �� ����.
	        �׷��Ƿ� Collection ���� �ߺ��� ��ҵ��� �������� �ʰ��� �Ҷ� ���� ���ȴ�.
	               
	     == LinkedHashSet ==
	     1. ��½� ����� ������ �����ȴ�.
	     2. �ߺ��� �����͸� ������ �� ����.
	        �׷��Ƿ� Collection ���� �ߺ��� ��ҵ��� �������� �ʰ��� �Ҷ� ���� ���ȴ�.        
    */

	public static void main(String[] args) {
		
		System.out.println(" \n=== HashSet ===\n ");
		
		//	1. Member Ŭ������ ��ü���� ������ �� �ִ� HashSet ��ü mbrHashSet �� �����Ѵ�.
		Set<Member> mbrHashSet = new HashSet<>();		// ��κ� �������̽��� ����

		// 2. Member Ŭ������ ��ü 6���� �����Ͽ� mbrHashSet �� �����Ѵ�.
		mbrHashSet.add(new Member("youjs","qwer1234$","���缮"));
		mbrHashSet.add(new Member("eom","qwer1234$","����ȭ"));
		mbrHashSet.add(new Member("kanghd","qwer1234$","��ȣ��"));
		mbrHashSet.add(new Member("leess","qwer1234$","�̼���"));
		mbrHashSet.add(new Member("kimth","qwer1234$","������"));
		mbrHashSet.add(new Member("kangkc","qwer1234$","������"));
				
		mbrHashSet.add(new Member("leess","qwer1234$","�̼���"));
	
		Member mbr1 = new Member("suji","abcd1234$","����");
		Member mbr2 = new Member("chaew","abcd1234$","������");
	
		mbr1 = mbr2;		// mbr2 �� �����ϰ� �ִ� �޸� �ּҸ� mbr1 ���� �־����Ƿ�
								// mbr1 �� new Member("chaew","abcd1234$","������"); �� �ּҸ� �����Ѵ�.		
								// mbr2 �� new Member("chaew","abcd1234$","������"); �� �ּҸ� �����Ѵ�.		
	
		mbrHashSet.add(mbr1);
		mbrHashSet.add(mbr2);
		/*
		 		mbr1 �� mbr2 �� ������ ��ü(������)�� ����Ű�� ���̹Ƿ�
		 		�̹� mbr1 �� ����Ǿ����Ƿ� mbr2 �� ������� �ʴ´�.
		 */
		
		// 3. mbrHashSet �� ����Ǿ��� ��� Member ���� ������ ����Ѵ�.
		//    Set �迭�� ����� ������(���)�� �����ؼ� �о���� ���ؼ��� Iterator �� ���ؼ��� �����ϴ�.
		Iterator<Member> it = mbrHashSet.iterator();
		while (it.hasNext()) {
			// it.hasNext() �� 
	        // it ���� ���� it�� ������ �ִ� ���� Member �������� 
	        // �ϳ��� ������� �����ϴ����� �˾ƺ��� ���̴�.
	        // �����ϸ� true, �������� ������ false.
			
			Member mbr = it.next();
			// ������ Member�� it ����  �������.
	        // *** ������ �� Member�� ���̻� it ���� �������� �ʰ� �ȴ�.
			
			mbr.infoPrint();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~\n");
		
		// 4. mbrHashSet �� ����Ǿ��� ȸ���� �߿�
		//    id�� "leess" �� ȸ���� ������ ����ϼ���.
		Iterator<Member> it2 = mbrHashSet.iterator();
		
		while(it2.hasNext()) {
			Member mbr = it2.next();
			if(mbr.id.equals("leess"))
				mbr.infoPrint();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~\n");
		
		// 5. mbrHashSet �� ����Ǿ��� ȸ���� �߿�
		//    id�� "leess" �� ȸ���� ������ �����ϼ���.
		it2 = mbrHashSet.iterator();
		
		while(it2.hasNext()) {
			Member mbr = it2.next();
			if(mbr.id.equals("leess"))
				it2.remove();
				// mbrHashSet �� ����� ���(Element)�� �����Ϸ���
	            // Iterator�� �̿��� it.remove(); �� ����Ͽ� �����Ѵ�.
		}
		
		// id�� "leess" �� ȸ���� ������ �� ��� ȸ������ ����ϱ�
		
		while(it2.hasNext()) {
			Member mbr = it2.next();
				mbr.infoPrint();
		}
		
		//////////////////////////////////////////////////////////////////////
		
		
		System.out.println(" \n=== LinkedHashSet ===\n ");
		
		//	1. Member Ŭ������ ��ü���� ������ �� �ִ� LinkedHashSet ��ü mbrLinkedHashSet �� �����Ѵ�.
		Set<Member> mbrLinkedHashSet = new LinkedHashSet<>();		// ��κ� �������̽��� ����

		// 2. Member Ŭ������ ��ü 6���� �����Ͽ� mbrLinkedHashSet �� �����Ѵ�.
		mbrLinkedHashSet.add(new Member("youjs","qwer1234$","���缮"));
		mbrLinkedHashSet.add(new Member("eom","qwer1234$","����ȭ"));
		mbrLinkedHashSet.add(new Member("kanghd","qwer1234$","��ȣ��"));
		mbrLinkedHashSet.add(new Member("leess","qwer1234$","�̼���"));
		mbrLinkedHashSet.add(new Member("kimth","qwer1234$","������"));
		mbrLinkedHashSet.add(new Member("kangkc","qwer1234$","������"));
				
		mbrLinkedHashSet.add(new Member("leess","qwer1234$","�̼���"));
	
		Member mbr3 = new Member("suji","abcd1234$","����");
		Member mbr4 = new Member("chaew","abcd1234$","������");
	
		mbr3 = mbr4;		// mbr4 �� �����ϰ� �ִ� �޸� �ּҸ� mbr3 ���� �־����Ƿ�
								// mbr3 �� new Member("chaew","abcd1234$","������"); �� �ּҸ� �����Ѵ�.		
								// mbr4 �� new Member("chaew","abcd1234$","������"); �� �ּҸ� �����Ѵ�.		
	
		mbrLinkedHashSet.add(mbr3);
		mbrLinkedHashSet.add(mbr4);
		/*
		 		mbr3 �� mbr4 �� ������ ��ü(������)�� ����Ű�� ���̹Ƿ�
		 		�̹� mbr3 �� ����Ǿ����Ƿ� mbr4 �� ������� �ʴ´�.
		 */
		
		// 3. mbrLinkedHashSet �� ����Ǿ��� ��� Member ���� ������ ����Ѵ�.
		//    Set �迭�� ����� ������(���)�� �����ؼ� �о���� ���ؼ��� Iterator �� ���ؼ��� �����ϴ�.
		Iterator<Member> it3 = mbrLinkedHashSet.iterator();
		while (it3.hasNext()) {
			// it3.hasNext() �� 
	        // it3 ���� ���� it�� ������ �ִ� ���� Member �������� 
	        // �ϳ��� ������� �����ϴ����� �˾ƺ��� ���̴�.
	        // �����ϸ� true, �������� ������ false.
			
			Member mbr = it3.next();
			// ������ Member�� it3 ����  �������.
	        // *** ������ �� Member�� ���̻� it3 ���� �������� �ʰ� �ȴ�.
			
			mbr.infoPrint();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~\n");
		
		// 4. mbrLinkedHashSet �� ����Ǿ��� ȸ���� �߿�
		//    id�� "leess" �� ȸ���� ������ ����ϼ���.
		it3 = mbrLinkedHashSet.iterator();
		
		while(it3.hasNext()) {
			Member mbr = it3.next();
			if(mbr.id.equals("leess"))
				mbr.infoPrint();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~\n");
		
		// 5. mbrLinkedHashSet �� ����Ǿ��� ȸ���� �߿�
		//    id�� "leess" �� ȸ���� ������ �����ϼ���.
		it3 = mbrLinkedHashSet.iterator();
		
		while(it3.hasNext()) {
			Member mbr = it3.next();
			if(mbr.id.equals("leess"))
				it3.remove();
				// mbrLinkedHashSet �� ����� ���(Element)�� �����Ϸ���
	            // Iterator�� �̿��� it.remove(); �� ����Ͽ� �����Ѵ�.
		}
		
		// id�� "leess" �� ȸ���� ������ �� ��� ȸ������ ����ϱ�
		it3 = mbrLinkedHashSet.iterator();
		
		while(it3.hasNext()) {
			Member mbr = it3.next();
				mbr.infoPrint();
		}
		
		
	}// end of main() --------------------------------------------

}
