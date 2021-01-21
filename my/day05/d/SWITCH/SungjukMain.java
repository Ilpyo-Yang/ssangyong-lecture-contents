package my.day05.d.SWITCH;

public class SungjukMain {

	public static void main(String[] args) {
		
		Sungjuk sj = new Sungjuk();
		sj.hakbun = "091234";
		sj.name = "이순신";
		sj.kor = 0;
		sj.eng = 0;
		sj.math = 88;
		
		System.out.println("총점 : "+sj.total());
		System.out.println("평균 : "+sj.avg());      //반올림
		System.out.println("학점 : "+sj.grade());
		System.out.println("상품 : "+sj.gift());		
		// 학점이 "A"이라면 "놀이공원이용권, 치킨, 피자, 아이스크림"
		// 학점이 "B"이라면 "치킨, 피자, 아이스크림"
		// 학점이 "C"이라면 "피자, 아이스크림"
		// 학점이 "D"이라면 "아이스크림"
		// 학점이 "F"이라면 "꿀밤3대"
	}

}
