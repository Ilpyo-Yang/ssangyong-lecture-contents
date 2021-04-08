package chap05.oracle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personDelete.do")
public class PersonDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();	// "GET" 또는 "POST"
		String path = "";
		
		if("POST".equalsIgnoreCase(method)) {
			String seq = request.getParameter("seq");
			System.out.println("확인용 제거할 seq => "+seq);
		} else {
			path="/WEB-INF/chap05_right/personDelete_fail.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
