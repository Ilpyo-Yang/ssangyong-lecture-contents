package io.day3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import io.util.FileManager;

public class Main {

	public static void main(String[] args) {

		try {
			Student stud1 = new Student("한석규",21,"서울시 강동구");
			Student stud2 = new Student("두석규",21,"서울시 강서구");
			Student stud3 = new Student("세석규",21,"서울시 강남구");
			Student stud4 = new Student("네석규",21,"서울시 강북구");
			
			List<Student> studList = new ArrayList<>();
			
			studList.add(stud1);
			studList.add(stud2);
			studList.add(stud3);
			studList.add(stud4);
			
			FileManager.objectToFileSave(studList, "C:/iotestdata/객체저장용/StudentList.dat");
			// 직렬화 시켜주는 메서드 호출
			
			////////////////////////////////////////////////////////////////////////////////////
			
			Object obj = FileManager.getObjectFromFile("C:/iotestdata/객체저장용/StudentList.dat");
			if(obj!=null) {
				@SuppressWarnings("unchecked")
				List<Student> resultList = (List<Student>)obj;
				System.out.println(">>> C:/iotestdata/객체저장용/StudentList.dat 파일에 저장된 객체 정보 출력하기");
				
				for(Student stud : resultList) {
					System.out.println(stud.toString());
				}
			} else {
				System.out.println(">> 파일에 저장된 객체정보가 없습니다. <<");
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
	}

}
