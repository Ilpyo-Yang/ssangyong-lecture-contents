package my.day08.b.DOWHILE;

public class DoWhileMain {

/*
	  === do ~ while() ===
	   
	   �����ʱ�ȭ;
	   
	   do{
	              �ݺ��ؼ� ������ ��ɹ�;
	              ������;
	   } while(���ǽ�);
	   
	  //������ �ϴ� �Ծ��. �׸��� ���� ������ ���߿� ����.
	   
	  while ���� ��� ���ǽ��� true �϶��� �ݺ� ����������,
	  do ~ while ���� ���� ���ǽ��� false ������
	   ������ do{ } �ӿ� �ִ� ��ɹ��� 1���� �����ϰ� �ݺ����� �����.
	       
	   �׷��Ƿ� do ~ while ���� ������ do{ } �ӿ� �ִ� ��ɹ��� �����ϰ�
	  while(���ǽ�) ���� ���ǿ� ���� ��(true)�̶�� ��� �ݺ��ϰ�,
	   ������ ����(false)�̶�� �����Ѵ�.  
*/
	
	public static void main(String[] args) {

		do {
			System.out.println("�ȳ� �ڹ�~~~");
		} while (false);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		int cnt=5, loop=0;
		do {
			System.out.println(++loop+". Hello Java");
		} while (loop<cnt);
		
		/*
			1. Hello Java
			2. Hello Java
			3. Hello Java
			4. Hello Java
			5. Hello Java
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		cnt=5; loop=0;
		do {
			System.out.println(++loop+". Hello Java~~");
		} while (!(loop==5));  //!()�� ��ȣ ()�ӿ� do while �ݺ����� Ż���� ������ �־��� ��
	
	
	}

}
