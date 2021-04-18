package test.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;

public class Test01Action extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DB에서 select 해서 얻어온 값이 "김태희", "kimth.jpg" 이라고 가정한다. 
		String name = "김태희";
		String imgFilename = "kimth.jpg";
		
		Map<String, String> paraMap = new HashMap<>();
		
		paraMap.put("name", name);
		paraMap.put("imgFilename", imgFilename);
		
		request.setAttribute("paraMap", paraMap);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/test/test01.jsp");
	}

}
