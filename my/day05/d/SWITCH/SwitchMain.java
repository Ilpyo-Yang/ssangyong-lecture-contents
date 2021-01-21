package my.day05.d.SWITCH;

import java.util.Scanner;

public class SwitchMain {

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
			
            //== switch �� == //
			switch (operator) { 
			case "+":  //operator�� ���� "+"�� ���ٶ��
				result = String.valueOf(num1 + num2);
				break; //switch���� ����������
				
			case "-":  //operator�� ���� "-"�� ���ٶ��
				result = String.valueOf(num1 - num2);
				break;
				
			case "*":  //operator�� ���� "*"�� ���ٶ��
				result = String.valueOf(num1 * num2);
				break;	
				
			case "/":  //operator�� ���� "/"�� ���ٶ��
				if(num2 == 0) 
					result = ">>> �и𿡴� 0 �� �� �� �����ϴ�! <<<";
				else
					result = String.valueOf((double)num1 / num2);
				break;

			default:  //operator�� ���� ��Ģ���� ��ȣ�� �ƴ϶��
				System.out.println(">> ��Ģ����(+ - * /)�� �����ϼ���. <<"); 
				sc.close();
				break;
				//if���� �޸� {}�� ����
			} //end of switch -----------------------------------------------------------------
					
			//***���׿�����
			result = ("/".equals(operator) && num2==0)? result : num1+"+"+num2+"="+result;
			
			System.out.println(result);
			
		} catch (NumberFormatException e) {	
			
			System.out.println(">>> ������ �Է����ּ���! <<<");
			e.getStackTrace();
						
		}

		sc.close();

	}//end of main

}
