package member.controller;

import java.util.*;
import javax.servlet.http.*;
import common.controller.AbstractController;
import member.model.*;

public class LoginAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		
		if(!"post".equalsIgnoreCase(method)) {
			// post 방식으로 넘어온 것이 아니라면		
			String message = "비정상적인 경로로 들어왔습니다";
			String loc = "javascript:history.back()";
			request.setAttribute("message", message);
			request.setAttribute("loc", loc);
			
		//	super.setRedirect(false);
			super.setViewPage("/WEB-INF/msg.jsp");
			
		} else {
			// post 방식으로 넘어온 것이라면
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			
			// ===> 클라이언트의 IP 주소를 알아오는 것 <==== //
			String clientip = request.getRemoteAddr();
			// System.out.println("확인용 clientip ==> "+clientip);
			// /MyMVC/WebContent/JSP 파일을 실행시켰을 때 IP 주소가 제대로 출력되기위한 방법.txt 참조
			// 확인용 clientip ==> 0:0:0:0:0:0:0:1 을 아래로 변경하기 (run configuration 에서 설정)
			// 확인용 clientip ==> 127.0.0.1
			
			Map<String, String> paraMap = new HashMap<>();
			paraMap.put("userid", userid);
			paraMap.put("pwd", pwd);
			paraMap.put("clientip", clientip);
			
			InterMemberDAO mdao = new MemberDAO();
			MemberVO loginuser = mdao.selectOneMember(paraMap);
			
			if(loginuser!=null) {
				if(loginuser.getIdle()==1) {
					// 원래는 휴면처리 되어진 사용자를 풀어주는 페이지로 이동해야 한다.
					// 그런데 우리는 그냥 "로그인을 한지 1년지 지나서 휴면상태로 되었습니다. 관리자가에게 문의 바랍니다."
					// 라는 메시지만 alert 로 띄워주고 시작페이지로 가게끔하겠다.
					String message = "로그인을 한지 1년지 지나서 휴면상태로 되었습니다. 관리자가에게 문의 바랍니다.";
		            String loc = request.getContextPath()+"/home.up";
		            
		            request.setAttribute("message", message);
		            request.setAttribute("loc", loc);
		            
		            super.setRedirect(false);
		            super.setViewPage("/WEB-INF/msg.jsp");
		            
		            return;  // 메소드 종료
				}
				
				// 로그인 성공시
				// System.out.println("로그인한 사용자명 : "+loginuser.getName());
				// !!!! session(세션) 이라는 저장소에 로그인 되어진 loginuser 을 저장시켜두어야 한다.!!!! //
		        // session(세션) 이란 ? WAS 컴퓨터의 메모리(RAM)의 일부분을 사용하는 것으로 접속한 클라이언트 컴퓨터에서 보내온 정보를 저장하는 용도로 쓰인다. 
		        // 클라이언트 컴퓨터가 WAS 컴퓨터에 웹으로 접속을 하기만 하면 무조건 자동적으로 WAS 컴퓨터의 메모리(RAM)의 일부분에 session 이 생성되어진다.
		        // session 은 클라이언트 컴퓨터 웹브라우저당 1개씩 생성되어진다. 
		        // 예를 들면 클라이언트 컴퓨터가 크롬웹브라우저로 WAS 컴퓨터에 웹으로 연결하면 session이 하나 생성되어지고 ,
		        // 또 이어서 동일한 클라이언트 컴퓨터가 엣지웹브라우저로 WAS 컴퓨터에 웹으로 연결하면 또 하나의 새로운 session이 생성되어진다. 
		        /*
		               -------------
		               | 클라이언트     |             ---------------------
		               | A 웹브라우저 | -----------  |   WAS 서버                 |
		               -------------             |                  |
		                                         |  RAM (A session) |
		               --------------            |      (B session) | 
		               | 클라이언트       |             |                  |
		               | B 웹브라우저   | ----------  |                  |
		               ---------------           --------------------
		               
		           !!!! 세션(session)이라는 저장 영역에 loginuser 를 저장시켜두면
		                Command.properties 파일에 기술된 모든 클래스 및  모든 JSP 페이지(파일)에서 
		                     세션(session)에 저장되어진 loginuser 정보를 사용할 수 있게 된다. !!!! 
		                     그러므로 어떤 정보를 여러 클래스 또는 여러 jsp 페이지에서 공통적으로 사용하고자 한다라면
		                     세션(session)에 저장해야 한다.!!!!          
		         */
				
				HttpSession session = request.getSession();
				// 메모리에 생성되어져 있는 session 을 불러오는 것이다.
				session.setAttribute("loginuser", loginuser);
				// session(세션)에 로그인 되어진 사용자 정보인 loginuser 을 키이름을 "loginuser" 으로 저장시켜두는 것이다.
				
				if(loginuser.isRequiredPwdChange()) {
					// 비밀번호를 변경한지가 3개월이 지난 경우
					// 원래는 사용자의 암호를 변경해주는 페이지로 가야 하지만 우리는 alert만 띄우고 시작페이지로 가게 하겠다.
					String message = "비밀번호를 변경하신지 3월이 지났습니다. 암호를 변경하세요!!";
					String loc = request.getContextPath()+"/home.up";
					
					request.setAttribute("message", message);
					request.setAttribute("loc", loc);
					
					super.setRedirect(false);
					super.setViewPage("/WEB-INF/msg.jsp");
					
					return;
					
				} else {
					super.setRedirect(true);
					super.setViewPage(request.getContextPath()+"/home.up");
					
				}
				
			} else {
				String message = "로그인실패";
				String loc = "javascript:history.back()";
				
				request.setAttribute("message", message);
				request.setAttribute("loc", loc);
				
				super.setRedirect(false);
				super.setViewPage("/WEB-INF/msg.jsp");
			}
		}
		
	}

}
