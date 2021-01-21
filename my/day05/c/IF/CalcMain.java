package my.day05.c.IF;

import java.util.Scanner;

public class CalcMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("ù��° ���� �Է� => ");
			int num1 = Integer.parseInt(sc.nextLine());
			
			
			System.out.print("�ι�° ���� �Է� => ");
			int num2 = Integer.parseInt(sc.nextLine());
			System.out.print("��Ģ������ ���� (+ - * /) => ");
			String operator = sc.nextLine();
			
			String result = "";
			
			if("+".equals(operator)) {
				result = String.valueOf(num1 + num2);
			} else if ("-".equals(operator)) {
				result = String.valueOf(num1 - num2);
			} else if ("*".equals(operator)) {
				result = String.valueOf(num1 * num2);
			} else if ("/".equals(operator)) {
				if(num2 == 0) 
					result = ">>> �и𿡴� 0 �� �� �� �����ϴ�! <<<";
				else
					result = String.valueOf((double)num1 / num2);
			} else {
				System.out.println(">> ��Ģ����(+ - * /)�� �����ϼ���. <<"); 
				sc.close();
				return;
			}
					
			//***���׿�����
			result = ("/".equals(operator) && num2==0)? result : num1+"+"+num2+"="+result;
			
			System.out.println(result);
			
		} catch (NumberFormatException e) {	
			
			System.out.println(">>> ������ �Է����ּ���! <<<");
			e.getStackTrace();
						
		}

		sc.close();
	}
	
		
}
