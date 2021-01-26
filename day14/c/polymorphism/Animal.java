package my.day14.c.polymorphism;

/*
	����������(����������, accessmodifier)   �ڱ��ڽ�Ŭ��������      ������Ű�����ִ´ٸ�Ŭ����      �ٸ���Ű�����ִ�����(�ڽ�)Ŭ����        �׿��ǿ���  
	----------------------------------------------------------------------------------------------------------------------- 
	public                                    O                    O                         O                 O  
	protected                                 O                    O                         O                 X
	default                                   O                    O                         X                 X
	private                                   O                    X                         X                 X
*/	

public class Animal {
	
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
	
	public void cry() {
		System.out.println(">>> �������� �Ҹ��� ���ϴ�. <<<");
	}
		
}
