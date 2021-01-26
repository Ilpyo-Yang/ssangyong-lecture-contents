package my.day15.a.abstractClass;

public class Main {

	// == 미완성 클래스 == //
	// 미완성 클래스는 스스로 객체생성(인스턴스화)은 불가하지만 
	// 일반적인 자식클래스로 생성된 객체를 저장하는 용도로는 사용이 가능하다!!!
	
	public static void main(String[] args) {

		Animal[] aniArr = new Animal[5];
		
		Dog dog = new Dog();
	//	Animal ani1 = new Dog();	//가능
	//	aniArr[0] = new Dog();		//가능
		dog.setName("뽀삐");
		dog.setBirthYear(2010);
		dog.setWeight(5);
		aniArr[0] = dog;
		
		Cat cat = new Cat();		//가능
		cat.setName("톰");
		cat.setBirthYear(2017);
		cat.setColor("검정");
		aniArr[1] = cat;			//가능
		
		Duck duck = new Duck();		//가능
		duck.setName("도날드");
		duck.setBirthYear(2018);
		duck.setPrice(5000);
		aniArr[2] = duck;			//가능

	/*	
		Animal ani = new Animal();  
		// Animal 은 미완성 클래스(== 추상클래스, abstract class)이므로
		// Animal 을 사용하여 객체(인스턴스)를 생성할 수 없다!!!
		ani.cry();
	*/
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null)
				aniArr[i].showInfo();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null)
				aniArr[i].cry();
		}
		
		
	}//end of main() ----------------------------

}
