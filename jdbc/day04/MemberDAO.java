package jdbc.day04;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

import jdbc.day03.MemberDTO;
import jdbc.day04.singleton.dbconnection.MyDBConnection;

public class MemberDAO implements interMemberDAO {

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
		
	
	@Override
	public int memberRegister(MemberDTO member, Scanner sc) {
		int result = 0;
		
		try {
			conn = MyDBConnection.getConn();
			
			String sql = " insert into jdbc_member(userseq, userid, passwd, name, mobile) "+
				         " values(userseq.nextval,?,?,?,?) ";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMobile());
			
			result = pstmt.executeUpdate();
		
			if(result == 1) {
	            String yn = "";
	            do {
	               System.out.print(">> 회원가입을 정말로 하시겠습니까?[Y/N] ");
	               yn = sc.nextLine();
	               
	               if("Y".equalsIgnoreCase(yn)) {
	                  conn.commit(); // 커밋
	               }
	               else if("N".equalsIgnoreCase(yn)) {
	                  conn.rollback(); // 롤백
	                  result = 0;
	               }
	               else {
	                  System.out.println(">>> Y 또는 N 만 입력하세요!! \n");
	               }
	               
	            } while (!("Y".equalsIgnoreCase(yn) || "N".equalsIgnoreCase(yn)));
	         }// end of if(result == 1) =----------------------------------------------------
			
		} catch (SQLIntegrityConstraintViolationException e) {
			if(e.getErrorCode()==1) 
			result = -1;
		} catch (SQLException e) {
			result = -2;
		} finally {
			close();
		}
		
		return result;	
		// 0 => 회원가입을 취소한 것임.
		// 1 => 정상적으로 회원가입한 것임.
		// -1 => 사용자 아이디에 중복이 발생한 것임.
		// -2 => SQL 구문에 오류발생한 것임.
		
	}// end of public int memberRegister(MemberDTO member) -------------------------

	@Override
	public MemberDTO login(Map<String, String> paraMap) {
		MemberDTO member = null;
		
		try {
			conn = MyDBConnection.getConn();
			
			String sql = " select name "
				    	+ " from jdbc_member "
			            + " where userid = ? and passwd = ? ";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paraMap.get("userid"));
			pstmt.setString(2, paraMap.get("passwd"));
		
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setName(rs.getString("NAME"));
			}
			
			
		} catch (Exception e) {
			
		} finally {
			close();
		}
		
		return member;
	}// end of public MemberDTO login(Map<String, String> paraMap) -------------------------


}
