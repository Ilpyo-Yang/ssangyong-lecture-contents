package io.day1;

import java.io.*;
import java.util.Scanner;

public class FileCopy1_9 {

/*
       ※ Data Source (File, 키보드, 원격 컴퓨터)
     : 데이터의 근원
       
       ※ Data Destination (파일, 모니터, 프린터, 메모리)
      : 데이터가 최종적으로 도착하는 곳
   
     Data Sourceㅇ======>ㅇ 프로그램 ㅇ======>ㅇ Data Destination
                                입력스트림                    출력스트림
       			InputStream        OutputStream     
       			
    === 파일로부터 입력받은 것을 파일에 기록(출력하기로 한다. ===
    1. 데이터 소스 : 파일로부터 입력받음			 FileInputStream
    2. 데이터 목적지 : 결과를 특정파일에 출력함		 FileOutputStream
*/
	
   public static void main(String[] args) throws FileNotFoundException {

	   
	  Scanner sc = new Scanner(System.in);
	  
      System.out.print(">> 복사할 원본파일명(절대경로) 입력 => ");
      String srcFileName = sc.nextLine();
      
      System.out.print(">> 목적 파일명(절대경로) 입력 => ");
      String targetFileName = sc.nextLine();
      
      System.out.println("소스파일 : "+srcFileName);
      System.out.println("목적파일 : "+targetFileName);
      
      byte[] dataArr = new byte[1024];		// 1024 byte == 1kb
      
      int inputLength = 0;
      int totalByte = 0;      // byte 수 누적용도
      int cnt = 0;          // 반복횟수
      
      try {
    	 
    	 FileInputStream fist = new FileInputStream(srcFileName);
    	 // FileInputStream 생성 : 접속점이 파일인 것으로 특정 파일에 빨대를 꽂아 파일의 내용물을 1byte 기반으로 빨아들이는 입력노드 스트림이다. 
      
         FileOutputStream fost = new FileOutputStream(targetFileName);
         // FileOutputStream 생성 : 접속점이 파일인 것으로 특정 파일에 빨대를 꽂아 파일의 내용물을 1byte 기반으로 기록해주는(써주는) 출력노드 스트림이다. 
         
         /*
	                  만약에  탐색기에서 
	                  C:/iotestdata/result.txt 파일이 없다라면
	                  파일을 자동으로 생성해준다.
	                  단, 탐색기에서 C:/iotestdata 폴더는 존재해야 한다.
	               
	                  두번째 파라미터인 append 가 true 인 경우는
	                  첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
	                  기존내용물은 그대로 두고 기존내용 뒤에 새로운 내용을 덧붙여 추가하겠다는 말이다. 
	                  
	                  두번째 파라미터인 append 가 false 인 경우는
	                  첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
	                  기존내용물은 싹 지우고 새로운 내용을 새롭게 처음부터 쓰겠다는 말이다.
	                
	                  그런데 만약에 두번째 파라미터를 생략하면    
	                  즉, FileOutputStream fost = new FileOutputStream(filename); 이라면
	                  자동적으로 false 로 인식한다. 즉, filename 의 기존내용물은 싹 지우고 새로운 내용을 새롭게 처음부터 쓰겠다는 말이다.    
          */
         
         while( (inputLength = fist.read(dataArr)) != -1 ) {
               
            fost.write(dataArr, 0, inputLength);      // 파일에 쓰기   
            fost.flush();
            
            totalByte+=inputLength;   
            cnt++;		// 반복횟수
            }// end of while ----------------------------------------
         
         fist.close();
         fost.close();
         
      } catch(FileNotFoundException e) {
    	 e.printStackTrace();
      } catch(IOException e) {
         e.printStackTrace();
      }
      
      System.out.println(targetFileName+"에 쓰기 완료!! "+totalByte+"byte 복사됨.");
      System.out.println("반복횟수 : "+cnt+"번 반복함.");
      System.out.close();
      
      sc.close();
      
   }// end of main() -------------------------------------------

}