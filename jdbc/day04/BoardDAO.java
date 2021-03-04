package jdbc.day04;

import java.sql.*;
import java.util.*;

import jdbc.day04.singleton.dbconnection.MyDBConnection;

//DAO(Database Access Object) => 데이터베이스에 연결하여 SQL 구문을 실행시켜주는 객체

public class BoardDAO implements interBoardDAO {

	// attribute, property, 속성
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// === 자원반납 메소드 === //
	private void close() {
		
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}// end of private void close() ------------------------

	// 게시판 글쓰기 
	// 글쓰기 성공이라면 1 을 리턴, 글쓰기가 실패라면 0 을 리턴
	@Override
	public int write(BoardDTO bdto) {
		int result = 0;
		
		try {
			conn = MyDBConnection.getConn();
			// conn 은 수동 commit 으로 되어져 있다.
			
			String sql = " insert into jdbc_board(BOARDNO, FK_USERID, SUBJECT, CONTENTS, BOARDPASSWD) "
					   + " values(BOARD_SEQ.NEXTVAL,?,?,?,?) ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getFk_userid());
			pstmt.setString(2, bdto.getSubject());
			pstmt.setString(3, bdto.getContents());
			pstmt.setString(4, bdto.getBoardpasswd());

			result = pstmt.executeUpdate();
			// insert 가 성공되어지면 result 에는 1 이 들어간다.
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	
		return result;
		// result 는 1 또는 0 을 리턴할 것이다.
		
	}// public int write(BoardDTO bdto) -------------------------------------

	
	// 글 목록보기
	@Override
	public List<BoardDTO> boardList() {
		List<BoardDTO> boardList = new ArrayList<>();
		
		try {
			conn = MyDBConnection.getConn();			

			String sql = "select B.boardno "+
			             "     , case when length(B.subject)>10 then substr(B.subject,1,8)||'..' else B.subject end as subject "+
 						 "     , M.name "+
						 "     , to_char(B.writeday,'yyyy-mm-dd hh24:mi:ss') as writeday "+
						 "     , b.viewcount "+
						 "from jdbc_board B join jdbc_member M "+
						 "on B.fk_userid = M.userid "+
						 "order by 1 desc";

			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO bdto = new BoardDTO();
				
				bdto.setBoardno(rs.getInt(1));	// 또는 bdto.setBoardno(rs.getInt("BOARDNO"));
				bdto.setSubject(rs.getString(2));
				
				MemberDTO member = new MemberDTO();
				member.setName(rs.getString(3));
				bdto.setMember(member);
				
				bdto.setWriteday(rs.getString(4));
				bdto.setViewcount(rs.getInt(5));
				
				//////////////////////////////////////////
			
				boardList.add(bdto);
				
				
			} // end of while(rs.next()) -----------------------------------------------
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return boardList;
	}// end of public List<BoardDTO> boardList() ---------------------------------

			
			
}
