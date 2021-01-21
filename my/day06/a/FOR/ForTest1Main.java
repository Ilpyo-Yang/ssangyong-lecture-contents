package my.day06.a.FOR;

/*
 **** 반복문(loop) ==> for 문 ****
  
          ※ for 문의 형식
   
    for(초기화; 조건식; 증감식) {
          반복해서 실행할 문장;
    }  
    
               ▣ 순서
    1) 초기화;
    2) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.)
    3) 증감식
    4) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.) 
    5) 증감식
    6) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.)                                                  
    
*/

public class ForTest1Main {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			System.out.println((i+1)+". 안녕자바~");
		}
		
		/*
		    1. 안녕자바~
			2. 안녕자바~
			3. 안녕자바~
			4. 안녕자바~
			5. 안녕자바~
			6. 안녕자바~
			7. 안녕자바~
			8. 안녕자바~
			9. 안녕자바~
			10. 안녕자바~
		 */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<10; i+=1) {   //i+=1  => i=i+1
			System.out.println((i+1)+". 안녕 JAVA~");
		}
		
		/*
		    1. 안녕자바~
			2. 안녕자바~
			3. 안녕자바~
			4. 안녕자바~
			5. 안녕자바~
			6. 안녕자바~
			7. 안녕자바~
			8. 안녕자바~
			9. 안녕자바~
			10. 안녕자바~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<10; i++) {
			System.out.println(++i+". 안녕이클립스~");
		}
		
		/*
		    1. 안녕이클립스~
			3. 안녕이클립스~
			5. 안녕이클립스~
			7. 안녕이클립스~
			9. 안녕이클립스~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<10; i++) {
			System.out.println(i++ +". 안녕이클립스~");
		}
		
		/*
		    0. 안녕이클립스~
			2. 안녕이클립스~
			4. 안녕이클립스~
			6. 안녕이클립스~
			8. 안녕이클립스~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<10; i+=2) {
			System.out.println((i+1) +". 안녕Eclipes~");
		}
		
		/*
		    1. 안녕Eclipes~
			3. 안녕Eclipes~
			5. 안녕Eclipes~
			7. 안녕Eclipes~
			9. 안녕Eclipes~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//i는 1증가, j는 2증가
		for(int i=0, j=0; i<10; i++,j+=2) {
			System.out.println((j+1) +". 안녕오라클~");
		}
		
		/*
		    1. 안녕오라클~
			3. 안녕오라클~
			5. 안녕오라클~
			7. 안녕오라클~
			9. 안녕오라클~
			11. 안녕오라클~
			13. 안녕오라클~
			15. 안녕오라클~
			17. 안녕오라클~
			19. 안녕오라클~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=10; i>0; i--) {
			System.out.println(i+". 안녕Oracle~");
		}
		
		/*
		   10. 안녕Oracle~
			9. 안녕Oracle~
			8. 안녕Oracle~
			7. 안녕Oracle~
			6. 안녕Oracle~
			5. 안녕Oracle~
			4. 안녕Oracle~
			3. 안녕Oracle~
			2. 안녕Oracle~
			1. 안녕Oracle~  
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=10; i>0; i-=1) {
			System.out.println(i+". 안녕스프링~");
		}
		
		/*
		   10. 안녕스프링~
			9. 안녕스프링~
			8. 안녕스프링~
			7. 안녕스프링~
			6. 안녕스프링~
			5. 안녕스프링~
			4. 안녕스프링~
			3. 안녕스프링~
			2. 안녕스프링~
			1. 안녕스프링~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//***for()문의 증감식대로 수가 변경되며 System.out.println() 내 사칙연산은 출력에만 영향을 미칠 뿐 전체적인 증감기준을 바꾸지는 않는다. 
//i에 대입되는 값이 아니므로
		for(int i=10; i>0; i-=2) {
			System.out.println((i-1)+". 안녕Spring~");
		}
		
		/*
		    9. 안녕Spring~
			7. 안녕Spring~
			5. 안녕Spring~
			3. 안녕Spring~
			1. 안녕Spring~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
//***for()문의 증감식대로 수가 변경되며 System.out.println() 내 증감연산자의 영향을 받는다. 
		
		for(int i=10; i>0; i--) {
			System.out.println((--i)+". 안녕Spring~");
		}
		
		/*
		    9. 안녕Spring~
			7. 안녕Spring~
			5. 안녕Spring~
			3. 안녕Spring~
			1. 안녕Spring~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=10; i>0; i--) {
			if(i%2 != 0)
				System.out.println(i+". 안녕Spring~");
		}
		
		/*
		    9. 안녕Spring~
			7. 안녕Spring~
			5. 안녕Spring~
			3. 안녕Spring~
			1. 안녕Spring~
	    */
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//i는 반복횟수만 나타내고 j를 찍음
		for(int i=0,j=9; i<5; i++,j-=2) {
			System.out.println(j+". Hello~");
		}
		
		/*
	    	9. Hello~
			7. Hello~
			5. Hello~
			3. Hello~
			1. Hello~
		 */
		
		System.out.println("\n===========================");
		
		int n=0; //초기치 변수의 선언을 밖으로 빼서 작성, for문 밖에서 사용할 수 있다
		
		for(; n<5; n++) {
			System.out.println((n+1)+". 서강준~");
		}
		
		System.out.println("n => "+n);  //n이 5일때 빠져나오므로
		
		System.out.println("\n~~~~~~~ 프로그램 종료 ~~~~~~~");

	}//end of main

}
