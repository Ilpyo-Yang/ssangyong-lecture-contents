package my.day15.d.block;

public class MainBlock {

	public static void main(String[] args) {
		
		Child child1 = new Child();
		System.out.println("child1.name => "+child1.name);		
		System.out.println("Child.count => "+Child.count);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Child child2 = new Child();
		child2.name = "전지현";
		System.out.println("child2.name => "+child2.name);		
		System.out.println("Child.count => "+Child.count);
		
/*
 	*** Child 클래스의 'static 초기화 블럭' 호출됨. ***
	>> 부모 클래스인 Parent 클래스의 기본생성자 호출됨 <<
	### Child 클래스의 인스턴스 초기화 블럭 호출됨. ###
	>> 자식 클래스인 Child 클래스의 기본생성자 호출됨 <<
	child1.name => 한지민
	
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	>> 부모 클래스인 Parent 클래스의 기본생성자 호출됨 <<
	### Child 클래스의 인스턴스 초기화 블럭 호출됨. ###
	>> 자식 클래스인 Child 클래스의 기본생성자 호출됨 <<
 */
		

	}

}
