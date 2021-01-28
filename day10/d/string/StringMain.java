package my.day10.d.string;

import java.text.DecimalFormat;

import my.util.MyUtil;

public class StringMain {

	public static void main(String[] args) {

// === 1. "���ڿ�".charAt(int index) ===
		// "�ȳ��ϼ���".charAt(2) ==> '��'
		// index => 01234
		
		char ch = "�ȳ��ϼ���".charAt(2);
		System.out.println("ch => "+ch);
		// ch => ��

		String str = "�ȳ��ϼ���";
		// index =>   01234
		String result = "";
		
		for (int i=str.length()-1; i>=0; i--) {
			result += str.charAt(i);
		}
		System.out.println(result);
		//�似�ϳ��
		
		
// === 2. "���ڿ�".tocCharArray(int index) ===		
		// "�ȳ��ϼ���".tocCharArray() ==> char Ÿ���� �迭�� ������ش�
		//-----------------------
		//|'��'|'��'|'��'|'��'|'��'|
		//-----------------------
		
		char[] chArr = "�ȳ��ϼ���".toCharArray();
		result = "";
		
		for (int i=chArr.length-1; i>=0; i--) {
			result+=chArr[i];
		}
		System.out.println(result);
		//�似�ϳ��
		
		
// === 3. "���ڿ�".substring(int �����ε���, int ���ε���) ===		
		// "�ȳ��ϼ���".substring(1,4) ==> 1�� �ε����� "��"���� 4�� �ε��� �ձ����� "��"���� �Ϻ� �����͸� �������ش�
		
		str = "�ȳ��ϼ���".substring(1,4);
		System.out.println(str);    //���ϼ�
		
		int len = "�ȳ��ϼ���".length();  //5
		str = "�ȳ��ϼ���".substring(2,len);
		System.out.println(str);    //�ϼ���
		
		
// === 4. "���ڿ�".substring(int �����ε���) ===		
		// "�ȳ��ϼ���".substring(2) ==> 2�� �ε����� "��"���� ������ �̾ƿ´�.
		
		str = "�ȳ��ϼ���".substring(2);
		System.out.println(str);    //�ϼ���

		
// === 5. "���ڿ�".indexOf("ã�����ڿ�") ===		
		// "���ڿ�"���� ���ʷ� ������ "ã�����ڿ�"�� �ε�����(int)�� �˷��ش�.
		int index = "�����϶� �ȳ��ϼ��� �ǰ��ϼ���".indexOf("��");
		System.out.println(index); //2
		
		index = "�����϶� �ȳ��ϼ��� �ǰ��ϼ���".indexOf("�ϼ���");
		System.out.println(index); //7
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
//==== [����] ==== //
		String [] pathFileNameArr = {"C:/mydocument/resume/�����̷¼�.hwp",   //�ڹٴ�  \ �ν��� ���Ѵ�.
								  "D:/mymusic.mp3",
								  "C:/photo/����.jpg"};  
		for(int i=0; i<pathFileNameArr.length; i++) {
			System.out.println(pathFileNameArr[i]);
		}
		/*
		    C:/mydocument/resume/�����̷¼�.hwp
			D:/mymusic.mp3
			C:/photo/����.jpg

		 */
		
		/*
		       �����̷¼�.hwp
			mymusic.mp3
			����.jpg
	
		 */
		
//������ ��		
		System.out.println("\n=== ���ϸ� �̾ƿ� ����� ===");
	      //���ٷ� �о��
	      for(int i=0; i<pathFileNameArr.length; i++) {
	         String pathFileName = pathFileNameArr[i];   //***String[] => String => char[]
	         char[] chrArr = pathFileName.toCharArray();
	         
	         String strReverse = "";
	         for(int j=chrArr.length-1; j>=0; j--) {
	            strReverse += chrArr[j];     //���ٷ� �������� �ױ�
	         }
	         
	      //   System.out.println(strReverse);
	         
	         int idxSlash = strReverse.indexOf("/");
	         
	         strReverse = strReverse.substring(0, idxSlash);
	         //���ʷ� /�� ������ �ε��� ��
	      //   System.out.println(strReverse);
	         
	         chrArr = strReverse.toCharArray();
	         
	         String fileName = "";
	         for(int j=chrArr.length-1; j>=0; j--) {
	            fileName += chrArr[j]; 
	         }
	         
	         System.out.println(fileName);
	      }
	      
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		      
		
// === 6. "���ڿ�".lastIndexOf("ã�����ڿ�") ===		
		// "���ڿ�"���� ���������� ������ "ã�����ڿ�"�� �ε�����(int)�� �˷��ش�.
		index = "�����϶� �ȳ��ϼ��� �ǰ��ϼ���".lastIndexOf("��");
		System.out.println(index); //13
		
		index = "�����϶� �ȳ��ϼ��� �ǰ��ϼ���".lastIndexOf("�ϼ���");
		System.out.println(index); //13
		
//���� ����		
		System.out.println("\n=== ���ϸ� �̾ƿ� ����� ===");
	
		for (int i=0; i<pathFileNameArr.length; i++) {
			for (int j=0; j<pathFileNameArr[i].length(); j++) {
				if(j==pathFileNameArr[i].lastIndexOf("/")) {
					System.out.print(pathFileNameArr[i].substring(j+1));
				}
			}
			System.out.print("\n");		
		}
		
//������ ����		
		System.out.println("\n=== ���ϸ� �̾ƿ� ����� ===");
	
		for (int i=0; i<pathFileNameArr.length; i++) {
			int idx = pathFileNameArr[i].lastIndexOf("/");
			System.out.println(pathFileNameArr[i].substring(idx+1));
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
//==== [����] ==== //
		//String money1 = "1,000,000";  //�ĸ��� �� ���� int�� �ٲ۴����� ���ϱ�
		//String money2 = "5,000";
		//1000000 + 5000;
		//1005000
		
//������ ����			
		String money = "2,000,000";
		int commaIndex = money.indexOf(",");
		System.out.println(commaIndex);   //1

		System.out.println(money.substring(0,commaIndex));  //2
		System.out.println(money.substring(commaIndex+1));  //000,000
		
		money = money.substring(0,commaIndex)+money.substring(commaIndex+1);
		// "2"+"000,000"
		System.out.println(money);  //2000,000

		commaIndex = money.indexOf(",");  //4
		
		System.out.println(money.substring(0,commaIndex));  //2000
		System.out.println(money.substring(commaIndex+1));  //000
		
		money = money.substring(0,commaIndex)+money.substring(commaIndex+1);
		// "2000"+"000"
		System.out.println(money);  //2000000
		
		commaIndex = money.indexOf(",");  //-1
		System.out.println("commaIndex");
		
		
//������ ����	
		//MyUtilŬ������ delComma �޼��� ���� ����ϱ�
		int sum = MyUtil.delComma("1,000,000")+MyUtil.delComma("5,000");   
		System.out.println(sum);   //1005000
		
		DecimalFormat df = new DecimalFormat("#,###");    //���ڿ� ���·� ����
		System.out.println(df.format(sum));  //1,005,000
	
// === 7. "���ڿ�".split("������") ===
		//"���ڿ�"�� "������"�� �߶� String Ÿ���� �迭�� �����ִ� ���̴�.
		System.out.println("\n 1. ======================\n");
		
		String food = "�Ľ�Ÿ,����,������,����,�������";
		String[] foodArr = food.split(",");
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */		
		System.out.println("\n 2. ======================\n");
		
		food = "�Ľ�Ÿ	����	������	����	�������";
		foodArr = food.split("\t");
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */	
		System.out.println("\n 3. ======= split ���� �����ڷ� .| / �� Ư�����ڸ� ����Ϸ��� �ϴ� ��� =======\n");
		
		food = "�Ľ�Ÿ.����.������.����.�������";
		//{"�Ľ�Ÿ","����","������","����","�������"}
		foodArr = food.split(".");       
		System.out.println(foodArr.length);  
		// ==> 0 �� ����. �� . �ܵ������δ� �����ڷ� �ν��� ����.
       // split ���� �����ڷ� . | / �� Ư�����ڸ� ����Ϸ��� �� ��쿡�� �����ڷ� �ν��� ���� ��찡 �����Ƿ�
       //*** ������ �տ� \\ �� ���̰ų� �����ڸ� [] �� �����ָ� �ȴ�. ��, [������] �̷��� ���̴�.
		
		foodArr = food.split("[.]");   
		System.out.println(foodArr.length); //5
		foodArr = food.split("\\.");  
		System.out.println(foodArr.length); //5
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */
		System.out.println("\n 4. ======================\n");
		
		food = "�Ľ�Ÿ|����|������|����|�������";
		foodArr = food.split("[|]");
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */		
		System.out.println("\n 5. ======================\n");
		
		food = "�Ľ�Ÿ,����,������,����,�������";
		foodArr = food.split("[,]");
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */		
		
		System.out.println("\n 6. ======================\n");
		
		food = "�Ľ�Ÿ,����.������	����,�������";   
		//�����ڰ� ���� �� �� ��, | ���� ������ �Է� ����, []�� ��� �Է°���
		foodArr = food.split("[,.\t]");
		foodArr = food.split("\\,|\\t|\\.");
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */		
		System.out.println("\n 7. ======================\n");
		
		food = "�Ľ�Ÿ1����2������3����4�������";   
		foodArr = food.split("\\d");    
		// \\d���� d�� ����ǥ������ �ϳ��ν� ���ڸ� �ǹ��Ѵ�.
		// ��, ���ڰ� �����ڰ� �Ǵ� ���̴�.
		//{"�Ľ�Ÿ","����","������","����","�������"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        �Ľ�Ÿ
			����
			������
			����
			�������
		 */		

		System.out.println("\n 8. ======================\n");
		
		food = "�Ľ�Ÿ1����2������3����4�������";   
		foodArr = food.split("\\D");    
		// \\D���� D�� ����ǥ������ �ϳ��ν� ���ڰ� �ƴ� ���� �ǹ��Ѵ�.
		// ��, ���ڰ� �����ڰ� �Ǵ� ���̴�.
		//{"1","2","3","4"}
		
		for (int j=0; j<foodArr.length; j++) {
			System.out.println(foodArr[j]);
		}
		/*
		        1
		        2
		        3
		        4
		 */		
		
		//=== ����: \ �� escape ���ڶ�� �θ���.
		System.out.println("���� �̸��� \"�̼���\"�Դϴ�.");
		//���� �̸��� "�̼���"�Դϴ�.
		System.out.println("���� �̸��� '����ȭ'�Դϴ�.");
		//���� �̸��� '����ȭ'�Դϴ�.
		System.out.println("C:\\movie\\koremovie\\���̷ο�ҹ�.mp4");
		//C:\movie\koremovie\���̷ο�ҹ�.mp4

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		
		
// === 8. String.join("������", ���ڿ��迭��) ===
		//���ڿ��迭�� "������"�� ���ļ� String Ÿ������ �����ִ� ���̴�.		
		String[] nameArr = {"�Ѽ���","�μ���","������","�׼���","������"};
		String names = String.join("-",nameArr);
		System.out.println(names);
		// �Ѽ���-�μ���-������-�׼���-������
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		
		
// === 9. "���ڿ�".replaceAll("�������ڿ�", "�����̺���ɹ��ڿ�") ===
		//"���ڿ�"���� "�������ڿ�"�� ���"�����̺���ɹ��ڿ�"�� ��ü�ؼ� ��ȯ���ִ� ���̴�.		
		names = names.replaceAll("����", "SK");
		System.out.println(names);
		// ��SK-��SK-��SK-��SK-��SK
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 10. "���ڿ�".replaceFirst("�������ڿ�", "�����̺���ɹ��ڿ�") ===
		//"���ڿ�"���� "�������ڿ�"�� ù��°�� "�����̺���ɹ��ڿ�"�� ��ü�ؼ� ��ȯ���ִ� ���̴�.		
		names = names.replaceFirst("SK", "���� ");
		System.out.println(names);
		// �Ѽ���-��SK-��SK-��SK-��SK
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
		// === ���� === //
		// replaceFirst�� ����Ͽ� ù��°, �ι�°, ����° "SK"�� "����" ��ȯ�ϼ���.
		names = "��SK-��SK-��SK-��SK-��SK";
		
		for (int i=0; i<3; i++) {
			names = names.replaceFirst("SK", "���� ");
		}
		
		System.out.println(names);
		//�Ѽ���-�μ���-������-��SK-��SK
//������ ��
		names = "��SK-��SK-��SK-��SK-��SK";
	      
		String[] namesArr = names.split("SK");
		      
		for(int i=0; i<namesArr.length; i++) {
		    if(i==1 || i==2) {
		        namesArr[i] += "����";
		    }
		    
		    else {
		   namesArr[i] += "SK";
		    }
		} // end of for-----------------------
		      
		names = String.join("", namesArr);
		      
		System.out.println(names);
		// "��SK-�μ���-������-��SK-��SK"
//�ٸ� ��� ��
		names = "��SK-��SK-��SK-��SK-��SK";
	    String [] nameRArr = names.split("\\-");
	       
	    for(int i=1; i<3; i++) {
	        nameRArr[i] = nameRArr[i].replace("SK", "����");
	    }
	      
	    String renames = String.join("-", nameRArr);
	    System.out.println(renames);
	      
//���� ��		
		names = "��SK-��SK-��SK-��SK-��SK";
		names = names.replace("��SK-��SK",  "�μ���-������");
		System.out.println(names);
		//��SK-�μ���-������-��SK-��SK
		
		System.out.println("\n === ���� === \n");	
		String[] contents = {"ȣȣ�ȳ��ϼ���","�ǰ��ϼ���","�ູ�ϼ��� �Ǻ���","��̰� �ǰ��� �Ϸ�Ǽ���"}; 

// [Quiz1] "�ǰ�" �̶�� �ܾ ���ԵȰ��� ����ϼ���.
		//���� ��
		for (int i=0; i<contents.length; i++) {
			if(contents[i].contains("�ǰ�")) {
				System.out.println(contents[i]);
			}
		}
		//������ ��
		for(int i=0; i<contents.length; i++) {
	          int idx = contents[i].indexOf("�ǰ�");
	          if(idx != -1)
	             System.out.println(contents[i]);
	       }
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	

// [Quiz2] "�ǰ�" �̶�� �ܾ�� �����ϴ� �͸� ����ϼ���.	

		for (int i=0; i<contents.length; i++) {
			if(contents[i].indexOf("�ǰ�")==0) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
			
		// �Ǵ� �Ʒ��� ���� �Ҽ��� �ֽ��ϴ�.
// === 11. "���ڿ�".startsWith("ã�����ϴ¹��ڿ�")  ===
	    //       "���ڿ�" ���� "ã�����ϴ¹��ڿ�"�� ��ù��°�� ������ true �� ��ȯ.
	    //      "���ڿ�" ���� "ã�����ϴ¹��ڿ�"�� ��ù��°�� ������ ������ false �� ��ȯ.
	     
		// "�ǰ�" �̶�� �ܾ�� �����ϴ� �͸� ����ϼ���.		
		for (int i=0; i<contents.length; i++) {
			if(contents[i].startsWith("�ǰ�")) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 12. "���ڿ�".endsWith("ã�����ϴ¹��ڿ�")  ===
	    //       "���ڿ�" ���� "ã�����ϴ¹��ڿ�"�� �� �������� ������ true �� ��ȯ.
	    //      "���ڿ�" ���� "ã�����ϴ¹��ڿ�"�� �� �������� ������ ������ false �� ��ȯ.
	     
		// "�ϼ���" ��� �ܾ�� ������ �͸� ����ϼ���.		
		for (int i=0; i<contents.length; i++) {
			if(contents[i].endsWith("�ϼ���")) {
				System.out.println(contents[i]);
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 13. "���ڿ�".trim()  ===
	    //       "���ڿ�".trim() �� "���ڿ�"�� ��,�쿡 ������ ������ ������ �����Ѵ�.
	     
		String insa = "     ����    �����˽��ϴ�   ";	
		System.out.println("������"+insa+"���� �ɰԿ�~~");
		System.out.println("������"+insa.trim()+"���� �ɰԿ�~~");
		//������     ����    �����˽��ϴ�   ���� �ɰԿ�~~
		//�����ϼ���    �����˽��ϴٳ��� �ɰԿ�~~
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 14. "���ڿ�".isEmpty()  ===
	    //       "���ڿ�"�� �ƹ��͵� ������ true�� ��ȯ���ְ�,
		//       "���ڿ�"�� ���� ������ false�� ��ȯ���ش�.
	    String str1="", str2="abc", str3="      ";	
		System.out.println(str1.isEmpty());   //true
		System.out.println(str2.isEmpty());   //false
		System.out.println(str3.isEmpty());   //false
		System.out.println(str3.trim().isEmpty());   //true

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
	
// === 15. "���ڿ�".toUpperCase()  ===
	    //       "���ڿ�"���� �ҹ��ڰ� ������ ��� �빮�ڷ� ��ȯ���ش�.
	    String words="My Name is Tom �Դϴ�.";	
		System.out.println(words.toUpperCase());   
		//MY NAME IS TOM �Դϴ�.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		
// === 16. "���ڿ�".toLowerCase()  ===
			    //       "���ڿ�"���� �ҹ��ڰ� ������ ��� �빮�ڷ� ��ȯ���ش�.
			    words="My Name is Tom �Դϴ�.";	
				System.out.println(words.toLowerCase());   
				//my name is tom �Դϴ�.
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
				
// === 17. "���ڿ�".equals("�񱳴���ڿ�")  ===
				//        �빮�ڿ� �ҹ��ڸ� �����ϸ鼭
			    //       "���ڿ�"�� "�񱳴���ڿ�"�� ���� ��ġ�ϸ� true�� ��ȯ
			    //       "���ڿ�"�� "�񱳴���ڿ�"�� ���� ��ġ���� ������ false�� ��ȯ
				
// === 18. "���ڿ�".equalsIgnoreCase("�񱳴���ڿ�")  ===
				//        �빮�ڿ� �ҹ��ڸ� �������� �ʰ�
			    //       "���ڿ�"�� "�񱳴���ڿ�"�� ���� ��,�ҹ��ڿ� ������� ��ġ�ϸ� true�� ��ȯ
			    //       "���ڿ�"�� "�񱳴���ڿ�"�� ���� ��,�ҹ��ڿ� ������� ��ġ���� ������ false�� ��ȯ
			    
				String[] strArr = {"korea","seoul","Korea ���ѹα�","���� kOrEA ����",null};
				
				for (String s :strArr) {  //�迭�� ���� ��ŭ �ݺ�
					if("korea".equals(s))  
						//NullPointerException ����!
						//���ڿ� �񱳽� ������� �տ� ���� ������ �ڿ�, �������� null�� �� �� �ִ�.
						System.out.println(s);
				}
				//korea
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				//�˻�� "korea","KOREA","kOrEA" �� ���� �ƹ��ų� �Է��ϸ�,
				//"korea"," korea seoul","Korea ���ѹα�","���� kOrEA ����"�� ��µǵ��� ����
				
				String search = "kOrEA";
				for (String s :strArr) {  //�迭�� ���� ��ŭ �ݺ�
					search = search.toLowerCase();
					if (s!=null && s.toLowerCase().indexOf(search)!=-1) { //***null ������ ���� �Ϳ� ����
						System.out.println(s);
					}
			    }
				/*
				 	korea
					Korea ���ѹα�
					���� kOrEA ����
				 */
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				

	}//end of main------------------------------------------------------------
	
}
