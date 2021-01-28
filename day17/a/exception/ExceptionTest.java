package my.day17.a.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		
		System.out.println("\n1. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//1. ArrayIndexOutOfBoundsException
		//=> �迭�� ũ�Ⱑ �����Ǿ����� �߻��ϴ� �ͼ���
		
		String[] subjectArr = {"�ڹ�","����Ŭ","JSP"};
		
		try {
			for (int i=0; i<=subjectArr.length; i++) {
				System.out.println(subjectArr[i]);
			}	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(">> �迭�� �ε��� ������ �ʰ��Ǿ����ϴ�. <<\n");
			//System.out.println("e.getMessage()");
			//e.getMessage()�� �����޽����� �˷��ִ� ���̴�.
			
			//��� �������� �����ؼ� �˷��ش�.
			//e.printStackTrace();
		}
		
		System.out.println("\n2. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		//2. ArithmeticException
		//=> �и� 0�� ���� ��쿡 �߻��ϴ� �ͼ���
		
		int num = 10;
		
		try {
			for (int i=2; i>=0; i--) {
				System.out.println(num/i);
			}
		} catch (ArithmeticException e) {
			System.out.println(">> �и𿡴� 0 �� �� �� �����ϴ�. <<\n");
			
			//e.printStackTrace();
		}
		
		System.out.println("\n3. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		//3. ArithmeticException
		//=> �и� 0�� ���� ��쿡 �߻��ϴ� �ͼ���
		
		int[] numArr = {10,20,30};
		
		try {
			for (int i=3; i>=0; i--) {
				int val = numArr[i]/i;	// num[3]/3 =>  ArrayIndexOutOfBoundsException
				System.out.println(val);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(">> �迭�� �ε��� ������ �ʰ��Ǿ����ϴ�. <<\n");
		}
		
		System.out.println("\n4. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=3; i>=0; i--) {
			try {
				int val = numArr[i]/i;	// num[3]/3 =>  ArrayIndexOutOfBoundsException
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(">> �迭�� �ε��� ������ �ʰ��Ǿ����ϴ�. <<");
			} catch (ArithmeticException e) {
				System.out.println(">> �и𿡴� 0 �� �� �� �����ϴ�. <<\n");
			}		
		}
		
		System.out.println("\n5. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=3; i>=0; i--) {
			try {
				int val = numArr[i]/i;	
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�����޽��� : "+e.getMessage());
			} catch (ArithmeticException e) {
				System.out.println("�����޽��� : "+e.getMessage());
			}		
		}
		
		System.out.println("\n6. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=3; i>=0; i--) {
			try {
				int val = numArr[i]/i;	
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				System.out.println("�����޽��� : "+e.getMessage());
			}		
		}
		
		System.out.println("\n7. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for (int i=3; i>=0; i--) {
			try {
				int val = numArr[i]/i;	
				System.out.println(val);
			} catch (Exception e) {
				System.out.println("�����޽��� : "+e.getMessage());
			}		
		}
		
		System.out.println("\n8. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		String[] strArr = {"10","����","30"};
		
		for (int i=3; i>=0; i--) {
			try {
				int val = Integer.parseInt(strArr[i])/i;	
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� �ε��� ��ȣ "+e.getMessage()+"�� �������� �ʽ��ϴ�.");
			} catch (ArithmeticException e) {
				System.out.println("�и� 0�� ���� �� �����ϴ�.");
			} catch (Exception e) {
				System.out.println("�����޽��� : "+e.getMessage());
			}				
		}

	/*
		for (int i=3; i>=0; i--) {
			try {
				int val = Integer.parseInt(strArr[i])/i;	
				System.out.println(val);
			} catch (Exception e) {
				System.out.println("�����޽��� : "+e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� �ε��� ��ȣ "+e.getMessage()+"�� �������� �ʽ��ϴ�.");
			} catch (ArithmeticException e) {
				System.out.println("�и� 0�� ���� �� �����ϴ�.");
			} 		
		}
		
		�ͼ��� ó���� �θ� Ŭ������ �ͼ����� �� �Ʒ��� ���;� �Ѵ�.
		�ֳ��ϸ� �ͼ��� ó���� ������ ó���Ǹ鼭 ���� ���� ó���� �ȵǸ�
		�Ʒ��� ��������� ���ε� �θ� Ŭ������ �ͼ����� ���� ������
		�ڽ� Ŭ������ �ͼ����� �Ʒ��� ������ �θ� Ŭ���� �ͼ��� ó���� ���� ����
		�ڽ� Ŭ���� �ͼ����� ó���� �ض�� ���� ����̱� �����̴�.
	*/
		
		System.out.println("\n9. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		String[] strArr2 = {"10","20","30","40"};
		
		int cnt = 0;
		
		for (int i=3; i>=0; i--) {
			try {
				int val = Integer.parseInt(strArr2[i])/(i+1);	
				System.out.println(val);
			} finally {
				// finally �� ������ �߻��ϴ��� �Ǵ� ������ �߻����� �ʵ��� ������� ������ �����ؾ� �ϴ� �͵���
				// finally �κп� ������ָ� �ȴ�.
				System.out.println(++cnt+". ~~~ ������ �߻��ϵ� ���ϵ� ������ �����մϴ�! ~~~\n");
			}				
		}
		
		System.out.println("\n10. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		String[] strArr3 = {"10","����","30"};
		
		cnt = 0;
		
		for (int i=3; i>=0; i--) {
			try {
				int val = Integer.parseInt(strArr3[i])/(i+1);	
				System.out.println(val);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭�� �ε��� ��ȣ "+e.getMessage()+"�� �������� �ʽ��ϴ�.");
			} catch (ArithmeticException e) {
				System.out.println("�и� 0�� ���� �� �����ϴ�.");
			} catch (Exception e) {
				System.out.println("�����޽��� : "+e.getMessage());
			} finally {
				// finally �� ������ �߻��ϴ��� �Ǵ� ������ �߻����� �ʵ��� ������� ������ �����ؾ� �ϴ� �͵���
				// finally �κп� ������ָ� �ȴ�.
				System.out.println(++cnt+". ~~~ ������ �߻��ϵ� ���ϵ� ������ �����մϴ�! ~~~\n");
			}				
		}
		
	}

}
