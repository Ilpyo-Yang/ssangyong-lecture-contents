package test.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;

public class Form01ResultAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("name", name);
		paraMap.put("address", address);
		
		request.setAttribute("paraMap", paraMap);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/test/form01Result.jsp");
	}

}
