package member.model;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.security.AES256;
import util.security.SecretMyKey;
import util.security.Sha256;

public class MemberDAO implements InterMemberDAO {

	private DataSource ds; // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private AES256 aes; // 클래스의 객체가 인스턴스이기 때문에 메소드가 필요하다.
	
	// 생성자
	public MemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			aes = new AES256(SecretMyKey.KEY);
			// SecretMyKey.KEY은 우리가 만든 비밀키이다.
		} catch(NamingException e) {
			e.printStackTrace();
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 사용한 자원을 반납하는 close() 메소드 생성하기 
	   private void close() {
	      try {
	         if(rs != null)    {rs.close();    rs=null;}
	         if(pstmt != null) {pstmt.close(); pstmt=null;}
	         if(conn != null)  {conn.close();  conn=null;}
	      } catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }
	
	   
	// 회원가입을 해주는 메소드(tbl_member 테이블에 insert)
	@Override
	public int registerMember(MemberVO member) throws SQLException {
		int n=0;
		
		try {
			conn = ds.getConnection();
			
			String sql = " insert into tbl_member(userid, pwd, name, email, mobile, postcode, address, detailaddress, extraaddress, gender, birthday) "  + 
					     " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, Sha256.encrypt(member.getPwd())); // 암호를 SHA256 알고리즘으로 단방향(한번 암호화시키면 해독(복호화) 불가) 암호화 시킨다. 
			pstmt.setString(3, member.getName());
			pstmt.setString(4, aes.encrypt(member.getEmail())); // 이메일을 AES256 알고리즘으로 양방향 암호화 시킨다. 물건 구매를 하게되면 관련메일을 보내야 하기 때문에 양방향 암호화를 시켜야 한다.
			pstmt.setString(5, aes.encrypt(member.getMobile())); // 휴대폰 번호를 AES256 알고리즘으로 양방향 암호화 시킨다. 물건 구매를 하게되면 관련메일을 보내야 하기 때문에 양방향 암호화를 시켜야 한다.
			pstmt.setString(6, member.getPostcode());
	        pstmt.setString(7, member.getAddress());
	        pstmt.setString(8, member.getDetailaddress());
	        pstmt.setString(9, member.getExtraaddress());
	        pstmt.setString(10, member.getGender());
	        pstmt.setString(11, member.getBirthday());
			
	        n = pstmt.executeUpdate();
		
		} catch(GeneralSecurityException | UnsupportedEncodingException e) {
			// aes 에서 발생하는 예외처리로 또는(|)으로 처리해준다.
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	
	// ID 중복검사 (tbl_member 테이블에서 userid 가 존재하면 true를 리턴해주고, userid 가 존재하지 않으면 false를 리턴한다)
	@Override
	public boolean idDuplicateCheck(String userid) throws SQLException {
		boolean isExists = false;
		
		try {
			conn = ds.getConnection();
			String sql = " select userid "
					   + " from tbl_member "
					   + " where userid= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			isExists=rs.next();
			// 행이 있으면(중복된 userid) true, 
            // 행이 없으면(사용가능한 userid) false
			
		} finally {
			close();
		}
		
		return isExists;
	}

	
	   // email 중복검사 (tbl_member 테이블에서 email 이 존재하면 true를 리턴해주고, email 이 존재하지 않으면 false를 리턴한다)
	   @Override
	   public boolean emailDuplicateCheck(String email) throws SQLException {
	
	      boolean isExist = false;
	      
	      try {
	         conn = ds.getConnection();
	         
	         String sql = " select email "
	                  + " from tbl_member "
	                  + " where email = ? ";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, aes.encrypt(email));
	         
	         rs = pstmt.executeQuery();
	         
	         isExist = rs.next();  // 행이 있으면(중복된 email) true, 
	                               // 행이 없으면(사용가능한 email) false
	      } catch (GeneralSecurityException | UnsupportedEncodingException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      
	      return isExist;
	   }

	   
	// 입력받은 paraMap 을 가지고 한 명의 회원정보를 리턴시켜주는 메서드(로그인 처리)
	@Override
	public MemberVO selectOneMember(Map<String, String> paraMap) throws SQLException {
		MemberVO member = null;
		try {
	         conn = ds.getConnection();
	         
	         String sql = " SELECT userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender, "+
		        		 "       birthyyyy, birthmm, birthdd, coin, point, registerday, pwdchagegap,  "+
		        		 "       nvl(lastlogingap, trunc(months_between(sysdate,registerday))) as lastlogingap "+
		        		 " FROM "+
		        		 " ( "+
		        		 " select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender "+
		        		 "    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd  "+
		        		 "    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday "+
		        		 "    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchagegap "+
		        		 " from tbl_member "+
		        		 " where status=1 and userid=? and pwd=? "+
		        		 " ) M "+
		        		 " CROSS JOIN "+
		        		 " ( "+
		        		 " select months_between(sysdate, max(logindate)) as lastlogingap "+
		        		 " from tbl_loginhistory "+
		        		 " where fk_userid = ? "+
		        		 " ) H ";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, paraMap.get("userid"));
	         pstmt.setString(2, Sha256.encrypt(paraMap.get("pwd")));
	         pstmt.setString(3, paraMap.get("userid"));
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 member = new MemberVO();
	        	 member.setUserid(rs.getString(1));
	             member.setName(rs.getString(2));
	             member.setEmail(aes.decrypt(rs.getString(3)));	// 복호화
	             member.setMobile(aes.decrypt(rs.getString(4)));	// 복호화
	             member.setPostcode(rs.getString(5));
	             member.setAddress(rs.getString(6));
	             member.setDetailaddress(rs.getString(7));
	             member.setExtraaddress(rs.getString(8));
	             member.setGender(rs.getString(9));
		         member.setBirthday(rs.getString(10)+rs.getString(11)+rs.getString(12));
		         member.setCoin(rs.getInt(13));
	             member.setPoint(rs.getInt(14));
	             member.setRegisterday(rs.getString(15));
	             
	             // 마지막으로 암호를 변경한 날짜가 현재시각으로 부터 3개월이 지났으면 true
	         	 // 마지막으로 암호를 변경한 날짜가 현재시각으로 부터 3개월이 지나지 않았으면 false
	             if(rs.getInt(16) >= 3) {
	            	 member.setRequiredPwdChange(true);	// 로그인시 암호를 변경해라는 alert 를 띄우도록 할 때 사용한다.
	             }
	             
	             if(rs.getInt(17) >= 12) {
	            	 // 마지막으로 로그인 한 날짜시간이 현재시각으로 부터 1년이 지났으면 휴면으로 지정
	            	 member.setIdle(1);	// 휴면중으로 변경
	            	
	            	 // === tbl_member 테이블의 idle 컬럼의 값을 1 로 변경 하기 === //
	                 if(member.getIdle()!=1) {
		            	 sql = " update tbl_member set idle = 1 "
		                     + " where userid = ? ";
		                 
		                 pstmt = conn.prepareStatement(sql);
		                 pstmt.setString(1, paraMap.get("userid"));
		                 pstmt.executeUpdate();
	                 }
	             }
	             
	             
	             // === tbl_loginhistory(로그인기록) 테이블에 insert 하기 === //
	             sql = " insert into tbl_loginhistory(fk_userid, clientip) " +
	            	   " values(?,?) ";
	             pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, paraMap.get("userid"));
		         pstmt.setString(2, paraMap.get("clientip"));
		         pstmt.executeUpdate();
		       
		         
	         } 
		  } catch(UnsupportedEncodingException | GeneralSecurityException e) {
			  e.printStackTrace();
	      } finally {
	         close();
	      }
	     
	return member;
	}

	
	// 아이디 찾기(성명, 이메일을 입력받아서 해당 사용자의 아이디를 알려준다)
	@Override
	public String findUserid(Map<String, String> paraMap) throws SQLException {
		String userid ="";
		
		try {
	         conn = ds.getConnection();
	         
	         String sql = " select userid "
	                    + " from tbl_member "
	                    + " where status=1 and name=? and email = ? ";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, paraMap.get("name"));
	         pstmt.setString(2, aes.encrypt(paraMap.get("email")));
	         
	         rs = pstmt.executeQuery();	
	         if(rs.next()) {
		         userid = rs.getString(1);     	 
	         }

	         
	      } catch (GeneralSecurityException | UnsupportedEncodingException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      
		return userid;
	}

	
	// 비밀번호 찾기(아이디, 이메일을 입력받아서 해당 사용자가 존재하는지 유무를 알려준다)
	@Override
	public boolean isUserExist(Map<String, String> paraMap) throws SQLException {
		boolean isUserExist = false;
		
		  try {
	         conn = ds.getConnection();
	         
	         String sql = " select userid "
	                    + " from tbl_member "
	                    + " where status=1 and userid=? and email = ? ";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, paraMap.get("userid"));
	         pstmt.setString(2, aes.encrypt(paraMap.get("email")));
	         
	         rs = pstmt.executeQuery();	
	         isUserExist = rs.next();
	       
	      } catch (GeneralSecurityException | UnsupportedEncodingException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
		
		return isUserExist;
	}

	
	// 암호 변경하기
	@Override
	public int pwdUpdate(Map<String, String> paraMap) throws SQLException {
		int n = 0;
		
		try {
			conn = ds.getConnection();
			String sql = " update tbl_member set pwd =? , lastpwdchangedate=sysdate " +
			             " where userid=? ";
			pstmt = conn.prepareStatement(sql);
			// 암호를 SHA256 알고리즘으로 단방향 암호화 시킨다.
			pstmt.setString(1, Sha256.encrypt(paraMap.get("pwd")));
			pstmt.setString(2, paraMap.get("userid"));
			
			n = pstmt.executeUpdate();
					
		} finally {
			close();
		}
		
		return n;
	}

}
