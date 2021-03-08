package jdbc.day04;

import java.sql.*;
import java.util.*;

import jdbc.day04.singleton.dbconnection.MyDBConnection;

//DAO(Database Access Object) ==> 데이터베이스에 연결하여 SQL구문을 실행시켜주는 객체 

public class BoardDAO implements interBoardDAO {

	// field, attribute, property, 속성 
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// === 자원반납 메소드  === //
	private void close() {
		try {
			 if(rs != null)    rs.close();
			 if(pstmt != null) pstmt.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of private void close()----------------	

	
	
	// 게시판 글쓰기 (글쓰기가 성공이라면 1 을 리턴, 글쓰기가 실패이라면 0 을 리턴)
	@Override
	public int write(BoardDTO bdto) {
		
		int result = 0;
		
		try {
			  conn = MyDBConnection.getConn(); // conn 은 수동commit 으로 되어져 있다.
			  
			  String sql = " insert into jdbc_board(BOARDNO, FK_USERID, SUBJECT, CONTENTS, BOARDPASSWD) "     
			  		     + " values(board_seq.nextval, ?, ?, ?, ?) ";
			  
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setString(1, bdto.getFk_userid());
			  pstmt.setString(2, bdto.getSubject());
			  pstmt.setString(3, bdto.getContents());
			  pstmt.setString(4, bdto.getBoardpasswd());
			  
			  result = pstmt.executeUpdate();
			  // insert 가 성공되어지면 result 에는 1이 들어간다.
			  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		//  result 는 1 또는 0 을 리턴 할 것이다. 
		
	}// end of public int write(BoardDTO bdto)--------------- 


	
	// 글목록보기
	@Override
	public List<BoardDTO> boardList() {
		
		List<BoardDTO> boardList = new ArrayList<>();
		
		try {
			  conn = MyDBConnection.getConn();
			 
		/*	  
			  ===> 댓글의 개수를 보여주지 않는 SQL문 <===
			  String sql = "select B.boardno "+
					       "     , case when length(B.subject) > 10 then substr(B.subject, 1, 8) || '..' else B.subject end AS SUBJECT "+
					       "     , M.name "+
					       "     , to_char( B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY "+
					       "     , B.viewcount "+
					       "from jdbc_board B JOIN jdbc_member M "+
					       "ON B.fk_userid = M.userid "+
					       "order by 1 desc ";
		*/			
			  
			  
		//	  ===> 댓글의 개수를 보여주는 SQL문 <===    //
			  String sql = "select B.boardno "+
					       "     , B.subject "+
					       "     , M.name "+
					       "     , to_char( B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY "+ 
					       "     , B.viewcount "+
					       "     , NVL(C.COMMENTCNT, 0) AS COMMENTCNT "+
					       " from jdbc_board B JOIN jdbc_member M "+
					       " ON B.fk_userid = M.userid "+
						   " LEFT JOIN "+
						   "("+
						   "  select fk_boardno, count(*) AS COMMENTCNT "+
						   "  from jdbc_comment "+
						   "  group by fk_boardno "+
						   ") C "+
						   " ON B.boardno = C.fk_boardno "+
						   " order by 1 desc ";
			  
			  pstmt = conn.prepareStatement(sql);
			  
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  
				  BoardDTO bdto = new BoardDTO();
				  
				  bdto.setBoardno( rs.getInt(1) );    // 또는  bdto.setBoardno( rs.getInt("BOARDNO") ); 
				  bdto.setSubject( rs.getString(2) ); // 또는  bdto.setBoardno( rs.getString("SUBJECT") ); 
				  
				  MemberDTO member = new MemberDTO();
				  member.setName(rs.getString(3));
				  
				  bdto.setMember(member);
				  
				  bdto.setWriteday(rs.getString(4));
				  bdto.setViewcount(rs.getInt(5));
				  
				  bdto.setCommentcnt(rs.getInt(6)); // 댓글의 개수
				  
				  /////////////////////////////////////////////
				  
				  boardList.add(bdto);
				  
			  }// end of while(rs.next())-------------------------
			  
			  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return boardList;
		
	}// end of public List<BoardDTO> boardList()-------------


	
	// 글내용보기
/*	
	@Override
	public BoardDTO viewContents(Map<String, String> paraMap) {
		
		BoardDTO bdto = null;
		
		try {
			  conn = MyDBConnection.getConn();
			  
			  String sql = " select subject, contents, fk_userid " + 
			  		       " from jdbc_board " + 
			  		       " where boardno = ? ";
			  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, paraMap.get("boardno") );
			  
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) {
				  bdto = new BoardDTO();
				  bdto.setSubject(rs.getString(1));
				  bdto.setContents(rs.getString(2));
				  
				  String fk_userid = rs.getString(3); // 글을 쓴 작성자의 userid 
				  
				  if( !fk_userid.equals( paraMap.get("login_userid") ) ) {
					  // 로그인 한 사용자의 userid 와 글을 쓴 작성자의 userid 가 다를 경우  
					  
					  sql = " update jdbc_board set viewcount = viewcount + 1 "
					  	  + " where boardno = ? ";
					  
					  pstmt = conn.prepareStatement(sql);
					  pstmt.setString(1, paraMap.get("boardno"));
					  
					  int n = pstmt.executeUpdate();
					  
					  if(n==1) {
						  conn.commit();
					  }
				  }
				  
			  }// end of if(rs.next())-----------------------
			  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bdto;
	}// end of public BoardDTO viewContents(Map<String, String> paraMap)---------------
*/
	
	
	// 글내용보기
	@Override
	public BoardDTO viewContents(Map<String, String> paraMap) {
		
		BoardDTO bdto = null;
		
		try {
			  conn = MyDBConnection.getConn();
			  
			  String sql = " select subject, contents, fk_userid, boardpasswd " + 
			  		       " from jdbc_board " + 
			  		       " where boardno = ? ";
			  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, paraMap.get("boardno") );
			  
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) {
				  bdto = new BoardDTO();
				  bdto.setSubject(rs.getString(1));
				  bdto.setContents(rs.getString(2));
				  bdto.setFk_userid(rs.getString(3));
				  bdto.setBoardpasswd(rs.getString(3));
			  }// end of if(rs.next())-----------------------
			  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bdto;
	}// end of public BoardDTO viewContents(Map<String, String> paraMap)---------------	



	// 조회수 1증가 시키기 
	@Override
	public void updateViewCount(String boardno) {
		
		try {
			  conn = MyDBConnection.getConn(); // conn 은 수동commit 으로 되어져 있다.
			  
			  String sql = " update jdbc_board set viewcount = viewcount + 1 "
				  	     + " where boardno = ? ";
				  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, boardno);
				  
			  int n = pstmt.executeUpdate();
				  
			  if(n==1) {
				  conn.commit();
			  }
			  
		} catch (SQLException e) {
			     e.printStackTrace();
		} finally {
			close();
		}		
		
	}// end of public void updateViewCount(String boardno)----------


	// 댓글쓰기(jdbc_comment 테이블에 insert)
	@Override
	public int writeComment(BoardCommentDTO cmdto, Scanner sc) {
		int result = 0;
		
		try {
			  conn = MyDBConnection.getConn(); // conn 은 수동commit 으로 되어져 있다.
			  
			  String sql = " insert into jdbc_comment(COMMENTNO, FK_BOARDNO, FK_USERID, CONTENTS) "     
			  		     + " values(SEQ_COMMENT.nextval, ?, ?, ?) ";
			  
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setString(1, cmdto.getFk_boardno()); // 넘어온 원글번호가 2342 와 같이 존재하지 않는 원글번호 일 수도 있다. 이렇게 되면 HR.FK_JDBC_COMMENT_FK_BOARDNO 제약조건에 위배가 된다.  
			  pstmt.setString(2, cmdto.getFk_userid());
			  pstmt.setString(3, cmdto.getContents());
			  			  
			  result = pstmt.executeUpdate();
			  // insert 가 성공되어지면 result 에는 1이 들어간다.
			  
			  if(result == 1) {
				  
				  do {
					  System.out.print("\n>> 댓글쓰기를 완료하시겠습니까?[Y/N] : ");
					  String yn = sc.nextLine();
					  
					  if("y".equalsIgnoreCase(yn)) {
						  conn.commit();
						  break;
					  }
					  
					  else if("n".equalsIgnoreCase(yn)) {
						  conn.rollback();
						  result = 0;
						  break;
					  }
					  
					  else {
						  System.out.println(">> Y 또는 N 만 입력하세요!! << \n");
					  }
					  
				  } while (true);
				  
			  }
			  
		} catch (SQLIntegrityConstraintViolationException e) {
		//	e.printStackTrace();
			
			if(e.getErrorCode() == 2291) {
			   /*
			           오류 보고 -
			      ORA-02291: integrity constraint (HR.FK_JDBC_COMMENT_FK_BOARDNO) violated - parent key not found	
			   */	
			   result = -1;
			}	
		
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		
	}// end of public int writeComment(BoardCommentDTO cmdto)----------


	// 원글에 대한 댓글을 가져오는 것 (특정 게시글 글번호에 대한 jdbc_comment 테이블과 jdbc_member 테이블을 JOIN 해서 보여준다)
	@Override
	public List<BoardCommentDTO> commentList(String boardno) {
		
		List<BoardCommentDTO> commentList = null;
		
		try {
			  conn = MyDBConnection.getConn();
			  
			  String sql = "select C.contents, M.name, C.writeday "+
						   "from "+
						   "( "+
						   " select contents "+
						   "      , to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY "+
						   "      , fk_userid "+
						   " from jdbc_comment "+
						   " where fk_boardno = ? "+
						   ") C JOIN jdbc_member M "+
						   "ON C.fk_userid = M.userid ";
			  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, boardno );
			  
			  rs = pstmt.executeQuery();
			  
			  int cnt = 0;
			  while(rs.next()) {
				  
				  cnt++;
				  
				  BoardCommentDTO cmdto = new BoardCommentDTO();
				  cmdto.setContents(rs.getString(1)); 
				  
				  MemberDTO member = new MemberDTO();
				  member.setName(rs.getString(2));
				  
				  cmdto.setMember(member);
				  cmdto.setWriteday(rs.getString(3));
				  
				  if(cnt == 1) {
					  commentList = new ArrayList<>();
				  }
				  
				  commentList.add(cmdto);
				  
			  }// end of while(rs.next())-----------------------
			  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		
		return commentList;
		
	}// end of public List<BoardCommentDTO> commentList(String boardno)---------------------


	
	// 글수정하기
	@Override
	public int updateBoard(Map<String, String> paraMap) {		
		int result = 0;
		
		try {
			  conn = MyDBConnection.getConn(); // conn 은 수동commit 으로 되어져 있다.
			  
			  String sql = " update jdbc_board set subject = ? , contents = ? "+
					       " where boardno = ? ";
				  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, paraMap.get("subject"));
			  pstmt.setString(2, paraMap.get("contents"));
			  pstmt.setString(3, paraMap.get("boardno"));
			  
			  result = pstmt.executeUpdate();
			
			  
		} catch (SQLException e) {
			    e.printStackTrace();
		} finally {
			close();
		}		
		
		return result;
	}
	
	
	// 글삭제하기
		@Override
		public int deleteBoard(Map<String, String> paraMap) {		
			int result = 0;
			
			try {
				  conn = MyDBConnection.getConn(); // conn 은 수동commit 으로 되어져 있다.
				  
				  String sql = " delete from jdbc_board "
				  			 + " where boardno = ? and boardpasswd = ? ";
						  
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setString(1, paraMap.get("boardno"));
				  pstmt.setString(2, paraMap.get("boardpasswd"));
				  
				  result = pstmt.executeUpdate();
				  
			} catch (SQLException e) {
				    e.printStackTrace();
			} finally {
				close();
			}		
			
			return result;
		}// end of public int deleteBoard(Map<String, String> paraMap) -----------------------------------
	
}
