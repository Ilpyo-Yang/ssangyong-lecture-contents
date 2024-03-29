package member.controller;

import java.util.*;
import javax.servlet.http.*;
import common.controller.AbstractController;
import member.model.*;

public class IdFindAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		
		if("POST".equalsIgnoreCase(method)) {
			// 아이디 찾기 모달창에서 찾기 버튼을 클릭했을 경우
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			InterMemberDAO mdao = new MemberDAO();
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("name", name);
			paraMap.put("email", email);
			
			String userid = mdao.findUserid(paraMap);
			if(userid!=null) {
				request.setAttribute("userid", userid);
			} else {
				request.setAttribute("userid", "존재하지 않습니다.");
			}
			request.setAttribute("name", name);
			request.setAttribute("email", email);
		}
		
		
		request.setAttribute("method", method);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/login/idFind.jsp");
	}

}
