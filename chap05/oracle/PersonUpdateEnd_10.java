package chap05.oracle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personUpdateEnd.do")
public class PersonUpdateEnd_10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InterPersonDAO_03 dao = new PersonDAO_04();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String path= "";

		
		if("post".equalsIgnoreCase(method)) {
			
			 String seq = request.getParameter("seq");
			 String name = request.getParameter("name");
	    	 String school = request.getParameter("school");
	    	 String color = request.getParameter("color");
	    	 String[] foodArr = request.getParameterValues("food");
	    	  
	    	 PersonDTO_02 psdto = new PersonDTO_02();
	    	 psdto.setSeq(Integer.parseInt(seq));
	    	 psdto.setName(name);
	    	 psdto.setSchool(school);
	    	 psdto.setColor(color);
	    	 psdto.setFood(foodArr);
	    	 
			try {
				int n = dao.updatePerson(psdto);
				if(n==1) {
					/*  ★ javascript 에서 location.href=""; 와 같은 기능. */
					/*  ★ 상대경로는 / 가 앞에 없고 그냥 이하 url 이 포함된 것에 해당, 절대경로는 생략된 포트넘버까지 다음에 이하 url 주소. */
					response.sendRedirect("personDetail.do?seq="+seq);
					// URL 경로로 페이지의 이동을 시켜주는 것이다.
					return;
				} else {
					response.sendRedirect("personSelect.do");
					// URL 경로로 페이지의 이동을 시켜주는 것이다.
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				path="/WEB-INF/chap05_right/personUpdate_error.jsp";
			}

		} else {
			path="/WEB-INF/chap05_right/personUpdate_fail.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		/*  ★ forward 는 새로운 jsp 파일로 보내는 것이고,
		 *   sendRedirect 는 이미 만들어진 jsp 파일로 가는 것이다 */
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
