package io.day2.b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class File_1 {

	/*
	 		>>> File 클래스 <<<
	 		자바에서 File 클래스의 객체라 함은 파일 및 폴더(디렉토리)를 다 포함한다.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("탐색기에 존재하는 파일명을 입력하세요 : ");
		String fileName = sc.nextLine();
		// c:/iotestdata/원본/k5_2.png
		
		File file1 = new File(fileName);
		
		System.out.println("파일명만 : "+file1.getName());
		// file1.getName(); 은 파일명만 알려주는 것이다.
		// 파일명만 : k5_2.png
		
		Long fileSize = file1.length();		// 파일크기
		System.out.println("파일크기 : "+fileSize+"byte");
		// 파일크기 : 169890byte
		
		String absoultePath = file1.getAbsolutePath();
		System.out.println("파일의 절대경로 : "+absoultePath);
		// 파일의 절대경로 : c:\iotestdata\원본\k5_2.png
		
		String path = file1.getPath();
		System.out.println("파일의 경로 : "+path);
		// 파일의 절대경로 : c:\iotestdata\원본\k5_2.png
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 디렉토리(폴더) 생성하기 <<<");
		
		File dir = new File("C:/iotestdata/MyDir");
		
		boolean bool = false;
		
		if(!dir.exists()) {
			// 해당 디렉토리 폴더가 없으면
			bool = dir.mkdir();		// 해당 디렉토리(폴더)를 생성해라.
			String result = bool?"디렉토리(폴더) 생성 성공!!":"디렉토리(폴더) 생성 실패!!";
			System.out.println("C:/iotestdata/MyDir "+result);
		}
	
		// dir이 폴더인지 알아오기
		if(dir.isDirectory()) {
			System.out.println("C:/iotestdata/MyDir 은 디렉토리(폴더) 입니다.");
		}
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 파일 생성하기 <<<");
		
		File file2 = new File("C:/iotestdata/MyDir/테스트1.txt");
		
		bool = false;
		

		if(!file2.exists()) {
			// 해당 파일이 존재하지 않으면
			
			try {
				bool = file2.createNewFile();		// 해당 파일을 생성해라.
				
				if(bool)
					System.out.println("테스트1.txt의 절대경로 : "+file2.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		// file2가 파일인지 알아오기
		if(file2.isFile()) {
			System.out.println("C:/iotestdata/MyDir/테스트1.txt 는 파일 입니다.");
		}
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 파일 삭제하기 <<<");
		
		bool = file2.delete();	
		
		String result = bool?"C:/iotestdata/MyDir/테스트1.txt 파일삭제 성공!!":"C:/iotestdata/MyDir/테스트1.txt 파일삭제 실패!!";
		System.out.println(result);
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 빈 디렉토리(폴더) 삭제하기 <<<");
		
		if(dir.exists()) {
			bool = dir.delete();	
			result = bool?"C:/iotestdata/MyDir 디렉토리(폴더) 삭제 성공!!":"C:/iotestdata/MyDir 디렉토리(폴더) 삭제 실패!!";
			System.out.println(result);
		}
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 내용물이 들어있는 디렉토리(폴더) 삭제하기 실패한 예제 <<<");
		// 먼저 아래 실습을 하려면 탐색기에서 C:/iotestdata 에 images 폴더를 생성하고 폴더 속에 파일을 몇 개 올려둔다.
		
		File imagesDir = new File("C:/iotestdata/images");
		
		if(imagesDir.exists()) {
			bool = imagesDir.delete();	
			result = bool?"C:/iotestdata/images 디렉토리(폴더) 삭제 성공!!":"C:/iotestdata/images 디렉토리(폴더) 삭제 실패!!";
			System.out.println(result);
		}
		
		System.out.println("========================================\n");
		
		System.out.println(">>> 내용물이 들어있는 디렉토리(폴더) 삭제하기 성공한 예제 <<<");
		
		// 1. 내용물이 들어있는 디렉토리 내에 존재하는 내용물을 파악한다.
		File[] fileArr = imagesDir.listFiles();
		for (int i=0; i<fileArr.length; i++) {
			String absolutePath2 = fileArr[i].getAbsolutePath();
			System.out.println(absolutePath2);
			fileArr[i].delete();
			// C:\iotestdata\images 폴더 내의 파일들을 모두 삭제한다.
			// C:\iotestdata\images 폴더는 텅 빈 상태이므로 삭제가 가능하다.
		}
		
		/*
			 	C:\iotestdata\images\k5.png
				C:\iotestdata\images\k5_2.png
		 */

        bool = imagesDir.delete();		
		result = bool?"C:/iotestdata/images 디렉토리(폴더) 삭제 성공!!":"C:/iotestdata/images 디렉토리(폴더) 삭제 실패!!";
		System.out.println(result);
		
		sc.close();
	}

}
