package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends AbstractController {

	@Override
	public String toString() {
		return "@@@ 클래스 IndexController 의 인스턴스 메소드  toString() 호출함 @@@";
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	//	System.out.println("@@@ 확인용 IndexController 의 인스턴스 메소드 execute 가 호출됨 @@@");
		
		// DB에서 select 해서 얻어온 값이 "이순신" 이라고 가정한다.
		
		String name = "이순신";
	
		request.setAttribute("name", name);
	
	//	super.setRedirect(false);
		// super.setRedirect(false); 을 안하더라도 super.isRedirect() 의 기본값은 false 이다.
		
		super.setViewPage("/WEB-INF/index.jsp");
	}

}
