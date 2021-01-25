package my.day14.c.polymorphism;

public class Main {

	// >>> ������(Polymorphism) <<<
	// => ����� �̿��Ͽ� ���� Ŭ���� Ÿ���� �ϳ��� Ŭ���� Ÿ������ �ٷ�� ��� 
	// �ڽ�Ŭ������ ������ ��ü�� �θ� Ŭ���� Ÿ������ ���� �� �ִٴ� ���� ������
	
	public static void main(String[] args) {

		Animal[] aniArr = new Animal[5];
		
		Dog dog = new Dog();
	//	Animal ani1 = new Dog();	//����
	//	aniArr[0] = new Dog();		//����
		dog.setName("�ǻ�");
		dog.setBirthYear(2010);
		dog.setWeight(5);
		aniArr[0] = dog;
		
		Cat cat = new Cat();		//����
		cat.setName("��");
		cat.setBirthYear(2017);
		cat.setColor("����");
		aniArr[1] = cat;			//����
		
		Duck duck = new Duck();		//����
		duck.setName("������");
		duck.setBirthYear(2018);
		duck.setPrice(5000);
		aniArr[2] = duck;			//����
		
		for (int i=0; i<aniArr.length; i++) {
			if(aniArr[i]!=null)
				aniArr[i].showInfo();
		}
		
	}//end of main() ----------------------------

}
