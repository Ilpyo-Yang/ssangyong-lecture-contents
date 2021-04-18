package test.controller;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import test.model.*;


public class Form01InsertAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		TestVO vo = new TestVO();
		vo.setName(name);
		vo.setAddress(address);
		
		InterTestDAO dao = new TestDAO();
		
		try {
			 int n = dao.insertTest(vo);
		
			 if(n==1) {
				 super.setRedirect(false);
				 super.setViewPage("/WEB-INF/test/insertResult.jsp");
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
			
			super.setRedirect(false);
			super.setViewPage("/WEB-INF/test/error.jsp");
		}
		
	}

}
