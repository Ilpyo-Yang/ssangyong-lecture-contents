package io.day1;

import java.io.IOException;

public class inputStreamTest1_4 {

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

		// Ű���忡�� "���ѹα������ȫ���Ա�����" �ߴٶ��
		// "���ѹα���"  "���ȫ����"  "������"
		//  10byte			10byte			4byte
		
		byte[] dataArr = new byte[10];
		// dataArr ������ �뵵�� ����(System.in, Ű����)���� ������ �� ����ũ�⸦ 10byte�� �ϴ� ���̴�.
		
		int inputLength = 0;
		// inputLength ������ �뵵�� ����(System.in, Ű����)���� ������ ���� ũ�⸦ ��Ÿ���� �뵵��.
		
		int totalByte = 0;
		
		while( (inputLength = System.in.read(dataArr)) != -1 ) {
			// Ű����� Ctrl+C(��������)�� ������ ������ ��� �����ض�.
			
		/*
               System.in.read(dataArr)�� 
               �Է��� �����Ͱ� "���ѹα������ȫ���Ա�����" �̶��
               �Է��� ���뿡�� �迭 dataArr�� ũ�⸸ŭ(������  10byte) �о���δ�(������ "���ѹα���"). 
               �о���� "���ѹα���"�� �迭 dataArr �� �����Ű��, �о���� ũ�⸦(������ 10byte) ���Ͻ����ش�. 
           
               �ݺ����� ù��°�϶�
               dataArr ����  "���ѹα���" �� ����, inputLength ���� 10 �� ����.
         
               �ݺ����� �ι�°�϶�
               dataArr ����  "���ȫ����" �� ����, inputLength ���� 10 �� ����.
            
               �ݺ����� ����°�϶�
               dataArr ����  "������" �� ����, inputLength ���� 4 �� ����.    
         */
			
			System.out.write(dataArr, 0, inputLength);
			// �迭 dataArr �� ����� �����Ϳ��� �������� 0��° index ����(ó������) inputLength byte �� ��ŭ ����ض�� ���̴�.
			System.out.flush();
			
			totalByte+=inputLength;		// 10+10+4
			
	
		}// end of while ----------------------------------------
		
		System.out.println("�� : "+(totalByte-2)+"byte �Է���");		// ���� ũ�⸦ ������ +2�� �� ����.
		
		System.in.close(); 	// �Է³��(Ű����) ���� �ݱ�
		System.out.close();   // �Է³��(�����) ���� �ݱ�
		
	}// end of main() -------------------------------------------

}
