package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.controller.AbstractController;
import member.model.InterMemberDAO;
import member.model.MemberDAO;

public class EmailDuplicateCheckAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		
		if("post".equalsIgnoreCase(method)) {
			String email = request.getParameter("email");
			//	System.out.println(">>> 확인용 email :"+email);
				
			InterMemberDAO dao = new MemberDAO();
			boolean isExists = dao.emailDuplicateCheck(email);
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("isExists", isExists);
			/*
				{"isExists":true} 또는 {"isExists":false} 으로 만들어진다.
			*/
			
			String json = jsonObj.toString();
			// 문자열 형태인 {"isExists":true} 또는 {"isExists":false} 으로 만든다.
			// System.out.println(json);
			
			request.setAttribute("json", json);
			
			super.setRedirect(false);
			super.setViewPage("/WEB-INF/jsonview.jsp");
				
		}
	
	}

}
