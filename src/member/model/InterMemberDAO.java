package member.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InterMemberDAO {

	// 회원가입을 해주는 메소드(tbl_member 테이블에 insert)
	int registerMember(MemberVO member) throws SQLException;

	// ID 중복검사 (tbl_member 테이블에서 userid 가 존재하면 true를 리턴해주고, userid 가 존재하지 않으면 false를 리턴한다)
	boolean idDuplicateCheck(String userid) throws SQLException;

	// Email 중복검사 (tbl_member 테이블에서 Email 가 존재하면 true를 리턴해주고, Email 가 존재하지 않으면 false를 리턴한다)
	boolean emailDuplicateCheck(String email) throws SQLException ;

	// 입력받은 paraMap 을 가지고 한 명의 회원정보를 리턴시켜주는 메서드(로그인 처리)
	MemberVO selectOneMember(Map<String, String> paraMap) throws SQLException ;

	// 아이디 찾기(성명, 이메일을 입력받아서 해당 사용자의 아이디를 알려준다)
	String findUserid(Map<String, String> paraMap) throws SQLException ;

	// 비밀번호 찾기(아이디, 이메일을 입력받아서 해당 사용자가 존재하는지 유무를 알려준다)
	boolean isUserExist(Map<String, String> paraMap) throws SQLException;

	// 암호변경하기
	int pwdUpdate(Map<String, String> paraMap) throws SQLException;

	// 회원의 개인정보변경하기 
	int updateMember(MemberVO member) throws SQLException;

	// DB에 코인, 포인트 업데이트
	int coinPointUpdate(Map<String, String> paraMap) throws SQLException;

	// *** 페이징 처리를 한 모든 회원 또는 검색한 회원 목록 보여주기 *** //
	List<MemberVO> selectPagingMember(Map<String, String> paraMap) throws SQLException;

	// 페이징처리를 위해서 전체회원에 대한 총페이지 개수 알아오기(select)  
	int selectTotalPage(Map<String, String> paraMap) throws SQLException;

	
	
}
