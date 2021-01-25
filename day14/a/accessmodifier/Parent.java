package my.day14.a.accessmodifier;

public class Parent {
	
	/*
	   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스        그외의영역  
	   ----------------------------------------------------------------------------------------------------------------------- 
	   public                                    O                    O                         O                 O  
	   protected                                 O                    O                         O                 X
	   default                                   O                    O                         X                 X
	   private                                   O                    X                         X                 X
	 */	
	
	public String id;			// public		동그라미(초록색)
	protected String passwd;	// protected    마름모(노란색)
	String name;				// default		삼각형(파란색)
	private String jubun;		// private		사각형(빨간색)

}
