package io.day2.c;

import java.io.*;

public class PrintWriter_7 {
	
/*
	소스 -- 파일 "C:/iotestdata/myprofile.txt"
	노드스트림 -- FileReader
	필터스트림(보조스트림, 오리발) BufferedReader
	        
	        
	목적지 -- 파일 "C:/iotestdata/myprofile복사.txt" 
	노드스트림 -- FileWriter
	필터스트림(보조스트림, 오리발) BufferedWriter / PrintWriter       
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
			PrintWriter pw = new PrintWriter(fw, true);
			/*
			 	new PrintWriter(fw, true); 에서 
			 	두번째 파라미터인 값에 true 를 주면 개행문자(엔터)를 만날때마다 자동으로
			 	flush()메서드가 작동한다는 말이다.
			 */
	
			String strLine = "";
			while ((strLine = br.readLine()) != null) {
				// br.readLine() 메서드는 한 줄 단위로 읽어와서 
				// 읽어온 내용은 String 타입이므로 strLine 변수에 넣어준다. 
				// 1줄을 읽어오되 엔터 전까지 읽어온다.
				
				pw.println(strLine);				
			}
			
			System.out.println("\n>>> 파일복사 완료!! <<<");
			
			pw.close();
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
		 		C:\NCS\workplace(java)\IO\bin>java io.day2.c.PrintWriter_7

				>>> 파일복사 완료!! <<<
		 */
		
	}

}
