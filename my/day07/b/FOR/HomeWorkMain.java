package my.day07.b.FOR;

public class HomeWorkMain {

	public static void main(String[] args) {
/*

== ¼÷Á¦ 1 == 
*
**
***
****
*****
		          
		          
== ¼÷Á¦ 2 == 
       *
      **
     ***
    ****
   ***** 

== ¼÷Á¦ 3 == 
*****   
****    
***    
**     
*   
          
== ¼÷Á¦ 4 ==
 
   *
  ***
 ***** 
      
== ¼÷Á¦ 5 ==
      
  *****
   ***
    *
              
 == ¼÷Á¦ 6 ==
   
    *
   ***
  *****
   ***   
   	*   
   	
== ÀÔ»ç¹®Á¦ == 
        
   *********1
   ********2
   *******3
   ******4
   *****5
   ****6
   ***7
   **8
   *9
   
== ±¸±¸´Ü 3´Ü¾¿ ²÷±â ==

1*1=1   2*1=2   3*1=3   
1*2=2   2*2=4   3*2=6   
1*3=3   2*3=6   3*3=9   
1*4=4   2*4=8   3*4=12   
1*5=5   2*5=10   3*5=15   
1*6=6   2*6=12   3*6=18   
1*7=7   2*7=14   3*7=21   
1*8=8   2*8=16   3*8=24   
1*9=9   2*9=18   3*9=27   

4*1=4    5*1=5    6*1=6   
4*2=8    5*2=10   6*2=12   
4*3=12   5*3=15   6*3=18   
4*4=16   5*4=20   6*4=24   
4*5=20   5*5=25   6*5=30   
4*6=24   5*6=30   6*6=36   
4*7=28   5*7=35   6*7=42   
4*8=32   5*8=40   6*8=48   
4*9=36   5*9=45   6*9=54   

7*1=7    8*1=8    9*1=9   
7*2=14   8*2=16   9*2=18   
7*3=21   8*3=24   9*3=27   
7*4=28   8*4=32   9*4=36   
7*5=35   8*5=40   9*5=45   
7*6=42   8*6=48   9*6=54   
7*7=49   8*7=56   9*7=63   
7*8=56   8*8=64   9*8=72   
7*9=63   8*9=72   9*9=81   

~~~~~ ±¸±¸´Ü 4´Ü¾¿ ²÷±â(!!ÀÔ»ç¹®Á¦!!) ~~~~~

2*1=2    3*1=3    4*1=4    5*1=5   
2*2=4    3*2=6    4*2=8    5*2=10   
2*3=6    3*3=9    4*3=12   5*3=15   
2*4=8    3*4=12   4*4=16   5*4=20   
2*5=10   3*5=15   4*5=20   5*5=25   
2*6=12   3*6=18   4*6=24   5*6=30   
2*7=14   3*7=21   4*7=28   5*7=35   
2*8=16   3*8=24   4*8=32   5*8=40   
2*9=18   3*9=27   4*9=36   5*9=45   

6*1=6    7*1=7    8*1=8    9*1=9   
6*2=12   7*2=14   8*2=16   9*2=18   
6*3=18   7*3=21   8*3=24   9*3=27   
6*4=24   7*4=28   8*4=32   9*4=36   
6*5=30   7*5=35   8*5=40   9*5=45   
6*6=36   7*6=42   8*6=48   9*6=54   
6*7=42   7*7=49   8*7=56   9*7=63   
6*8=48   7*8=56   8*8=64   9*8=72   
6*9=54   7*9=63   8*9=72   9*9=81   

*/
		
//¹®Á¦ 1.
	System.out.println("\n== ¼÷Á¦ 1 ==");
		
	for(int a=1; a<6; a++) {
		for (int b=0; b<a; b++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
//¹®Á¦ 2.	
	System.out.println("\n== ¼÷Á¦ 2 ==");

	for(int a=1; a<6; a++) {
		for(int b=5; b>a; b--) {
			System.out.print(" ");
		}
		for (int c=0; c<a; c++) {
			System.out.print("*");
		}
		System.out.println("");
	}

	
//¹®Á¦ 3.
	System.out.println("\n== ¼÷Á¦ 3 ==");
	
	for(int a=6; a>1; a--) {
		for (int b=1; b<a; b++) {
			System.out.printf("%s","*");
		}
		System.out.println("");
	}
	
//¹®Á¦ 4.
	System.out.println("\n== ¼÷Á¦ 4 ==");

	for(int a=1; a<6; a++) {
		for(int b=3; b>a; b--) {
			System.out.print(" ");
		}
		if(a%2==0) continue;
		for (int c=0; c<a; c++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
//¹®Á¦ 5.
	System.out.println("\n== ¼÷Á¦ 5 ==");

	for(int a=0; a<5; a++) {
		for(int b=1; b<=a; b++) {
			System.out.print(" ");
		}
		for (int c=5; c>=a*2+1; c--) {
			System.out.print("*");
		}
		System.out.println("");
	}

//¹®Á¦ 6.
	System.out.println("\n== ¼÷Á¦ 6 ==");
	
	for(int a=1; a<4; a++) {
		for(int b=3; b>a; b--) {
			System.out.print(" ");
		}
		for (int c=0; c<a*2-1; c++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	for(int a=0; a<3; a++) {
		for(int b=1; b<a+2; b++) {
			System.out.print(" ");
		}
		for (int c=4; c>a*2+1; c--) {
			System.out.print("*");
		}
		System.out.println("");
	}

//ÀÔ»ç¹®Á¦.
	System.out.println("\n== ÀÔ»ç¹®Á¦ ==");
	int a1,b;
	for(a1=9; a1>0; a1--) {
		for (b=0; b<a1; b++) {
			System.out.print("*");
		}
		System.out.println(a1);
	}
		
//***±¸±¸´Ü 3´Ü ²÷±â
	System.out.println("=== ±¸±¸´Ü 3´Ü ²÷±â ===\n");
	for(int dan=2; dan<10; dan+=3) { //3´Ü¾¿ °Ç³Ê¶Ù±â
		for(int jul=1; jul<10; jul++) {
			for(int j=dan; j<dan+3; j++) {
				System.out.print(j+"*"+jul+"="+j*jul+"\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	
//±¸±¸´Ü 4´Ü ²÷±â ÀÔ»ç¹®Á¦
	System.out.println("=== ±¸±¸´Ü 4´Ü ²÷±â ===\n");
	
	for(int dan=2; dan<10; dan+=3) { 
		for(int i=1; i<11; i++) {	
				for(int j=0; j<8; j++) {			
					System.out.print((j+2)+"*"+i+"="+(j+2)*i+"\t");	
				}
				System.out.print("\n");
		}
		System.out.print("\n");
	}
		
		
	}
}//end of main()---------------------------------------


