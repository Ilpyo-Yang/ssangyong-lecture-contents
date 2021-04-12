package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends AbstractController {

	@Override
	public String toString() {
		return "### 클래스 MainController 의 인스턴스 메소드  toString() 호출함 ###";
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println("### 확인용 MainController 의 인스턴스 메소드 execute 가 호출됨 ###");				
	
		// DB 에서 select 해서 얻어온 값이 "서울시 마포구 월드컵로"이라고 가정한다.
		String address = "서울시 마포구 월드컵로";
		request.setAttribute("address", address);
		
		super.setRedirect(false);	
		// super.setRedirect(false); 을 안하더라도 super.isRedirect() 기본값이 false 이다. 
		
		super.setViewPage("/WEB-INF/main.jsp");
	}

}
