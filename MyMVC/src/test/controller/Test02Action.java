package test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;

public class Test02Action extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 페이지 이동(sendRedirect)
		
		super.setRedirect(true);
		
		super.setViewPage(request.getContextPath()+"/index.up");
		//                /MyMVC/index.up(절대경로를 사용한다)
		
	}

}
