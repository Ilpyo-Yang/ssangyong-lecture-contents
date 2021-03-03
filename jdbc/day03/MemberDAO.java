package jdbc.day03;

import java.sql.*;
import java.util.Map;

// DAO(Database Access Object)
public class MemberDAO implements InterMemberDAO {

	// attribute, property, 속성
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// === 자원반납 메소드 === //
	private void close() {
		
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}// end of private void close() ------------------------
	
	
	// === 회원가입(insert) 메소드 구현하기 === //
	@Override
	public int memberRegister(MemberDTO member) {
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","HR","cclass");
			
			String sql = " insert into jdbc_member(userseq, userid, passwd, name, mobile) "+
					     " values(userseq.nextval,?,?,?,?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMobile());
			
			result = pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println(">> 회원가입 성공! <<");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(">> ojdbc6.jar 파일이 없습니다. <<");
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			//System.out.println("에러코드번호: "+e.getErrorCode());
			//System.out.println("에러메시지: "+e.getMessage());
			//에러코드번호: 1
			//에러메시지: ORA-00001: unique constraint (HR.UQ_JDBC_MEMBER) violated
			if(e.getErrorCode()==1) {
				System.out.println(">> 아이디가 중복되었습니다. 새로운 아이디를 입력하세요!! <<");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return 0;
	}// end of public int memberRegister(MemberDTO member) --------


	// ==== 로그인처리(select) 메소드 구현하기 ====
	@Override
	public MemberDTO login(Map<String, String> paraMap) {
		MemberDTO member = null;	//지역변수 초기화 필수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","HR","cclass");
			
			String sql = " select name, to_char(registerday, 'yyyy-mm-dd') as registerday, status "+
					     " from jdbc_member "+
					     " where userid = ? and passwd = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paraMap.get("userid"));
			pstmt.setString(2, paraMap.get("passwd"));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setName(rs.getString("NAME"));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(">> ojdbc6.jar 파일이 없습니다. <<");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return member;
	}// end of public MemberDTO login(Map<String, String> paraMap) ----------
	
}
