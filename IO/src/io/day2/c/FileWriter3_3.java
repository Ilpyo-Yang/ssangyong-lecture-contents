package io.day2.c;

import java.io.*;
import io.util.FileManager;

public class FileWriter3_3 {

	public static void main(String[] args) {
		
		try {
			FileManager.charFileCopy(args[0], args[1]);
			// args[0] 은 C:/iotestdata/애국가.txt 으로 하고
			// args[1] 은 C:/iotestdata/애국사_복사본.txt 으로 한다.
			
			System.out.println(args[0]+"을 "+args[1]+"로 복사완료함!!");
		} catch (FileNotFoundException e) {
			System.out.println(args[0]+" 파일이 존재하지 않습니다");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(args[0]+" 파일이 존재하지 않습니다");
			e.printStackTrace();
		}

	}

}

/*
	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\NCS\workplace(java)\IO\bin>java io.day2.c.FileWriter3_3 C:/iotestdata/애국가.txt c:/iotestdata/애국사_복사본.txt
	C:/iotestdata/애국가.txt을 c:/iotestdata/애국사_복사본.txt로 복사완료함!!
*/