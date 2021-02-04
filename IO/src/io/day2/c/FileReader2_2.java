package io.day2.c;

import java.io.IOException;

import io.util.FileManager;

public class FileReader2_2 {

	public static void main(String[] args) {

		String str = "";
		
		try {
			str = FileManager.reading2(args[0]);
		} catch (IOException e) {
			System.out.println(str+" 파일이 존재하지 않습니다");
			e.printStackTrace();
		}
		// args[0] 에 C:/iotestdata/애국가.txt 로 할 것이다.
		
		System.out.println(str);
	
	}

}

/*
	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\NCS\workplace(java)\IO\bin>java io.day2.c.FileReader2_2 C:/iotestdata/애국가.txt
	
	애국가.txt 파일은 저장시 인코딩을 ANSI로 해야 한다.
*/