package chap03;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/registerPerson.do")
public class RegisterPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();// GET 또는 POST	
		// System.out.println("확인용 method => "+method);
		// 확인용 method => GET
		
		if("POST".equalsIgnoreCase(method)) {
			// POST 방식으로 접근한 경우
			String name = request.getParameter("name");
			String school = request.getParameter("school");
			String color = request.getParameter("color");
			String[] arrFood = request.getParameterValues("food");			
			String foods = String.join(",", arrFood);
			
			/*
			 * System.out.println(name); System.out.println(school);
			 * System.out.println(color); System.out.println(foods);
			 */
			
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("name", name);
			paraMap.put("school", school);
			paraMap.put("color", color);
			paraMap.put("food", foods);
			
			request.setAttribute("paraMap", paraMap);
			
			// 실제 내용물의 위치
			RequestDispatcher dispatcher = request.getRequestDispatcher("/chap03_StandardAction/04_forwardForm_view_03.jsp");
			dispatcher.forward(request, response);
			
		} else {
			// GET 방식으로 접근한 경우
			
			// http://localhost:9090/JSPServletBegin/registerPerson.do?name=홍길동&school=군필&color=김밥&food=food1
			// 단순히 주소창에 내용이 입력되면 콘솔로 출력되는 것을 막아야 한다.
			
			// !!!! 중요
			// <jsp:forward page="03forwardCalc_view_03.jsp" /> 와 달리 서블릿에서 view 단을 보여주는 방법
			RequestDispatcher dispatcher = request.getRequestDispatcher("/chap03_StandardAction/04_error_02.jsp");
			dispatcher.forward(request, response);
			
		}
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
