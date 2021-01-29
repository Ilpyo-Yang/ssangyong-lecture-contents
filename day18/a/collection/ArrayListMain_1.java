package my.day18.a.collection;

import java.util.*;

public class ArrayListMain_1 {

	public static void main(String[] args) {
	
		String[] nameArr = new String[1000];
		for (int i=0; i<20; i++) {
			nameArr[i] = (i+1)+". ȫ�浿";
		}
		// java.lang.ArrayIndexOutOfBoundsException �� �߻���.
	/*
		for (int i=0; i<nameArr.length; i++) {
			System.out.println(nameArr[i].substring(1));
		}
	*/
		//////////////////////////////////////////////////////////////////
		
/*
	 ==== �迭(Array)�� �ڷᱸ��(Collection)�� ������ ====

 		1. �迭(Array)�� ������ ������ ������ Ÿ�Ը� ���� ������̴�.
           �迭(Array)�� �� ũ�Ⱑ �ѹ� �������� ũ�⸦ ������ �� ����.!!!
     
 		2. �ڷᱸ��(Collection)�� ������ Ÿ���� ��ü�� �ƴϴ���
           ��üŸ���̱⸸ �ϸ� ��� ���� ������̴�.
           �ڷᱸ��(Collection)�� ����Ǵ� ũ�Ⱑ �ڵ������� �þ��.!!!
    
    		������ ���� ���� ����ϴ� ��ǥ���� Collection Ÿ���� List �迭�� Map �迭�̴�.

			-------------------------------------------------------------------------
			              Web���� �ַ� ����ϴ� Ŭ����          �������α׷��ֿ��� �ַ� ����ϴ� Ŭ����
			Interface       (Single Thread ���)          (Multi Thread ���)
			-------------------------------------------------------------------------           
			List �迭       --      ArrayList      	  ,         Vector
			Map  �迭    --      HashMap           ,         Hashtable 
			
			ArrayList �� HashMap �� Multi Thread�� ���������ֹǷ� ������.
			Vector �� Hashtable �� Multi Thread�� �������ֹǷ� ���̴�.
			
			Multi Thread�� �������ִ³� �����ִ��ĸ� ���̰� ���� �� �� ������ ����� �����ϴ�.  
*/

/*
		    JDK 1.5 ���� ���׸�(Generic)Ÿ���� ���� �߰��Ǿ��µ�, ���׸�(Generic)�� �̿������ν� �߸��� Ÿ����
		   ���� �� �ִ� ������ ������ �������� ������ �� �ְ� �Ǿ���. 
		   ���α׷� ����� Ÿ�� ������ �߻��Ͽ� �۵��� ���ߴ� �ͺ��ٴ� �����Ͻÿ� Ÿ�Կ����� �߻��ϵ��� �Ͽ� 
		   ���α׷� ����� ������ �߻����� �ʵ��� ������ �����ϴ� ���� ���� �����̴�.
		   
		     �� ���׸�(Generic)�� �÷���(�ڷᱸ��) ��, ���� ���ؼ� ��ü���� ����(����)�ϴ� �������� ������ �����ϱ� ���� �����ϴ� ���̴�.
		     �� ������ ���� ���ڸ� ���̶�� Ư�� ��ü�� �ִٰ� ����. 
		      �� ���� ���� ���� �� �ִ� ���� , �Ǵ� �� ���� �꽺�� ���� �� �ִ� �꽺 ��. �̷��� �������ֵ��� �ϴ� ����  ���׸�(Generic) �̴�.    
		
		     ��  JDK 1.5 ���� ���׸�(Generic)Ÿ���� ���� �߰��Ǹ鼭, Ư�� �÷���(�ڷᱸ��)�� ����Ǿ��� Ư���� ��ü Ÿ���� ����Ͽ�
		     �����ϱ��� ������ �ܰ迡�� Ư���� ��ü Ÿ���� �ƴϸ� ������ �߻���� �Ͽ� ������ �Ұ����ϵ��� �������.
		     ��, Ư�� �÷���(�ڷᱸ��)�� ����Ǿ��� ��ü�� Ÿ���� �����ϵ��� ���� ���̴�.
		
		    ��   ���׸�(Generic)Ÿ���� ����ϱ� ��������  �÷���(�ڷᱸ��)�� ����Ǿ��� ��ü���� �ϳ��� �����Ͽ� ��ü Ÿ���� Ȯ���� �� �ۿ� ������.
		  Object �� ���� ��ӹ��� ��ü�� ��� ������ �����ߴ� ������ ��������� �޸� ���� ü�����̶� �� �� �ִ�.
		  
		    �� ���׸�(Generic)Ÿ���� ��������ν� ������ �� ��ȯ(Casting)�� �ʿ���� <> ���̿� �����Ͽ��� ��ü�ڷ������� ����Ǿ� ���ϴ�.       
		
		    �� ���׸�(Generic)Ÿ�Կ� �־ 1�� ���ڷ� �� �����빮�ڴ� �����빮�� �ƹ����̳� ����ص� �����ϴ�.
		 -- �׷��� ������ ��ü�� ���׸�(Generic)Ÿ������ ���ɶ� �ڷ���(Type)�̶�� ��Ÿ���� �������� <T>��� ����,
		           ��� ���(Element)�̶�� ��Ÿ���� �������� <E>��� ����, 
		    key���̶�� ��Ÿ���� �������� <K>��� ����, Value���̶�� ��Ÿ���� �������� <V>��� ����.      
    
*/	

		ArrayList nameList = new ArrayList();
		
		nameList.add(new String("�̼���"));
		nameList.add("�̼���");
		
		nameList.add(new Double(1234.5));
		nameList.add(1234.5);		// double --> Double ����ڽ� �Ǿ���
		
		nameList.add(new Integer(98));
		nameList.add(98);		// int --> Integer �� ����ڽ� �Ǿ���
		
		nameList.add(new Member());
		
		
		for (int i=0; i<20000; i++) {
			nameList.add((i+1)+". ����ȭ");
		}
		
		for (int i=0; i<nameList.size(); i++) {
			System.out.println(nameList.get(i));
		}
			
		// == �Ի繮�� == //
		/* *** Array�� ArrayList�� ��������
		   1. Array �� ũ�Ⱑ �����Ǿ��� ������
		      Collection�� ũ�Ⱑ ������ �̴�.
		   2. Array �� �迭�� ũ�Ⱑ ����Ǿ��� ������ Ÿ���� �����͸� �Է°���������
		      Collection�� �ԷµǾ����� �����Ͱ� ��ü�̱⸸ �ϸ� � ���̵��� �����ϴ�.
		 */
		
		/////////////////////////////////////////////////////////////////////////
		// ==== Generic(���׸�) ==== //
		/* ���� Collection(����ü)�� Object �̱⸸ �ϸ� ��� �Է��� �����ϴ�.
		    �׷��� �Է��� ��� ������ �����ͼ� ����� ���� ������ �߻��Ѵ�.
		    ������ �������߿��� Ư�� ������Ÿ���� ������ �����͸� ��������� ������
		    ������ �۾��� �ؾ߸� �Ѵ�. 
		    �׷��� �迭ó�� Ư���� Ÿ���� �����͸� �Է��ϵ��� ���� ���� Generic(���׸�)�̴�.
		    �׷��߸� �����͸� ������ �� ���� ��Ȯ������.
		*/
		
		//List<E> �� E �� elements
		//�������̽��� ��ü�ޱ�
		
/*
 		public class ArrayList<E>
		extends AbstractList<E>
		implements List<E>, RandomAccess, Cloneable, Serializable
 */
		
	//	List<String> strList = new ArrayList<String>();
	// �Ǵ�
		List<String> strList = new ArrayList<>();		// String�� ���������ѵ� JDK 8���� ������.
	//	List<> strList = new ArrayList<String>();		// ����!!
		
	//	List<Double> dbList = new ArrayList<Double>();
		List<Double> dbList = new ArrayList<>();
		
	//	List<Integer> intList = new ArrayList<Integer>();
		List<Integer> intList = new ArrayList<>();
		
	//	List<Member> mbrList = new ArrayList<Member>();
		List<Member> mbrList = new ArrayList<>();
		
		mbrList.add(new Member());
	//	mbrList.add(10); 	// ����!! mbrList ���� Generic���� ����� Member ��ü�� ������ �����̴�.
		
		
	}

}
