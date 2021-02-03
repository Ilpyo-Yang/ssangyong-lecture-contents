package io.day2.a;

import java.io.*;
import java.util.Scanner;

public class BufferedInputStream3_3ME {

/*
	   >>>>> BufferedInputStream 와 BufferedOutputStream <<<<<
	   -- 1 byte 기반 스트림.
	   -- 필터스트림(다른말로 보조스트림 이라고 부른다.)
	   -- 단독으로 사용할 수 없고, 반드시 노드스트림에 장착되어 사용되는 것이다.
           마치 수영장에서 오리발처럼 보조기구로 사용한다.
           이것을 사용하면 오리발처럼 속도가 향상되므로 많이 사용한다.
	           
	   -- 읽어올 데이터를 매번 1 byte 마다 읽고,쓰고 한다라면 입.출력에 너무 많은 시간이 소요된다.
           그래서 쓰는 작업없이 메모리 버퍼에 데이터를 한꺼번에 쭉~~ 읽기만 하여 모아두면
           그만큼 쓰는 작업이 없으므로 읽기 속도는 빨라질 것이다.
           그리고 나서 메모리 버퍼에 읽어서 모아두었던 내용을 한방에 쓰기를 하면 매번 1byte 씩 쓰는 것보다
           속도가 빨라진다.
        // => 저장장치가 디스크에서 디스크로 바로 복사하는 것보다 한 번에 읽어서 임시저장공간 RAM 버퍼에 기억하고 한 번에 디스크에 넣는 것이 빠르다.
	           
	    BufferedInputStream 와  BufferedOutputStream 의 기본 버퍼크기는 512 byte 이다.
	    
	    [예제]
	       필터스트림(보조스트림)을 이용해서 파일로 부터 입력받고, 
	       입력받은 그 내용을 파일에 출력해본다. 즉, 파일복사하기
	       
	    >>> 데이터소스 : 파일(FileInputStream --> 노드스트림)
	            + 필터스트림(보조스트림)으로 BufferedInputStream 을 사용함.
	    
	    >>> 데이터목적지 : 파일(FileOutputStream --> 노드스트림)
                + 필터스트림(보조스트림)으로  BufferedOutputStream 을 사용함.                                                 
	      
*/
	
	// 원본파일 크기 176,315,124 바이트
	/*
	 		##################################################
	 */
	// # 1개를 1mb(==1024*1024)로 본다. 
	
	public static void main(String[] args) {
		
		try {
			// 입력노드스트림 ==> 파일(FileInputStream)
			// 입력노드스트림 ==> 보조(필터) 스트림(BufferedInputStream)을 장착한다.
			
			String srcFileName = "c:/iotestdata/원본/k5_2.png";
			File srcFile = new File(srcFileName);
			FileInputStream fist = new FileInputStream(srcFileName);
			
			BufferedInputStream bist = new BufferedInputStream(fist, 4096);		//1024 == 1kb
			// 노드스트림인 fist에 필터스트림(보조스트림)을 장착함.
			// fist [필터스트림(보조스트림)]의 버퍼크기는 4096 byte로 했다.
			
			// 출력노드스트림 ==> 파일(FileOutputStream.out)
			// 출력노드스트림 ==> 보조(필터) 스트림(BufferedOutputStream)을 장착한다.
			
			String targetFileName = "c:/iotestdata/복사본/k5_2_복사본.png";
			File targetFile = new File(targetFileName);
			FileOutputStream fost = new FileOutputStream(targetFileName);
			
			BufferedOutputStream bost = new BufferedOutputStream(fost, 4096);
			// 노드스트림인 FileOutputStream 필터스트림(보조스트림)을 장착함.
			// bost2 [필터스트림(보조스트림)]의 버퍼크기는 1024 byte로 했다.
			
			byte[] byteArr = new byte[512];
			
			int inputLength = 0;
			int totalByte = 0;
			int cnt = 0;
			
			while ((inputLength = bist.read(byteArr)) != -1) {
				
				// 파일에 출력
				bost.write(byteArr, 0, inputLength);
				bost.flush();
			
				totalByte+=inputLength;
				
				System.out.print("#");
				cnt++;
				if(cnt%50==0)
					System.out.print("\n");
				
			}// end of while --------------------------------------------------

			// 닫을 때는 보조(필터)스트림부터 먼저 닫고, 그 다음에 노드스트림을 닫는다.
			
			bist.close();
			fist.close();
			
			bost.close();
			fost.close();
			
			System.out.println("\n복사완료");
			System.out.println(">> "+totalByte+" byte 씀 <<");
			
		} catch (FileNotFoundException e) {
			System.out.println(">> 파일이 존재하지 않습니다. <<");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
