package my.day06.a.FOR;
//***
public class Quiz2Main {

	public static void main(String[] args) {
//[Quiz1]
		//���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => super
		//���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => 5
		
//***���1.		
		String word = "sup3er007Man";
		String result = "";
		int i=0;
		
		//�迭 Ǯ�� ����غ� ��!
		for (; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isDigit(ch)) {
				break;    //i => 5, ���ڿ��� ���̿� ����
			} else {
				result += ch;
				//�ϳ��� ����ϴ� ���� �ƴ϶� ���ڸ� result ���� �ϳ��� �����ؼ� ���
			}
			
		} 
		
		System.out.print("\n1.���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => "+result);
		System.out.println("\n1.���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => "+i);

		//System.out.println("���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => "+);
		//System.out.println("���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => "+);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//���2.
		int index = 0;
		result = "";
		
		for(;;) {
			char ch = word.charAt(index++);
				//word.charAt(0);
				//index => 0+1
			
			if(Character.isDigit(ch)) break;    //word.charAt(5)
		    else result += ch;
		}
		
		System.out.print("\n2.���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => "+result);
		System.out.println("\n2.���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => "+(index-1));
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//[Quiz2]
		/*
		       ���ĺ� �ҹ��ڸ� ����ϴµ� �Ʒ�ó�� ��Ÿ������ �ϼ���.
		   a,c,e,g,i,k,m,o,q,s,u,w,y
		 */
//���1.
		int len = 'z'-'a'+1;  //122-97+1 = 26
		
		for (i=0; i<len; i++) {
			char ch = (char)('a'+i);
			if((ch+0)%2 == 0) continue;  //�Ʒ� ������ ������� �ʰ� ����������
			//���� ���׿����ڿ� ���� �� �𸣰� �ִ� �� ������
			//�� �ڿ� , �� ���� ���ɼ��� ������ ��
			String str = (i<len-2) ? "," : "";
			System.out.print(ch+str);
	    }
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
//���2.
		for(i='a';i<'z'+1;i++) {	
			if(i%2==0) continue;
			String str = (i<'z'-1)?",":"";
			System.out.print((char)i+str);
		}
		
	}//end of main()
}

