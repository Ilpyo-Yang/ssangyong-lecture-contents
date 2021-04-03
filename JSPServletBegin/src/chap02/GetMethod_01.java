package chap02;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
=== Servlet 이란 ? 웹서비스 기능을 해주는 자바 클래스를 말한다. ===

*** Servlet 이 되기 위한 조건은 3가지 규칙을 따라야 한다. ***
1. 서블릿(Servlet)은 반드시 
   javax.servlet.http.HttpServlet 클래스를 부모 클래스로 상속을 받아와야 한다. 

2. 웹클라이언트의 요청방식이 GET 방식으로 요청을 해오면
     doGet() 메소드로 응답을 해주도록 코딩을 해야하고,
     웹클라이언트의 요청방식이 POST 방식으로 요청을 해오면
     doPost() 메소드로 응답을 해주도록 코딩을 해주어야만 한다.
      그러므로  반드시  doGet() 메소드와  doPost() 메소드를 
   Overriding(재정의)를 해주어야만 한다.
   
   doGet() 메소드와 doPost() 메소드의 
           첫번째 파라미터는 HttpServletRequest 타입이고,
           두번째 파라미터는 HttpServletResponse 타입이다. 
           
3. 만약에  서블릿(Servlet)에서 결과물을 웹브라우저상에 출력하고자 한다라면 
   doGet() 메소드와 doPost() 메소드 모두 
      서블릿(Servlet)의 두번째 파라미터인 HttpServletResponse response 를 
      사용하여 출력해준다.
*/   

@WebServlet("/GetMethod_01")
public class GetMethod_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws IOException {
    	System.out.println("확인용: doGet 메소드가 호출됨~~~~~~");

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException {
    	System.out.println("확인용: doPost 메소드가 호출됨######");
    }
	

}
