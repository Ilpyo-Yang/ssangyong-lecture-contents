package my.day06.a.FOR;
//�Ի��� �� ���� ����ٴ� for��......
public class Quiz3Main {

	public static void main(String[] args) {
//str�� ����� , ��⿡ ���� �� �� �����غ���!
		//1,2,3,4,5,6,7,8,9,10
		
		for (int i=0; i<10; i++) {
			String str = (i<10-1)?",":"";
			System.out.print(i+1+str);
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
		
		//5,6,7,8,9,10,11,12,13,14
		for (int i=0,j=5; i<10 ; i++,j++) {
			String str = (i<10-1)?",":"";
			System.out.print(j+str);
		}	
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
		
		//5,6,7,8,9,10,11,12,13,14
		for(int i=5;i<15; i++) {
			String str = (i<14)?",":"";
			System.out.print(i+str);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
		
		//1~20 ������ 3�� ��� ����ϱ�
		//3+6+9+12+15+18
		for(int i=1;i<=20;i++) {
			if(i%3!=0) continue;
			String str = (i<=17)?",":"";
			System.out.print(i+str);
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
		
		//3+6+9+12+15+18=63
		
		String result ="";
		int i = 0;
		int sum = 0;
		
		for(i=1;i<=20;i++) {
			if(i%3!=0) continue;
			String str = (i<=17)?",":"";	
			result += i+str;
			sum += i;
		}
		System.out.print(result+" = "+sum);
	}

}
