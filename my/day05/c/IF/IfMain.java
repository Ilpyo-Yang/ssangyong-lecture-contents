package my.day05.c.IF;

public class IfMain {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2 = 20;
		
		if(n1 == n2) {
			System.out.println(n1+ "은 " + n2+ "과 같습니다.");
		} else {
			System.out.println(n1+ "은 " + n2+ "과 같지 않습니다.");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

// 문자열의 비교
		
		String name1 = "이순신";   //클래스지만 원시형처럼 사용, 많이 사용되니까
		String name2 = "이순신";

		if(name1 == name2) {  //name1 == name2은 name1과 name2의 값을 비교한다.
			System.out.println(name1+ "은 " + name2+ "과 같습니다.");
		} else {
			System.out.println(name1+ "은 " + name2+ "과 같지 않습니다.");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		String name3 = new String("강감찬");
		String name4 = new String("강감찬");

		if(name3 == name4) {   //name3 == name4은 name3과 name4의 메모리 주소 값을 비교한다.
			System.out.println(name3+ "은 " + name4+ "과 같습니다.");
		} else {
			System.out.println(name3+ "은 " + name4+ "과 같지 않습니다.");
		}
//***		
		if(name3.equals(name4)) {   //name3.equals(name4)은 name3과 name4의  값을 비교한다.
			System.out.println(name3+ "은 " + name4+ "과 같습니다.");
		} else {
			System.out.println(name3+ "은 " + name4+ "과 같지 않습니다.");
		}
		
	}

}
