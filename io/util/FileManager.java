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

	
	// === 직렬화(Serialization) 해주는 메서드 생성하기 === //
	//	      직렬화(Serialization) => 객체를 파일로 저장하기
	public static void objectToFileSave(Object obj, String saveFileName) throws FileNotFoundException, IOException {
		
		// === 객체 obj 를 파일 saveFileName 로 저장하기
		
		FileOutputStream fost = new FileOutputStream(saveFileName);
		// 노드스트림(빨대꽂기)
		
		BufferedOutputStream bufOst = new BufferedOutputStream(fost, 1024);		// 버퍼 크기를 안잡으면 512byte
		// 필터스트림(보조스트림, 노드스트림에 오리발장착하기)
		
		ObjectOutputStream objOst = new ObjectOutputStream(bufOst);
		// 객체 obj 를 파일 saveFileName에 기록하는 (저장하는) 스트림 생성하기
		
		objOst.writeObject(obj);
		// objOst 을 사용하여 객체 obj 를 파일 saveFileName 에 기록하기(저장하기)
		
		objOst.close();
		bufOst.close();
		fost.close();
		
	} 
	
	
	// === 역직렬화 해주는 메서드 생성하기 === //
	//	      역직렬화 => 파일로 저장된 데이터를 객체로 만들어주는 것이다.
	public static Object getObjectFromFile(String saveFileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// ===  파일 saveFileName 에 저장되어진 정보를 읽어와서 객체로 변환하기 ==
		
		FileInputStream fist = new FileInputStream(saveFileName);
		// 노드스트림(빨대꽂기)
		
		BufferedInputStream bufInst = new BufferedInputStream(fist, 1024);		// 버퍼 크기를 안잡으면 512byte
		// 필터스트림(보조스트림, 노드스트림에 오리발장착하기)
		
		ObjectInputStream objInst = new ObjectInputStream(bufInst);
		// 파일 saveFileName 에 저장되어진 정보를 읽어와서 객체로 변환해주는  스트림 생성하기
		
		Object obj = objInst.readObject();
		// objInst 을 사용하여 파일 saveFileName 에 저장된 객체를 불러와서I Object 타입으로 리턴해주는 것이다.
		
		objInst.close();
		bufInst.close();
		fist.close();
		
		return obj;
		
	} 
}
