package my.day14.a.accessmodifier;

public class Parent {
	
	/*
	   ����������(����������, accessmodifier)   �ڱ��ڽ�Ŭ��������      ������Ű�����ִ´ٸ�Ŭ����      �ٸ���Ű�����ִ�����(�ڽ�)Ŭ����        �׿��ǿ���  
	   ----------------------------------------------------------------------------------------------------------------------- 
	   public                                    O                    O                         O                 O  
	   protected                                 O                    O                         O                 X
	   default                                   O                    O                         X                 X
	   private                                   O                    X                         X                 X
	 */	
	
	public String id;			// public		���׶��(�ʷϻ�)
	protected String passwd;	// protected    ������(�����)
	String name;				// default		�ﰢ��(�Ķ���)
	private String jubun;		// private		�簢��(������)

}
