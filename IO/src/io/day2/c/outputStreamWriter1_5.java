package io.day2.c;

import java.io.*;

/*
		소스 - "c:/iotestdata/오늘의날씨.txt" 
		FileReader => 2byte기반
		목적지 - 출력노드 스트림 System.out => 1byte기반    
		브릿지 스트림 OutputStreamWriter => 1byte 를 2byte 로 변경 
*/

public class outputStreamWriter1_5 {

	public static void main(String[] args) {


		try {
			String srcFileName = "c:/iotestdata/오늘의날씨.txt";
			FileReader fr = new FileReader(srcFileName);
			// fr 은 2byte 기반임

			OutputStreamWriter ostReader = new OutputStreamWriter(System.out);
			// 모니터에 출력되는 것은 1byte 기반인데 이것을 2byte 기반에서 변경해주는 것이다.
		
			int input = 0;
			while ((input=fr.read())!=-1) {
				ostReader.write(input);
				ostReader.flush();
			}
			
			fr.close();
			ostReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 		C:\NCS\workplace(java)\IO\bin>java io.day2.c.outputStreamWriter1_5
				오늘은 덥다가 춥다가 저녁 퇴근무렵에는 눈이 온대요~~
		 */

	}

}
