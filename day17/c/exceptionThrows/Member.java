package my.day17.c.exceptionThrows;

public class Member {

	// field
	String name;
	String kor;
	String eng;
	String math;
	
	// method
	void info() throws Exception {
		// ������ info() �޼��� ������ �ͼ��� ó���� �ؾ� ������
		// ���⼭�� info() �޼��� ������ throws Exception �� �����Ƿ� 
		// info() �޼��� ������ �ͼ��� ó���� ���� �ʰ�
		// info() �޼��� ȣ���ϴ� �ʿ��� Exception �� ó���ض�� ���̴�.
		
		int nkor = Integer.parseInt(kor);
		int neng = Integer.parseInt(eng);
		int nmath = Integer.parseInt(math);
		
		int total = nkor+neng+nmath;
		
		String info="1. �л��� : "+name+"\n"
					  +"2. ���� : "+kor+"\n"
					  +"3. ���� : "+eng+"\n"
					  +"4. ���� : "+math+"\n"
					  +"5. ���� : "+total+"�� \n";
					  
		System.out.println(info);
	}
	
}
