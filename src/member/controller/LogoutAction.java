package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractController;

public class LogoutAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그아웃 처리하기
		
		HttpSession session = request.getSession(); // 세션 불려오기
		
		// 첫번째 방법 : 세션을 그대로 존재하게 끔 해두고 세션에 저장되어진 어떤 값(지금은 로그인 되어진 회원객체)을 삭제하기
	//	session.removeAttribute("loginuser");
		
		// 두번째 방법 : WAS 메모리 상에서 세션을 아예 삭제해버리기 
		session.invalidate();
		// WAS 사이트 페이지에 연결만 하면 세션은 자동적으로 다시 생성된다.
		
		super.setRedirect(true);
		super.setViewPage(request.getContextPath()+"/home.up");
	}

}
