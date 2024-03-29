package my.day14.c.polymorphism;

public class Main {

	// >>> 다형성(Polymorphism) <<<
	// => 상속을 이용하여 여러 클래스 타입을 하나의 클래스 타입으로 다루는 기술 
	// 자식클래스로 생성된 객체를 부모 클래스 타입으로 받을 수 있다는 것이 다형성
	
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
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null)
				aniArr[i].showInfo();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null)
				aniArr[i].cry();
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null) {
				if(aniArr[i] instanceof Dog) {
					// aniArr[i]에 들어있는 instance(객체)가 Dog라는 클래스로 만든 instance(객체)입니까?
					((Dog) aniArr[i]).run();
				}
				if(aniArr[i] instanceof Cat) {
					// aniArr[i]에 들어있는 instance(객체)가 Cat라는 클래스로 만든 instance(객체)입니까?
					((Cat) aniArr[i]).jump();
				}
				if(aniArr[i] instanceof Duck) {
					// aniArr[i]에 들어있는 instance(객체)가 Duck라는 클래스로 만든 instance(객체)입니까?
					((Duck) aniArr[i]).swim();
				}
			}
		}
		
	}//end of main() ----------------------------

}
