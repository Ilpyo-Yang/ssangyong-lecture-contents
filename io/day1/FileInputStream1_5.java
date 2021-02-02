package io.day1;

import java.io.*;
import java.util.Scanner;

public class FileInputStream1_5 {

/*
	    �� Data Source (File, Ű����, ���� ��ǻ��)
	  : �������� �ٿ�
	    
	    �� Data Destination (����, �����, ������, �޸�)
	   : �����Ͱ� ���������� �����ϴ� ��
	
	  Data Source��======>�� ���α׷� ��======>�� Data Destination
	                             �Է½�Ʈ��                    ��½�Ʈ��
	                              InputStream                  OutputStream           
	                              
	 === c:\iotestdata\korea.txt ������ �о �� ������ �����(�ܼ�ȭ��)�� ����ϴ� ���� ===
                  
      1. �����ͼҽ�    : ���Ϸ� ���� �о����   (��彺Ʈ��: FileInputStream) 
      2. �����͸����� : ������� ����Ϳ� ���(��彺Ʈ��: System.out)
      
      >>>> FileInputStream
         - Node ��Ʈ��(�������� ������ �Է½�Ʈ��)
         - 1byte ��� ��Ʈ��.
        
      >>>>> System.out :
                    �θ�Ŭ������ �߻�Ŭ���� OutputStream(�⺻ ��� ��Ʈ��) Ÿ���� �����μ�
                    ������(����)�� �ܼ�ȭ��(�����)�� ��� ��Ʈ��(PrintStream)�̴�.
                    
       -- Node(������)�� �ܼ�ȭ��(�����)�� ��½�Ʈ���̴�.
       -- 1byte ��� ��Ʈ���̴�.
       -- �ֿ� �޼ҵ� : println(String str),
		                     print(String str),
		                     write(int b)  
*/
	
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ���� ������ �̸�(������)�� �Է� => ");
		String fileName = sc.nextLine();
		// ���ϸ� �Է� ==> �����ͼҽ��� �ȴ�.
		// c:\iotestdata\korea.txt
		
		int input = 0;
		int totalByte = 0;		// byte �� �����뵵
		
		try {
		
			FileInputStream fist = new FileInputStream(fileName);
				
			while( (input = fist.read()) != -1 ) {
				/*
		                fist.read() �޼ҵ�� �ش� ���Ͽ��� 
		                �����͸� 1byte �� �о int Ÿ������ �������ش�.
		                ���࿡ ������ ���빰���� �о���� �����Ͱ� ���ٶ��  -1 �� ���Ͻ����ش�.
		                ��, ���ϼ��� ���빰�� ���� �ƴ϶�� ����ؼ� while{} �κ��� �����ض�� ���̴�.
		         */
					
				System.out.write(input);		// ����� (�ܼ�ȭ��)�� ���	
				System.out.flush();
				
				totalByte++;
					
			}// end of while ----------------------------------------
			
			fist.close();
			
		} catch(FileNotFoundException e) {
			System.out.println(fileName+" ������ �����ϴ�.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n=======================");
		System.out.println("�� "+totalByte+"byte");
		System.out.println("�ݺ�Ƚ�� "+totalByte+"�� �ݺ���");
		System.out.println("=======================");
		
		sc.close();
		
	}// end of main() -------------------------------------------

}
