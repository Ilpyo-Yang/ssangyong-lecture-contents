package my.day16.b.multiInterface;

public class MainChild {

	public static void main(String[] args) {
		
		Child cd1 = new Child();
		cd1.work();
		cd1.cook();
		cd1.play();

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		InterFather infather = new Child();
		infather.work();
		//cook과 play가 없음 ==> 해당 인터페이스에만 있는 것으로 사용할 수 있다.
		
		InterMother inmother = new Child();
		inmother.cook();
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		InterChild inchild = new Child();
		inchild.work();
		inchild.cook();
		inchild.play();
	}
	

}
