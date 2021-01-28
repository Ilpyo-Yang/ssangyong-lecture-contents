package my.day17.b.userDefineException;

public class Main {

	public static void main(String[] args) {

		Product[] prodArr = new Product[3];
		
		prodArr[0] = new Product();
		prodArr[0].setProdName("새우깡");
		prodArr[0].setJango(100);
		
		prodArr[1] = new Product();
		prodArr[1].setProdName("감자깡");
		prodArr[1].setJango(50);
		
		prodArr[2] = new Product();
		prodArr[2].setProdName("양파링");
		prodArr[2].setJango(150);
		
		for(Product prod : prodArr) {
			try {
				prod.order(80); 	// 80개 주문
			} catch (JangolackException e) {
				//e.printStackTrace();
				System.out.println("오류메시지 : "+e.getMessage());
			} finally {
				prod.info();
			}
		}

		/*
			 my.day17.b.userDefineException.JangolackException: >> 잔고량이 주문량보다 적으므로 주문이 불가합니다. <<
			 at my.day17.b.userDefineException.Product.order(Product.java:39)
			 at my.day17.b.userDefineException.Main.main(Main.java:23)
		 */
		
		System.out.println("\n====================================================\n");
		
		prodArr[0].setJango(100);
		prodArr[1].setJango(50);
		prodArr[2].setJango(150);
		
		for(Product prod : prodArr) {
			try {
				prod.jumun(80); 	// 80개 주문
			} catch (JangolackException e) {
				//e.printStackTrace();
				System.out.println("오류메시지 : "+e.getMessage());
			} finally {
				prod.info();
			}
		}
		
	}

}
