package jdbc.day04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import jdbc.day04.singleton.dbconnection.MyDBConnection;

public class TotalController {

	
	// attribute, property, 속성
		interMemberDAO mdao = new MemberDAO();
		interBoardDAO  bdao = new BoardDAO();
	
	
	// *** 시작메뉴 *** //
	public void menu_Start(Scanner sc) {
		
		MemberDTO member = null;
		
		String s_Choice = "";
		do {
			
			String loginName = (member!=null)?"["+member.getName()+" 로그인 중 ..]":"";
			String login_logout = (member!=null)?"로그아웃":"로그인";
			String myInfoView = (member!=null)?"4. 내 정보보기":"";
			String goBoardMenu = (member!=null)?"5. 게시판가기":"";
				
			
			System.out.println("\n >>> --------- 시작메뉴 "+loginName+"--------- <<< \n"
							 + "1. 회원가입   2. "+login_logout+"   3. 프로그램 종료   "+myInfoView+"   "+goBoardMenu+"\n");
			System.out.print("▶ 메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
			case "1":	// 회원가입
				memberRegister(sc);
				break;
				
			case "2":	// 로그인 또는 로그아웃
			
			  	if("로그인".equals(login_logout))	 {
			  		member = login(sc);	// 로그인	 
			  	/*
			  		if(member!=null) { // 로그인이 성공한 경우
			  			menu_Board();  // 게시판 메뉴에 들어간다.
			  		} 
			  	*/	
			  	} else {
					member = null;	// 로그아웃
					System.out.println(">> 로그아웃되었습니다. <<");
				}
				break;
				
			case "3":	// 프로그램 종료
				// Connection 객체 자원반납.
				MyDBConnection.closeConnection(); 		
				break;
			
			case "4":	// 내 정보보기 => 로그인을 했을 때에만 작동되도록 해야 한다.
				if(member!=null)
					System.out.println(member);
				break;
			
			case "5":	// 게시판가기 => 로그인을 했을 때에만 작동되도록 해야 한다.
				if(member!=null) 
					menu_Board(sc,member);
				break;
			
				
			default:
				System.out.println(">>> 메뉴에 없는 번호입니다. 다시 선택하세요! <<<");
			}// end of switch(s_Choice) -------------------------------------------
			
		} while (!("3".equals(s_Choice)));
		
	}// end of public void menu_Start(Scanner sc) --------------------------


	// **** 회원가입 **** //
	private void memberRegister(Scanner sc) {
		System.out.println("\n >>> ----- 회원가입 ----- <<< \n");
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		System.out.print("3. 회원명 : ");
		String name = sc.nextLine();
		System.out.print("4. 연락처(휴대폰) : ");
		String mobile = sc.nextLine();
		
		MemberDTO member = new MemberDTO();
		member.setUserid(userid);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMobile(mobile);
		
		int n = mdao.memberRegister(member, sc);
		// 0 => 회원가입을 취소한 것임.
		// 1 => 정상적으로 회원가입한 것임.
		// -1 => 사용자 아이디에 중복이 발생한 것임.
		// -2 => SQL 구문에 오류발생한 것임.
		
		if(n==0) {
			System.out.println("\n >>> 회원가입을 취소했습니다. <<< \n");
		} else if(n==1) {
			System.out.println("\n >>> 회원가입을 축하드립니다. <<< \n");
		} else if(n==-1) {
			System.out.println("\n >>> 아이디가 이미 사용중이므로 다른 아이디를 입력하세요. <<< \n");
		} else if(n==-2) {
			System.out.println("\n >>> SQL 구문에 오류가 발생함!! <<< \n");
		}
		
	}
	
	
	// **** 로그인하기 **** //
	private MemberDTO login(Scanner sc) {
		MemberDTO member = null;
		
		System.out.println("\n >>> ----- 로그인하기 ----- <<< \n");
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("passwd", passwd);
		
		member = mdao.login(paraMap);
		// 스프링은 Map에 담아서 보낸다.
		
		if(member!=null) System.out.println("\n로그인 성공!!\n");
		else System.out.println("\n로그인 실패!!\n");
		
		return member;
	}


	// **** 게시판 메뉴 **** //
	private void menu_Board(Scanner sc, MemberDTO member) {
		
		String menuNo = "";
		String showAllInfo = ("admin".equals(member.getUserid()))?"10. 모든 회원정보 조회하기":"";
		
		do {
			System.out.println("\n --------- 게시판메뉴 [ "+member.getName()+"님 로그인중.. ]--------- \n"
					 		 + "1. 글목록보기   2. 글내용보기   3. 글쓰기   4.댓글쓰기\n"
					 		 + "5. 글수정하기   6. 글삭제하기   7. 최근1주일간 일자별 게시글 작성건수 \n"
					 		 + "8. 이번달 일자별 게시글 작성건수   9. 나가기    "+showAllInfo+"\n"
					 		 + "-----------------------------------------------");
			System.out.print("▶ 메뉴번호 선택 : ");
			menuNo = sc.nextLine(); 
					
			switch (menuNo) {
				case "1":	// 글목록보기
					boardList();
					break;

				case "2":	// 글내용보기
					
					break;
					
				case "3":	// 글쓰기(insert). 
					/*
					 	글쓰기는 jdbc_board 테이블에 insert 가 성공 되어지면 
					 	jdbc_member 테이블에서 글을 쓴 작성자의 point 컬럼의 값을 10 씩 증가(update) 시켜주겠다.
						
					    -- *** Transaction(트랜잭션) 처리 *** --
					    --> Transaction(트랜잭션)이라 함은 관련된 일련의 DML로 이루어진 한꾸러미(한세트)를 말한다.
					    --> Transaction(트랜잭션)이라 함은 데이터베이스의 상태를 변환시키기 위하여 논리적 기능을 수행하는 하나의 작업단위를 말한다. 
					    
					    Transaction(트랜잭션) 처리에서 가장 중요한 것은 
           				모든 DML문이 성공해야만 최종적으로 모두 commit 을 해주고,
           				DML문중에 1개라도 실패하면 모두 rollback 을 해주어야 한다는 것이다. 					
					*/
					int n = write(sc, member);
					
					if(n==1) {
						System.out.println(">> 글쓰기 성공!! <<\n");
					} else if(n==0) {
						System.out.println(">> 글쓰기를 취소하셨습니다. <<\n");
					} else {
						System.out.println(">> 글쓰기 실패!! <<\n");
					}
					break;	
				
				case "4":	// 댓글쓰기
	
					break;
				
				case "5":	// 글수정하기
					
					break;
				case "6":	// 글삭제하기
					
					break;
				case "7":	// 최근1주일간 일자별 게시글 작성건수
	
					break;
				case "8":	// 이번달 일자별 게시글 작성건수
					
					break;
				case "9":	// 나가기
					
					break;
					
					
				case "10":	// 모든 회원정보조회(관리자 전용 메뉴)
					if("admin".equals(member.getUserid()))
						System.out.println("== 모든 회원정보를 보여줄게요 ==");
					else 
						System.out.println(">> 없는 번호입니다. <<\n");
					break;

				default:
					System.out.println(">> 없는 번호입니다. <<\n");
					break;
					
			}// end of switch (menuNo) ----------------------------------
		} while(!("9".equals(menuNo)));
		
	}// end of private void menu_Board() ------------------------------------

	
	
	// **** 글쓰기(Transaction 처리) **** //
	//(글쓰기[jdbc_board 테이블에 insert] + 글쓴회원의 point를 10 증가[jdbc_member 테이블에 update] ==> Transaction 처리 )
	private int write(Scanner sc, MemberDTO member) {
		
		int result = 0;
		
		System.out.println("\n>>> 글쓰기 <<<\n");
		System.out.println("1. 작성자명 : "+member.getName());
		System.out.print("2. 글제목 : ");
		String subject = sc.nextLine();
		System.out.print("3. 글내용 : ");
		String contents = sc.nextLine();
		System.out.print("4. 글암호 : ");
		String boardpasswd = sc.nextLine();
		
		BoardDTO bdto = new BoardDTO();
		bdto.setFk_userid(member.getUserid());
		bdto.setSubject(subject);
		bdto.setContents(contents);
		bdto.setBoardpasswd(boardpasswd);
		
		int n_insert = bdao.write(bdto);	
		// insert 가 성공되어지면 n_insert 에는 1 값이 들어올 것이다.
		// insert 가 실패되어지면 n_insert 에는 0 값이 들어올 것이다.
		
		int n_update = 0;
		
		if(n_insert==1) {
			n_update = mdao.updateMemberPoint(member.getUserid());
			// 회원테이블에서 글을 작성한 회원의 point를 10 증가하도록 하는 update
			// update 가 성공되어지면 n_update 에는 1 값이 들어올 것이다.
			// 그런데 jdbc_member 테이블에 point 컬럼에는 check 제약으로 인해서 
			// 30을 넘지 못한다. 30을 넘으면 check 제약으로 인해 오류가 발생할 것이다.
			// check 제약으로 오류가 발생할 경우에는 n_update 에 0 을 넣어주도록 하겠다.
		}
		
		Connection conn = MyDBConnection.getConn();
		
		// (트랜잭션 처리 : jdbc_board 테이블에 insert + jdbc_member 테이블에 update)
		try {
			if(n_insert==1 && n_update==1) {
			// 게시판에 글쓰기 및 회원의 point 값이 10 증가 한 것이 모두 성공이라면
			
				do {
					System.out.print(">> 정말로 글쓰기를 하시겠습니까?[Y/N] => ");
					String yn= sc.nextLine();
					if("y".equalsIgnoreCase(yn)) {
						conn.commit();
						result = 1;
						break;
					}
					else if("n".equalsIgnoreCase(yn)) {
						// 성공인데 사용자가 원하지 않는 경우
						conn.rollback();
						break;
					}
						
					else
						System.out.println(">> Y 또는 N 만 입력하세요!! <<");
					
				} while (true);	// end of do~while(true) -------------------------------------
				
			} else {
				// 제약조건을 포함한 sql 구문 장애가 발생한 경우
				conn.rollback();
				result = -1;
			}
		} catch(SQLException e) {
			
		}
		
		return result;
		/*
			리턴되는 result 값이 1 인 경우는 글쓰기가 성공한 경우
			리턴되는 result 값이 0 인 경우는 글쓰기를 취소한 경우
			리턴되는 result 값이 -1 인 경우는 장애가 발생해서 글쓰기가 실패한 경우
		*/
	}// end of private int write(Scanner sc, MemberDTO member) ----------------------------------
	 



	// **** 글목록보기 **** //
	private void boardList() {
		List<BoardDTO> boardList= bdao.boardList();
		if(boardList.size()>0) {
			// 게시글이 존재하는 경우
			System.out.println("\n-------------------- [ 게시글 목록 ] --------------------\n");
			System.out.println("글번호\t글제목\t작성자\t작성일자\t\t조회수");
			System.out.println("\n------------------------------------------------------\n");
			
			for (int i=0; i<boardList.size(); i++) {
				BoardDTO bdto = boardList.get(i);
				
				System.out.println(bdto.getBoardno()+"\t"+bdto.getSubject()+"\t"
				                  +bdto.getMember().getName()+"\t"
				                  +bdto.getWriteday()+"\t"+bdto.getViewcount());
			}// end of for (int i=0; i<boardList.size(); i++) ---------------------------------
			
		} else {
			// 게시글이 존재하지 않는 경우
			System.out.println(">> 글목록이 없습니다. <<");
		}
	}// end of private void boardList() -------------------------------------





}
