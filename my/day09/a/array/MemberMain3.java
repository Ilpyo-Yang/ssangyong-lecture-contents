package my.day09.a.array;

import java.util.Scanner;

import my.util.MyUtil;

public class MemberMain3 {

	public static void main(String[] args) {
		
		Member2[] mbrArr = new Member2[3];
		
	/*	
		for(int i=0; i<mbrArr.length; i++) {
			System.out.println(mbrArr[i]);
		}

			null
			null
			null
	*/	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">>> ȸ������");
		
		int menuNo = 0;
		
		do {
			System.out.println("\n=========== >> �޴� << ==========");
			System.out.println("1. ȸ������ 2.���ȸ����ȸ 3.���α׷�����");
			System.out.print("�� �����ϼ��� => ");
			try {
				menuNo = Integer.parseInt(sc.nextLine());
				if(!(1<= menuNo && menuNo <=3)) {
					System.out.println(">> �޴��� ���� ��ȣ�Դϴ� \n");
					continue;
				}
				
				switch (menuNo) {
				case 1:  //ȸ������
					Member2 mbr = new Member2();
					
					System.out.print("\n1. ���̵� : ");
					mbr.id = sc.nextLine();
					
					boolean bool = false;
					do {
						System.out.print("2. ��й�ȣ : ");
						String passwd = sc.nextLine();
						bool = MyUtil.isCheckPasswd(passwd);
						if(bool) {
							mbr.passwd = passwd;
						} else {
							System.out.println(">> ��й�ȣ�� 8~15 �ڸ� ������ �Է��ؾ� �ϸ�, ��ҹ���, ����, Ư�����ڰ� ȥ�յǾ�� �մϴ�!!\n");
						}
					} while(!(bool==true));
										
					System.out.print("3. ���� : ");
					mbr.name = sc.nextLine();
					
					for (int i=0; i<mbrArr.length; i++) {
						if (mbrArr[i] == null) {
							mbrArr[i] = mbr;  //�� �� index�� �����ؾ� �Ѵ�. ��� ���ο� ������ �ٲ�� �ȵ�.
							break;
						}
					}
										
					break;
					
				case 2:  //���ȸ����ȸ
					
					int nullCount = 0;
					
					for(int i=0; i<mbrArr.length; i++) {
						if(mbrArr[i]!=null) {        //null ���� �� Ȯ���ϱ�
							System.out.println(mbrArr[i].showInfo());
						} else nullCount++;
					} 
					if(nullCount==mbrArr.length)
						System.out.println("\n���Ե� ȸ����  0�� �Դϴ�.");
					break;

				default:
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println(">> ������ �Է��ϼ���! <<\n");
			}
			
		} while (!(menuNo==3));
				
		sc.close();	
		System.out.println(">> ���α׷� ���� <<");


	}

}
