package my.day17.b.userDefineException;

public class Product {

	//field
	private String prodName;	//��ǰ��("�����","���ڱ�","���ĸ�")
	private int jango;			//�ܰ�  (  100,   50,    150  )
	
	
	//method
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getJango() {
		return jango;
	}
	public void setJango(int jango) {
		this.jango = jango;
	}	
	
	
	// ��ǰ�� ������ �����ִ� �޼��� ����
	public void info() {
		String info ="1. ��ǰ�� : "+prodName+"\n"
				   + "2. �ܰ� : "+jango+"��\n";
				   
		System.out.println(info);
	}
	
	// �ֹ��� �޴� �޼��� ����1
	public void order(int jumunSu) throws JangolackException {
		// order(int jumunSu) �� �Ķ���ͷ� ������ jumunSu �� ���� ����
		// �����(������)�� ���� JangolackException �ͼ����� ������ �� �ִٴ� ���̴�.
		if(jango<jumunSu) {
			// �ܰ��� �ֹ������� ������ �� JangolackException �ͼ����� ���߽��Ѿ� �Ѵ�.
			throw new JangolackException();
		}
		else {
			jango -= jumunSu;
			System.out.println(prodName+" ��ǰ�� "+jumunSu+"���� �ֹ��ϼ̽��ϴ�.");

		}
	}
	
	// �ֹ��� �޴� �޼��� ����2
		public void jumun(int jumunSu) throws JangolackException {
			// order(int jumunSu) �� �Ķ���ͷ� ������ jumunSu �� ���� ����
			// �����(������)�� ���� JangolackException �ͼ����� ������ �� �ִٴ� ���̴�.
			if(jango<jumunSu) {
				// �ܰ��� �ֹ������� ������ �� JangolackException �ͼ����� ���߽��Ѿ� �Ѵ�.
				throw new JangolackException(">> "+prodName+"�� �ܰ� "+jango+"�� �ε� �ֹ����� "+jumunSu+"���� �ܰ� �������� �ֹ��� �Ұ��մϴ�." );
			}
			else {
				jango -= jumunSu;
				System.out.println(prodName+" ��ǰ�� "+jumunSu+"���� �ֹ��ϼ̽��ϴ�.");

			}
		}
}
