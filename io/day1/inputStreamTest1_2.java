package io.day1;

import java.io.IOException;

public class inputStreamTest1_2 {

/*
	    �� Data Source (File, Ű����, ���� ��ǻ��)
	  : �������� �ٿ�
	    
	    �� Data Destination (����, �����, ������, �޸�)
	   : �����Ͱ� ���������� �����ϴ� ��
	
	  Data Source��======>�� ���α׷� ��======>�� Data Destination
	                             �Է½�Ʈ��                    ��½�Ʈ��
	                              InputStream                  OutputStream          
	   
	    
	  >>>>> System.in :
	             �θ�Ŭ������ �߻�Ŭ���� InputStream(�⺻ �Է� ��Ʈ��) Ÿ���� �����μ� 
	             ������(����)�� Ű������ �Է� ��Ʈ���̴�.
	             
	    -- Node(������)�� Ű������ �Է½�Ʈ���̴�.
	    -- 1 byte ��� ��Ʈ���̴�.
	    -- �ֿ�޼ҵ� :
	          public int read() throws IOException
	          ==> 1byte �� �����͸� �о
	              1byte �� ��ȯ�ϰ�
	                          �Է¹��� Ű���尡 Ctrl+C(������), Ctrl+D(���н�,������)
	                          �̶�� -1 �� ��ȯ���ִ� �޼ҵ��̴�.
	              read() �޼ҵ��� ����Ÿ���� byte �� �ƴ϶� int �̴�.
	                          ������ �Է��� ���� ��Ÿ���� ������ -1 �� ����ϴµ�
	              Ctrl+C(������), Ctrl+D(���н�,������)�� ����ϸ� �ȴ�.
	                          ���� IOException �� �߻��Ҽ��� �����Ƿ� �ݵ�� ����ó���� �� ���־�� �Ѵ�.              
	                          �׷��� ���� �츮�� �����츦 ����ϰ� �����Ƿ� InputStream �۾��� 
	                          ������ �����Ϸ���  Ctrl+C(������) �ϸ� �ȴ�.
	    
	  >>>>> System.out :
	              �θ�Ŭ������ �߻�Ŭ������ OutputStream(�⺻ ��� ��Ʈ��) Ÿ���� �����μ�
	              ������(����)�� �ܼ�ȭ��(�����)�� ��� ��Ʈ��(PrintStream)�̴�.
	                   
	    -- Node(������)�� �ܼ�ȭ��(�����)�� ��½�Ʈ���̴�.
	    -- 1byte ��� ��Ʈ���̴�.
	    -- �ֿ� �޼ҵ� : println(String str),
	                  print(String str),
	                  write(int b)             
*/
	
	public static void main(String[] args) throws IOException {

		int input = 0;
		
		while((input = System.in.read()) != -1) {
			// -1 �� Ű����� ctrl +c (��������)�� �Է��� ���̴�. (windows ���, cmd ���)
			// Ű����� ctrl+c(��������)�� �ϸ� while �� ����������.
			// System.in.read() �� 1byte �� �о�´�.
			
			System.out.println("\r\n === Ű����κ��� ������ �Է¹ޱ� ===");
			System.out.println("ȭ�鿡 ��� [println (input)] : "+input);
			System.out.print("ȭ�鿡 ��� [write (input)] : ");
			System.out.write(input);
		//	System.out.flush();
	
		/*
	          flush �� ? ��¹��ۿ� �ӽ÷� �����Ǿ� ��Ʈ������ ��µ� ������ ������� �����͸� ��Ʈ������ �������� ���� flush ��� �Ѵ�.
	          write() �޼ҵ�� flush() �޼ҵ�� �Բ� ���Ǿ�߸� ��¹��ۿ� �� �ִ� ������ �����(�Ǵ� ����)�� ��µȴ�.
	          �׷���  flush() �޼ҵ带 ������� �ʾƵ� �����(�Ǵ� ����)�� ��µǴ� ����̶�� auto flush �� ����Ǿ����� �����̴�. 
	     */			
			
		// print �� ���� ���ÿ� ��������
		// write �� ���⸸ �ϰ� flush �� ���� ���� ������ �� �ִ�.
			
			System.out.println("");
			System.out.println("ȭ�鿡 ��� [println ((char)input)] : "+(char)input);
			
		}// end of while ----------------------------------------
		
		System.in.close(); 	// �Է³��(Ű����) ���� �ݱ�
		System.out.close();   // �Է³��(�����) ���� �ݱ�
		
	}// end of main() -------------------------------------------

}
