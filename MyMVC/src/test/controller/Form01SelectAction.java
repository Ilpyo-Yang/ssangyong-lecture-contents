package test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import test.model.*;

public class Form01SelectAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		InterTestDAO dao = new TestDAO();
		
		List<TestVO> testVOList = dao.selectTest();
		
		request.setAttribute("testVOList", testVOList);
		
		super.setRedirect(false);
		super.setViewPage("/WEB-INF/test/selectResult.jsp");
	}

}
