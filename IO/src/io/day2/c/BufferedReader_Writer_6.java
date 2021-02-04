package io.day2.c;

import java.io.*;

public class BufferedReader_Writer_6 {
	
/*
    소스 -- 파일 "C:/iotestdata/myprofile.txt"
    노드스트림 -- FileReader
  	필터스트림(보조스트림, 오리발) BufferedReader
        
  	목적지 -- 파일 "C:/iotestdata/myprofile복사.txt" 
    노드스트림 -- FileWriter
 	필터스트림(보조스트림, 오리발) BufferedWriter || PrintWriter       
*/
	
	public static void main(String[] args) {
		try {
			// 소스파일 이름
			String srcFileName = "C:/iotestdata/myprofile.txt";
			
			// 2byte 기반의 입력 노드스트림 생성 (빨대꽂기)
			FileReader fr = new FileReader(srcFileName);
			
			// 입력 필터스트림(보조스트림, 오리발)을 노드스트림에 장착하기
			BufferedReader br = new BufferedReader(fr, 1024);
			
			// ------------------------------------------------------------------------------------ //
			
			// 타겟파일 이름
			String targetFileName = "C:/iotestdata/myprofile_복사본.txt";
			
			// 2byte 기반의 입력 노드스트림 생성 (빨대꽂기)
			FileWriter fw = new FileWriter(targetFileName);
			
			// 입력 필터스트림(보조스트림, 오리발)을 노드스트림에 장착하기
			BufferedWriter bw = new BufferedWriter(fw, 1024);
	
			String strLine = "";
			while ((strLine = br.readLine()) != null) {
				// br.readLine() 메서드는 한 줄 단위로 읽어와서 
				// 읽어온 내용은 String 타입이므로 strLine 변수에 넣어준다. 
				// 1줄을 읽어오되 엔터 전까지 읽어온다.
				
				bw.write(strLine);
				bw.newLine();
				// 줄바꿈을 해야한다.
				// 또는
				// bw.write("\r\n");		// 엔터
				
				bw.flush();
			}
			
			System.out.println("\n>>> 파일복사 완료!! <<<");
			
			bw.close();
			fw.close();
			
			br.close();
			br.close();
		
		} catch(FileNotFoundException e) {
			System.out.println("");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		/*
		 		C:\NCS\workplace(java)\IO\bin>java io.day2.c.BufferedReader_Writer_6

				>>> 파일복사 완료!! <<<
		 */
		
	}

}
