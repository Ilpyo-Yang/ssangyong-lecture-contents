package my.day06.a.FOR;
//***
public class Quiz2MainNA {

	public static void main(String[] args) {
//[Quiz1]
		//���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => super
		//���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => 5
		
	
		String word = "super007Man";
		
		int cnt = 0;
		
		System.out.print("\n���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => ");
		
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(Character.isAlphabetic(ch)) {
				cnt++;
				System.out.print(ch);
			} else break;
			
		} 
			System.out.println("\n���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => "+cnt);

		//System.out.println("���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ��� => "+);
		//System.out.println("���ʷ� ���ڰ� ������ ���� �ձ��� ���ڿ� ���� => "+);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//[Quiz2]
		/*
		       ���ĺ� �ҹ��ڸ� ����ϴµ� �Ʒ�ó�� ��Ÿ������ �ϼ���.
		   a,c,e,g,i,k,m,o,q,s,u,w,y
		 */
				
		for (char i=97; i<122; i+=2) {
			if(i<122-2) {
			System.out.print(Character.toString(i)+',');
			}
			else System.out.print(i);
	    }
		
	}//end of main()
}

