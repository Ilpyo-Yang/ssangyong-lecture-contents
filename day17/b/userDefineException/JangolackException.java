package my.day17.b.userDefineException;

// == 사용자(개발자)가 정의하는 예외(익셉션)절 클래스 만들기 == //
/*
 	1. Exception 클래스를 상속받아야 한다.
 	2. 생성자에서 예외메시지(오류메시지)를 등록해주면 끝난다.
 */

public class JangolackException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// 기본생성자
	public JangolackException() {
		super(">> 잔고량이 주문량보다 적으므로 주문이 불가합니다. <<\n");
	}
	
	// 파라미터가 있는 생성자
	public JangolackException(String errMsg)  {
		super(errMsg);
	}
	
	
}
