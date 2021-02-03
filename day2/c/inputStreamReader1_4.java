package io.day2.c;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	소스 - 입력노드 스트림  키보드(System.in) => 1byte기반
    브릿지 스트림 InputStreamReader => 1byte 를 2byte 로 변경 
	목적지 - 출력노드 스트림 FileWriter => 2byte기반
*/

public class inputStreamReader1_4 {

	public static void main(String[] args) {


		try {
			InputStreamReader istReader = new InputStreamReader(System.in);
			// 키보드에서 입력하는 것은 1byte 기반인데 이것을 2byte 기반으로 변경해주는 것이다.
			
			String targetFileName = "c:/iotestdata/오늘의날씨.txt";
			
			FileWriter fw = new FileWriter(targetFileName);
			
			int input = 0;
			while ((input=istReader.read())!=-1) {
				fw.write(input);
				fw.flush();
			}
			
			fw.close();
			istReader.close();
			
			System.out.println("\n >> 종료합니다 <<");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 		C:\NCS\workplace(java)\IO\bin>java io.day2.c.inputStreamReader1_4
				오늘은 덥다가 춥다가 저녁 퇴근무렵에는 눈이 온대요~~
				
				 >> 종료합니다 <<
		 */

	}

}
