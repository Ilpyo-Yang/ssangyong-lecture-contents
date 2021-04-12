package chap05.oracle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personDelete.do")
public class PersonDelete_08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	InterPersonDAO_03 dao = new PersonDAO_04();

	private Object String;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();	// "GET" 또는 "POST"
		String path = "";
		String delInfo = "";
		
		if("POST".equalsIgnoreCase(method)) {
			String seq = request.getParameter("seq");
			String name = request.getParameter("name");
		//	System.out.println("확인용 제거할 seq => "+seq);
		//	System.out.println("확인용 제거할 seq => "+name);	확인용 제거할 seq => 아아아아
			
			try {
				int n = dao.deletePerson(seq);
				if(n==1)
					delInfo = "회원번호 "+seq+"번 "+name+" 님을 삭제했습니다.";
					request.setAttribute("delInfo", delInfo);
				
					path="/WEB-INF/chap05_right/personDelete_success.jsp";
					
			} catch (SQLException e) {
				e.printStackTrace();
				path="/WEB-INF/chap05_right/personDelete_error.jsp";
			}
			
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
