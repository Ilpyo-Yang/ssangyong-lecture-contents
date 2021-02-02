package io.day1;

import java.io.*;

public class FileOutputStream2_8 {

/*
       ※ Data Source (File, 키보드, 원격 컴퓨터)
     : 데이터의 근원
       
       ※ Data Destination (파일, 모니터, 프린터, 메모리)
      : 데이터가 최종적으로 도착하는 곳
   
     Data Sourceㅇ======>ㅇ 프로그램 ㅇ======>ㅇ Data Destination
                                입력스트림                    출력스트림
                                 InputStream                  OutputStream           
*/
   public static void main(String[] args) throws FileNotFoundException {

      System.out.println(">> 내용을 입력하세요 [ 입력하신 내용은 C:\\iotestdata\\result.txt 파일에 저장됨 ]" );
      
      String fileName = "C:/iotestdata/result.txt ";
      
      boolean append = true;
      byte[] dataArr = new byte[10];
      
      int inputLength = 0;
      int totalByte = 0;      // byte 수 누적용도
      int cnt = 0;          // 반복횟수
      
      try {
      
         FileOutputStream fost = new FileOutputStream(fileName, append);
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
         
         while( (inputLength = System.in.read(dataArr)) != -1 ) {
            /*
                      fist.read(dataArr) 메소드는 해당 파일에서 
                      데이터를 배열 dataArr 크기인 64 byte 씩 잘라서 읽는데  
                      실제 읽어온 byte 크기(int 타입)를 inputLength 에 넣어준다.
                      이어서 읽어온 내용물은 배열 dataArr 에 저장시킨다.
                     
                      만약에 파일의 내용물에서 읽어들일 데이터가 없다라면  -1 을 리턴시켜준다.
                      즉, 파일속의 내용물이 끝이 아니라면 계속해서 while{} 부분을 실행해라는 말이다.
               */
               
            fost.write(dataArr, 0, inputLength);      // 모니터 (콘솔화면)에 출력   
            fost.flush();
            
            totalByte+=inputLength;   
            cnt++;
            }// end of while ----------------------------------------
         
         fost.close();
         
      } catch(FileNotFoundException e) {
         System.out.println(fileName+" 파일이 없습니다.");
      } catch(IOException e) {
         e.printStackTrace();
      }
      
      System.out.println(fileName+"에 쓰기 완료!! "+totalByte+"byte 씀.");
      System.out.println("반복횟수 : "+cnt+"번 반복함.");
      System.out.close();
      
   }// end of main() -------------------------------------------

}