package io.day2.c;

import io.util.FileManager;

public class FileReader1_1 {

	public static void main(String[] args) {
	// 읽어들일 파일명은 명령프롬프트에서 파라미터(인자)로 주겠다.
	/*
		String str1 = args[0];
		String str2 = args[1];
		
		System.out.println("str1 => "+str1);
		System.out.println("str2 => "+str2);
	*/
		
		String str = FileManager.reading(args[0]);
		// args[0] 에 C:/iotestdata/애국가.txt 로 할 것이다.
		
		System.out.println(str);
	
	}

}

/*
 	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\Users\ilpyo>cd C:\NCS\workplace(java)\IO\bin
	
	C:\NCS\workplace(java)\IO\bin>java io.day2.c.FileReader1_1 안녕하세요 hello
	str1 => 안녕하세요
	str2 => hello
	
	실행은 명령프롬프트에서 아래와 같이 한다.
	C:\NCS\workplace(java)\IO\bin>java io.day2.c.FileReader1_1 C:/iotestdata/애국가.txt
	
	애국가.txt 파일은 저장시 인코딩을 ANSI로 해야 한다.
	
*/