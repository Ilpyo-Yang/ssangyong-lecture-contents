package my.day17.b.userDefineException;

public class Main {

	public static void main(String[] args) {

		Product[] prodArr = new Product[3];
		
		prodArr[0] = new Product();
		prodArr[0].setProdName("�����");
		prodArr[0].setJango(100);
		
		prodArr[1] = new Product();
		prodArr[1].setProdName("���ڱ�");
		prodArr[1].setJango(50);
		
		prodArr[2] = new Product();
		prodArr[2].setProdName("���ĸ�");
		prodArr[2].setJango(150);
		
		for(Product prod : prodArr) {
			try {
				prod.order(80); 	// 80�� �ֹ�
			} catch (JangolackException e) {
				//e.printStackTrace();
				System.out.println("�����޽��� : "+e.getMessage());
			} finally {
				prod.info();
			}
		}

		/*
			 my.day17.b.userDefineException.JangolackException: >> �ܰ��� �ֹ������� �����Ƿ� �ֹ��� �Ұ��մϴ�. <<
			 at my.day17.b.userDefineException.Product.order(Product.java:39)
			 at my.day17.b.userDefineException.Main.main(Main.java:23)
		 */
		
		System.out.println("\n====================================================\n");
		
		prodArr[0].setJango(100);
		prodArr[1].setJango(50);
		prodArr[2].setJango(150);
		
		for(Product prod : prodArr) {
			try {
				prod.jumun(80); 	// 80�� �ֹ�
			} catch (JangolackException e) {
				//e.printStackTrace();
				System.out.println("�����޽��� : "+e.getMessage());
			} finally {
				prod.info();
			}
		}
		
	}

}
