package io.util;

import java.io.*;

public class FileManager {

	public static String reading(String fileName) { 
		
		// 해당 파일에 노드 연결을 생성(빨대꽂기)
		try {
			FileReader fr = new FileReader(fileName);
			int data = 0;
			// String returnData = "";
			// package my.day10.e.stringbuilder;
			// String의 누적은 메모리 손실을 가져오기 때문에 StringBuilder를 통해서 정리해야 한다.
			StringBuilder sb = new StringBuilder();
			
			do {
				data = fr.read();		// 파일로부터 글자(char) 1개(2byte) 씩 읽어들임.
											// 파일로부터 읽어들일 글자(char)가 없으면 -1을 리턴시켜줌.
				if(data != -1)
					//returnData += (char)data;
					sb.append((char)data);
				
				else
					break;
			} while(true);		// 참이면 계속 뺑뺑이
			
			//return returnData;
			return sb.toString();
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			return fileName + "이라는 파일은 없습니다!!";
		} catch (IOException e) {
			e.printStackTrace();
			return fileName + "이 손상되었습니다!!";
		}
		
	}// end of public static String reading(String fileName) --------------------
	
	
	public static String reading2(String fileName) throws FileNotFoundException, IOException { 
		
		// 해당 파일에 노드 연결을 생성(빨대꽂기)
		FileReader fr = new FileReader(fileName);
		
		char[] dataArr = new char[10];
		int dataLength = 0;
		// String returnData = "";
		// package my.day10.e.stringbuilder;
		// String의 누적은 메모리 손실을 가져오기 때문에 StringBuilder를 통해서 정리해야 한다.
		StringBuilder sb = new StringBuilder();
		
		do {
			dataLength = fr.read(dataArr);		
			 // fr 파일로 부터 글자(char)10개씩 읽어들임.
	         // 읽어들인 글자는 char[] 타입의 배열인 dataArr 에 저장시킨후
	         // 읽어들인 글자수(길이)는 dataLength 에 저장시킨다.
	         // 그런데 fr 파일이 손상되었을시 IOException 이 발생된다. 
			
				if(dataLength != -1) {
					String str = new String(dataArr, 0, dataLength);
					// new String(dataArr, 0, dataLength) 은 
					// char[] 타입의 배열인 dataArr 에서 0 번째 인덱스 글자부터 
					// dataLength 갯수만큼 뽑아서 String 타입으로 만든다는 말이다.
					
					sb.append(str);
				}
				else
					break;
		} while(true);		// 참이면 계속 뺑뺑이
		
		//return returnData;
		return sb.toString();
	
	}// end of public static String reading(String fileName) --------------------
	
	public static void charFileCopy(String srcFileName, String targetFileName) throws FileNotFoundException, IOException { 
	
	// 해당 소스파일에 노드 연결을 생성(빨대꽂기)
	FileReader fr = new FileReader(srcFileName);
	
	// 해당 타겟파일에 노드 연결을 생성(빨대꽂기)
	FileWriter fw = new FileWriter(targetFileName);
		
	char[] dataArr = new char[10];
	int dataLength = 0;

	do {
		dataLength = fr.read(dataArr);		
		 // fr 파일로 부터 글자(char)10개씩 읽어들임.
         // 읽어들인 글자는 char[] 타입의 배열인 dataArr 에 저장시킨후
         // 읽어들인 글자수(길이)는 dataLength 에 저장시킨다.
         // 그런데 fr 파일이 손상되었을시 IOException 이 발생된다. 
		
			if(dataLength != -1) {
				fw.write(dataArr);
				fw.flush();
			}
			else
				break;
	} while(true);		// 참이면 계속 뺑뺑이
	
	fr.close();
	fw.close();

}// end of public static String reading(String fileName) --------------------

}
