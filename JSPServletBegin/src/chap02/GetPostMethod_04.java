package chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPostMethod_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");	
		// get 방식에서는 필요없지만 post 에서 넘겨받는 것을 처리하기 위해 필요.
		
		// HttpServletRequest request 객체는 전송되어져온 데이터를 처리해주는 용도로 쓰인다.
		String name = request.getParameter("name");
		String school = request.getParameter("school");
		String color = request.getParameter("color");
		
		String[] arrFood = request.getParameterValues("food");
		
		// *** 콘솔에 출력하기 시작 *** //
		System.out.println("name => "+name);
		System.out.println("school => "+school);
		
		if(color==null) {
			color="없음";
		}
		System.out.println("color => "+color);
		
		if(arrFood!=null) {
			for (int i=0; i<arrFood.length; i++) {
				System.out.println("arrFood["+i+"] => "+arrFood[i]);	
			}
			String likeFoodes = String.join(",", arrFood);
			System.out.println("좋아하는 음식 => "+likeFoodes);	
		} else {
			System.out.println("좋아하는 음식이 없습니다");
		}
		// *** 콘솔에 출력하기 끝 *** //
		
		
		// *** 웹브라우저에 출력하기 시작 *** //
		
		// *** 클라이언트(form 태그가 있는 .jsp)에서 넘어온 method 방식이 GET 인지 POST 인지 알아오기 *** //
		String method = request.getMethod();	// get 또는 post
		
		// HttpServletResponse response 객체는 넘어온 데이터를 조작해서 결과물을 나타내고자 할 때 쓰인다.
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		// out 은 웹브라우저에 기술하는 대상체라고 생각하자.
		out.println("<html>");
		out.println("<head><title>개인성향 테스트 결과화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인 성향 테스트 결과("+method+")</h2>");
		out.printf("<span style='color: red; font-weight: bold;'>%s</span>님의 개인 성향은<br/><br/>",name);
		
		if(!"없음".equals(color)) {
			out.printf("학력은 %s이며, %s색을 좋아합니다.<br><br>", school, color);
		} else {
			out.printf("학력은 %s이며, 좋아하는 색이 없습니다.<br><br>", school);
		}
		/*
			%d ==> decimal 정수
			%f ==> float 실수
			%s ==> string 문자열
		*/
		
		String foodes = "";
			
		if(arrFood!= null) {
			foodes = String.join(",", arrFood)+"입니다.";
		} else {
			foodes = "업습니다.";
		}
		
			
		out.println("좋아하는 음식은 "+foodes);
		
		out.println("</body>");
		out.println("</html>");
		// *** 웹브라우저에 출력하기 끝 *** //
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doGet(request, response);
	}

}
