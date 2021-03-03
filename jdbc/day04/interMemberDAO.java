package jdbc.day04;

import java.util.*;

public interface interMemberDAO {

	// 회원가입(insert) 메소드
	int memberRegister(MemberDTO member, Scanner sc);
	
	// 로그인처리(select) 메소드
	MemberDTO login(Map<String, String> paraMap);
	
}
