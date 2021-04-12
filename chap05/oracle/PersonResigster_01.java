package chap05.oracle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personRegister.do")
public class PersonResigster_01 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	InterPersonDAO_03 dao = new PersonDAO_04();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      String method = request.getMethod(); // "GET" 또는 "POST" 
	      
	      if("GET".equals(method)) {
	         // == http://localhost:9090/JSPServletBegin/personRegister.do 을 하면 회원가입창을 띄우도록 한다. == 
	      
	    	 // RequestDispatcher dispatcher = request.getRequestDispatcher("/chap05_mistake/personRegister.jsp");
	         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/chap05_right/personRegister.jsp");
	         dispatcher.forward(request, response);
	      }
	      
	      else {
	         // POST 방식으로 http://localhost:9090/JSPServletBegin/personRegister.do 을 호출한 경우이라면 서브밋 되어져온 데이터를 받아서 DB로 보내야 한다.  
	      
	    	 String name = request.getParameter("name");
	    	 String school = request.getParameter("school");
	    	 String color = request.getParameter("color");
	    	 String[] foodArr = request.getParameterValues("food");
	    	  
	    	 PersonDTO_02 psdto = new PersonDTO_02();
	    	 psdto.setName(name);
	    	 psdto.setSchool(school);
	    	 psdto.setColor(color);
	    	 psdto.setFood(foodArr);
	    	 
	    	 String pathName = "";
	    	 
	    	 try {
				int n = dao.personRegister(psdto);
				if(n==1) {
					pathName="/WEB-INF/chap05_right/personRegister_success.jsp";
				} 
			} catch (SQLException e) {
				e.printStackTrace();
				pathName="/WEB-INF/chap05_right/personRegister_fail.jsp";
			}
	    	 
	         RequestDispatcher dispatcher = request.getRequestDispatcher(pathName);
	         dispatcher.forward(request, response);
	      }	       
	   }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
