package my.day10.c.array;

import java.util.Arrays;

public class BubbleSortMain {

 /*
   == �Ի繮�� ==
   >> ���� ����(Bubble Sort)�� 
    ���� ��� ����Ʈ(�迭)�� �׸��� ����������� �����ߴٰ� �������� ��, 
    ���� ���������� �����ؼ� �����ϴ� �� �׸��� ���� ���Ͽ� 
    �ùٸ� ����(�������� �Ǵ� ��������)�� �Ǿ����� ������ ���� ��ġ�� ��ȯ�ϴ� ���Ĺ���̴�.
    
    �̷��� �����ϴ� �׸��� ���� ���ؼ� ��ġ�� ��ȯ�ϴ� ������ 
    ����Ʈ(�迭)�� ������ �׸���� �ݺ��ؼ� ���� ū(�Ǵ� ����) ���� ���� ������ �Ѵ�.
    
    �� ȸ��(Pass)������ ���������� ������ �ڿ������� �ϳ��� �Ϸ�ȴ�. 
 */   
   
   public static void main(String[] args) {
   
      int[] numArr = {9,7,3,5,1}; 
    /*
        numArr[0] => 9
        numArr[1] => 7
        numArr[2] => 3
        numArr[3] => 5
        numArr[1] => 1  
    */
      
      System.out.println("=== �����ϱ� �� ===");
      for(int i=0; i<numArr.length; i++) {
         String str = (i<numArr.length-1)?",":"\n";
         System.out.print(numArr[i]+str);
      }// end of for---------------------
      /*
         === �����ϱ� �� ===
          9,7,3,5,1 
          
                    --------------------
                  �����Ͱ�  => | 7 | 3 | 9 | 5 | 1 | 
                    --------------------   
          index  =>   0   1   2   3   4          
       */
      
      // === �������� �����ϱ� === //
      for(int i=0; i<numArr.length-1; i++) { 
         // ���� ����� ������ ���� ==>  9  7  3  5  �� �? 4��
      // (int i=0; i<4; i++)   
         for(int j=0; j<numArr.length-1-i; j++) { // i=0;  ==> ���ǽ��� j<4; �Ǿ�߸� 4�� ����.  
                                                 // i=1;  ==> ���ǽ��� j<3; �Ǿ�߸� 3�� ����.
                                                 // i=2;  ==> ���ǽ��� j<2; �Ǿ�߸� 2�� ����.
                                                 // i=3;  ==> ���ǽ��� j<1; �Ǿ�߸� 1�� ����.
         
            if(numArr[j] > numArr[j+1]) {
            // numArr[0] > numArr[1]
            //    9             7
               
            /*   
               int temp = numArr[0];  // 9;
               numArr[0] = numArr[1]; // numArr[0] <= 7; 
               numArr[1] = temp;      // numArr[1] <= 9
               
               int temp = numArr[1];  // 9;
               numArr[1] = numArr[2]; // numArr[1] <= 3; 
               numArr[2] = temp;      // numArr[2] <= 9
               
               int temp = numArr[2];  // 9;
               numArr[2] = numArr[3]; // numArr[2] <= 5; 
               numArr[3] = temp;      // numArr[3] <= 9
            */   
               
               int temp = numArr[j];
               numArr[j] = numArr[j+1];
               numArr[j+1] = temp; 
            }   
         }// end of for----------------------
         
      }// end of for---------------------------
      
      System.out.println("\n=== �������� ������ �� ===");
      for(int i=0; i<numArr.length; i++) {
         String str = (i<numArr.length-1)?",":"\n";
         System.out.print(numArr[i]+str);
      }// end of for---------------------
      
      System.out.println("\n~~~~~~~~~~~~~~~~~~~\n");
      
      int[] numArr2 = {9,7,3,5,1}; 
      
      System.out.println("=== �����ϱ� �� ===");
      for(int i=0; i<numArr2.length; i++) {
         String str = (i<numArr2.length-1)?",":"\n";
         System.out.print(numArr2[i]+str);
      }// end of for---------------------
      
      // === �������� �����ϱ� === //
      for(int i=0; i<numArr2.length-1; i++) { 
         
         for(int j=0; j<numArr2.length-1-i; j++) { 
         
            if(numArr2[j] < numArr2[j+1]) {
               int temp = numArr2[j];
               numArr2[j] = numArr2[j+1];
               numArr2[j+1] = temp; 
            }   
         }// end of for----------------------
         
      }// end of for---------------------------
      
      System.out.println("\n=== �������� ������ �� ===");
      for(int i=0; i<numArr2.length; i++) {
         String str = (i<numArr2.length-1)?",":"\n";
         System.out.print(numArr2[i]+str);
      }// end of for---------------------
      
      
      System.out.println("\n~~~~~~~~~~~~~~~~~~~\n");
      
      int[] numArr3 = {9,7,3,5,1}; 
      
      System.out.println("=== �����ϱ� �� ===");
      for(int i=0; i<numArr2.length; i++) {
         String str = (i<numArr2.length-1)?",":"\n";
         System.out.print(numArr2[i]+str);
      }// end of for---------------------
      
      Arrays.sort(numArr3);  // �������� ����
      
      System.out.println("\n=== Arrays.sort()�� ����Ͽ� ������ �� ===");
      for(int i=0; i<numArr3.length; i++) {
         String str = (i<numArr3.length-1)?",":"\n";
         System.out.print(numArr3[i]+str);
      }// end of for---------------------

   }// end of main()--------------------------------

}

