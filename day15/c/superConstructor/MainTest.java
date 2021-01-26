package my.day15.c.superConstructor;

public class MainTest {

	public static void main(String[] args) {
		
		Child child = new Child();
		// 자식클래스의 기본생성자를 호출함.
		
		// 이것은 Child의 부모클래스인 Parent 클래스의 기본생성자가 먼저 호출되어지고 나서 
		// 그 다음에 자식클래스인 Child의 기본생성자가 호출되어진다.
		
		child.childInfo();
		
	}

}
