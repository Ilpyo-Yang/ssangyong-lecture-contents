package chap05.oracle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/personUpdate.do")
public class PersonUpdate_09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String path= "";
		InterPersonDAO_03 dao = new PersonDAO_04();
		
		if("post".equalsIgnoreCase(method)) {
			String seq = request.getParameter("seq");

			try {
				PersonDTO_02 psdto = dao.selectOne(seq);
				request.setAttribute("psdto", psdto);
				path="/WEB-INF/chap05_right/personUpdate.jsp";
				
			} catch (SQLException e) {
				e.printStackTrace();
				path="/WEB-INF/chap05_right/personUpdate_error.jsp";
			}

		} else {
			path="/WEB-INF/chap05_right/personUpdate_fail.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
