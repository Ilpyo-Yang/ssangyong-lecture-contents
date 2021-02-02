package io.day1;

import java.io.IOException;

public class inputStreamTest1_1 {

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

		System.out.println(">> �����ڸ� �Է��ϼ��� <<");
		
		int input = 0;
		int totalByte = 0;
		
		while(true) {
			
			input = System.in.read();		// abcd����
		// System.in �� Ű������ �����ϸ� �ȴ�.
		// Ű���忡�� �Է��� ���ڿ� �� ���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ���ִ� ���̴�.
		// System.in.read() �� 1byte �� �о�´�.
			
			System.out.println("���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : "+ input);
			// ���ʹ� \r\n �ε� \r(carriage return) �� 13 �̰� \n(new line) �� 10�� ���̴�.
			// ��, ���Ͷ� ���� �� ������ ���� (\r) �� �ٲ�(\n) �� �ض�� ���̴�.
			
			/*
			 	���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 97
				���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 98
				���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 99
				���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 100
				���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 13
				���� 1����(char)�� �о�鿩 char �� �ش��ϴ� int Ÿ������ ��ȯ�� �� : 10
			 */
			
			if(input!=13 && input!=10) {
				
				if((char)input=='x' || (char)input=='X' )
					break;
				
				totalByte++;
				System.out.println("�� ���� 1�� : "+ (char)input);
			}
			
		}// end of while ----------------------------------------
		
		System.out.println(">> �Է¹��� byte �� : "+totalByte+"byte");
		
	}// end of main() -------------------------------------------

}
