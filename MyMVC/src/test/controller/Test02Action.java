package test.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.controller.AbstractController;

public class Test02Action extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 페이지 이동(sendRedirect) 하겠다.
		super.setRedirect(true);
		
		super.setViewPage(request.getContextPath() + "/index.up");
		//					/MyMVC/index.up
	}

}
