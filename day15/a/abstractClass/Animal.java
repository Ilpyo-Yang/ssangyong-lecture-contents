package my.day15.a.abstractClass;	

// abstract public class Animal {
// �Ǵ�
public abstract class Animal {	// �̿ϼ� Ŭ���� (== �߻�Ŭ����, abstract Ŭ����)
	
/*
	 �̿ϼ� �޼���(== �߻�޼���, abstract method)�� �ִ� Ŭ������
	 �ݵ�� �̿ϼ� Ŭ����(== �߻�Ŭ����, abstract class)�� ������ �Ѵ�.
	 �� �̿ϼ� �޼��带 ������?
	 �ֳ��ϸ� �ڽ�Ŭ�������� �޼��带 �������̵�(=������)�� �ϱ� ������ 
	 �θ�Ŭ���������� �޼��带 ������ �ʿ䰡 �����Ƿ� �̿ϼ� �޼���(== �߻�޼���, abstract method)�� ����� ������.
	 
	 �Ϲ������� �θ�Ŭ������ �̿ϼ�Ŭ����(== �߻�Ŭ����, abstract class)�� �����.
 */
	
	// �̿ϼ� Ŭ����(== �߻�Ŭ����, abstract class)�� ����Ͽ� ��ü(�ν��Ͻ�)�� ������ �� ����!!!
	
	// Dog, Cat, Duck �� ���� field (�߻�ȭ)
	private String name;
	private int birthYear;
	
	
	// Dog, Cat, Duck �� ���� method(���)
	//package == default
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		if(name!=null && !name.trim().isEmpty())
			this.name = name;
	}
	protected int getBirthYear() {
		return birthYear;
	}
	protected void setBirthYear(int birthYear) {
		if(birthYear>0)
			this.birthYear = birthYear;
	}
	
	// === ������(������, �����, ����)�� ������ ������ִ� �޼��� ===
	public void showInfo() {
		System.out.println("== �������� ==\n"
				+ "1. ���� : "+name+"\n"
				+ "2. ���� : "+birthYear+"��\n");
	}
	
	// abstract public void cry();
	// �Ǵ�
	protected abstract void cry();   // �̿ϼ� �޼���
	// �̿ϼ� �޼���(= �߻�޼���, abstract method)�� �ڽ�Ŭ�������� ������ ������(�������̵�)�� �� ���־�߸� �ȴ�!!!
		
}
